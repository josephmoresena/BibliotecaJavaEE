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
@Table(name = "GENEROS", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class GeneroEntidad extends Genero implements Serializable {
    public GeneroEntidad() {
        super();
    }
    public GeneroEntidad(Genero autor, boolean tieneLibros) {
        super(autor, tieneLibros);
    }
}
