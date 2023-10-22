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

/**
 *
 * @author atem94
 */
@Stateless
public class PaisDaoImpl extends SuperEntidadDaoImpl<Short, Pais, PaisDetalle, PaisEntidad> implements PaisDao  {
    @EJB
    private LogServidor logServidor;
    @Inject
    private LogLocal log;
    
    public PaisDaoImpl() {
    }
    
    @Override
    protected Class<PaisEntidad> claseEntidad() {
        return Definicion.INSTANCIA.clase();
    }
    @Override
    protected HasComparableOperators<PaisEntidad, Short> campoId() {
        return Definicion.INSTANCIA.id();
    }
    @Override
    protected LogLocal log() {
        return this.log.utilizando(this.logServidor);
    }
    
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Pais> listar() {
        return this.streamListado()
                .map(p -> new Pais(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Pais> listarPais(Function<? extends PaisDefinicion, SpeedmentPredicate<? extends Pais>> funcionPredicado) {
        return this.streamListado(PaisDaoImpl.predicado(funcionPredicado))
                .map(p -> new Pais(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public Optional<Pais> encontrar(Short id) {
        return this.streamEncontrar(id)
                .map(p -> new Pais(p))
                .findAny();
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public Pais guardar(Pais entidad) {
        this.initialize(false);
        PaisEntidad resultado = PaisEntidad.crearEntidad(entidad);
        if (this.esActualizacion(entidad)) {
            return this.entityManager().merge(resultado);
        }
        this.entityManager().persist(resultado);
        return resultado;
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public boolean eliminar(Short id) {
        Optional<PaisEntidad> pais = this.streamer()
                .stream(Definicion.INSTANCIA.clase())
                .filter(Definicion.INSTANCIA.id().equal(id))
                .findAny();
        if (pais.isPresent()) {
            this.entityManager().joinTransaction();
            this.entityManager().remove(this.entityManager().merge(pais.get()));
            return true;
        }
        return false;
    }

    @Override
    public List<PaisDetalle> listarDetallado() {
        return this.streamListado()
                .map(p -> new PaisDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public List<PaisDetalle> listarPaisDetallado(Function<? extends PaisDefinicion, SpeedmentPredicate<? extends Pais>> funcionPredicado) {
        return this.streamListado(PaisDaoImpl.predicado(funcionPredicado))
                .map(p -> new PaisDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<PaisDetalle> encontrarDetallado(Short id) {
        return this.streamEncontrar(id)
                .map(p -> new PaisDetalle(p))
                .findAny();
    }
    
    private static SpeedmentPredicate<PaisEntidad> predicado(Function<? extends PaisDefinicion, SpeedmentPredicate<? extends Pais>> funcionPredicado) {
        Function<Definicion, SpeedmentPredicate<PaisEntidad>> predicado = (Function)funcionPredicado;
        return predicado.apply(Definicion.INSTANCIA);
    }

    private static final class Definicion implements PaisDefinicion<PaisEntidad, LibroEntidad, AutorEntidad> {
        private static final Definicion INSTANCIA = new Definicion();
        
        private static final ShortField<PaisEntidad> ID = ShortField.create(PaisEntidad.class, "id", PaisEntidad::getPaisId, true);
        private static final StringField<PaisEntidad> NOMBRE = StringField.create(PaisEntidad.class, "nombre", PaisEntidad::getNombre, false);
        private static final ReferenceField<PaisEntidad, Set<LibroEntidad>> LIBROS = ReferenceField.create(PaisEntidad.class, "libroSet", PaisEntidad::getLibroSet, false);
        private static final ReferenceField<PaisEntidad, Set<AutorEntidad>> AUTORES = ReferenceField.create(PaisEntidad.class, "autorSet", PaisEntidad::getAutorSet, false);

        private Definicion() {}
        @Override
        public Class<PaisEntidad> clase() {
            return PaisEntidad.class;
        }
        @Override
        public ShortField<PaisEntidad> id() {
            return ID;
        }
        @Override
        public StringField<PaisEntidad> nombre() {
            return NOMBRE;
        }
        @Override
        public ReferenceField<PaisEntidad, Set<LibroEntidad>> libroSet() {
            return LIBROS;
        }
        @Override
        public ReferenceField<PaisEntidad, Set<AutorEntidad>> autorSet() {
            return AUTORES;
        }
    }
}