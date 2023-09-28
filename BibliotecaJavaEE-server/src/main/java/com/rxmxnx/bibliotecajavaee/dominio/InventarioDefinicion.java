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
public interface InventarioDefinicion extends SuperDefinicion<Inventario> {
    @Override
    LongField<Inventario> id();
    StringField<Inventario> estante();
    IntField<Inventario> cantidadEjemplares();
    
    ReferenceField<Inventario, Libro> libro();
}
