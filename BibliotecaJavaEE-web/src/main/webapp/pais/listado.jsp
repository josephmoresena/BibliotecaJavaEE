<%-- 
    Document   : listado
    Created on : Oct 23, 2023, 12:22:59 AM
    Author     : atem94
--%><%@page import="com.rxmxnx.bibliotecajavaee.web.controladores.PaisServlet"%><%@taglib 
    uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@page contentType="text/html" pageEncoding="UTF-8" 
    import="com.rxmxnx.bibliotecajavaee.web.*, com.rxmxnx.bibliotecajavaee.dominio.detalle.PaisDetalle, java.util.*"%><%
    final String uriServlet = "." + PaisServlet.URL;
    final String nombreLista = PaisServlet.NOMBRE_LISTADO;
    final String uriServletPais = uriServlet + "?" + PaisServlet.PARAMETRO_ID + "=";
    final BotonFormulario botonBuscar = BotonFormulario.BUSCAR;
    AtributoPagina<List<PaisDetalle>> info = UtilidadesWeb.traerAtributo(pageContext, nombreLista);
    if (info.getObjeto() == null) {
        pageContext.forward("./");
    } else {
%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Paises</title>
    </head>
    <body>
        <h1>Paises</h1>
        <table>
            <thead>
                <tr>
                    <th>&nbsp;</th>
                    <th>Nombre</th>
                    <th>Libros</th>
                    <th>Autores</th>
                </tr>
            </thead>
            <tbody><%for(PaisDetalle pais : info.getObjeto()) {%>
                <tr>
                    <td><a href="<%=uriServletPais + pais.getPaisId()%>">Editar</a></td>
                    <td><%=pais.getNombre()%></td>
                    <td><%=pais.getLibroSet().size()%></td>
                    <td><%=pais.getAutorSet().size()%></td>
                </tr>
            <%}%></tbody>
        </table>
        </ul>
    </body>
</html><%
    }%>
