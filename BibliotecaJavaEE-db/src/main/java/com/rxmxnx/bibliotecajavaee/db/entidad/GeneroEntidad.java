/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db.entidad;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import java.io.*;
import java.util.Set;
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
    public GeneroEntidad() {
        super();
    }
    public GeneroEntidad(Genero autor) {
        super(autor);
    }
    
    @Override
    @XmlTransient
    public Set<LibroEntidad> getLibroSet() {
        return (Set<LibroEntidad>)super.getLibroSet();
    }
    
    public static GeneroEntidad crearEntidad(Genero genero) {
        if (genero instanceof GeneroEntidad)
            return (GeneroEntidad)genero;
        return new GeneroEntidad(genero);
    }
}
