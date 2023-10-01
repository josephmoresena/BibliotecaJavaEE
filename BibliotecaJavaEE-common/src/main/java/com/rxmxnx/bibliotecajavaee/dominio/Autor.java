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
@Table(name = "AUTORES")
@XmlRootElement
public class Autor extends SuperEntidad<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    @ManyToOne
    private Pais pais;
    @OneToMany(mappedBy = "autor")
    private Set<Libro> libroSet;

    public Autor() {
    }
    public Autor(Integer id) {
        super(id);
    }
    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Autor(Autor autor, boolean tieneLibros) {
        super(autor.getId());
        this.nombre = autor.getNombre();
        this.apellido = autor.getApellido();
        this.pais = autor.getPais();
        if (tieneLibros)
            this.libroSet = autor.getLibroSet();
    }

    public Integer getAutorId() {
        return super.getId();
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    public Pais getPais() {
        return this.pais;
    }

    @XmlTransient
    public Set<Libro> getLibroSet() {
        return this.libroSet;
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
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    protected void setLibroSet(Set<Libro> libroSet) {
        this.libroSet = libroSet;
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
        return "Autor{" + "id=" + this.getId() + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", this.fechaNacimiento=" + fechaNacimiento + ", pais=" + getId(this.pais) + '}';
    }
}
