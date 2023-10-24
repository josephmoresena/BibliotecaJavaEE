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
public interface AutorDao extends SuperEntidadDao<Integer, Autor, AutorDetalle> {
    @Override
    List<Autor> listar();
    List<Autor> listarAutor(AutorFuncionFiltro funcionPredicado);
    @Override
    Optional<Autor> encontrar(Integer id);
    @Override
    Autor guardar(Autor entidad);
    @Override
    boolean eliminar(Integer id);
    
    @Override
    List<AutorDetalle> listarDetallado();
    List<AutorDetalle> listarAutorDetallado(AutorFuncionFiltro funcionPredicado);
    @Override
    Optional<AutorDetalle> encontrarDetallado(Integer id);

    @Override
    default List<Autor> listar(SuperEntidadFuncionFiltro<Integer, ? extends Autor, ? extends SuperEntidadDefinicion<Integer, ? extends Autor>> funcionPredicado) {
        AutorFuncionFiltro funcion = (AutorFuncionFiltro)funcionPredicado;
        return this.listarAutor(funcion);
    }
    @Override
    default List<AutorDetalle> listarDetallado(SuperEntidadFuncionFiltro<Integer, ? extends Autor, ? extends SuperEntidadDefinicion<Integer, ? extends Autor>> funcionPredicado) {
        AutorFuncionFiltro funcion = (AutorFuncionFiltro)funcionPredicado;
        return this.listarAutorDetallado(funcion);
    }
}
