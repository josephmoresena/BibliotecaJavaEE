/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.predicate.SpeedmentPredicate;
import java.util.*;
import java.util.function.Function;
import javax.ejb.*;

/**
 *
 * @author atem94
 */
@Remote
public interface UsuarioDao extends SuperEntidadDao<Integer, Usuario> {
    @Override
    List<Usuario> listar();
    List<Usuario> listarUsuario(Function<? extends UsuarioDefinicion, SpeedmentPredicate<? extends Usuario>> funcionPredicado);
    @Override
    Optional<Usuario> encontrar(Integer id);
    @Override
    Usuario guardar(Usuario entidad);
    @Override
    boolean eliminar(Integer id);
    
    @Override
    default List<Usuario> listar(Function<? extends SuperDefinicion<Integer, ? extends Usuario>, SpeedmentPredicate<? extends Usuario>> funcionPredicado) {
        Function<? extends UsuarioDefinicion, SpeedmentPredicate<? extends Usuario>> funcion = (Function)funcionPredicado;
        return this.listarUsuario(funcion);
    }
}
