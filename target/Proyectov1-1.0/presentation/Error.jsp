<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.program.proyectov1.presentation.admin.categorias.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "Head.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
        <link rel="stylesheet" href="/Proyectov1/css/inicio.css">
    </head>
    <body>
        <%@ include file = "Header.jsp"%>
        
        <div class = "fondo"></div>
        <section class = "cuerpo">
            <h1 class = "error"> <%=request.getAttribute("ERROR")%> </h1>
        </section>
        
        <%@ include file = "Footer.jsp"%>
    </body>
</html>
