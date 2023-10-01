/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import com.speedment.jpastreamer.field.*;
import java.util.*;

/**
 *
 * @author atem94
 * @param <T>
 */
public interface PrestamoDefinicion<T extends Prestamo> extends SuperDefinicion<Long, T> {
    @Override
    LongField<T> id();
    ComparableField<T, Date> fechaPrestamo();
    ComparableField<T, Date> fechaDevolucion();
    BooleanField<T> devuelto();
    
    ReferenceField<T, Libro> libro();
    ReferenceField<T, Usuario> usuario();
}
