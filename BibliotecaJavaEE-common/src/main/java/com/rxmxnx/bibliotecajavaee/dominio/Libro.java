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
public class Libro extends SuperEntidad<Integer> implements Serializable {
    protected static final long ENTIDAD_VERSION = 1L;
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    @Basic(optional = false)
    private String titulo;
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    private String isbn;
    @Lob
    private String sinopsis;
    @Column(name="id_autor")
    private Integer autorId;
    @Column(name="id_genero")
    private Short generoId;
    @Column(name="id_pais_publicacion")
    private Short paisId;

    public Libro() {
    }
    public Libro(Integer id) {
        super(id);
    }
    public Libro(String titulo) {
        this.titulo = titulo;
    }
    public Libro(Libro libro) {
        super(libro.getId());
        this.titulo = libro.getTitulo();
        this.fechaPublicacion = libro.getFechaPublicacion();
        this.isbn = libro.getIsbn();
        this.sinopsis = libro.getSinopsis();
        this.autorId = libro.getAutorId();
        this.paisId = libro.getPaisId();
        this.generoId = libro.getGeneroId();
    }

    public Integer getLibroId() {
        return super.getId();
    }
    public String getTitulo() {
        return titulo;
    }
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public Integer getAutorId() {
        return this.autorId;
    }
    public Short getGeneroId() {
        return generoId;
    }
    public Short getPaisId() {
        return paisId;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }
    public void setGeneroId(Short generoId) {
        this.generoId = generoId;
    }
    public void setPaisId(Short paisId) {
        this.paisId = paisId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        return super.equals(object);
    }
    @Override
    public String toString() {
        return "Libro{" + "id=" + this.getId() + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + ", isbn=" + isbn + ", sinopsis=" + sinopsis + ", autor=" + this.autorId + ", genero=" + this.generoId + ", pais=" + this.paisId + '}';
    }
}
