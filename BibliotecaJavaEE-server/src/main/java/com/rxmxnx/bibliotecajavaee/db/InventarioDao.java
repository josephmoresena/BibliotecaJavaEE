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
public interface InventarioDao extends SuperEntidadDao<Integer, Inventario, InventarioDetalle> {
    @Override
    List<Inventario> listar();
    List<Inventario> listarInventario(InventarioFuncionFiltro funcionPredicado);
    @Override
    Optional<Inventario> encontrar(Integer id);
    @Override
    Inventario guardar(Inventario entidad);
    @Override
    boolean eliminar(Integer id);
    
    @Override
    List<InventarioDetalle> listarDetallado();
    List<InventarioDetalle> listarInventarioDetallado(InventarioFuncionFiltro funcionPredicado);
    @Override
    Optional<InventarioDetalle> encontrarDetallado(Integer id);
    
    @Override
    default List<Inventario> listar(SuperEntidadFuncionFiltro<Integer, ? extends Inventario, ? extends SuperEntidadDefinicion<Integer, ? extends Inventario>> funcionPredicado) {
        InventarioFuncionFiltro funcion = (InventarioFuncionFiltro)funcionPredicado;
        return this.listarInventario(funcion);
    }
    @Override
    default List<InventarioDetalle> listarDetallado(SuperEntidadFuncionFiltro<Integer, ? extends Inventario, ? extends SuperEntidadDefinicion<Integer, ? extends Inventario>> funcionPredicado) {
        InventarioFuncionFiltro funcion = (InventarioFuncionFiltro)funcionPredicado;
        return this.listarInventarioDetallado(funcion);
    }
}
