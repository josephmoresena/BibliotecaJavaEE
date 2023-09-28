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
 */
public interface LibroDefinicion extends SuperDefinicion<Libro> {
    @Override
    IntField<Libro> id();
    StringField<Libro> titulo();
    StringField<Libro> isbn();
    ReferenceField<Libro, String> sinopsis();
    
    ReferenceField<Libro, Autor> autor();
    ReferenceField<Libro, Genero> genero();
    ReferenceField<Libro, Pais> paisPublicacion(); 
}
