/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio.detalle;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import java.io.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author atem94
 */
@MappedSuperclass
@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class InventarioDetalle extends Inventario implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Libro libro;
    
    public InventarioDetalle() {
        super();
    }
    public InventarioDetalle(Inventario inventario) {
        super(inventario);
        if (inventario instanceof InventarioDetalle) {
            InventarioDetalle referencia = (InventarioDetalle)inventario;
            this.libro = new LibroDetalle(referencia.getLibro());
        }
    }
    
    public Libro getLibro() {
        return this.libro;
    }
    
    protected void setLibro(Libro libro) {
        this.libro = libro;
        if (libro != null)
            super.setLibroId(libro.getLibroId());
        else
            super.setLibroId(null);
    }
    
    @Override
    public void setLibroId(Integer libroId) {
        if (libroId == null)
            this.libro = null;
        else if (this.libro != null && !libroId.equals(this.libro.getLibroId()))
            this.libro = null;
        super.setLibroId(libroId);
    }
}
