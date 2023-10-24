/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db;

import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.db.entidad.*;
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
import com.speedment.jpastreamer.streamconfiguration.*;

/**
 *
 * @author atem94
 */
@Stateless
public class AutorDaoImpl extends SuperEntidadDaoImpl<Integer, Autor, AutorDetalle, AutorEntidad> implements AutorDao  {
    @EJB
    private LogServidor logServidor;
    @Inject
    private LogLocal log;
    
    public AutorDaoImpl() {
    }
    
    @Override
    protected Class<AutorEntidad> claseEntidad() {
        return Definicion.INSTANCIA.clase();
    }
    @Override
    protected HasComparableOperators<AutorEntidad, Integer> campoId() {
        return Definicion.INSTANCIA.id();
    }
    @Override
    protected LogLocal log() {
        return this.log.utilizando(this.logServidor);
    }
    @Override
    protected StreamConfiguration<AutorEntidad> configuracionDetalle() {
        return StreamConfiguration.of(this.claseEntidad())
                .joining(Definicion.INSTANCIA.pais())
                .joining(Definicion.INSTANCIA.libroSet());
    }
    
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Autor> listar() {
        return this.streamListado()
                .map(p -> new Autor(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Autor> listarAutor(AutorFuncionFiltro funcionPredicado) {
        return this.streamListado(AutorDaoImpl.predicado(funcionPredicado))
                .map(p -> new Autor(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public Optional<Autor> encontrar(Integer id) {
        return this.streamEncontrar(id)
                .map(p -> new Autor(p))
                .findAny();
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public Autor guardar(Autor entidad) {
        this.initialize(false);
        AutorEntidad resultado = AutorEntidad.crearEntidad(entidad);
        if (this.esActualizacion(entidad)) {
            return this.entityManager().merge(resultado);
        }
        this.entityManager().persist(resultado);
        return resultado;
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public boolean eliminar(Integer id) {
        Optional<AutorEntidad> Autor = this.streamer()
                .stream(Definicion.INSTANCIA.clase())
                .filter(Definicion.INSTANCIA.id().equal(id))
                .findAny();
        if (Autor.isPresent()) {
            this.entityManager().joinTransaction();
            this.entityManager().remove(this.entityManager().merge(Autor.get()));
            return true;
        }
        return false;
    }

    @Override
    public List<AutorDetalle> listarDetallado() {
        return this.streamListado()
                .map(p -> new AutorDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public List<AutorDetalle> listarAutorDetallado(AutorFuncionFiltro funcionPredicado) {
        return this.streamListado(AutorDaoImpl.predicado(funcionPredicado))
                .map(p -> new AutorDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<AutorDetalle> encontrarDetallado(Integer id) {
        return this.streamEncontrar(id)
                .map(p -> new AutorDetalle(p))
                .findAny();
    }
    
    private static SpeedmentPredicate<AutorEntidad> predicado(AutorFuncionFiltro funcionPredicado) {
        Function<Definicion, SpeedmentPredicate<AutorEntidad>> predicado = (Function)funcionPredicado;
        return predicado.apply(Definicion.INSTANCIA);
    }

    private static final class Definicion implements AutorDefinicion<AutorEntidad, PaisEntidad, LibroEntidad> {
        private static final Definicion INSTANCIA = new Definicion();
        
        private static final IntField<AutorEntidad> ID = IntField.create(AutorEntidad.class, "id", AutorEntidad::getAutorId, true);
        private static final StringField<AutorEntidad> NOMBRE = StringField.create(AutorEntidad.class, "nombre", AutorEntidad::getNombre, false);
        private static final StringField<AutorEntidad> APELLIDO = StringField.create(AutorEntidad.class, "apellido", AutorEntidad::getNombre, false);
        private static final ComparableField<AutorEntidad, Date> FECHA_NACIMIENTO = ComparableField.create(AutorEntidad.class, "fecha_nacimiento", AutorEntidad::getFechaNacimiento, false);
        private static final ShortField<AutorEntidad> PAIS_ID = ShortField.create(AutorEntidad.class, "id_pais", AutorEntidad::getPaisId, false);
        private static final ReferenceField<AutorEntidad, PaisEntidad> PAIS = ReferenceField.create(AutorEntidad.class, "id_pais", AutorEntidad::getPais, false);
        private static final ReferenceField<AutorEntidad, Set<LibroEntidad>> LIBROS = ReferenceField.create(AutorEntidad.class, "libroSet", AutorEntidad::getLibroSet, false);
        
        
        private Definicion() {}
        @Override
        public Class<AutorEntidad> clase() {
            return AutorEntidad.class;
        }
        @Override
        public IntField<AutorEntidad> id() {
            return ID;
        }
        @Override
        public StringField<AutorEntidad> nombre() {
            return NOMBRE;
        }
        @Override
        public StringField<AutorEntidad> apellido() {
            return APELLIDO;
        }
        @Override
        public ComparableField<AutorEntidad, Date> fechaNacimiento() {
            return FECHA_NACIMIENTO;
        }
        @Override
        public ShortField<AutorEntidad> paisId() {
            return PAIS_ID;
        }
        @Override
        public ReferenceField<AutorEntidad, PaisEntidad> pais() {
            return PAIS;
        }
        @Override
        public ReferenceField<AutorEntidad, Set<LibroEntidad>> libroSet() {
            return LIBROS;
        }
    }
}