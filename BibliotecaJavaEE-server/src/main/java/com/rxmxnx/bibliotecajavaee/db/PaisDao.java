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
public interface PaisDao extends SuperEntidadDao<Short, Pais, PaisDetalle> {
    @Override
    List<Pais> listar();
    List<Pais> listarPais(PaisFuncionFiltro funcionPredicado);
    @Override
    Optional<Pais> encontrar(Short id);
    @Override
    Pais guardar(Pais entidad);
    @Override
    boolean eliminar(Short id);
    
    @Override
    List<PaisDetalle> listarDetallado();
    List<PaisDetalle> listarPaisDetallado(PaisFuncionFiltro funcionPredicado);
    @Override
    Optional<PaisDetalle> encontrarDetallado(Short id);
    
    @Override
    default List<Pais> listar(SuperEntidadFuncionFiltro<Short, ? extends Pais, ? extends SuperEntidadDefinicion<Short, ? extends Pais>> funcionPredicado) {
        PaisFuncionFiltro funcion = (PaisFuncionFiltro)funcionPredicado;
        return this.listarPais(funcion);
    }
    @Override
    default List<PaisDetalle> listarDetallado(SuperEntidadFuncionFiltro<Short, ? extends Pais, ? extends SuperEntidadDefinicion<Short, ? extends Pais>> funcionPredicado) {
        PaisFuncionFiltro funcion = (PaisFuncionFiltro)funcionPredicado;
        return this.listarPaisDetallado(funcion);
    }
}
