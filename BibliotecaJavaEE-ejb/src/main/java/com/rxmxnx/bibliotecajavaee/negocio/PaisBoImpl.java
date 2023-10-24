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
import com.rxmxnx.bibliotecajavaee.db.funciones.*;

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
    protected void validarUnicidad(Pais entidad) throws RegistroExiste, RegistroExiste {
        FuncionFiltroNombre filtro = new FuncionFiltroNombre(entidad);
        Optional<Pais> paisExistente = this.dao.listarPais(filtro).stream().findAny();
        if (paisExistente.isPresent())
            throw new RegistroExiste("Nombre: " + entidad.getNombre(), Pais.class, paisExistente.get().getPaisId());
    }
    @Override
    protected PaisFuncionFiltro crearFiltroId(FuncionFiltroId<Short, Pais> funcion) {
        return new FuncionFiltroPaisId(funcion);
    }
    
    @Override
    public List<PaisDetalle> buscarPorNombre(String nombre) {
        FuncionFiltroNombre filtro = new FuncionFiltroNombre(nombre);
        return this.dao.listarPaisDetallado(filtro);
    }
    
    private static class FuncionFiltroNombre<TPais extends Pais, TDefinicion extends PaisDefinicion<TPais, ?, ?>> implements PaisFuncionFiltro<TPais, TDefinicion> {
        private final boolean igual;
        private final String nombre;
        private final FuncionFiltroId funcionExcluir;

        public FuncionFiltroNombre(String nombre) {
            this.igual = false;
            this.funcionExcluir = null;
            this.nombre = nombre;
        }
        public FuncionFiltroNombre(Pais pais) {
            this.igual = true;
            this.nombre = pais.getNombre();
            this.funcionExcluir = pais.getPaisId() != null ? new FuncionFiltroId(true, pais.getPaisId()) : null;
        }
        
        @Override
        public SpeedmentPredicate<TPais> apply(TDefinicion d) {
            SpeedmentPredicate<TPais> filtro = this.igual ? d.nombre().equal(this.nombre) : d.nombre().contains(this.nombre);
            if (this.funcionExcluir != null)
                filtro = filtro.and(this.funcionExcluir.apply(d));
            return filtro;
        }
    }
    private static class FuncionFiltroPaisId<TPais extends Pais, TDefinicion extends PaisDefinicion<TPais, ?, ?>> implements PaisFuncionFiltro<TPais, TDefinicion> {
        private final FuncionFiltroId funcion;
        
        public FuncionFiltroPaisId(FuncionFiltroId<Short, Pais> funcion) {
            this.funcion = funcion;
        }
        
        @Override
        public SpeedmentPredicate<TPais> apply(TDefinicion d) {
            return this.funcion.apply(d);
        }
    }
}