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
public class Inventario extends SuperEntidad<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "cantidad_ejemplares")
    private Integer cantidadEjemplares;
    private String estante;
    @JoinColumn(name = "id_libro", referencedColumnName = "id")
    @ManyToOne
    private Libro libro;

    public Inventario() {
    }
    public Inventario(Integer id) {
        super(id);
    }
    public Inventario(Inventario inventario) {
        super(inventario.getId());
        this.estante = inventario.getEstante();
        this.libro = inventario.getLibro();
    }

    @Override
    public Integer getId() {
        return super.getId();
    }
    
    public Integer getCantidadEjemplares() {
        return cantidadEjemplares;
    }
    public String getEstante() {
        return estante;
    }
    public Libro getLibro() {
        return libro;
    }
    
    public void setCantidadEjemplares(Integer cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }
    public void setEstante(String estante) {
        this.estante = estante;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
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
        return "Inventario{" + "id=" + this.getId() + ", cantidadEjemplares=" + this.cantidadEjemplares + ", estante=" + this.estante + ", libro=" + getId(this.libro) + '}';
    }
}
