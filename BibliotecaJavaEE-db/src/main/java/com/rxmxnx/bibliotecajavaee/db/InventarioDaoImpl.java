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
public class InventarioDaoImpl extends SuperEntidadDaoImpl<Integer, Inventario, InventarioDetalle, InventarioEntidad> implements InventarioDao  {
    @Inject
    private LogLocal log;
    
    public InventarioDaoImpl() {
    }
    
    @Override
    protected Class<InventarioEntidad> claseEntidad() {
        return Definicion.INSTANCIA.clase();
    }
    @Override
    protected HasComparableOperators<InventarioEntidad, Integer> campoId() {
        return Definicion.INSTANCIA.id();
    }
    @Override
    protected LogLocal log() {
        return this.log;
    }
    
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Inventario> listar() {
        return this.streamListado()
                .map(p -> new Inventario(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public List<Inventario> listarInventario(Function<? extends InventarioDefinicion, SpeedmentPredicate<? extends Inventario>> funcionPredicado) {
        return this.streamListado(InventarioDaoImpl.predicado(funcionPredicado))
                .map(p -> new Inventario(p))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(TxType.SUPPORTS)
    public Optional<Inventario> encontrar(Integer id) {
        return this.streamEncontrar(id)
                .map(p -> new Inventario(p))
                .findAny();
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public Inventario guardar(Inventario entidad) {
        this.initialize(false);
        InventarioEntidad resultado = InventarioEntidad.crearEntidad(entidad);
        if (this.esActualizacion(entidad)) {
            return this.entityManager().merge(resultado);
        }
        this.entityManager().persist(resultado);
        return resultado;
    }
    @Override
    @Transactional(TxType.REQUIRES_NEW)
    public boolean eliminar(Integer id) {
        Optional<InventarioEntidad> Inventario = this.streamer()
                .stream(Definicion.INSTANCIA.clase())
                .filter(Definicion.INSTANCIA.id().equal(id))
                .findAny();
        if (Inventario.isPresent()) {
            this.entityManager().joinTransaction();
            this.entityManager().remove(this.entityManager().merge(Inventario.get()));
            return true;
        }
        return false;
    }

    @Override
    public List<InventarioDetalle> listarDetallado() {
        return this.streamListado()
                .map(p -> new InventarioDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public List<InventarioDetalle> listarInventarioDetallado(Function<? extends InventarioDefinicion, SpeedmentPredicate<? extends Inventario>> funcionPredicado) {
        return this.streamListado(InventarioDaoImpl.predicado(funcionPredicado))
                .map(p -> new InventarioDetalle(p))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<InventarioDetalle> encontrarDetallado(Integer id) {
        return this.streamEncontrar(id)
                .map(p -> new InventarioDetalle(p))
                .findAny();
    }
    
    private static SpeedmentPredicate<InventarioEntidad> predicado(Function<? extends InventarioDefinicion, SpeedmentPredicate<? extends Inventario>> funcionPredicado) {
        Function<Definicion, SpeedmentPredicate<InventarioEntidad>> predicado = (Function)funcionPredicado;
        return predicado.apply(Definicion.INSTANCIA);
    }

    private static final class Definicion implements InventarioDefinicion<InventarioEntidad, LibroEntidad> {
        private static final Definicion INSTANCIA = new Definicion();
        
        private static final IntField<InventarioEntidad> ID = IntField.create(InventarioEntidad.class, "id", InventarioEntidad::getInventarioId, true);
        private static final StringField<InventarioEntidad> ESTANTE = StringField.create(InventarioEntidad.class, "estante", InventarioEntidad::getEstante, false);
        private static final IntField<InventarioEntidad> CANTIDAD = IntField.create(InventarioEntidad.class, "cantidad_ejemplares", InventarioEntidad::getCantidadEjemplares, false);
        private static final IntField<InventarioEntidad> LIBRO_ID = IntField.create(InventarioEntidad.class, "id_libro", InventarioEntidad::getLibroId, false);
        private static final ReferenceField<InventarioEntidad, LibroEntidad> LIBRO = ReferenceField.create(InventarioEntidad.class, "id_libro", InventarioEntidad::getLibro, false);
        
        private Definicion() {}
        @Override
        public Class<InventarioEntidad> clase() {
            return InventarioEntidad.class;
        }
        @Override
        public IntField<InventarioEntidad> id() {
            return ID;
        }
        @Override
        public StringField<InventarioEntidad> estante() {
            return ESTANTE;
        }
        @Override
        public IntField<InventarioEntidad> libroId() {
            return LIBRO_ID;
        }
        @Override
        public IntField<InventarioEntidad> cantidadEjemplares() {
            return CANTIDAD;
        }
        @Override
        public ReferenceField<InventarioEntidad, LibroEntidad> libro() {
            return LIBRO;
        }
    }
}