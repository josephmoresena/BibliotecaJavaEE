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
import java.util.stream.*;
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
    private Set<PrestamoEntidad> prestamoSet;
    
    public UsuarioEntidad(){
        super();
    }
    public UsuarioEntidad(Usuario usuario) {
        super(usuario);
        if (usuario instanceof UsuarioDetalle) {
            UsuarioEntidad referencia = (UsuarioEntidad)usuario;
            this.prestamoSet = referencia.getPrestamoSet();
        }
    }
    
    @Override
    public Set<Long> getPrestamos() {
        return this.getPrestamoSet().stream()
                .map(p -> p.getPrestamoId())
                .collect(Collectors.toSet());
    }
    
    @XmlTransient
    @OneToMany(mappedBy = "usuario")
    public Set<PrestamoEntidad> getPrestamoSet() {
        return this.prestamoSet;
    }
    
    public void setPrestamoSet(Set<PrestamoEntidad> prestamoSet) {
        this.prestamoSet = prestamoSet;
    }
    
    public static UsuarioEntidad crearEntidad(Usuario usuario) {
        if (usuario instanceof UsuarioEntidad)
            return (UsuarioEntidad)usuario;
        return new UsuarioEntidad(usuario);
    }
}
