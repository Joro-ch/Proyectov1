<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                        <th>Codigo</th>
                                        <th>Vehiculo</th>
                                        <th>Valor Seguro</th>
                                        <th>PlazoPagos</th>
                                        <th>Fecha de inicio</th>
                                        <th>Coberturas</th>
                                </tr>
                        </thead>
                        <tbody>
                                <c:forEach var="poliza" items="${polizas}">
                                        <tr>
                                                <td>${poliza.getCodigo()}</td>
                                                <td>${poliza.getVehiculo().getModelo().getModelo()} - ${poliza.getVehiculo().getNumPlaca()}</td>
                                                <td>${poliza.getValorSeguro()}</td>
                                                <td>${poliza.getPlazoPagos()}</td>
                                                <td>${poliza.getFechaInicioVigencia()}</td>
                                                <td> </td>
                                        </tr>
                                </c:forEach>                                       
                        </tbody>
                </table>
            </div>
        </div>
        <%@ include file = "../../../Footer.jsp"%>
    </body>
</html>
