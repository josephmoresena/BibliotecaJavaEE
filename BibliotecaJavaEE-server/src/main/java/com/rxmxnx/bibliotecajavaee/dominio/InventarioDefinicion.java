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
public interface InventarioDefinicion<T extends Inventario> extends SuperDefinicion<Integer, T> {
    @Override
    IntField<T> id();
    StringField<T> estante();
    IntField<T> cantidadEjemplares();
    IntField<T> libroId();
    
    ReferenceField<T, Libro> libro();
}
