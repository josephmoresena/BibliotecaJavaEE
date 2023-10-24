/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.util;

/**
 *
 * @author atem94
 */
public interface Parametrica extends Registro {
    public String nombre();
    
    @Override
    default String descripcion() {
        return this.nombre();
    }
}
