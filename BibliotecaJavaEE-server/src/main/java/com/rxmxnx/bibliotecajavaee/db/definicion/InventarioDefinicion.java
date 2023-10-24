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
 * @param <TInventario>
 * @param <TLibro>
 */
public interface InventarioDefinicion<TInventario extends Inventario, TLibro extends Libro> extends SuperEntidadDefinicion<Integer, TInventario> {
    @Override
    IntField<TInventario> id();
    StringField<TInventario> estante();
    IntField<TInventario> cantidadEjemplares();
    IntField<TInventario> libroId();
    
    ReferenceField<TInventario, TLibro> libro();
}
