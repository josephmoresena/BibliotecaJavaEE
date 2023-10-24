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
@Table(name = "AUTORES", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class AutorEntidad extends AutorDetalle implements Serializable {
    private Set<LibroEntidad> libroSet;
    
    public AutorEntidad() {
        super();
    }
    public AutorEntidad(Autor autor) {
        super(autor);
        if (autor instanceof AutorEntidad) {
            AutorEntidad referencia = (AutorEntidad)autor;
            this.libroSet = referencia.getLibroSet();
        }
    }
    
    @Override
    @JoinColumn(name = "id_pais", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    public PaisEntidad getPais() {
        return (PaisEntidad)super.getPais();
    }
    @Override
    public Set<Integer> getLibros() {
        return this.getLibroSet().stream()
                .map(l -> l.getLibroId())
                .collect(Collectors.toSet());
    }
    
    @XmlTransient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
    public Set<LibroEntidad> getLibroSet() {
        return this.libroSet;
    }
    
    public void setPais(PaisEntidad pais) {
        super.setPais(pais);
    }
    public void setLibroSet(Set<LibroEntidad> libroSet) {
        this.libroSet = libroSet;
    }
    
    public static AutorEntidad crearEntidad(Autor autor) {
        if (autor instanceof AutorEntidad)
            return (AutorEntidad)autor;
        return new AutorEntidad(autor);
    }
}
