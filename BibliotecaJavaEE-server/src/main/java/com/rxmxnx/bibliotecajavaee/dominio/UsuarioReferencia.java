/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.dominio;

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
public class UsuarioReferencia extends Usuario implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Set<? extends Prestamo> prestamoSet;
    
    public UsuarioReferencia() {
        super();
    }
    public UsuarioReferencia(Usuario usuario) {
        super(usuario);
        if (usuario instanceof UsuarioReferencia) {
            UsuarioReferencia referencia = (UsuarioReferencia)usuario;
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
