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
public interface PaisDao extends SuperEntidadDao<Short, Pais> {
    @Override
    List<Pais> listar();
    @Override
    List<Pais> listar(SpeedmentPredicate<Pais> predicado);
    @Override
    Optional<Pais> encontrar(Short id);
    @Override
    Pais guardar(Pais entidad);
    @Override
    boolean eliminar(Short id);
}
