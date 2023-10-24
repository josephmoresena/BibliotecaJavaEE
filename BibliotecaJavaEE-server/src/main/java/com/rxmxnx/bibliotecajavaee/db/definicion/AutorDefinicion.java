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
 * @param <TAutor>
 * @param <TPais>
 * @param <TLibro>
 */
public interface AutorDefinicion<TAutor extends Autor, TPais extends Pais, TLibro extends Libro> extends SuperEntidadDefinicion<Integer, TAutor> {
    @Override
    IntField<TAutor> id();
    StringField<TAutor> nombre();
    StringField<TAutor> apellido();
    ComparableField<TAutor, Date> fechaNacimiento();
    ShortField<TAutor> paisId();
    
    ReferenceField<TAutor, TPais> pais();
    ReferenceField<TAutor, Set<TLibro>> libroSet();
}
