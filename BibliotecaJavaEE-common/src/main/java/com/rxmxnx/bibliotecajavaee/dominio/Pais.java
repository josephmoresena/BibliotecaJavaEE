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
@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pais extends SuperEntidad<Short> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    private String nombre;
    @OneToMany(mappedBy = "pais")
    private Set<Autor> autorSet;
    @OneToMany(mappedBy = "pais")
    private Set<Libro> libroSet;

    public Pais() {
    }
    public Pais(Short id) {
        super(id);
    }
    public Pais(String nombre) {
        this.nombre = nombre;
    }
    public Pais(Pais pais) {
        this(pais, false, false);
    }
    public Pais(Pais pais, boolean tieneAutores, boolean tieneLibros) {
        super(pais.getId());
        this.nombre = pais.getNombre();
        
        if (tieneAutores)
            this.autorSet = pais.getAutorSet();
        if (tieneLibros)
            this.libroSet = pais.getLibroSet();
    }

    public Short getPaisId() {
        return super.getId();
    }
    public String getNombre() {
        return nombre;
    }

    @XmlTransient
    public Set<Autor> getAutorSet() {
        return autorSet;
    }
    @XmlTransient
    public Set<Libro> getLibroSet() {
        return libroSet;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    protected void setAutorSet(Set<Autor> autorSet) {
        this.autorSet = autorSet;
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
        if (!(object instanceof Pais)) {
            return false;
        }
        return super.equals(object);
    }
    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + '}';
    }
}
