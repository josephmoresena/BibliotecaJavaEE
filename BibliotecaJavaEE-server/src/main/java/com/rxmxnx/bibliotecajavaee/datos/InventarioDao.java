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
public interface InventarioDao extends SuperEntidadDao<Integer, Inventario> {
    @Override
    List<Inventario> listar();
    @Override
    List<Inventario> listar(SpeedmentPredicate<Inventario> predicado);
    @Override
    Optional<Inventario> encontrar(Integer id);
    @Override
    Inventario guardar(Inventario entidad);
    @Override
    boolean eliminar(Integer id);
}
