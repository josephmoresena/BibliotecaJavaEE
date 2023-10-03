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
public class LibroReferencia extends Libro implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Autor autor;
    private Genero genero;
    private Pais pais;
    private Set<? extends Prestamo> prestamoSet;
    private Set<? extends Inventario> inventarioSet;
    
    public LibroReferencia() {
        super();
    }
    public LibroReferencia(Libro libro){
        super(libro);
        if (libro instanceof LibroReferencia) {
            LibroReferencia referencia = (LibroReferencia)libro;
            this.autor = referencia.getAutor();
            this.genero = referencia.getGenero();
            this.pais = referencia.getPais();
            this.inventarioSet = referencia.getInventarioSet();
            this.prestamoSet = referencia.getPrestamoSet();
        }
    }
    
    @JoinColumn(name = "id_autor", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public Autor getAutor() {
        return autor;
    }
    @JoinColumn(name = "id_genero", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public Genero getGenero() {
        return genero;
    }
    @JoinColumn(name = "id_pais_publicacion", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public Pais getPais() {
        return pais;
    }

    @OneToMany(mappedBy = "libro")
    @XmlTransient
    protected Set<? extends Prestamo> getPrestamoSet() {
        return prestamoSet;
    }
    @OneToMany(mappedBy = "libro")
    @XmlTransient
    protected Set<? extends Inventario> getInventarioSet() {
        return inventarioSet;
    }
    
    protected void setAutor(Autor autor) {
        this.autor = autor;
        if (autor != null)
            super.setAutorId(autor.getId());
        else
            super.setAutorId(null);
    }
    protected void setGenero(Genero genero) {
        this.genero = genero;
        if (genero != null)
            super.setGeneroId(genero.getId());
        else
            super.setGeneroId(null);
    }
    protected void setPais(Pais pais) {
        this.pais = pais;
        if (pais != null)
            super.setPaisId(pais.getId());
        else
            super.setPaisId(null);
    }
    
    @Override
    public void setAutorId(Integer autorId) {
        if (autorId == null)
            this.autor = null;
        else if (this.autor != null && !autorId.equals(this.autor.getId()))
            this.autor = null;
        super.setAutorId(autorId);
    }
    @Override
    public void setGeneroId(Short generoId) {
        if (generoId == null)
            this.genero = null;
        else if (this.genero != null && !generoId.equals(this.genero.getId()))
            this.genero = null;
        super.setGeneroId(generoId);
    }
    @Override
    public void setPaisId(Short paisId) {
        if (paisId == null)
            this.pais = null;
        else if (this.pais != null && !paisId.equals(this.pais.getId()))
            this.pais = null;
        super.setPaisId(paisId);
    }

    protected void setPrestamoSet(Set<Prestamo> prestamoSet) {
        this.prestamoSet = prestamoSet;
    }
    protected void setInventarioSet(Set<Inventario> inventarioSet) {
        this.inventarioSet = inventarioSet;
    }
}
