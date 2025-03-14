<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>

<%
    Usuario usuario2 = (Usuario) session.getAttribute("usuario");
    if(usuario2 == null || usuario2.getTipo() != 1){
        response.sendRedirect(request.getContextPath() + "/Inicio");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Lista de Clientes </title>
        <link rel="stylesheet" href="/Proyectov1/css/Vmodelos.css">
    </head>
    <body>
        <%@ include file = "../../../../Header.jsp"%>
        <div class = "fondo">
            <div class = "cuerpo">
                <table>
                        <thead>
                                <tr>
                                        <th>Codigo</th>
                                        <th>Vehiculo</th>
                                        <th>Valor Seguro</th>
                                        <th>PlazoPagos</th>
                                        <th>Fecha de inicio</th>
                                        <th>Coberturas</th>
                                </tr>
                        </thead>
                        <tbody>
                                <tr>
                                        <td>${poliza.getCodigo()}</td>
                                        <td>${poliza.getVehiculo().getModelo().getModelo()} - ${poliza.getVehiculo().getNumPlaca()}</td>
                                        <td>${poliza.getValorSeguro()}</td>
                                        <td>${poliza.getPlazoPagos()}</td>
                                        <td>${poliza.getFechaInicioVigencia()}</td>
                                        <td> 
                                            <ul>
                                                <c:forEach var="cobertura" items="${poliza.getCoberturas()}">
                                                  <li><c:out value="${cobertura.getDescripcion()}"/></li>
                                                </c:forEach>
                                            </ul>
                                        </td>
                                </tr>                                    
                        </tbody>
                </table>
            </div>
        </div>
        <%@ include file = "../../../../Footer.jsp"%>
    </body>
</html>
