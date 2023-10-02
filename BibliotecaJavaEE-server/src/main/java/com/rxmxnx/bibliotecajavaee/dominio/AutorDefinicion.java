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
public interface AutorDefinicion<T extends Autor> extends SuperDefinicion<Integer, T> {
    @Override
    IntField<T> id();
    StringField<T> nombre();
    StringField<T> apellido();
    ComparableField<T, Date> fechaNacimiento();
    ShortField<T> paisId();
    
    ReferenceField<Autor, Pais> pais();
    ReferenceField<Autor, Set<Libro>> libroSet();
}
