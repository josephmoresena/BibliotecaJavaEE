/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.web;

/**
 *
 * @author atem94
 */
public class InfoRedireccion {
    public static final String NOMBRE_REDIRECCION = "redireccion";
    
    private final String titulo;
    private final String mensaje;
    private final String url;
    
    public InfoRedireccion(String titulo, String mensaje, String url) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.url = url;
    }
    public InfoRedireccion(Exception ex, String url) {
        this.titulo = ex.getClass().getSimpleName();
        this.mensaje = getMessage(ex);
        this.url = url;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    public String getMensaje(){
        return this.mensaje;
    }
    public String getUrl() {
        return url;
    }
    
    public static String getMessage(Exception ex) {
        String resultado = ex.getMessage();
        if (resultado == null && ex.getCause() != null) {
            resultado = ex.getCause().getMessage();
            if (resultado == null)
                resultado = ex.getCause().toString();
        } else if(resultado == null)
            resultado = ex.toString();
        return resultado;
    }
}
