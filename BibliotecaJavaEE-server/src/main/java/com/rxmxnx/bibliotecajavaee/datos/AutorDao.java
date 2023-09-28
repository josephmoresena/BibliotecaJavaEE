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
public interface AutorDao extends SuperEntidadDao<Integer, Autor> {
    @Override
    List<Autor> listar();
    @Override
    List<Autor> listar(SpeedmentPredicate<Autor> predicado);
    @Override
    Optional<Autor> encontrar(Integer id);
    @Override
    Autor guardar(Autor entidad);
    @Override
    boolean eliminar(Integer id);
}
