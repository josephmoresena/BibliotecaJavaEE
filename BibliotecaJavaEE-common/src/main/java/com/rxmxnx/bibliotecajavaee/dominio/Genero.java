/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import java.io.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author atem94
 */
@MappedSuperclass
@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Genero extends SuperEntidad<Short> implements Serializable {
    protected static final long ENTIDAD_VERSION = 1L;
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private String nombre;

    public Genero() {
    }
    public Genero(Short id) {
        super(id);
    }
    public Genero(String nombre) {
        this.nombre = nombre;
    }
    public Genero(Genero genero) {
        super(genero.getId());
        this.nombre = genero.getNombre();
    }

    public Short getGeneroId() {
        return super.getId();
    }
    @Basic(optional = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        return super.equals(object);
    }
    @Override
    public String toString() {
        return "Genero{" + "id=" + this.getId() + ", nombre=" + nombre + '}';
    }
}
