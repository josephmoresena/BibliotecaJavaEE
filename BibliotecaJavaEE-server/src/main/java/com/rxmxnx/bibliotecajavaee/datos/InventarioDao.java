/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos;

import com.rxmxnx.bibliotecajavaee.datos.definiciones.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.predicate.*;
import java.util.*;
import java.util.function.*;
import javax.ejb.*;

/**
 *
 * @author atem94
 */
@Remote
public interface InventarioDao extends SuperEntidadDao<Integer, Inventario, InventarioDetalle> {
    @Override
    List<Inventario> listar();
    List<Inventario> listarInventario(Function<? extends InventarioDefinicion, SpeedmentPredicate<? extends Inventario>> funcionPredicado);
    @Override
    Optional<Inventario> encontrar(Integer id);
    @Override
    Inventario guardar(Inventario entidad);
    @Override
    boolean eliminar(Integer id);
    
    @Override
    List<InventarioDetalle> listarDetallado();
    List<InventarioDetalle> listarInventarioDetallado(Function<? extends InventarioDefinicion, SpeedmentPredicate<? extends Inventario>> funcionPredicado);
    @Override
    Optional<InventarioDetalle> encontrarDetallado(Integer id);
    
    @Override
    default List<Inventario> listar(Function<? extends SuperDefinicion<Integer, ? extends Inventario>, SpeedmentPredicate<? extends Inventario>> funcionPredicado) {
        Function<? extends InventarioDefinicion, SpeedmentPredicate<? extends Inventario>> funcion = (Function)funcionPredicado;
        return this.listarInventario(funcion);
    }
    @Override
    default List<InventarioDetalle> listarDetallado(Function<? extends SuperDefinicion<Integer, ? extends Inventario>, SpeedmentPredicate<? extends Inventario>> funcionPredicado) {
        Function<? extends InventarioDefinicion, SpeedmentPredicate<? extends Inventario>> funcion = (Function)funcionPredicado;
        return this.listarInventarioDetallado(funcion);
    }
}
