/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rxmxnx.bibliotecajavaee.web.controladores;

import com.rxmxnx.bibliotecajavaee.dominio.detalle.*;
import com.rxmxnx.bibliotecajavaee.negocio.*;
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
    public static final String NOMBRE_LISTADO = "listadoPais";
    
    @EJB
    private PaisBo bo;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Number paisId = UtilidadesWeb.getId(request, "id");
        if (paisId == null) {
            List<PaisDetalle> paises = this.bo.listarDetallado();
            request.setAttribute(NOMBRE_LISTADO, paises);
            request.getRequestDispatcher("/pais/listado.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

}
