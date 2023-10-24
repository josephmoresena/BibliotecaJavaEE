/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.web.controladores;

import com.rxmxnx.bibliotecajavaee.dominio.Pais;
import com.rxmxnx.bibliotecajavaee.dominio.detalle.PaisDetalle;
import com.rxmxnx.bibliotecajavaee.excepciones.*;
import com.rxmxnx.bibliotecajavaee.negocio.*;
import com.rxmxnx.bibliotecajavaee.util.*;
import com.rxmxnx.bibliotecajavaee.web.*;
import java.io.*;
import java.util.*;
import javax.ejb.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 *
 * @author atem94
 */
@WebServlet(name = "Paises", urlPatterns = { PaisServlet.URL })
public class PaisServlet extends HttpServlet {
    public static final String URL = "/pais";
    public static final String NOMBRE = "Pais";
    public static final String PARAMETRO_CREAR = "creacion";
    public static final String PARAMETRO_ID = "id";
    public static final String PARAMETRO_NOMBRE = "nombre";
    public static final String NOMBRE_PAIS = "pais";
    public static final String NOMBRE_LISTADO = "listadoPais";
    
    @EJB
    private PaisBo bo;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Number paisId = UtilidadesWeb.getId(request, "id");
        boolean creacion = esCreacion(request);
        if (paisId == null && !creacion)
            mostrarListado(request, response);
        else 
            mostrarRegistro(paisId, creacion, request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pais pais = new Pais();
        try
        {
            BotonFormulario boton = BotonFormulario.traerBoton(request);
            switch(boton)
            {
                case MODIFICAR:
                    pais = this.traerPais(request);
                    actualizarPais(pais, request);
                    this.bo.modificar(pais);
                    break;
                case ELIMINAR:
                    pais = this.traerPais(request);
                    this.bo.eliminar(pais.getPaisId());
                    break;
                default:
                    actualizarPais(pais, request);
                    this.bo.crear(pais);
                    break;
                
            }
            UtilidadesWeb.redirigir(new InfoRedireccion("Cambios realizados", UtilidadesWeb.mensajeFormulario(boton), URL), request, response);
        } catch(Exception ex) {
            UtilidadesWeb.redirigir(new InfoRedireccion(ex, URL), request, response);
        }
    }
    
    private void mostrarListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filtro = Registro.limpiarTexto(request.getParameter(PARAMETRO_NOMBRE));
        List<PaisDetalle> paises = filtro.equals("") ? this.bo.listarDetallado() : this.bo.buscarPorNombre(filtro);
        request.setAttribute(NOMBRE_LISTADO, paises);
        request.getRequestDispatcher("/pais/listado.jsp").forward(request, response);
    }
    private void mostrarRegistro(Number paisId, boolean creacion, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute(NOMBRE_PAIS, !creacion ? this.bo.encontrar(paisId.shortValue()) : new Pais());
            request.getRequestDispatcher("/pais/formulario.jsp").forward(request, response);
        } catch(Exception ex) {
            request.setAttribute(InfoRedireccion.NOMBRE_REDIRECCION, new InfoRedireccion(ex, URL));
            request.getRequestDispatcher("/paginaError.jsp").forward(request, response);
        }
    }
    private Pais traerPais(HttpServletRequest request) throws RegistroNoEncontrado {
        Number id = UtilidadesWeb.getId(request, "id");
        Pais pais = this.bo.encontrar(id.shortValue());
        return pais;
    }
    private void actualizarPais(Pais pais, HttpServletRequest request) {
        pais.setNombre(request.getParameter("nombre"));
    }
    
    private static boolean esCreacion(HttpServletRequest request) {
        return request.getParameterMap().keySet().stream().anyMatch(p -> p.equals(PARAMETRO_CREAR));
    }
}
