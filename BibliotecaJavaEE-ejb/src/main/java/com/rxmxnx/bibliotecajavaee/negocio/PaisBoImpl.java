/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.negocio;

import com.rxmxnx.bibliotecajavaee.db.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import com.rxmxnx.bibliotecajavaee.excepciones.*;
import java.util.*;
import javax.ejb.*;

/**
 *
 * @author atem94
 */
@Stateless
public class PaisBoImpl extends SuperEntidadBoImpl<Short, Pais, PaisDetalle> implements PaisBo {
    @EJB
    private PaisDao dao;

    public PaisBoImpl() {
        super(Pais.class);
    }

    @Override
    protected PaisDao getDao() {
        return this.dao;
    }
    @Override
    protected void validarUnicidad(Pais entidad) throws RegistroExiste {
        Optional<Pais> paisExistente = this.dao.listarPais(f -> f.nombre().equal(entidad.getNombre())).stream().findFirst();
        if (paisExistente != null)
            throw new RegistroExiste("Nombre: " + entidad.getNombre(), Pais.class, paisExistente.get().getPaisId());
    }
    
    @Override
    public List<PaisDetalle> buscarPorNombre(String nombre) {
        return this.dao.listarPaisDetallado(f -> f.nombre().contains(nombre));
    }
}
