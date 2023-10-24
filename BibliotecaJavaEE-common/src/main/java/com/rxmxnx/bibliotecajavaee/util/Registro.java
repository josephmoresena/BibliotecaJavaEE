/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.util;

import com.rxmxnx.bibliotecajavaee.dominio.*;

/**
 *
 * @author atem94
 */
public interface Registro {
    public String codigo();
    public String descripcion();
    
    public static String obtenerCodigo(SuperEntidad entidad) {
        Number id = SuperEntidad.getId(entidad);
        return id != null ? id.toString() : "";
    }
    public static String limpiarTexto(String texto) {
        return texto != null ? texto.trim() : "";
    }
}
