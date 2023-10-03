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
public class GeneroDetalle extends Genero implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Set<? extends Libro> libroSet;
    
    public GeneroDetalle() {
    }
    public GeneroDetalle(Genero genero) {
        super(genero);
        if (genero instanceof GeneroDetalle) {
            GeneroDetalle referencia = (GeneroDetalle)genero;
            this.libroSet = referencia.getLibroSet();
        }
    }
    
    @XmlTransient
    @OneToMany(mappedBy = "genero")
    public Set<? extends Libro> getLibroSet() {
        return this.libroSet;
    }
    
    protected void setLibroSet(Set<? extends Libro> libroSet) {
        this.libroSet = libroSet;
    }
}
