/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.db.entidad;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
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
public class PrestamoEntidad extends PrestamoDetalle implements Serializable {
    public PrestamoEntidad(){
        super();
    }
    public PrestamoEntidad(Prestamo prestamo){
        super(prestamo);
    }
    
    @Override
    @JoinColumn(name = "id_libro", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public LibroEntidad getLibro() {
        return (LibroEntidad)super.getLibro();
    }
    @Override
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public UsuarioEntidad getUsuario() {
        return (UsuarioEntidad)super.getUsuario();
    }
    
    public void setLibro(LibroEntidad libro) {
        super.setLibro(libro);
    }
    public void setUsuario(UsuarioEntidad usuario) {
        super.setUsuario(usuario);
    }
    
    public static PrestamoEntidad crearEntidad(Prestamo prestamo) {
        if (prestamo instanceof PrestamoEntidad)
            return (PrestamoEntidad)prestamo;
        return new PrestamoEntidad(prestamo);
    }
}