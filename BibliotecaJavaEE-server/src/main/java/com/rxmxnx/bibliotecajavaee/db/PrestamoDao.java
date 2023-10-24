/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db;

import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import java.util.*;
import javax.ejb.*;
import com.rxmxnx.bibliotecajavaee.db.funciones.*;

/**
 *
 * @author atem94
 */
@Remote
public interface PrestamoDao extends SuperEntidadDao<Long, Prestamo, PrestamoDetalle> {
    @Override
    List<Prestamo> listar();
    List<Prestamo> listarPrestamo(PrestamoFuncionFiltro funcionPredicado);
    @Override
    Optional<Prestamo> encontrar(Long id);
    @Override
    Prestamo guardar(Prestamo entidad);
    @Override
    boolean eliminar(Long id);
    
    @Override
    List<PrestamoDetalle> listarDetallado();
    List<PrestamoDetalle> listarPrestamoDetallado(PrestamoFuncionFiltro funcionPredicado);
    @Override
    Optional<PrestamoDetalle> encontrarDetallado(Long id);
    
    @Override
    default List<Prestamo> listar(SuperEntidadFuncionFiltro<Long, ? extends Prestamo, ? extends SuperEntidadDefinicion<Long, ? extends Prestamo>> funcionPredicado) {
        PrestamoFuncionFiltro funcion = (PrestamoFuncionFiltro)funcionPredicado;
        return this.listarPrestamo(funcion);
    }
    @Override
    default List<PrestamoDetalle> listarDetallado(SuperEntidadFuncionFiltro<Long, ? extends Prestamo, ? extends SuperEntidadDefinicion<Long, ? extends Prestamo>> funcionPredicado) {
        PrestamoFuncionFiltro funcion = (PrestamoFuncionFiltro)funcionPredicado;
        return this.listarPrestamoDetallado(funcion);
    }
}
