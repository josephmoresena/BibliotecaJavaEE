<%-- 
    Document   : paginaError
    Created on : Oct 22, 2023, 11:29:47 PM
    Author     : atem94
--%><%@page contentType="text/html" pageEncoding="UTF-8" import="com.rxmxnx.bibliotecajavaee.web.*"%><%
    AtributoPagina<InfoRedireccion> info = UtilidadesWeb.traerAtributo(pageContext, "redireccion");
    InfoRedireccion redireccion = null;
    try {
        redireccion = info.getObjeto();
    } catch(Exception ex) {
        redireccion = new InfoRedireccion(ex, "./");
    }
    if (redireccion == null) { 
        pageContext.forward("./");
    } else {
%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=redireccion.getTitulo()%></title>
    </head>
    <body>
        <script type="text/javascript">
            alert('<%=redireccion.getMensaje()%>');
            window.location.href = '<%=redireccion.getUrl()%>';
        </script>
    </body>
</html><%
    }%>
