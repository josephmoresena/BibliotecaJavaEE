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
@Table(name = "LIBROS")
@XmlRootElement
public class Libro extends SuperEntidad<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    private String titulo;
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    private String isbn;
    @Lob
    private String sinopsis;
    @JoinColumn(name = "id_autor", referencedColumnName = "id")
    @ManyToOne
    private Autor autor;
    @JoinColumn(name = "id_genero", referencedColumnName = "id")
    @ManyToOne
    private Genero genero;
    @JoinColumn(name = "id_pais_publicacion", referencedColumnName = "id")
    @ManyToOne
    private Pais pais;
    @OneToMany(mappedBy = "libro")
    private Set<Prestamo> prestamoSet;
    @OneToMany(mappedBy = "libro")
    private Set<Inventario> inventarioSet;

    public Libro() {
    }
    public Libro(Integer id) {
        super(id);
    }
    public Libro(String titulo) {
        this.titulo = titulo;
    }
    public Libro(Libro libro, boolean tienePrestamos, boolean tieneInventarios) {
        super(libro.getId());
        this.titulo = libro.getTitulo();
        this.autor = libro.getAutor();
        this.fechaPublicacion = libro.getFechaPublicacion();
        this.genero = libro.getGenero();
        this.isbn = libro.getIsbn();
        this.sinopsis = libro.getSinopsis();
        this.pais = libro.getPais();
        
        if (tienePrestamos)
            this.prestamoSet = libro.getPrestamoSet();
        if (tieneInventarios)
            this.inventarioSet = libro.getInventarioSet();
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
    public Autor getAutor() {
        return autor;
    }
    public Genero getGenero() {
        return genero;
    }
    public Pais getPais() {
        return pais;
    }

    @XmlTransient
    public Set<Prestamo> getPrestamoSet() {
        return prestamoSet;
    }
    @XmlTransient
    public Set<Inventario> getInventarioSet() {
        return inventarioSet;
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
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    protected void setPrestamoSet(Set<Prestamo> prestamoSet) {
        this.prestamoSet = prestamoSet;
    }
    protected void setInventarioSet(Set<Inventario> inventarioSet) {
        this.inventarioSet = inventarioSet;
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
        return "Libro{" + "id=" + this.getId() + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + ", isbn=" + isbn + ", sinopsis=" + sinopsis + ", autor=" + getId(autor) + ", genero=" + getId(genero) + ", pais=" + getId(pais) + '}';
    }
}
