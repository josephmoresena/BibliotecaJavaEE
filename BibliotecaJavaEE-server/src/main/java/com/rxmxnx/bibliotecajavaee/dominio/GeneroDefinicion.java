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
 */
public interface GeneroDefinicion extends SuperDefinicion<Genero> {
    @Override
    ShortField<Genero> id();
    StringField<Genero> nombre();
    
    ReferenceField<Genero, Set<Libro>> libroSet();
}
