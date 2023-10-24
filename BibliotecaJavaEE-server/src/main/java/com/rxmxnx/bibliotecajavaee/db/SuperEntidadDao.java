/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db;

import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import java.util.*;
import javax.ejb.*;
import com.rxmxnx.bibliotecajavaee.db.funciones.*;

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
    List<T> listar(SuperEntidadFuncionFiltro<U, ? extends T, ? extends SuperEntidadDefinicion<U, ? extends T>> funcionPredicado);
    Optional<T> encontrar(U id);
    T guardar(T entidad);
    boolean eliminar(U id);
    
    List<TDetalle> listarDetallado();
    List<TDetalle> listarDetallado(SuperEntidadFuncionFiltro<U, ? extends T, ? extends SuperEntidadDefinicion<U, ? extends T>> funcionPredicado);
    Optional<TDetalle> encontrarDetallado(U id);
}
