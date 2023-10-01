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
@Table(name = "PRESTAMOS")
@XmlRootElement
public class Prestamo extends SuperEntidad<Long> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    private Boolean devuelto;
    @JoinColumn(name = "id_libro", referencedColumnName = "id")
    @ManyToOne
    private Libro libro;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;

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
        this.libro = prestamo.getLibro();
        this.usuario = prestamo.getUsuario();
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
    public Libro getLibro() {
        return libro;
    }
    public Usuario getUsuario() {
        return usuario;
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
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        return "Prestamo{" + "id=" + this.getId() + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", devuelto=" + devuelto + ", libro=" + getId(libro) + ", usuario=" + getId(usuario) + '}';
    }
}
