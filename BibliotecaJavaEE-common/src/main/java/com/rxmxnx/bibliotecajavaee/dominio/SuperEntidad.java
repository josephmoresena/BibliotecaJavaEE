/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import javax.persistence.*;

/**
 *
 * @author atem94
 * @param <T>
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class SuperEntidad<T extends Number & Comparable<T>> {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    private T id;
    
    protected SuperEntidad() { }
    protected SuperEntidad(T id) { this.id = id; }
    
    protected T getId() {
        return this.id;
    }
    protected void setId(T id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SuperEntidad)) {
            return false;
        }
        SuperEntidad other = (SuperEntidad)object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
    
    public static <U extends Number & Comparable<U>> U getId(SuperEntidad<U> entidad) {
        if (entidad == null)
            return null;
        return entidad.getId();
    }
}
