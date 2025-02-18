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
public class Autor extends SuperEntidad<Integer> implements Serializable, Registro {
    protected static final long ENTIDAD_VERSION = 1L;
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Short paisId;

    public Autor() {
    }
    public Autor(Integer id) {
        super(id);
    }
    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Autor(Autor autor) {
        super(autor.getId());
        this.nombre = autor.getNombre();
        this.apellido = autor.getApellido();
        this.paisId = autor.paisId;
    }

    public Integer getAutorId() {
        return super.getId();
    }

    @Basic(optional = false)
    public String getNombre() {
        return this.nombre;
    }
    @Basic(optional = false)
    public String getApellido() {
        return this.apellido;
    }
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    @Column(name = "id_pais")
    public Short getPaisId() {
        return this.paisId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
        if (!(object instanceof Autor)) {
            return false;
        }
        return super.equals(object);
    }
    @Override
    public String toString() {
        return "Autor{" + "id=" + this.getId() + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", this.fechaNacimiento=" + fechaNacimiento + ", pais=" + this.paisId + '}';
    }

    @Override
    public String codigo() {
        return Registro.obtenerCodigo(this);
    }
    @Override
    public String descripcion() {
        String nombreValor = Registro.limpiarTexto(this.getNombre());
        String apellidoValor = Registro.limpiarTexto(this.getApellido());
        return Registro.limpiarTexto(nombreValor + " " + apellidoValor);
    }
}
