/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author atem94
 */
@Entity
@Table(name = "PAISES", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaisEntidad.findAll", query = "SELECT p FROM PaisEntidad p")
    , @NamedQuery(name = "PaisEntidad.findById", query = "SELECT p FROM PaisEntidad p WHERE p.id = :id")
    , @NamedQuery(name = "PaisEntidad.findByNombre", query = "SELECT p FROM PaisEntidad p WHERE p.nombre = :nombre")})
public class PaisEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;
    @OneToMany(mappedBy = "paisEntidad")
    private Set<AutorEntidad> autorEntidadSet;
    @OneToMany(mappedBy = "paisEntidad")
    private Set<LibroEntidad> libroEntidadSet;

    public PaisEntidad() {
    }

    public PaisEntidad(Short id) {
        this.id = id;
    }

    public PaisEntidad(Short id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Set<AutorEntidad> getAutorEntidadSet() {
        return autorEntidadSet;
    }

    public void setAutorEntidadSet(Set<AutorEntidad> autorEntidadSet) {
        this.autorEntidadSet = autorEntidadSet;
    }

    @XmlTransient
    public Set<LibroEntidad> getLibroEntidadSet() {
        return libroEntidadSet;
    }

    public void setLibroEntidadSet(Set<LibroEntidad> libroEntidadSet) {
        this.libroEntidadSet = libroEntidadSet;
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
        if (!(object instanceof PaisEntidad)) {
            return false;
        }
        PaisEntidad other = (PaisEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rxmxnx.bibliotecajavaee.dominio.PaisEntidad[ id=" + id + " ]";
    }
    
}
