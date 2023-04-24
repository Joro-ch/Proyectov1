<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%@ include file = "../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Lista de Clientes </title>
        <link rel="stylesheet" href="/Proyectov1/css/Vmodelos.css">
    </head>
    <body>
        <%@ include file = "../../../Header.jsp"%>
        <div class = "fondo">
            <div class = "cuerpo">
                <table>
                        <thead>
                                <tr>
                                        <th>nombre</th>
                                        <th>telefono</th>
                                        <th>correo</th>
                                        <th>polizas</th>
                                </tr>
                        </thead>
                        <tbody>
                                <c:forEach var="cliente" items="${clientes}">
                                        <tr>
                                                <td>${cliente.getNombre()}</td>
                                                <td>${cliente.getTelefono()}</td>
                                                <td>${cliente.getCorreo()}</td>
                                                <td>  
                                                    <a href="./presentation/admin/clientes/polizas?id=${cliente.getId()}"><img src="/Proyectov1/images/poliza.png" alt="My Image" height="30" width="30"></a>
                                                </td>
                                        </tr>
                                </c:forEach>                                       
                        </tbody>
                </table>
            </div>
        </div>
        <%@ include file = "../../../Footer.jsp"%>
    </body>
</html>
