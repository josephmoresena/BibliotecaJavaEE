/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio.detalle;

import com.rxmxnx.bibliotecajavaee.dominio.Prestamo;
import com.rxmxnx.bibliotecajavaee.dominio.Usuario;
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
public class UsuarioDetalle extends Usuario implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Set<? extends Prestamo> prestamoSet;
    
    public UsuarioDetalle() {
        super();
    }
    public UsuarioDetalle(Usuario usuario) {
        super(usuario);
        if (usuario instanceof UsuarioDetalle) {
            UsuarioDetalle referencia = (UsuarioDetalle)usuario;
            this.prestamoSet = referencia.getPrestamoSet();
        }
    }

    @XmlTransient
    @OneToMany(mappedBy = "usuario")
    public Set<? extends Prestamo> getPrestamoSet() {
        return prestamoSet;
    }
    
    protected void setPrestamoSet(Set<? extends Prestamo> prestamoSet) {
        this.prestamoSet = prestamoSet;
    }
}
