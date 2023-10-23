/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio.detalle;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author atem94
 */
@MappedSuperclass
@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PaisDetalle extends Pais implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Set<Integer> autores;
    private Set<Integer> libros;
    
    public PaisDetalle(){
        super();
    }
    public PaisDetalle(Pais pais) {
        super(pais);
        if (pais instanceof PaisDetalle) {
            PaisDetalle referencia = (PaisDetalle)pais;
            this.autores = referencia.getAutores();
            this.libros = referencia.getLibros();
        }
    }

    public Set<Integer> getAutores() {
        return autores;
    }
    public Set<Integer> getLibros() {
        return libros;
    }
}
