/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.predicate.SpeedmentPredicate;
import java.util.*;
import javax.ejb.*;

/**
 *
 * @author atem94
 */
@Remote
public interface LibroDao extends SuperEntidadDao<Integer, Libro> {
    @Override
    List<Libro> listar();
    @Override
    List<Libro> listar(SpeedmentPredicate<Libro> predicado);
    @Override
    Optional<Libro> encontrar(Integer id);
    @Override
    Libro guardar(Libro entidad);
    @Override
    boolean eliminar(Integer id);
}
