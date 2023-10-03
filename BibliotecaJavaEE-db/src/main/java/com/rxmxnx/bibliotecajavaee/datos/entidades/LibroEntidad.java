/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos.entidades;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author atem94
 */
@Entity
@Table(name = "LIBROS", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class LibroEntidad extends LibroDetalle implements Serializable {
    public LibroEntidad() {
        super();
    }
    public LibroEntidad(Libro libro) {
        super(libro);
    }
    
    @Override
    public AutorEntidad getAutor() {
        return (AutorEntidad)super.getAutor();
    }
    @Override
    public GeneroEntidad getGenero() {
        return (GeneroEntidad)super.getGenero();
    }
    @Override
    public PaisEntidad getPais() {
        return (PaisEntidad)super.getPais();
    }
    
    @Override
    @XmlTransient
    public Set<PrestamoEntidad> getPrestamoSet() {
        return (Set<PrestamoEntidad>)super.getPrestamoSet();
    }
    @Override
    @XmlTransient
    public Set<InventarioEntidad> getInventarioSet() {
        return (Set<InventarioEntidad>)super.getInventarioSet();
    }
    
    public void setAutor(AutorEntidad autor) {
        super.setAutor(autor);
    }
    public void setGenero(GeneroEntidad genero) {
        super.setGenero(genero);
    }
    public void setPais(PaisEntidad pais) {
        super.setPais(pais);
    }
    
    public static LibroEntidad crearEntidad(Libro libro) {
        if (libro instanceof LibroEntidad)
            return (LibroEntidad)libro;
        return new LibroEntidad(libro);
    }
}
