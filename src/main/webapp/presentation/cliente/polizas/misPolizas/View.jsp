<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <%@ include file = "../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Lista de Clientes </title>
        <link rel="stylesheet" href="/Proyectov1/css/Vmodelos.css">
    </head>
    <body>
        <%@ include file = "../../../Header.jsp"%>
        <div class = "fondo">
            <div class = "cuerpo">
                <div class="busqueda">
                    <form class = "cuerpo-form" action = "./presentation/cliente/polizas/misPolizas/busqueda" method = "POST"> 
                        <input class = "busqueda_input" type="text" autocomplete="off" placeholder="Placa del Vehiculo" name="placa">
                        <input class = "busqueda_boton" type="submit" value="Buscar">                    
                    </form>
                </div>
                <table class = "cuerpo-table">
                        <thead>
                                <tr>
                                        <th>Numero</th>
                                        <th>Placa</th>
                                        <th>Fecha</th>
                                        <th>Auto</th>
                                        <th> </th>
                                        <th>Valor</th>
                                        <th>Ver</th>
                                </tr>
                        </thead>
                        <tbody>
                                <c:forEach var="poliza" items="${polizas}">
                                        <tr>
                                                <td>${poliza.getCodigo()}</td>
                                                <td>${poliza.getVehiculo().getNumPlaca()}</td>
                                                <td>${poliza.getFechaInicioVigencia()}</td>
                                                <td>${poliza.getVehiculo().getModelo().getMarca()} ${poliza.getVehiculo().getModelo().getModelo()} ${poliza.getVehiculo().getModelo().getAnio()}</td>
                                                <td><img src="data:image/jpg;base64,${poliza.getVehiculo().getModelo().getImagenBase64()}" alt="My Image"></td>
                                                <td>${poliza.getValorSeguro()}</td>
                                                <td>  
                                                    <a href="./presentation/cliente/polizas/misPolizas/datos?id=${cliente.getId()}&poliza=${poliza.getCodigo()}"><img src="/Proyectov1/images/ver.png" alt="My Image" height="30" width="30"></a>
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
