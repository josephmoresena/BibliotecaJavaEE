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
public class RegistroExiste extends ExcepcionRegistro {
    /**
     *
     * @param condicion
     * @param clase
     * @param id
     */
    public RegistroExiste(String condicion, Class<?> clase, Number id) {
        super("El registro ya existe " + clase.getSimpleName() + " con " + condicion, clase, id);
    }
}
