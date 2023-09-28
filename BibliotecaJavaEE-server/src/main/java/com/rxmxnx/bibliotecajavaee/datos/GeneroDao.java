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
public interface GeneroDao extends SuperEntidadDao<Short, Genero> {
    @Override
    List<Genero> listar();
    @Override
    List<Genero> listar(SpeedmentPredicate<Genero> predicado);
    @Override
    Optional<Genero> encontrar(Short id);
    @Override
    Genero guardar(Genero entidad);
    @Override
    boolean eliminar(Short id);
}
