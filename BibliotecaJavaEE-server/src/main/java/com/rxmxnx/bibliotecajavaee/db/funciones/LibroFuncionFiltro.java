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
 * @param <TLibro>
 * @param <TDefinicion>
 */
@FunctionalInterface
public interface LibroFuncionFiltro<TLibro extends Libro, TDefinicion extends LibroDefinicion<TLibro, ? extends Autor, ? extends Pais, ? extends Genero>> 
    extends SuperEntidadFuncionFiltro<Integer, TLibro, TDefinicion> {
}
