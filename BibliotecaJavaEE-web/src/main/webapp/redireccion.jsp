<%@page contentType="text/html" pageEncoding="UTF-8" import="com.rxmxnx.bibliotecajavaee.web.*"%><%
    AtributoPagina<InfoRedireccion> info = UtilidadesWeb.traerAtributo(pageContext, InfoRedireccion.NOMBRE_REDIRECCION);
    InfoRedireccion redireccion = null;
    try {
        redireccion = info.getObjeto();
    } catch(Exception ex) {
        redireccion = new InfoRedireccion(ex, "/");
    }
    if (redireccion == null) { 
        pageContext.forward("./");
    } else {
%><!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=UtilidadesWeb.textoHtml(redireccion.getTitulo())%></title>
    </head>
    <body>
        <script type="text/javascript">
            alert("<%=UtilidadesWeb.textoJavaScript(redireccion.getMensaje())%>");
            window.location.href = ".<%=UtilidadesWeb.textoJavaScript(redireccion.getUrl())%>";
        </script>
    </body>
</html><%
    }%>