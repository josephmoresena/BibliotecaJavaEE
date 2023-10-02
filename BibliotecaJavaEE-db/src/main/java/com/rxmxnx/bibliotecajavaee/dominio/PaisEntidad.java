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
public class PaisEntidad extends PaisReferencia implements Serializable {
    public PaisEntidad() {
        super();
    }
    private PaisEntidad(Pais pais) {
        super(pais);
    }
    
    @Override
    @XmlTransient
    public Set<AutorEntidad> getAutorSet() {
        return super.getAutorSet().stream().map(a -> (AutorEntidad)a).collect(Collectors.toSet());
    }
    @Override
    @XmlTransient
    public Set<LibroEntidad> getLibroSet() {
        return super.getLibroSet().stream().map(l -> (LibroEntidad)l).collect(Collectors.toSet());
    }
    
    public static PaisEntidad crearEntidad(Pais pais) {
        if (pais instanceof PaisEntidad)
            return (PaisEntidad)pais;
        return new PaisEntidad(pais);
    }
}
