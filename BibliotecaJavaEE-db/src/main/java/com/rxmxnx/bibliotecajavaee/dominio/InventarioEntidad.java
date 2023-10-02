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
@Table(name = "INVENTARIO", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class InventarioEntidad extends InventarioReferencia implements Serializable {
    public InventarioEntidad() {
        super();
    }
    public InventarioEntidad(Inventario inventario) {
        super(inventario);
    }
    
    @Override
    public LibroEntidad getLibro() {
        return (LibroEntidad)super.getLibro();
    }
    
    public void setLibro(LibroEntidad libro) {
        super.setLibro(libro);
    }
    
    public static InventarioEntidad crearEntidad(Inventario inventario) {
        if (inventario instanceof InventarioEntidad)
            return (InventarioEntidad)inventario;
        return new InventarioEntidad(inventario);
    }
}
