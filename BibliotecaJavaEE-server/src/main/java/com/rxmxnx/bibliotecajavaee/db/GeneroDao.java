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
public interface GeneroDao extends SuperEntidadDao<Short, Genero, GeneroDetalle> {
    @Override
    List<Genero> listar();
    List<Genero> listarGenero(GeneroFuncionFiltro funcionPredicado);
    @Override
    Optional<Genero> encontrar(Short id);
    @Override
    Genero guardar(Genero entidad);
    @Override
    boolean eliminar(Short id);
    
    @Override
    List<GeneroDetalle> listarDetallado();
    List<GeneroDetalle> listarGeneroDetallado(GeneroFuncionFiltro funcionPredicado);
    @Override
    Optional<GeneroDetalle> encontrarDetallado(Short id);
    
    @Override
    default List<Genero> listar(SuperEntidadFuncionFiltro<Short, ? extends Genero, ? extends SuperEntidadDefinicion<Short, ? extends Genero>> funcionPredicado) {
        GeneroFuncionFiltro funcion = (GeneroFuncionFiltro)funcionPredicado;
        return this.listarGenero(funcion);
    }
    @Override
    default List<GeneroDetalle> listarDetallado(SuperEntidadFuncionFiltro<Short, ? extends Genero, ? extends SuperEntidadDefinicion<Short, ? extends Genero>> funcionPredicado) {
        GeneroFuncionFiltro funcion = (GeneroFuncionFiltro)funcionPredicado;
        return this.listarGeneroDetallado(funcion);
    }
}
