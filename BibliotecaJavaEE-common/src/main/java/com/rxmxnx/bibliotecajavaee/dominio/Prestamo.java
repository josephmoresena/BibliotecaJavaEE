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
public class Prestamo extends SuperEntidad<Long> implements Serializable {
    protected static final long ENTIDAD_VERSION = 1L;
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    @Basic(optional = false)
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    private Boolean devuelto;
    @Column(name="id_libro")
    private Integer libroId;
    @Column(name="id_usuario")
    private Integer usuarioId;

    public Prestamo() {
    }
    public Prestamo(Long id) {
        super(id);
    }
    public Prestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public Prestamo(Prestamo prestamo){
        super(prestamo.getId());
        this.devuelto = prestamo.getDevuelto();
        this.fechaDevolucion = prestamo.getFechaDevolucion();
        this.fechaPrestamo = prestamo.getFechaPrestamo();
        this.libroId = prestamo.getLibroId();
        this.usuarioId = prestamo.getUsuarioId();
    }

    public Long getPrestamoId() {
        return super.getId();
    }
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
    public Boolean getDevuelto() {
        return devuelto;
    }
    public Integer getLibroId() {
        return libroId;
    }
    public Integer getUsuarioId() {
        return usuarioId;
    }
    
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }
    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        return super.equals(object);
    }
    @Override
    public String toString() {
        return "Prestamo{" + "id=" + this.getId() + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", devuelto=" + devuelto + ", libro=" + this.libroId + ", usuario=" + this.usuarioId + '}';
    }
}
