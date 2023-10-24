/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.negocio;

import com.rxmxnx.bibliotecajavaee.db.*;
import com.rxmxnx.bibliotecajavaee.db.definicion.*;
import com.rxmxnx.bibliotecajavaee.db.funciones.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.excepciones.*;
import com.speedment.jpastreamer.field.predicate.*;
import java.util.*;

/**
 *
 * @author atem94
 * @param <U>
 * @param <T>
 * @param <TDetalle>
 */
public abstract class SuperEntidadBoImpl<U extends Number & Comparable<U>, T extends SuperEntidad<U>, TDetalle extends T> implements SuperEntidadBo<U, T, TDetalle>  {
    private final Class<T> claseT;
    
    public SuperEntidadBoImpl(Class<T> claseT) {
        this.claseT = claseT;
    }

    @Override
    public List<T> listar() {
        return this.getDao().listar();
    }

    @Override
    public List<TDetalle> listarDetallado() {
        return this.getDao().listarDetallado();
    }
    
    @Override
    public T encontrar(U id) throws RegistroNoEncontrado {
        Optional<TDetalle> resultado = this.getDao().encontrarDetallado(id);
        if (!resultado.isPresent())
            throw new RegistroNoEncontrado(this.claseT, id);
        return resultado.get();
    }

    @Override
    public TDetalle encontrarDetallado(U id) throws RegistroNoEncontrado {
        Optional<TDetalle> resultado = this.getDao().encontrarDetallado(id);
        if (!resultado.isPresent())
            throw new RegistroNoEncontrado(this.claseT, id);
        return resultado.get();
    }

    @Override
    public U crear(T entidad) throws RegistroExiste {
        U id = SuperEntidad.getId(entidad);
        if (id != null)
            throw new RegistroExiste("id: " + id, this.claseT, id);
        this.validarUnicidad(entidad);
        return SuperEntidad.getId(this.getDao().guardar(entidad));
    }

    @Override
    public void modificar(T entidad) throws RegistroNoEncontrado, RegistroExiste {
        U id = SuperEntidad.getId(entidad);
        if (id == null)
            throw new RegistroNoEncontrado(this.claseT);
        SuperEntidadFuncionFiltro filtro = this.crearFiltroId(new FuncionFiltroId(id));
        if (this.getDao().listar(filtro).isEmpty())
            throw new RegistroNoEncontrado(this.claseT, id);
        this.validarUnicidad(entidad);
        this.getDao().guardar(entidad);
    }

    @Override
    public void eliminar(U id) throws RegistroNoEncontrado {
        if (id == null)
            throw new RegistroNoEncontrado(this.claseT);
        SuperEntidadFuncionFiltro filtro = this.crearFiltroId(new FuncionFiltroId(id));
        if (this.getDao().listar(filtro).isEmpty())
            throw new RegistroNoEncontrado(this.claseT, id);
        this.getDao().eliminar(id);
    }
    
    protected abstract SuperEntidadDao<U, T, TDetalle> getDao();
    protected abstract void validarUnicidad(T entidad) throws RegistroExiste;
    protected abstract SuperEntidadFuncionFiltro<U, T, ? extends SuperEntidadDefinicion<U, ? extends T>> crearFiltroId(FuncionFiltroId<U, T> funcion);
    
    protected static class FuncionFiltroId<U extends Number & Comparable<U>, T extends SuperEntidad<U>>  implements SuperEntidadFuncionFiltro<U, T, SuperEntidadDefinicion<U, ? extends T>> {
        private final boolean exclusion;
        private final List<U> identificadores = new ArrayList<>();
        
        public FuncionFiltroId(U id) {
            this(false, id);
        }
        public FuncionFiltroId(U... identificadores) {
            this(false, identificadores);
        }
        public FuncionFiltroId(boolean exclusion, U id) {
            this.exclusion = exclusion;
            this.identificadores.add(id);
        }
        public FuncionFiltroId(boolean exclusion, U... identificadores) {
            this.exclusion = exclusion;
            this.identificadores.addAll(this.identificadores);
        }
        
        @Override
        public SpeedmentPredicate<? extends T> apply(SuperEntidadDefinicion<U, ? extends T> d) {
            return !this.exclusion ? d.id().in(this.identificadores) : d.id().notIn(this.identificadores);
        }
    }
}
