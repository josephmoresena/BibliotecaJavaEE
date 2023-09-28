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
 */
public interface PrestamoDefinicion extends SuperDefinicion<Prestamo> {
    @Override
    LongField<Prestamo> id();
    ComparableField<Prestamo, Date> fechaPrestamo();
    ComparableField<Prestamo, Date> fechaDevolucion();
    BooleanField<Prestamo> devuelto();
    
    ReferenceField<Prestamo, Libro> libro();
    ReferenceField<Prestamo, Usuario> usuario();
}
