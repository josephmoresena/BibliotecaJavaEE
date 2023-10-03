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
@MappedSuperclass
@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PrestamoReferencia extends Prestamo implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Libro libro;
    private Usuario usuario;
    
    public PrestamoReferencia(){
        super();
    }
    public PrestamoReferencia(Prestamo prestamo){
        super(prestamo);
        if (prestamo instanceof PrestamoReferencia) {
            PrestamoReferencia referencia = (PrestamoReferencia)prestamo;
            this.libro = referencia.getLibro();
            this.usuario = referencia.getUsuario();
        }
    }
    
    @JoinColumn(name = "id_libro", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    public Libro getLibro() {
        return libro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    
    protected void setLibro(Libro libro) {
        this.libro = libro;
        if (libro != null)
            super.setLibroId(libro.getId());
        else
            super.setLibroId(null);
    }
    protected void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null)
            super.setUsuarioId(usuario.getId());
        else
            super.setUsuarioId(null);
    }
    
    @Override
    public void setLibroId(Integer libroId) {
        if (libroId == null)
            this.libro = null;
        else if (this.libro != null && !libroId.equals(this.libro.getId()))
            this.libro = null;
        super.setLibroId(libroId);
    }
    @Override
    public void setUsuarioId(Integer usuarioId) {
        if (usuarioId == null)
            this.usuario = null;
        else if (this.usuario != null && !usuarioId.equals(this.usuario.getId()))
            this.usuario = null;
        super.setUsuarioId(usuarioId);
    }
}
