/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos;

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
public interface LibroDao extends SuperEntidadDao<Integer, Libro> {
    @Override
    List<Libro> listar();
    List<Libro> listarLibro(Function<? extends LibroDefinicion, SpeedmentPredicate<? extends Libro>> funcionPredicado);
    @Override
    Optional<Libro> encontrar(Integer id);
    @Override
    Libro guardar(Libro entidad);
    @Override
    boolean eliminar(Integer id);
    
    @Override
    List<LibroReferencia> listarDetallado();
    List<LibroReferencia> listarLibroDetallado(Function<? extends LibroDefinicion, SpeedmentPredicate<? extends Libro>> funcionPredicado);
    @Override
    Optional<LibroReferencia> encontrarDetallado(Integer id);
    
    @Override
    default List<Libro> listar(Function<? extends SuperDefinicion<Integer, ? extends Libro>, SpeedmentPredicate<? extends Libro>> funcionPredicado) {
        Function<? extends LibroDefinicion, SpeedmentPredicate<? extends Libro>> funcion = (Function)funcionPredicado;
        return this.listarLibro(funcion);
    }
    @Override
    default List<LibroReferencia> listarDetallado(Function<? extends SuperDefinicion<Integer, ? extends Libro>, SpeedmentPredicate<? extends Libro>> funcionPredicado) {
        Function<? extends LibroDefinicion, SpeedmentPredicate<? extends Libro>> funcion = (Function)funcionPredicado;
        return this.listarLibroDetallado(funcion);
    }
}
