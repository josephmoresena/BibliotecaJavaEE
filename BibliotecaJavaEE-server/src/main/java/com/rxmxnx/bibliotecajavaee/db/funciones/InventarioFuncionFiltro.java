/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db.funciones;

import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;

/**
 *
 * @author atem94
 * @param <TInventario>
 * @param <TDefinicion>
 */
@FunctionalInterface
public interface InventarioFuncionFiltro<TInventario extends Inventario, TDefinicion extends InventarioDefinicion<TInventario, ? extends Libro>> 
        extends SuperEntidadFuncionFiltro<Integer, TInventario, TDefinicion> {
}
