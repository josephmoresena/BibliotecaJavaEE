/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author atem94
 */
@Entity
@Table(name = "LIBROS", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroEntidad.findAll", query = "SELECT l FROM LibroEntidad l")
    , @NamedQuery(name = "LibroEntidad.findById", query = "SELECT l FROM LibroEntidad l WHERE l.id = :id")
    , @NamedQuery(name = "LibroEntidad.findByTitulo", query = "SELECT l FROM LibroEntidad l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "LibroEntidad.findByFechaPublicacion", query = "SELECT l FROM LibroEntidad l WHERE l.fechaPublicacion = :fechaPublicacion")
    , @NamedQuery(name = "LibroEntidad.findByIsbn", query = "SELECT l FROM LibroEntidad l WHERE l.isbn = :isbn")})
public class LibroEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String titulo;
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Size(max = 20)
    private String isbn;
    @Lob
    @Size(max = 65535)
    private String sinopsis;
    @JoinColumn(name = "id_autor", referencedColumnName = "id")
    @ManyToOne
    private AutorEntidad autorEntidad;
    @JoinColumn(name = "id_genero", referencedColumnName = "id")
    @ManyToOne
    private GeneroEntidad generoEntidad;
    @JoinColumn(name = "id_pais_publicacion", referencedColumnName = "id")
    @ManyToOne
    private PaisEntidad paisEntidad;
    @OneToMany(mappedBy = "libroEntidad")
    private Set<PrestamoEntidad> prestamoEntidadSet;
    @OneToMany(mappedBy = "libroEntidad")
    private Set<InventarioEntidad> inventarioEntidadSet;

    public LibroEntidad() {
    }

    public LibroEntidad(Integer id) {
        this.id = id;
    }

    public LibroEntidad(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public AutorEntidad getAutorEntidad() {
        return autorEntidad;
    }

    public void setAutorEntidad(AutorEntidad autorEntidad) {
        this.autorEntidad = autorEntidad;
    }

    public GeneroEntidad getGeneroEntidad() {
        return generoEntidad;
    }

    public void setGeneroEntidad(GeneroEntidad generoEntidad) {
        this.generoEntidad = generoEntidad;
    }

    public PaisEntidad getPaisEntidad() {
        return paisEntidad;
    }

    public void setPaisEntidad(PaisEntidad paisEntidad) {
        this.paisEntidad = paisEntidad;
    }

    @XmlTransient
    public Set<PrestamoEntidad> getPrestamoEntidadSet() {
        return prestamoEntidadSet;
    }

    public void setPrestamoEntidadSet(Set<PrestamoEntidad> prestamoEntidadSet) {
        this.prestamoEntidadSet = prestamoEntidadSet;
    }

    @XmlTransient
    public Set<InventarioEntidad> getInventarioEntidadSet() {
        return inventarioEntidadSet;
    }

    public void setInventarioEntidadSet(Set<InventarioEntidad> inventarioEntidadSet) {
        this.inventarioEntidadSet = inventarioEntidadSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroEntidad)) {
            return false;
        }
        LibroEntidad other = (LibroEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rxmxnx.bibliotecajavaee.dominio.LibroEntidad[ id=" + id + " ]";
    }
    
}
