/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db.entidad;

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
    @JoinColumn(name = "id_autor", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public AutorEntidad getAutor() {
        return (AutorEntidad)super.getAutor();
    }
    @Override
    @JoinColumn(name = "id_genero", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public GeneroEntidad getGenero() {
        return (GeneroEntidad)super.getGenero();
    }
    @Override
    @JoinColumn(name = "id_pais_publicacion", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public PaisEntidad getPais() {
        return (PaisEntidad)super.getPais();
    }
    
    @Override
    @XmlTransient
    @OneToMany(mappedBy = "libro")
    public Set<PrestamoEntidad> getPrestamoSet() {
        return (Set<PrestamoEntidad>)super.getPrestamoSet();
    }
    @Override
    @XmlTransient
    @OneToMany(mappedBy = "libro")
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
