/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author atem94
 */
@Entity
@Table(name = "PRESTAMOS", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrestamoEntidad.findAll", query = "SELECT p FROM PrestamoEntidad p")
    , @NamedQuery(name = "PrestamoEntidad.findById", query = "SELECT p FROM PrestamoEntidad p WHERE p.id = :id")
    , @NamedQuery(name = "PrestamoEntidad.findByFechaPrestamo", query = "SELECT p FROM PrestamoEntidad p WHERE p.fechaPrestamo = :fechaPrestamo")
    , @NamedQuery(name = "PrestamoEntidad.findByFechaDevolucion", query = "SELECT p FROM PrestamoEntidad p WHERE p.fechaDevolucion = :fechaDevolucion")
    , @NamedQuery(name = "PrestamoEntidad.findByDevuelto", query = "SELECT p FROM PrestamoEntidad p WHERE p.devuelto = :devuelto")})
public class PrestamoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    private Boolean devuelto;
    @JoinColumn(name = "id_libro", referencedColumnName = "id")
    @ManyToOne
    private LibroEntidad libroEntidad;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private UsuarioEntidad usuarioEntidad;

    public PrestamoEntidad() {
    }

    public PrestamoEntidad(Long id) {
        this.id = id;
    }

    public PrestamoEntidad(Long id, Date fechaPrestamo) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public LibroEntidad getLibroEntidad() {
        return libroEntidad;
    }

    public void setLibroEntidad(LibroEntidad libroEntidad) {
        this.libroEntidad = libroEntidad;
    }

    public UsuarioEntidad getUsuarioEntidad() {
        return usuarioEntidad;
    }

    public void setUsuarioEntidad(UsuarioEntidad usuarioEntidad) {
        this.usuarioEntidad = usuarioEntidad;
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
        if (!(object instanceof PrestamoEntidad)) {
            return false;
        }
        PrestamoEntidad other = (PrestamoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rxmxnx.bibliotecajavaee.dominio.PrestamoEntidad[ id=" + id + " ]";
    }
    
}
