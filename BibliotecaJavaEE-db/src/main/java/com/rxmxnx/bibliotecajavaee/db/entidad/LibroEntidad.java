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
import java.util.stream.*;
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
    private Set<PrestamoEntidad> prestamoSet;
    private Set<InventarioEntidad> inventarioSet;
    
    public LibroEntidad() {
        super();
    }
    public LibroEntidad(Libro libro) {
        super(libro);
        if (libro instanceof LibroEntidad) {
            LibroEntidad referencia = (LibroEntidad)libro;
            this.inventarioSet = referencia.getInventarioSet();
            this.prestamoSet = referencia.getPrestamoSet();
        }
    }
    
    @Override
    @JoinColumn(name = "id_autor", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    public AutorEntidad getAutor() {
        return (AutorEntidad)super.getAutor();
    }
    @Override
    @JoinColumn(name = "id_genero", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    public GeneroEntidad getGenero() {
        return (GeneroEntidad)super.getGenero();
    }
    @Override
    @JoinColumn(name = "id_pais_publicacion", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    public PaisEntidad getPais() {
        return (PaisEntidad)super.getPais();
    }
    @Override
    public Set<Long> getPrestamos() {
        return this.getPrestamoSet().stream()
                .map(p -> p.getPrestamoId())
                .collect(Collectors.toSet());
    }
    @Override
    public Set<Integer> getInventario() {
        return this.getInventarioSet().stream()
                .map(i -> i.getInventarioId())
                .collect(Collectors.toSet());
    }
    
    @XmlTransient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "libro")
    public Set<PrestamoEntidad> getPrestamoSet() {
        return this.prestamoSet;
    }
    @XmlTransient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "libro")
    public Set<InventarioEntidad> getInventarioSet() {
        return this.inventarioSet;
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
    public void setPrestamoSet(Set<PrestamoEntidad> prestamoSet) {
        this.prestamoSet = prestamoSet;
    }
    public void setInventarioSet(Set<InventarioEntidad> inventarioSet) {
        this.inventarioSet = inventarioSet;
    }
    
    public static LibroEntidad crearEntidad(Libro libro) {
        if (libro instanceof LibroEntidad)
            return (LibroEntidad)libro;
        return new LibroEntidad(libro);
    }
}
