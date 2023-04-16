<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.program.proyectov1.logic.Cliente"%>
<% Cliente cliente = (Cliente) session.getAttribute("cliente"); %>


<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> EDITAR </title>
        <link rel="stylesheet" href="/Proyectov1/css/editarCuenta.css">
    </head>
    <body>
        <%@ include file = "../../../Header.jsp"%>
        
        <h1>Hello World!</h1>
        
        <%@include file = "../../../Footer.jsp" %>
    </body>
</html>
