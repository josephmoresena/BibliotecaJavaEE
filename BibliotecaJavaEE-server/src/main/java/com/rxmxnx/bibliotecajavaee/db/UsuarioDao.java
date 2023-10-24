/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db;

import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import java.util.*;
import javax.ejb.*;
import com.rxmxnx.bibliotecajavaee.db.funciones.*;

/**
 *
 * @author atem94
 */
@Remote
public interface UsuarioDao extends SuperEntidadDao<Integer, Usuario, UsuarioDetalle> {
    @Override
    List<Usuario> listar();
    List<Usuario> listarUsuario(UsuarioFuncionFiltro funcionPredicado);
    @Override
    Optional<Usuario> encontrar(Integer id);
    @Override
    Usuario guardar(Usuario entidad);
    @Override
    boolean eliminar(Integer id);
    
    @Override
    List<UsuarioDetalle> listarDetallado();
    List<UsuarioDetalle> listarUsuarioDetallado(UsuarioFuncionFiltro funcionPredicado);
    @Override
    Optional<UsuarioDetalle> encontrarDetallado(Integer id);
    
    @Override
    default List<Usuario> listar(SuperEntidadFuncionFiltro<Integer, ? extends Usuario, ? extends SuperEntidadDefinicion<Integer, ? extends Usuario>> funcionPredicado) {
        UsuarioFuncionFiltro funcion = (UsuarioFuncionFiltro)funcionPredicado;
        return this.listarUsuario(funcion);
    }
    @Override
    default List<UsuarioDetalle> listarDetallado(SuperEntidadFuncionFiltro<Integer, ? extends Usuario, ? extends SuperEntidadDefinicion<Integer, ? extends Usuario>> funcionPredicado) {
        UsuarioFuncionFiltro funcion = (UsuarioFuncionFiltro)funcionPredicado;
        return this.listarUsuarioDetallado(funcion);
    }
}
