/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos.definiciones;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.trait.*;

/**
 *
 * @author atem94
 * @param <U>
 * @param <TEntidad>
 */
public interface SuperDefinicion<U extends Number & Comparable<U>, TEntidad extends SuperEntidad<U>> {
    Class<? extends TEntidad> clase();
    HasComparableOperators<TEntidad, U> id();
}