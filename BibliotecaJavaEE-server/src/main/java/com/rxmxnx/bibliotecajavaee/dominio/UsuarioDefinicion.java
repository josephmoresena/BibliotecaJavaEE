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
public interface UsuarioDefinicion extends SuperDefinicion<Usuario> {
    @Override
    IntField<Usuario> id();
    StringField<Usuario> nombre();
    StringField<Usuario> email();
    
    ReferenceField<Usuario, Set<Prestamo>> prestamoSet();
}
