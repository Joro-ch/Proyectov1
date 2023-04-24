<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>

<%
    Usuario usuario2 = (Usuario) session.getAttribute("usuario");
    if(usuario2 == null || usuario2.getTipo() != 2){
        response.sendRedirect(request.getContextPath() + "/Inicio");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Admin Dashboard </title>
        <link rel="stylesheet" href="/Proyectov1/css/cuentaAdmin.css">
    </head>
    <body>
        
        <%@ include file = "../../Header.jsp" %>
        
        <div class = "cuerpo">
            <div class = "cuerpo-fondo">
                <% if (usuario != null) { %>
                <div class = "cuerpo-Datos">
                    <h2 class = "cuerpo-Datos__Titulo"> Datos del Administrador </h2>
                    <i class = "fas fa-user cuerpo-Datos__icon"></i>
                    <h4 class = "cuerpo-Datos__item"> Cédula: <%=usuario.getId()%> </h4>
                    <i class = "fas fa-key cuerpo-Datos__icon"></i>
                    <h4 class = "cuerpo-Datos__item"> Clave: <%=usuario.getClave()%> </h4>
                </div>
                <% } else { %>
                
                <h2> Error </h2>
                
                <% } %>
                
            </div>
        </div>
        
        <%@ include file = "../../Footer.jsp" %>
        
    </body>
</html>
