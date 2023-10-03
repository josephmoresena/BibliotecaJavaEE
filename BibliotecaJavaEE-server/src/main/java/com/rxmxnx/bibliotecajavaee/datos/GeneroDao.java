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
public interface GeneroDao extends SuperEntidadDao<Short, Genero, GeneroDetalle> {
    @Override
    List<Genero> listar();
    List<Genero> listarGenero(Function<? extends GeneroDefinicion, SpeedmentPredicate<? extends Genero>> funcionPredicado);
    @Override
    Optional<Genero> encontrar(Short id);
    @Override
    Genero guardar(Genero entidad);
    @Override
    boolean eliminar(Short id);
    
    @Override
    List<GeneroDetalle> listarDetallado();
    List<GeneroDetalle> listarGeneroDetallado(Function<? extends GeneroDefinicion, SpeedmentPredicate<? extends Genero>> funcionPredicado);
    @Override
    Optional<GeneroDetalle> encontrarDetallado(Short id);
    
    @Override
    default List<Genero> listar(Function<? extends SuperDefinicion<Short, ? extends Genero>, SpeedmentPredicate<? extends Genero>> funcionPredicado) {
        Function<? extends GeneroDefinicion, SpeedmentPredicate<? extends Genero>> funcion = (Function)funcionPredicado;
        return this.listarGenero(funcion);
    }
    @Override
    default List<GeneroDetalle> listarDetallado(Function<? extends SuperDefinicion<Short, ? extends Genero>, SpeedmentPredicate<? extends Genero>> funcionPredicado) {
        Function<? extends GeneroDefinicion, SpeedmentPredicate<? extends Genero>> funcion = (Function)funcionPredicado;
        return this.listarGeneroDetallado(funcion);
    }
}
