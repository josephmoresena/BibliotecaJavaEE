/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import com.rxmxnx.bibliotecajavaee.util.*;
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
public class Usuario extends SuperEntidad<Integer> implements Serializable, Registro {
    protected static final long ENTIDAD_VERSION = 1L;
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private String nombre;
    private String apellido;
    private Date fechaRegistro;
    private String email;

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
    public Usuario(Usuario usuario) {
        super(usuario.getId());
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.fechaRegistro = usuario.getFechaRegistro();
        this.email = usuario.getEmail();
    }
    
    public Integer getUsuarioId() {
        return super.getId();
    }
    @Basic(optional = false)
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    @Basic(optional = false)
    public String getEmail() {
        return email;
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

    @Override
    public String codigo() {
        return Registro.obtenerCodigo(this);
    }
    @Override
    public String descripcion() {
        String nombreValor = Registro.limpiarTexto(this.getNombre());
        String apellidoValor = Registro.limpiarTexto(this.getApellido());
        return Registro.limpiarTexto(apellidoValor + " " + nombreValor);
    }
}
