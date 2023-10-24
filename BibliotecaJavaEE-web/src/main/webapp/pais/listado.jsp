<%@page contentType="text/html" pageEncoding="UTF-8"%><%@page 
    import="com.rxmxnx.bibliotecajavaee.web.controladores.PaisServlet"%><%@page 
    import="com.rxmxnx.bibliotecajavaee.dominio.detalle.PaisDetalle"%><%@page 
    import="com.rxmxnx.bibliotecajavaee.web.*"%><%@page 
    import="java.util.*"%><%
    final String uriServlet = "." + PaisServlet.URL;
    final String nombreLista = PaisServlet.NOMBRE_LISTADO;
    final String uriServletPais = uriServlet + "?" + PaisServlet.PARAMETRO_ID + "=";
    final BotonFormulario botonBuscar = BotonFormulario.BUSCAR;
    AtributoPagina<List<PaisDetalle>> info = UtilidadesWeb.traerAtributo(pageContext, nombreLista);
    final String filtroNombre = UtilidadesWeb.textoHtml(request.getParameter(PaisServlet.PARAMETRO_NOMBRE));
    final String uriServletCreacion = uriServlet + "?" + PaisServlet.PARAMETRO_CREAR + "=true";
    if (info.getObjeto() == null) {
        pageContext.forward("./");
    } else {
%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Pa&iacute;ses</title>
        <style>
            table {
                width: 80%;
                border-collapse: collapse;
                margin: 20px auto;
            }
            th, td {
                border: 1px solid #ccc;
                padding: 10px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            tr:nth-child(odd) {
                background-color: #fff;
            }
            a {
                text-decoration: none;
                color: #0074D9;
            }
            a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <h1>Paises</h1>
        <table>
            <thead>
                <tr>
                    <th><a href="<%=uriServletCreacion%>">Crear Pais</a></th>
                    <th>Nombre</th>
                    <th>Total Libros</th>
                    <th>Total Autores</th>
                </tr>
            </thead>
            <tbody><%for(PaisDetalle pais : info.getObjeto()) {%>
                <tr>
                    <td><a href="<%=uriServletPais + pais.getPaisId()%>">Ver</a></td>
                    <td><%=UtilidadesWeb.textoHtml(pais.getNombre())%></td>
                    <td><%=pais.getLibros().size()%></td>
                    <td><%=pais.getAutores().size()%></td>
                </tr>
            <%}%></tbody>
        </table>
        <form method="GET" action="<%=uriServlet%>">
            <label>Buscar por nombre: </label>
            <input type="text" name="<%=PaisServlet.PARAMETRO_NOMBRE%>" value="<%=filtroNombre%>"/>
            <input type="submit" name="<%=botonBuscar.getNombre()%>" value="<%=botonBuscar.getValor()%>">
        </form>
        <a href=".">Regresar</a>
    </body>
</html><%
    }%>