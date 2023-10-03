/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db.definicion;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.*;
import java.util.*;

/**
 *
 * @author atem94
 * @param <TPais>
 * @param <TLibro>
 * @param <TAutor>
 */
public interface PaisDefinicion<TPais extends Pais, TLibro extends Libro, TAutor extends Autor> extends SuperDefinicion<Short, TPais> {
    @Override
    ShortField<TPais> id();
    StringField<TPais> nombre();
    
    ReferenceField<TPais, Set<TLibro>> libroSet();
    ReferenceField<TPais, Set<TAutor>> autorSet();
}
