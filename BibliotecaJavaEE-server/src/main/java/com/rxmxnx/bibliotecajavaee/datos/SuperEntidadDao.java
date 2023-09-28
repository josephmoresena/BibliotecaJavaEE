/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.speedment.jpastreamer.field.predicate.*;
import java.util.*;
import javax.ejb.Remote;

/**
 *
 * @author atem94
 * @param <U>
 * @param <TEntidad>
 */
@Remote
public interface SuperEntidadDao<U extends Number & Comparable<U>, TEntidad extends SuperEntidad<U>> {
    List<TEntidad> listar();
    List<TEntidad> listar(SpeedmentPredicate<TEntidad> predicado);
    Optional<TEntidad> encontrar(U id);
    TEntidad guardar(TEntidad entidad);
    boolean eliminar(U id);
}
