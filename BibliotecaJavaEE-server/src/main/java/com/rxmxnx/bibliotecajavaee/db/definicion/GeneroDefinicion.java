/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db.definicion;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.*;
import java.util.Set;

/**
 *
 * @author atem94
 * @param <TGenero>
 * @param <TLibro>
 */
public interface GeneroDefinicion<TGenero extends Genero, TLibro extends Libro> extends SuperEntidadDefinicion<Short, TGenero> {
    @Override
    ShortField<TGenero> id();
    StringField<TGenero> nombre();
    
    ReferenceField<TGenero, Set<TLibro>> libroSet();
}
