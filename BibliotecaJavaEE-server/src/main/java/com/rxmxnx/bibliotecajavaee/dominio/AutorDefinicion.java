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
public interface AutorDefinicion extends SuperDefinicion<Autor> {
    @Override
    IntField<Autor> id();
    StringField<Autor> nombre();
    StringField<Autor> apellido();
    ComparableField<Autor, Date> fechaNacimiento();
    
    ReferenceField<Autor, Pais> pais();
    ReferenceField<Autor, Set<Libro>> libroSet();
}
