/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.utilidades;

/**
 *
 * @author atem94
 */
public final class UtilidadesJava {
    private UtilidadesJava() {}
    
    public static <T> Class<T> recargarClase(Class<T> clase) {
        try {
            Class.forName(clase.getName(), true, clase.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);  // Can't happen
        }
        return clase;
    }
}
