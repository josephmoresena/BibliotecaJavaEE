/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos;

import com.rxmxnx.bibliotecajavaee.datos.definiciones.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.predicate.*;
import java.util.*;
import java.util.function.Function;
import javax.ejb.Remote;

/**
 *
 * @author atem94
 * @param <U>
 * @param <T>
 * @param <TDetalle>
 */
@Remote
public interface SuperEntidadDao<U extends Number & Comparable<U>, T extends SuperEntidad<U>, TDetalle extends T> {
    List<T> listar();
    List<T> listar(Function<? extends SuperDefinicion<U, ? extends T>, SpeedmentPredicate<? extends T>> funcionPredicado);
    Optional<T> encontrar(U id);
    T guardar(T entidad);
    boolean eliminar(U id);
    
    List<TDetalle> listarDetallado();
    List<TDetalle> listarDetallado(Function<? extends SuperDefinicion<U, ? extends T>, SpeedmentPredicate<? extends T>> funcionPredicado);
    Optional<TDetalle> encontrarDetallado(U id);
}
