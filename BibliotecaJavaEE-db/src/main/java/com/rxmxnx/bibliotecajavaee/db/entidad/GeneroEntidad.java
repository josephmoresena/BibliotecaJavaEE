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
@Table(name = "GENEROS", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class GeneroEntidad extends GeneroDetalle implements Serializable {
    private Set<LibroEntidad> libroSet;
    
    public GeneroEntidad() {
        super();
    }
    public GeneroEntidad(Genero genero) {
        super(genero);
        if (genero instanceof GeneroEntidad) {
            GeneroEntidad referencia = (GeneroEntidad)genero;
            this.libroSet = referencia.getLibroSet();
        }
    }
    
    @Override
    public Set<Integer> getLibros() {
        return this.getLibroSet().stream()
                .map(l -> l.getLibroId())
                .collect(Collectors.toSet());
    }
    
    @XmlTransient
    @OneToMany(mappedBy = "genero")
    public Set<LibroEntidad> getLibroSet() {
        return this.libroSet;
    }
    
    public void setLibroSet(Set<LibroEntidad> libroSet) {
        this.libroSet = libroSet;
    }
    
    public static GeneroEntidad crearEntidad(Genero genero) {
        if (genero instanceof GeneroEntidad)
            return (GeneroEntidad)genero;
        return new GeneroEntidad(genero);
    }
}
