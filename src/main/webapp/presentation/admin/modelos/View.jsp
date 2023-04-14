<%-- 
    Document   : View
    Created on : Apr 13, 2023, 7:23:47 PM
    Author     : Laptop Camilo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Lista de modelos </title>
        <<link rel="stylesheet" href="/Proyectov1/css/modelos.css"/>
    </head>
    <body>
        <%@ include file = "../../Header.jsp"%>
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
					<td>${modelo.getModelo()}</td>
					<td>${modelo.getAnio}</td>
					<td>${modelo.getMarca}</td>
					<td>${modelo.getImagen}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    </body>
</html>
