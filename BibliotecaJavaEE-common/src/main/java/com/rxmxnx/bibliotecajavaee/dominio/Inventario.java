/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import java.io.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author atem94
 */
@MappedSuperclass
@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Inventario extends SuperEntidad<Integer> implements Serializable {
    protected static final long ENTIDAD_VERSION = 1L;
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Integer cantidadEjemplares;
    private String estante;
    private Integer libroId;

    public Inventario() {
    }
    public Inventario(Integer id) {
        super(id);
    }
    public Inventario(Inventario inventario) {
        super(inventario.getId());
        this.estante = inventario.getEstante();
    }
    
    public Integer getInventarioId() {
        return super.getId();
    }
    
    @Column(name = "cantidad_ejemplares")
    public Integer getCantidadEjemplares() {
        return cantidadEjemplares;
    }
    public String getEstante() {
        return estante;
    }
    @Column(name="id_libro")
    public Integer getLibroId() {
        return this.libroId;
    }
    
    public void setCantidadEjemplares(Integer cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }
    public void setEstante(String estante) {
        this.estante = estante;
    }
    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        return super.equals(object);
    }
    @Override
    public String toString() {
        return "Inventario{" + "id=" + this.getId() + ", cantidadEjemplares=" + this.cantidadEjemplares + ", estante=" + this.estante + ", libro=" + this.libroId + '}';
    }
}
