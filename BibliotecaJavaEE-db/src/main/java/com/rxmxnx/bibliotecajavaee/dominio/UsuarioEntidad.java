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
@Table(name = "USUARIOS", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioEntidad.findAll", query = "SELECT u FROM UsuarioEntidad u")
    , @NamedQuery(name = "UsuarioEntidad.findById", query = "SELECT u FROM UsuarioEntidad u WHERE u.id = :id")
    , @NamedQuery(name = "UsuarioEntidad.findByNombre", query = "SELECT u FROM UsuarioEntidad u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UsuarioEntidad.findByApellido", query = "SELECT u FROM UsuarioEntidad u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "UsuarioEntidad.findByFechaRegistro", query = "SELECT u FROM UsuarioEntidad u WHERE u.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "UsuarioEntidad.findByEmail", query = "SELECT u FROM UsuarioEntidad u WHERE u.email = :email")})
public class UsuarioEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String nombre;
    @Size(max = 255)
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String email;
    @OneToMany(mappedBy = "usuarioEntidad")
    private Set<PrestamoEntidad> prestamoEntidadSet;

    public UsuarioEntidad() {
    }

    public UsuarioEntidad(Integer id) {
        this.id = id;
    }

    public UsuarioEntidad(Integer id, String nombre, Date fechaRegistro, String email) {
        this.id = id;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Set<PrestamoEntidad> getPrestamoEntidadSet() {
        return prestamoEntidadSet;
    }

    public void setPrestamoEntidadSet(Set<PrestamoEntidad> prestamoEntidadSet) {
        this.prestamoEntidadSet = prestamoEntidadSet;
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
        if (!(object instanceof UsuarioEntidad)) {
            return false;
        }
        UsuarioEntidad other = (UsuarioEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rxmxnx.bibliotecajavaee.dominio.UsuarioEntidad[ id=" + id + " ]";
    }
    
}
