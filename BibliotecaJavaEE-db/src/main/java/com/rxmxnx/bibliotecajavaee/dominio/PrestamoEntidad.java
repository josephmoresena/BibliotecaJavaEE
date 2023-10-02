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
@Table(name = "PRESTAMOS", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class PrestamoEntidad extends PrestamoReferencia implements Serializable {
    public PrestamoEntidad(){
        super();
    }
    public PrestamoEntidad(Prestamo prestamo){
        super(prestamo);
    }
    
    @Override
    public LibroEntidad getLibro() {
        return (LibroEntidad)super.getLibro();
    }
    @Override
    public UsuarioEntidad getUsuario() {
        return (UsuarioEntidad)super.getUsuario();
    }
}