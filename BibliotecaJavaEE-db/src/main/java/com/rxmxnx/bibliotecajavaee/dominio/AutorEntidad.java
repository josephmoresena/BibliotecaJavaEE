/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

import java.io.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author atem94
 */
@Entity
@Table(name = "AUTORES", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class AutorEntidad extends AutorReferencia implements Serializable {
    public AutorEntidad() {
        super();
    }
    public AutorEntidad(Autor autor, boolean tieneLibros) {
        super(autor);
    }
    
    @Override
    public PaisEntidad getPais() {
        return (PaisEntidad)super.getPais();
    }
    
    public void setPais(PaisEntidad pais) {
        super.setPais(pais);
    }
}
