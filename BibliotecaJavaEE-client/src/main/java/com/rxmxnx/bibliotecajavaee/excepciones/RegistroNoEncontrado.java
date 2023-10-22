/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.excepciones;

/**
 *
 * @author atem94
 */
public final class RegistroNoEncontrado extends ExcepcionRegistro {
    public RegistroNoEncontrado(Class<?> clase) {
        super("No se encontró registro " + clase.getSimpleName(), clase, null);
    }
    /**
     *
     * @param clase
     * @param id
     */
    public RegistroNoEncontrado(Class<?> clase, Number id) {
        super("No se encontró registro " + clase.getSimpleName() + " con identificador " + id, clase, id);
    }
}
