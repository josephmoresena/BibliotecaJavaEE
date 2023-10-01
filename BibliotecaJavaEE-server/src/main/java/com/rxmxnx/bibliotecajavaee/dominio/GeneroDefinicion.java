/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import com.speedment.jpastreamer.field.*;
import java.util.Set;

/**
 *
 * @author atem94
 * @param <T>
 */
public interface GeneroDefinicion<T extends Genero> extends SuperDefinicion<Short, T> {
    @Override
    ShortField<T> id();
    StringField<T> nombre();
    
    ReferenceField<T, Set<Libro>> libroSet();
}
