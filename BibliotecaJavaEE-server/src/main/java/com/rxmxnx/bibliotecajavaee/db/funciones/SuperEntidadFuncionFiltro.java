/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db.funciones;

import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.predicate.*;
import java.io.*;
import java.util.function.*;

/**
 *
 * @author atem94
 * @param <U>
 * @param <T>
 * @param <TDefinicion>
 */
@FunctionalInterface
public interface SuperEntidadFuncionFiltro<U extends Number & Comparable<U>, T extends SuperEntidad<U>, TDefinicion extends SuperEntidadDefinicion<U, ? extends T>> 
        extends Serializable, Function<TDefinicion, SpeedmentPredicate<? extends T>> {
}
