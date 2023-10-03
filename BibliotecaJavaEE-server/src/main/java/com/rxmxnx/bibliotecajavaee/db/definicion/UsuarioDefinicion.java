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
 * @param <TUsuario>
 * @param <TPrestamo>
 */
public interface UsuarioDefinicion<TUsuario extends Usuario, TPrestamo extends Prestamo> extends SuperDefinicion<Integer, TUsuario> {
    @Override
    IntField<TUsuario> id();
    StringField<TUsuario> nombre();
    StringField<TUsuario> email();
    
    ReferenceField<TUsuario, Set<TPrestamo>> prestamoSet();
}
