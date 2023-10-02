/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import com.speedment.jpastreamer.field.*;

/**
 *
 * @author atem94
 * @param <T>
 */
public interface LibroDefinicion<T extends Libro> extends SuperDefinicion<Integer, T> {
    @Override
    IntField<T> id();
    StringField<T> titulo();
    StringField<Libro> isbn();
    ReferenceField<T, String> sinopsis();
    IntField<T> autorId();
    ShortField<T> generoId();
    ShortField<T> PaisId();
    
    ReferenceField<T, Autor> autor();
    ReferenceField<T, Genero> genero();
    ReferenceField<T, Pais> paisPublicacion(); 
}
