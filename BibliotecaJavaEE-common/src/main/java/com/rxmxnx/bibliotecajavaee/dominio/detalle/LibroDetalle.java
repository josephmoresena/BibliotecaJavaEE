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
public class LibroDetalle extends Libro implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Autor autor;
    private Genero genero;
    private Pais pais;
    private Set<Integer> inventario;
    private Set<Long> prestamos;
    
    public LibroDetalle() {
        super();
    }
    public LibroDetalle(Libro libro){
        super(libro);
        if (libro instanceof LibroDetalle) {
            LibroDetalle referencia = (LibroDetalle)libro;
            this.autor = new AutorDetalle(referencia.getAutor());
            this.genero = new GeneroDetalle(referencia.getGenero());
            this.pais = new PaisDetalle(referencia.getPais());
            this.inventario = referencia.getInventario();
            this.prestamos = referencia.getPrestamos();
        }
    }
    
    public Autor getAutor() {
        return autor;
    }
    public Genero getGenero() {
        return genero;
    }
    public Pais getPais() {
        return pais;
    }

    public Set<Long> getPrestamos() {
        return prestamos;
    }
    public Set<Integer> getInventario() {
        return inventario;
    }
    
    protected void setAutor(Autor autor) {
        this.autor = autor;
        if (autor != null)
            super.setAutorId(autor.getAutorId());
        else
            super.setAutorId(null);
    }
    protected void setGenero(Genero genero) {
        this.genero = genero;
        if (genero != null)
            super.setGeneroId(genero.getGeneroId());
        else
            super.setGeneroId(null);
    }
    protected void setPais(Pais pais) {
        this.pais = pais;
        if (pais != null)
            super.setPaisId(pais.getPaisId());
        else
            super.setPaisId(null);
    }
    
    @Override
    public void setAutorId(Integer autorId) {
        if (autorId == null)
            this.autor = null;
        else if (this.autor != null && !autorId.equals(this.autor.getAutorId()))
            this.autor = null;
        super.setAutorId(autorId);
    }
    @Override
    public void setGeneroId(Short generoId) {
        if (generoId == null)
            this.genero = null;
        else if (this.genero != null && !generoId.equals(this.genero.getGeneroId()))
            this.genero = null;
        super.setGeneroId(generoId);
    }
    @Override
    public void setPaisId(Short paisId) {
        if (paisId == null)
            this.pais = null;
        else if (this.pais != null && !paisId.equals(this.pais.getPaisId()))
            this.pais = null;
        super.setPaisId(paisId);
    }
}
