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
@Table(name = "PAISES", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class PaisEntidad extends PaisDetalle implements Serializable {
    private Set<AutorEntidad> autorSet;
    private Set<LibroEntidad> libroSet;
    
    public PaisEntidad() {
        super();
    }
    private PaisEntidad(Pais pais) {
        super(pais);
        if (pais instanceof PaisEntidad) {
            PaisEntidad referencia = (PaisEntidad)pais;
            this.autorSet = referencia.getAutorSet();
            this.libroSet = referencia.getLibroSet();
        }
    }
    
    @Override
    public Set<Integer> getAutores() {
        return this.getAutorSet().stream()
                .map(a -> a.getAutorId())
                .collect(Collectors.toSet());
    }
    @Override
    public Set<Integer> getLibros() {
        return this.getLibroSet().stream()
                .map(l -> l.getLibroId())
                .collect(Collectors.toSet());
    }
    
    @XmlTransient
    @OneToMany(mappedBy = "pais")
    public Set<AutorEntidad> getAutorSet() {
        return this.autorSet;
    }
    @XmlTransient
    @OneToMany(mappedBy = "pais")
    public Set<LibroEntidad> getLibroSet() {
        return this.libroSet;
    }
    
    public void setAutorSet(Set<AutorEntidad> autorSet) {
        this.autorSet = autorSet;
    }
    public void setLibroSet(Set<LibroEntidad> libroSet) {
        this.libroSet = libroSet;
    }
    
    public static PaisEntidad crearEntidad(Pais pais) {
        if (pais instanceof PaisEntidad)
            return (PaisEntidad)pais;
        return new PaisEntidad(pais);
    }
}
