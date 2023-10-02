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
public class PaisReferencia extends Pais implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    @OneToMany(mappedBy = "pais")
    private Set<? extends Autor> autorSet;
    @OneToMany(mappedBy = "pais")
    private Set<? extends Libro> libroSet;
    
    public PaisReferencia(){
        super();
    }
    public PaisReferencia(Pais pais) {
        super(pais);
        if (pais instanceof PaisReferencia) {
            PaisReferencia referencia = (PaisReferencia)pais;
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
