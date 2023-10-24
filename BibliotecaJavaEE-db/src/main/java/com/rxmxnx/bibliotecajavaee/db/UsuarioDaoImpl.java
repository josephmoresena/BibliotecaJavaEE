/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db;

import com.rxmxnx.bibliotecajavaee.db.entidad.*;
import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.log.*;
import com.speedment.jpastreamer.field.*;
import com.speedment.jpastreamer.field.predicate.*;
import com.speedment.jpastreamer.field.trait.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import javax.ejb.*;
import javax.inject.*;
import javax.transaction.*;
import javax.transaction.Transactional.*;
import com.rxmxnx.bibliotecajavaee.db.funciones.*;
import com.speedment.jpastreamer.streamconfiguration.StreamConfiguration;

/**
 *
 * @author atem94
 */
@Stateless
public class UsuarioDaoImpl extends SuperEntidadDaoImpl<Integer, Usuario, UsuarioDetalle, UsuarioEntidad> implements UsuarioDao  {
    @EJB
    private LogServidor logServidor;
    @Inject
    private LogLocal log;
    
    public UsuarioDaoImpl() {
    }
    
    @Override
    protected Class<UsuarioEntidad> claseEntidad() {
        return Definicion.INSTANCIA.clase();
    }
    @Override
    protected HasComparableOperators<UsuarioEntidad, Integer> campoId() {
        return Definicion.INSTANCIA.id();
    }
    @Override
    protected LogLocal log() {
        return this.log.utilizando(this.logServidor);
    }
    @Override
    protected StreamConfiguration<UsuarioEntidad> configuracionDetalle() {
        return StreamConfiguration.of(this.claseEntidad())
                .joining(Definicion.INSTANCIA.prestamoSet());
    }
    
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Usuario> listar() {
        return this.streamListado()
                .map(p -> new Usuario(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Usuario> listarUsuario(UsuarioFuncionFiltro funcionPredicado) {
        return this.streamListado(UsuarioDaoImpl.predicado(funcionPredicado))
                .map(p -> new Usuario(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public Optional<Usuario> encontrar(Integer id) {
        return this.streamEncontrar(id)
                .map(p -> new Usuario(p))
                .findAny();
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public Usuario guardar(Usuario entidad) {
        this.initialize(false);
        UsuarioEntidad resultado = UsuarioEntidad.crearEntidad(entidad);
        if (this.esActualizacion(entidad)) {
            return this.entityManager().merge(resultado);
        }
        this.entityManager().persist(resultado);
        return resultado;
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public boolean eliminar(Integer id) {
        Optional<UsuarioEntidad> Usuario = this.streamer()
                .stream(Definicion.INSTANCIA.clase())
                .filter(Definicion.INSTANCIA.id().equal(id))
                .findAny();
        if (Usuario.isPresent()) {
            this.entityManager().joinTransaction();
            this.entityManager().remove(this.entityManager().merge(Usuario.get()));
            return true;
        }
        return false;
    }

    @Override
    public List<UsuarioDetalle> listarDetallado() {
        return this.streamListado()
                .map(p -> new UsuarioDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public List<UsuarioDetalle> listarUsuarioDetallado(UsuarioFuncionFiltro funcionPredicado) {
        return this.streamListado(UsuarioDaoImpl.predicado(funcionPredicado))
                .map(p -> new UsuarioDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<UsuarioDetalle> encontrarDetallado(Integer id) {
        return this.streamEncontrar(id)
                .map(p -> new UsuarioDetalle(p))
                .findAny();
    }
    
    private static SpeedmentPredicate<UsuarioEntidad> predicado(UsuarioFuncionFiltro funcionPredicado) {
        Function<Definicion, SpeedmentPredicate<UsuarioEntidad>> predicado = (Function)funcionPredicado;
        return predicado.apply(Definicion.INSTANCIA);
    }

    private static final class Definicion implements UsuarioDefinicion<UsuarioEntidad, PrestamoEntidad> {
        private static final Definicion INSTANCIA = new Definicion();
        
        private static final IntField<UsuarioEntidad> ID = IntField.create(UsuarioEntidad.class, "id", UsuarioEntidad::getUsuarioId, true);
        private static final StringField<UsuarioEntidad> NOMBRE = StringField.create(UsuarioEntidad.class, "nombre", UsuarioEntidad::getNombre, false);
        private static final StringField<UsuarioEntidad> EMAIL = StringField.create(UsuarioEntidad.class, "nombre", UsuarioEntidad::getEmail, false);
        private static final ReferenceField<UsuarioEntidad, Set<PrestamoEntidad>> PRESTAMOS = ReferenceField.create(UsuarioEntidad.class, "prestamoSet", UsuarioEntidad::getPrestamoSet, false);

        private Definicion() {}
        @Override
        public Class<UsuarioEntidad> clase() {
            return UsuarioEntidad.class;
        }
        @Override
        public IntField<UsuarioEntidad> id() {
            return ID;
        }
        @Override
        public StringField<UsuarioEntidad> nombre() {
            return NOMBRE;
        }
        @Override
        public StringField<UsuarioEntidad> email() {
            return EMAIL;
        }
        @Override
        public ReferenceField<UsuarioEntidad, Set<PrestamoEntidad>> prestamoSet() {
            return PRESTAMOS;
        }
    }
}