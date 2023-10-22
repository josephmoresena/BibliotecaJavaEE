/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.negocio;

import com.rxmxnx.bibliotecajavaee.db.*;
import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.excepciones.*;
import java.util.List;
import java.util.Optional;

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
    public void modificar(T entidad) throws RegistroNoEncontrado {
        U id = SuperEntidad.getId(entidad);
        if (id == null)
            throw new RegistroNoEncontrado(this.claseT);
        if (this.getDao().listar(f -> f.id().equal(id)).isEmpty())
            throw new RegistroNoEncontrado(this.claseT, id);
        this.getDao().guardar(entidad);
    }

    @Override
    public void eliminar(U id) throws RegistroNoEncontrado {
        if (id == null)
            throw new RegistroNoEncontrado(this.claseT);
        if (this.getDao().listar(f -> f.id().equal(id)).isEmpty())
            throw new RegistroNoEncontrado(this.claseT, id);
        this.getDao().eliminar(id);
    }
    
    protected abstract SuperEntidadDao<U, T, TDetalle> getDao();
    protected abstract void validarUnicidad(T entidad) throws RegistroExiste;
}
