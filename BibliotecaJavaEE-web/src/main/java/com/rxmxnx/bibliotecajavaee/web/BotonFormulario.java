/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.web;

import javax.servlet.http.*;

/**
 *
 * @author atem94
 */
public enum BotonFormulario {
    CREAR("Crear", "crear"), MODIFICAR("Modificar", "modificar"), ELIMINAR("Eliminar", "eliminar"), 
    BUSCAR("Buscar", "buscar");        
    private final String valor;
    private final String nombre;

    private BotonFormulario(String valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getValor() {
        return this.valor;
    }
    
    public static BotonFormulario traerBoton(HttpServletRequest request) {
        String valor = request.getParameter(ELIMINAR.getNombre());        
        if (valor != null && ELIMINAR.getValor().equals(valor))
            return ELIMINAR;
        else
            valor = request.getParameter(MODIFICAR.getNombre());        
        if (valor != null && MODIFICAR.getValor().equals(valor))
            return MODIFICAR;
        else
            valor = request.getParameter(CREAR.getNombre());        
        if (valor != null && CREAR.getValor().equals(valor))
            return CREAR;
        else
            valor = request.getParameter(BUSCAR.getNombre());      
        if (valor != null && BUSCAR.getValor().equals(valor))
            return BUSCAR;
        return null;
    }
}