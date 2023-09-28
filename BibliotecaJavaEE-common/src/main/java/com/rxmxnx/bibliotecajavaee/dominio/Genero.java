/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author atem94
 */
@MappedSuperclass
@Table(name = "GENEROS")
@XmlRootElement
public class Genero extends SuperEntidad<Short> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    private String nombre;
    @OneToMany(mappedBy = "genero")
    private Set<Libro> libroSet;

    public Genero() {
    }
    public Genero(Short id) {
        super(id);
    }
    public Genero(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Short getId() {
        return super.getId();
    }
    public String getNombre() {
        return nombre;
    }
    
    @XmlTransient
    public Set<Libro> getLibroSet() {
        return libroSet;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    protected void setLibroSet(Set<Libro> libroSet) {
        this.libroSet = libroSet;
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
