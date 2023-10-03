/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.datos.entidades;

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
@Table(name = "USUARIOS", catalog = "BIBLIOTECA_JEE", schema = "")
@XmlRootElement
public class UsuarioEntidad extends UsuarioDetalle implements Serializable {
    public UsuarioEntidad(){
        super();
    }
    public UsuarioEntidad(Usuario usuario) {
        super(usuario);
    }
    
    @Override
    @XmlTransient
    public Set<PrestamoEntidad> getPrestamoSet() {
        return (Set<PrestamoEntidad>)super.getPrestamoSet();
    }
    
    public static UsuarioEntidad crearEntidad(Usuario usuario) {
        if (usuario instanceof UsuarioEntidad)
            return (UsuarioEntidad)usuario;
        return new UsuarioEntidad(usuario);
    }
}
