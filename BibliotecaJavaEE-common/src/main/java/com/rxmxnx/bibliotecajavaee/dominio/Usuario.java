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
public class Usuario extends SuperEntidad<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    private String nombre;
    private String apellido;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    private String email;
    @OneToMany(mappedBy = "usuario")
    private Set<Prestamo> prestamoSet;

    public Usuario() {
    }
    public Usuario(Integer id) {
        super(id);
    }
    public Usuario(String nombre, Date fechaRegistro, String email) {
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.email = email;
    }
    public Usuario(Usuario usuario, boolean tienePrestamos) {
        super(usuario.getId());
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.fechaRegistro = usuario.getFechaRegistro();
        this.email = usuario.getEmail();
        if(tienePrestamos)
            this.prestamoSet = usuario.getPrestamoSet();
    }
    
    public Integer getUsuarioId() {
        return super.getId();
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public String getEmail() {
        return email;
    }

    @XmlTransient
    public Set<Prestamo> getPrestamoSet() {
        return prestamoSet;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    protected void setPrestamoSet(Set<Prestamo> prestamoSet) {
        this.prestamoSet = prestamoSet;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        return super.equals(object);
    }
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", fechaRegistro=" + fechaRegistro + ", email=" + email + '}';
    }
}
