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
public abstract class ExcepcionRegistro extends Exception {
    private final Class<?> clase;
    private final Number id;
    
    protected ExcepcionRegistro(String mensajeExcepcion, Class<?> clase, Number id) {
        super(mensajeExcepcion);
        this.clase = clase;
        this.id = id;
    }
    
    public Class<?> claseRegistro() {
        return this.clase;
    }
    
    public Number idRegistro() {
        return this.id;
    }
}
