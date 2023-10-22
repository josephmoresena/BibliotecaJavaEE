/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio.detalle;

import com.rxmxnx.bibliotecajavaee.dominio.*;
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
public class PaisDetalle extends Pais implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Set<? extends Autor> autorSet;
    private Set<? extends Libro> libroSet;
    
    public PaisDetalle(){
        super();
    }
    public PaisDetalle(Pais pais) {
        super(pais);
        if (pais instanceof PaisDetalle) {
            PaisDetalle referencia = (PaisDetalle)pais;
            this.autorSet = referencia.getAutorSet();
            this.libroSet = referencia.getLibroSet();
        }
    }

    @XmlTransient
    public Set<? extends Autor> getAutorSet() {
        return autorSet;
    }
    @XmlTransient
    public Set<? extends Libro> getLibroSet() {
        return libroSet;
    }
    
    protected void setAutorSet(Set<? extends Autor> autorSet) {
        this.autorSet = autorSet;
    }
    protected void setLibroSet(Set<? extends Libro> libroSet) {
        this.libroSet = libroSet;
    }
}
