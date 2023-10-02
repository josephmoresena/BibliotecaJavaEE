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
public class GeneroReferencia extends Genero implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    @OneToMany(mappedBy = "genero")
    private Set<? extends Libro> libroSet;
    
    public GeneroReferencia() {
    }
    public GeneroReferencia(Genero genero) {
        super(genero);
        if (genero instanceof GeneroReferencia) {
            GeneroReferencia referencia = (GeneroReferencia)genero;
            this.libroSet = referencia.getLibroSet();
        }
    }
    
    @XmlTransient
    public Set<? extends Libro> getLibroSet() {
        return this.libroSet;
    }
    
    protected void setLibroSet(Set<? extends Libro> libroSet) {
        this.libroSet = libroSet;
    }
}
