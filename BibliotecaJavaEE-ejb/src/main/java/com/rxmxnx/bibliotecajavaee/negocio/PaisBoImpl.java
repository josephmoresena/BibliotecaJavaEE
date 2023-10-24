/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.negocio;

import com.rxmxnx.bibliotecajavaee.db.*;
import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import com.rxmxnx.bibliotecajavaee.excepciones.*;
import com.speedment.jpastreamer.field.predicate.*;
import java.util.*;
import javax.ejb.*;
import com.rxmxnx.bibliotecajavaee.db.funciones.PaisFuncionFiltro;

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
        Filtro filtro = new Filtro(true, entidad.getNombre());
        Optional<Pais> paisExistente = this.dao.listarPais(filtro).stream().findFirst();
        if (paisExistente != null)
            throw new RegistroExiste("Nombre: " + entidad.getNombre(), Pais.class, paisExistente.get().getPaisId());
    }
    
    @Override
    public List<PaisDetalle> buscarPorNombre(String nombre) {
        Filtro filtro = new Filtro(false, nombre);
        return this.dao.listarPaisDetallado(filtro);
    }
    
    private static class Filtro<TPais extends Pais, TDefinicion extends PaisDefinicion<TPais, ?, ?>> implements PaisFuncionFiltro<TPais, TDefinicion> {
        private final boolean igual;
        private final String nombre;

        public Filtro(boolean igual,  String nombre) {
            this.igual = igual;
            this.nombre = nombre;
        }
        
        @Override
        public SpeedmentPredicate<TPais> apply(TDefinicion d) {
            return this.igual ? d.nombre().equal(this.nombre) : d.nombre().contains(this.nombre);
        }
    }
}