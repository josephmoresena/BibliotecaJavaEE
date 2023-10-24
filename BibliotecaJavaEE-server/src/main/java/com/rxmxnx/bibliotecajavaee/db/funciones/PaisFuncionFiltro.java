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
 * @param <TPais>
 * @param <TDefinicion>
 */
@FunctionalInterface
public interface PaisFuncionFiltro<TPais extends Pais, TDefinicion extends PaisDefinicion<TPais, ? extends Libro, ? extends Autor>> 
        extends SuperEntidadFuncionFiltro<Short, TPais, TDefinicion> {
}
