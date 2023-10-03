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
public class PrestamoDetalle extends Prestamo implements Serializable {
    private static final long serialVersionUID = ENTIDAD_VERSION;
    
    private Libro libro;
    private Usuario usuario;
    
    public PrestamoDetalle(){
        super();
    }
    public PrestamoDetalle(Prestamo prestamo){
        super(prestamo);
        if (prestamo instanceof PrestamoDetalle) {
            PrestamoDetalle referencia = (PrestamoDetalle)prestamo;
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
            super.setLibroId(libro.getLibroId());
        else
            super.setLibroId(null);
    }
    protected void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null)
            super.setUsuarioId(usuario.getUsuarioId());
        else
            super.setUsuarioId(null);
    }
    
    @Override
    public void setLibroId(Integer libroId) {
        if (libroId == null)
            this.libro = null;
        else if (this.libro != null && !libroId.equals(this.libro.getLibroId()))
            this.libro = null;
        super.setLibroId(libroId);
    }
    @Override
    public void setUsuarioId(Integer usuarioId) {
        if (usuarioId == null)
            this.usuario = null;
        else if (this.usuario != null && !usuarioId.equals(this.usuario.getUsuarioId()))
            this.usuario = null;
        super.setUsuarioId(usuarioId);
    }
}
