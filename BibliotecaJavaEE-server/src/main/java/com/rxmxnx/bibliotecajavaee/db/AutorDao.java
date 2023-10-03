/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db;

import com.rxmxnx.bibliotecajavaee.db.definicion.*;
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
public interface AutorDao extends SuperEntidadDao<Integer, Autor, AutorDetalle> {
    @Override
    List<Autor> listar();
    List<Autor> listarAutor(Function<? extends AutorDefinicion, SpeedmentPredicate<? extends Autor>> funcionPredicado);
    @Override
    Optional<Autor> encontrar(Integer id);
    @Override
    Autor guardar(Autor entidad);
    @Override
    boolean eliminar(Integer id);
    
    @Override
    List<AutorDetalle> listarDetallado();
    List<AutorDetalle> listarAutorDetallado(Function<? extends AutorDefinicion, SpeedmentPredicate<? extends Autor>> funcionPredicado);
    @Override
    Optional<AutorDetalle> encontrarDetallado(Integer id);
    
    @Override
    default List<Autor> listar(Function<? extends SuperDefinicion<Integer, ? extends Autor>, SpeedmentPredicate<? extends Autor>> funcionPredicado) {
        Function<? extends AutorDefinicion, SpeedmentPredicate<? extends Autor>> funcion = (Function)funcionPredicado;
        return this.listarAutor(funcion);
    }
    @Override
    default List<AutorDetalle> listarDetallado(Function<? extends SuperDefinicion<Integer, ? extends Autor>, SpeedmentPredicate<? extends Autor>> funcionPredicado) {
        Function<? extends AutorDefinicion, SpeedmentPredicate<? extends Autor>> funcion = (Function)funcionPredicado;
        return this.listarAutorDetallado(funcion);
    }
}
