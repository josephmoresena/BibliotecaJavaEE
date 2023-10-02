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
public class AutorReferencia extends Autor implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    @JoinColumn(name = "id_pais", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Pais pais;
    
    @OneToMany(mappedBy = "autor")
    private Set<? extends Libro> libroSet;
    
    public AutorReferencia() {
        super();
    }
    public AutorReferencia(Autor autor) {
        super(autor);
        if (autor instanceof AutorReferencia) {
            AutorReferencia referencia = (AutorReferencia)autor;
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
            super.setPaisId(pais.getId());
        else
            super.setPaisId(null);
    }
    
    @Override
    public void setPaisId(Short paisId) {
        if (paisId == null)
            this.pais = null;
        else if (this.pais != null && !paisId.equals(this.pais.getId()))
            this.pais = null;
        super.setPaisId(paisId);
    }
    
    protected void setLibroSet(Set<? extends Libro> libroSet) {
        this.libroSet = libroSet;
    }
}
