/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos;

import com.rxmxnx.bibliotecajavaee.datos.definiciones.*;
import com.rxmxnx.bibliotecajavaee.datos.entidades.*;
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
import javax.transaction.*;
import javax.transaction.Transactional.*;

/**
 *
 * @author atem94
 */
@Stateless
public class GeneroDaoImpl extends SuperEntidadDaoImpl<Short, Genero, GeneroDetalle, GeneroEntidad> implements GeneroDao  {
    @EJB
    private LogServidorFactory logFactory;
    
    public GeneroDaoImpl() {
    }
    
    @Override
    protected Class<GeneroEntidad> claseEntidad() {
        return Definicion.INSTANCIA.clase();
    }
    @Override
    protected HasComparableOperators<GeneroEntidad, Short> campoId() {
        return Definicion.INSTANCIA.id();
    }
    @Override
    protected LogServidorFactory logFactory() {
        return this.logFactory;
    }
    
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Genero> listar() {
        return this.streamListado()
                .map(p -> new Genero(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Genero> listarGenero(Function<? extends GeneroDefinicion, SpeedmentPredicate<? extends Genero>> funcionPredicado) {
        return this.streamListado(GeneroDaoImpl.predicado(funcionPredicado))
                .map(p -> new Genero(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public Optional<Genero> encontrar(Short id) {
        return this.streamEncontrar(id)
                .map(p -> new Genero(p))
                .findAny();
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public Genero guardar(Genero entidad) {
        this.initialize(false);
        GeneroEntidad resultado = GeneroEntidad.crearEntidad(entidad);
        if (this.esActualizacion(entidad)) {
            return this.entityManager().merge(resultado);
        }
        this.entityManager().persist(resultado);
        return resultado;
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public boolean eliminar(Short id) {
        Optional<GeneroEntidad> Genero = this.streamer()
                .stream(Definicion.INSTANCIA.clase())
                .filter(Definicion.INSTANCIA.id().equal(id))
                .findAny();
        if (Genero.isPresent()) {
            this.entityManager().joinTransaction();
            this.entityManager().remove(this.entityManager().merge(Genero.get()));
            return true;
        }
        return false;
    }

    @Override
    public List<GeneroDetalle> listarDetallado() {
        return this.streamListado()
                .map(p -> new GeneroDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public List<GeneroDetalle> listarGeneroDetallado(Function<? extends GeneroDefinicion, SpeedmentPredicate<? extends Genero>> funcionPredicado) {
        return this.streamListado(GeneroDaoImpl.predicado(funcionPredicado))
                .map(p -> new GeneroDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<GeneroDetalle> encontrarDetallado(Short id) {
        return this.streamEncontrar(id)
                .map(p -> new GeneroDetalle(p))
                .findAny();
    }
    
    private static SpeedmentPredicate<GeneroEntidad> predicado(Function<? extends GeneroDefinicion, SpeedmentPredicate<? extends Genero>> funcionPredicado) {
        Function<Definicion, SpeedmentPredicate<GeneroEntidad>> predicado = (Function)funcionPredicado;
        return predicado.apply(Definicion.INSTANCIA);
    }

    private static final class Definicion implements GeneroDefinicion<GeneroEntidad, LibroEntidad> {
        private static final Definicion INSTANCIA = new Definicion();
        
        private static final ShortField<GeneroEntidad> ID = ShortField.create(GeneroEntidad.class, "id", GeneroEntidad::getGeneroId, true);
        private static final StringField<GeneroEntidad> NOMBRE = StringField.create(GeneroEntidad.class, "nombre", GeneroEntidad::getNombre, false);
        private static final ReferenceField<GeneroEntidad, Set<LibroEntidad>> LIBROS = ReferenceField.create(GeneroEntidad.class, "libroSet", GeneroEntidad::getLibroSet, false);

        private Definicion() {}
        @Override
        public Class<GeneroEntidad> clase() {
            return GeneroEntidad.class;
        }
        @Override
        public ShortField<GeneroEntidad> id() {
            return ID;
        }
        @Override
        public StringField<GeneroEntidad> nombre() {
            return NOMBRE;
        }
        @Override
        public ReferenceField<GeneroEntidad, Set<LibroEntidad>> libroSet() {
            return LIBROS;
        }
    }
}