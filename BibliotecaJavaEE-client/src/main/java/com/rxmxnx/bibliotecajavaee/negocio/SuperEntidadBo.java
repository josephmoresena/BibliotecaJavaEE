/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.negocio;

import com.rxmxnx.bibliotecajavaee.dominio.SuperEntidad;
import com.rxmxnx.bibliotecajavaee.excepciones.*;
import java.util.List;

/**
 *
 * @author atem94
 * @param <T>
 * @param <U>
 * @param <TDetalle>
 */
public interface SuperEntidadBo<U extends Number & Comparable<U>, T extends SuperEntidad<U>, TDetalle extends T> {
    List<T> listar();
    List<TDetalle> listarDetallado();
    
    T encontrar(U id) throws RegistroNoEncontrado;
    TDetalle encontrarDetallado(U id) throws RegistroNoEncontrado;
    
    U crear(T entidad) throws RegistroExiste;
    void modificar(T entidad) throws RegistroNoEncontrado, RegistroExiste;
    void eliminar(U id) throws RegistroNoEncontrado;
}
