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
 * @param <TPrestamo>
 * @param <TLibro>
 * @param <TPais>
 */
public interface PrestamoDefinicion<TPrestamo extends Prestamo, TLibro extends Libro, TPais extends Usuario> extends SuperDefinicion<Long, TPrestamo> {
    @Override
    LongField<TPrestamo> id();
    ComparableField<TPrestamo, Date> fechaPrestamo();
    ComparableField<TPrestamo, Date> fechaDevolucion();
    BooleanField<TPrestamo> devuelto();
    IntField<TPrestamo> libroId();
    IntField<TPrestamo> usuarioId();
    
    ReferenceField<TPrestamo, TLibro> libro();
    ReferenceField<TPrestamo, TPais> usuario();
}
