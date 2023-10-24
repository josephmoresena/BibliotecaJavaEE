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
public interface LibroDao extends SuperEntidadDao<Integer, Libro, LibroDetalle> {
    @Override
    List<Libro> listar();
    List<Libro> listarLibro(LibroFuncionFiltro funcionPredicado);
    @Override
    Optional<Libro> encontrar(Integer id);
    @Override
    Libro guardar(Libro entidad);
    @Override
    boolean eliminar(Integer id);
    
    @Override
    List<LibroDetalle> listarDetallado();
    List<LibroDetalle> listarLibroDetallado(LibroFuncionFiltro funcionPredicado);
    @Override
    Optional<LibroDetalle> encontrarDetallado(Integer id);
    
    @Override
    default List<Libro> listar(SuperEntidadFuncionFiltro<Integer, ? extends Libro, ? extends SuperEntidadDefinicion<Integer, ? extends Libro>> funcionPredicado) {
        LibroFuncionFiltro funcion = (LibroFuncionFiltro)funcionPredicado;
        return this.listarLibro(funcion);
    }
    @Override
    default List<LibroDetalle> listarDetallado(SuperEntidadFuncionFiltro<Integer, ? extends Libro, ? extends SuperEntidadDefinicion<Integer, ? extends Libro>> funcionPredicado) {
        LibroFuncionFiltro funcion = (LibroFuncionFiltro)funcionPredicado;
        return this.listarLibroDetallado(funcion);
    }
}
