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
public class AutorDetalle extends Autor implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Pais pais;
    private Set<? extends Libro> libroSet;
    
    public AutorDetalle() {
        super();
    }
    public AutorDetalle(Autor autor) {
        super(autor);
        if (autor instanceof AutorDetalle) {
            AutorDetalle referencia = (AutorDetalle)autor;
            this.pais = referencia.getPais();
            this.libroSet = referencia.getLibroSet();
        }
    }
    
    public Pais getPais() {
        return this.pais;
    }

    @XmlTransient
    public Set<? extends Libro> getLibroSet() {
        return this.libroSet;
    }
    
    protected void setPais(Pais pais) {
        this.pais = pais;
        if (pais != null)
            super.setPaisId(pais.getPaisId());
        else
            super.setPaisId(null);
    }
    
    @Override
    public void setPaisId(Short paisId) {
        if (paisId == null)
            this.pais = null;
        else if (this.pais != null && !paisId.equals(this.pais.getPaisId()))
            this.pais = null;
        super.setPaisId(paisId);
    }
    
    protected void setLibroSet(Set<? extends Libro> libroSet) {
        this.libroSet = libroSet;
    }
}
