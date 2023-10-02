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
public interface PaisDao extends SuperEntidadDao<Short, Pais> {
    @Override
    List<Pais> listar();
    List<Pais> listarPais(Function<? extends PaisDefinicion, SpeedmentPredicate<? extends Pais>> funcionPredicado);
    @Override
    Optional<PaisReferencia> encontrar(Short id);
    @Override
    Pais guardar(Pais entidad);
    @Override
    boolean eliminar(Short id);
    
    @Override
    default List<Pais> listar(Function<? extends SuperDefinicion<Short, ? extends Pais>, SpeedmentPredicate<? extends Pais>> funcionPredicado) {
        Function<? extends PaisDefinicion, SpeedmentPredicate<? extends Pais>> funcion = (Function)funcionPredicado;
        return this.listarPais(funcion);
    }
}
