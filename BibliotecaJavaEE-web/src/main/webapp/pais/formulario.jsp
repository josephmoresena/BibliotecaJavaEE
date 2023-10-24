<%@page contentType="text/html" pageEncoding="UTF-8"%><%@page 
    import="com.rxmxnx.bibliotecajavaee.web.controladores.PaisServlet"%><%@page 
    import="com.rxmxnx.bibliotecajavaee.dominio.Pais"%><%@page 
    import="com.rxmxnx.bibliotecajavaee.web.*"%><%@page 
    import="java.util.*"%><%
    final String uriServlet = "." + PaisServlet.URL;
    final String nombrePais = PaisServlet.NOMBRE_PAIS;
    AtributoPagina<Pais> info = UtilidadesWeb.traerAtributo(pageContext, nombrePais);
    if (info.getObjeto() == null) {
        pageContext.forward("./");
    } else {
        final String accion = UtilidadesWeb.accionFormulario(info.getObjeto());
        final BotonFormulario boton = UtilidadesWeb.botonFormulario(info.getObjeto());
        final BotonFormulario botonEliminar = BotonFormulario.ELIMINAR;
        final boolean creacion = boton == BotonFormulario.CREAR;
        final Pais pais = info.getObjeto();
%><!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=accion%> Pais</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }
            h1 {
                background-color: #333;
                color: #fff;
                padding: 10px;
                text-align: center;
            }
            form {
                background-color: #fff;
                border: 1px solid #ccc;
                border-radius: 5px;
                padding: 20px;
                margin: 20px;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
            }
            label {
                display: block;
                margin-top: 10px;
            }
            input[type="text"] {
                width: 100%;
                padding: 10px;
                margin-top: 5px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            input[type="submit"] {
                background-color: #333;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-top: 10px;
            }
            input[type="submit"]:hover {
                background-color: #555;
            }
            a {
                text-decoration: none;
                background-color: #333;
                color: #fff;
                padding: 5px 10px;
                border-radius: 5px;
            }
            a:hover {
                background-color: #555;
            }
        </style>
    </head>
    <body>
        <h1><%=accion%> Pais</h1>
        <form name="mainForm" method="POST" action="<%=uriServlet%>"><%if (!creacion) {%>
            <input type="hidden" name="<%=PaisServlet.PARAMETRO_ID%>" value="<%=pais.getPaisId()%>"><%}%>
            Nombre: <input type="text" name="nombre" value="<%=UtilidadesWeb.textoHtml(pais.getNombre())%>"><br>
            <input type="submit" name="<%=boton.getNombre()%>" value="<%=boton.getValor()%>"><%if (!creacion) {%>
            <input type="submit" name="<%=botonEliminar.getNombre()%>" value="<%=botonEliminar.getValor()%>"><%}%>
        </form>
        <br/>
        <a href="<%=uriServlet%>">Regresar</a>
    </body>
</html><%
    }%>