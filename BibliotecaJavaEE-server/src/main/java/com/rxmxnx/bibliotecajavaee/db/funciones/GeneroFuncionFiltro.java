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
 * @param <TGenero>
 * @param <TDefinicion>
 */
@FunctionalInterface
public interface GeneroFuncionFiltro<TGenero extends Genero, TDefinicion extends GeneroDefinicion<TGenero, ? extends Libro>> 
        extends SuperEntidadFuncionFiltro<Short, TGenero, TDefinicion> {
}
