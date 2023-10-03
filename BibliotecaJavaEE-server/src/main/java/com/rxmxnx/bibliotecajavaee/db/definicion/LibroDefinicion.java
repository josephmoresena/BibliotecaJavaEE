/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db.definicion;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.*;

/**
 *
 * @author atem94
 * @param <TLibro>
 * @param <TAutor>
 * @param <TPais>
 * @param <TGenero>
 */
public interface LibroDefinicion<TLibro extends Libro, TAutor extends Autor, TPais extends Pais, TGenero extends Genero> extends SuperDefinicion<Integer, TLibro> {
    @Override
    IntField<TLibro> id();
    StringField<TLibro> titulo();
    StringField<TLibro> isbn();
    ReferenceField<TLibro, String> sinopsis();
    IntField<TLibro> autorId();
    ShortField<TLibro> generoId();
    ShortField<TLibro> PaisId();
    
    ReferenceField<TLibro, TAutor> autor();
    ReferenceField<TLibro, TGenero> genero();
    ReferenceField<TLibro, TPais> paisPublicacion(); 
}
