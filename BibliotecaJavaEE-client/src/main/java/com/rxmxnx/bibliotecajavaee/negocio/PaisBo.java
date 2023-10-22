/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.negocio;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import com.rxmxnx.bibliotecajavaee.excepciones.*;
import java.util.*;
import javax.ejb.*;

/**
 *
 * @author atem94
 */
@Remote
public interface PaisBo extends SuperEntidadBo<Short, Pais, PaisDetalle> {
    @Override
    List<Pais> listar();
    @Override
    List<PaisDetalle> listarDetallado();
    
    @Override
    Pais encontrar(Short id) throws RegistroNoEncontrado;
    @Override
    PaisDetalle encontrarDetallado(Short id) throws RegistroNoEncontrado;
    
    @Override
    Short crear(Pais entidad) throws RegistroExiste;
    @Override
    void modificar(Pais entidad) throws RegistroNoEncontrado;
    @Override
    void eliminar(Short id) throws RegistroNoEncontrado;
    
    List<PaisDetalle> buscarPorNombre(String nombre);
}
