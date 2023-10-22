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
@Table(name = "AUTORES", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class AutorEntidad extends AutorDetalle implements Serializable {
    public AutorEntidad() {
        super();
    }
    public AutorEntidad(Autor autor) {
        super(autor);
    }
    
    @Override
    @JoinColumn(name = "id_pais", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public PaisEntidad getPais() {
        return (PaisEntidad)super.getPais();
    }
    
    @Override
    @XmlTransient
    @OneToMany(mappedBy = "autor")
    public Set<LibroEntidad> getLibroSet() {
        return (Set<LibroEntidad>)super.getLibroSet();
    }
    
    public void setPais(PaisEntidad pais) {
        super.setPais(pais);
    }
    
    public static AutorEntidad crearEntidad(Autor autor) {
        if (autor instanceof AutorEntidad)
            return (AutorEntidad)autor;
        return new AutorEntidad(autor);
    }
}
