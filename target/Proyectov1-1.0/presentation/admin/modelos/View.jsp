<%-- 
    Document   : View
    Created on : Apr 13, 2023, 7:23:47 PM
    Author     : Laptop Camilo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.program.proyectov1.logic.Modelo"%>
<%@page import="java.util.List"%>
<% List<Modelo> modelos = (List<Modelo>) request.getAttribute("modelos"); %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Lista de modelos </title>
        <link rel="stylesheet" href="/Proyectov1/css/Vmodelos.css">
    </head>
    <body>
        <%@ include file = "../../Header.jsp"%>
        <div class = "fondo">
            <div class = "cuerpo">
                <form action="./presentation/login/logout" method="post" class = "form_Boton">
                    <button type="submit" id = "agregar">Agregar</button>
                </form>
                <table>
                        <thead>
                                <tr>
                                        <th>Marca</th>
                                        <th>Modelo</th>
                                        <th>Año</th>
                                        <th>Imagen</th>
                                </tr>
                        </thead>
                        <tbody>
                                <c:forEach var="modelo" items="${modelos}">
                                        <tr>
                                                <td>${modelo.getMarca()}</td>
                                                <td>${modelo.getModelo()}</td>
                                                <td>${modelo.getAnio()}</td>
                                                <td>
                                                    <img src="data:image/jpg;base64, ${modelo.getImagen()}" alt="My Image">
                                                </td>
                                        </tr>
                                </c:forEach>
                        </tbody>
                </table>
            </div>
        </div>
        <%@ include file = "../../Footer.jsp"%>
    </body>
</html>
