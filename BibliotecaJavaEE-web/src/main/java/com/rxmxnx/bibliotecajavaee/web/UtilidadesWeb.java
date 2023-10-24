/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.web;

import com.rxmxnx.bibliotecajavaee.dominio.*;
import com.rxmxnx.bibliotecajavaee.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.commons.lang.*;

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
    public static String accionFormulario(SuperEntidad entidad) {
        return entidad == null || SuperEntidad.getId(entidad) == null ? "Creaci&oacute;n" : "Edici&oacute;n";
    }
    public static BotonFormulario botonFormulario(SuperEntidad entidad) {
        return entidad == null || SuperEntidad.getId(entidad) == null ? BotonFormulario.CREAR : BotonFormulario.MODIFICAR;
    }
    public static String textoHtml(String texto) {
        return StringEscapeUtils.escapeHtml(Registro.limpiarTexto(texto));
    }
    public static String textoJavaScript(String texto) {
        return StringEscapeUtils.escapeJavaScript(Registro.limpiarTexto(texto));
    }
    public static void redirigir(InfoRedireccion info, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(InfoRedireccion.NOMBRE_REDIRECCION, info);
        request.getRequestDispatcher("/redireccion.jsp").forward(request, response);
    }
    public static String mensajeFormulario(BotonFormulario boton) {
        switch(boton) {
            case ELIMINAR:
                return "Registro eliminado satisfactoriamente.";
            case MODIFICAR:
                return "Registro modificado satisfactoriamente.";
            case CREAR:
                return "Registro creado satisfactoriamente.";
            default:
                return "";
        }
    }
}
