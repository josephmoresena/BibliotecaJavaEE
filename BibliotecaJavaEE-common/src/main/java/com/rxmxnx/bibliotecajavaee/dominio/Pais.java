/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import com.rxmxnx.bibliotecajavaee.util.*;
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
public class Pais extends SuperEntidad<Short> implements Serializable, Parametrica {
    protected static final long ENTIDAD_VERSION = 1L;
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private String nombre;

    public Pais() {
    }
    public Pais(Short id) {
        super(id);
    }
    public Pais(String nombre) {
        this.nombre = nombre;
    }
    public Pais(Pais pais) {
        super(pais.getId());
        this.nombre = pais.getNombre();
    }

    public Short getPaisId() {
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
        if (!(object instanceof Pais)) {
            return false;
        }
        return super.equals(object);
    }
    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + '}';
    }

    @Override
    public String codigo() {
        return Registro.obtenerCodigo(this);
    }
    @Override
    public String nombre() {
        return Registro.limpiarTexto(this.getNombre());
    }
}
