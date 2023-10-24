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
 * @param <TPrestamo>
 * @param <TDefinicion>
 */
@FunctionalInterface
public interface PrestamoFuncionFiltro<TPrestamo extends Prestamo, TDefinicion extends PrestamoDefinicion<TPrestamo, ? extends Libro, ? extends Usuario>>
    extends SuperEntidadFuncionFiltro<Long, TPrestamo, TDefinicion> {
}
