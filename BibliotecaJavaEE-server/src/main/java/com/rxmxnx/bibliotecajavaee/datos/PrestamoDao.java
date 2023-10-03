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
public interface PrestamoDao extends SuperEntidadDao<Long, Prestamo, PrestamoDetalle> {
    @Override
    List<Prestamo> listar();
    List<Prestamo> listarPrestamo(Function<? extends PrestamoDefinicion, SpeedmentPredicate<? extends Prestamo>> funcionPredicado);
    @Override
    Optional<Prestamo> encontrar(Long id);
    @Override
    Prestamo guardar(Prestamo entidad);
    @Override
    boolean eliminar(Long id);
    
    @Override
    List<PrestamoDetalle> listarDetallado();
    List<PrestamoDetalle> listarPrestamoDetallado(Function<? extends PrestamoDefinicion, SpeedmentPredicate<? extends Prestamo>> funcionPredicado);
    @Override
    Optional<PrestamoDetalle> encontrarDetallado(Long id);
    
    @Override
    default List<Prestamo> listar(Function<? extends SuperDefinicion<Long, ? extends Prestamo>, SpeedmentPredicate<? extends Prestamo>> funcionPredicado) {
        Function<? extends PrestamoDefinicion, SpeedmentPredicate<? extends Prestamo>> funcion = (Function)funcionPredicado;
        return this.listarPrestamo(funcion);
    }
    @Override
    default List<PrestamoDetalle> listarDetallado(Function<? extends SuperDefinicion<Long, ? extends Prestamo>, SpeedmentPredicate<? extends Prestamo>> funcionPredicado) {
        Function<? extends PrestamoDefinicion, SpeedmentPredicate<? extends Prestamo>> funcion = (Function)funcionPredicado;
        return this.listarPrestamoDetallado(funcion);
    }
}
