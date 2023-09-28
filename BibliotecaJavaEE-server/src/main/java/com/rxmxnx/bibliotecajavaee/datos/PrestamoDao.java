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
public interface PrestamoDao extends SuperEntidadDao<Long, Prestamo> {
    @Override
    List<Prestamo> listar();
    @Override
    List<Prestamo> listar(SpeedmentPredicate<Prestamo> predicado);
    @Override
    Optional<Prestamo> encontrar(Long id);
    @Override
    Prestamo guardar(Prestamo entidad);
    @Override
    boolean eliminar(Long id);
}
