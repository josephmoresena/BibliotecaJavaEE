/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

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
public class PaisEntidad extends Pais implements Serializable {
    public PaisEntidad() {
        super();
    }
    private PaisEntidad(Pais pais) {
        super(pais, false, false);
    }
    private PaisEntidad(Pais pais, boolean tieneAutores, boolean tieneLibros) {
        super(pais, tieneAutores, tieneLibros);
    }
    
    @XmlTransient
    public Set<AutorEntidad> getAutorEntidadSet() {
        return super.getAutorSet().stream().map(a -> (AutorEntidad)a).collect(Collectors.toSet());
    }
    @XmlTransient
    public Set<LibroEntidad> getLibroEntidadSet() {
        return super.getLibroSet().stream().map(l -> (LibroEntidad)l).collect(Collectors.toSet());
    }
    
    public static PaisEntidad crearEntidad(Pais pais) {
        if (pais instanceof PaisEntidad)
            return (PaisEntidad)pais;
        return new PaisEntidad(pais);
    }
}
