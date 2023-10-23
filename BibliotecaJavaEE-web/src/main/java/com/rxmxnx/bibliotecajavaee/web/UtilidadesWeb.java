/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.*;

/**
 *
 * @author atem94
 */
public final class UtilidadesWeb {
    public static <T> AtributoPagina<T> traerAtributo(PageContext pagina, String nombreAtributo) {
        Object objeto = pagina.getRequest().getAttribute(nombreAtributo);
        if (objeto == null) 
            return new AtributoPagina<>();
        try {
            return new AtributoPagina<>((T)objeto);
        } catch(Exception ex) {
            return new AtributoPagina<>(ex);
        }
    }
    public static Number getId(HttpServletRequest request, String nombre) {
        String valor = request.getParameter(nombre);
        try {
            return Long.parseLong(valor);
        } catch(Exception ex) {
            return null;
        }
    }
}
