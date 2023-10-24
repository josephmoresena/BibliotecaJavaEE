<%@page contentType="text/html" pageEncoding="UTF-8"%><%@page 
    import="com.rxmxnx.bibliotecajavaee.web.controladores.PaisServlet"%><%@page 
    import="com.rxmxnx.bibliotecajavaee.dominio.Pais"%><%@page 
    import="com.rxmxnx.bibliotecajavaee.util.*"%><%@page 
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=accion%> Pais</title>
    </head>
    <body>
        <h1><%=accion%> Pais</h1>
        <form name="mainForm" method="POST" action="<%=uriServlet%>"><%if (!creacion) {%>
            <input type="hidden" name="<%=PaisServlet.PARAMETRO_ID%>" value="<%=pais.getPaisId()%>"><%}%>
            Nombre: <input type="text" name="nombre" value="<%=Registro.limpiarTexto(pais.getNombre())%>"><br>
            <input type="submit" name="<%=boton.getNombre()%>" value="<%=boton.getValor()%>"><%if (!creacion) {%>
            <input type="submit" name="<%=botonEliminar.getNombre()%>" value="<%=botonEliminar.getValor()%>"><%}%>
        </form>
        <br/>
        <a href=".">Regresar</a>
    </body>
</html><%
    }%>