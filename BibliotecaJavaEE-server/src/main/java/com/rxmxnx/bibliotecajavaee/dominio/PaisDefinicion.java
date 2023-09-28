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
public interface PaisDefinicion extends SuperDefinicion<Pais> {
    @Override
    ShortField<Pais> id();
    StringField<Pais> nombre();
    
    ReferenceField<Pais, Set<Libro>> libroSet();
    ReferenceField<Pais, Set<Autor>> autorSet();
}
