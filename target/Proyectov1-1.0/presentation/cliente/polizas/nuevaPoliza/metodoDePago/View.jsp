<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.program.proyectov1.logic.Poliza"%>
<%@page import="com.program.proyectov1.logic.Cobertura"%>
<%@page import="com.program.proyectov1.logic.Vehiculo"%>
<%@page import="com.program.proyectov1.logic.Cliente"%>
<%@page import="com.program.proyectov1.logic.MetodoPago"%>

<%
    Poliza poliza = (Poliza)session.getAttribute("poliza");
    if(poliza == null){
        System.out.println("es nula la poliza");
    }else{
        System.out.println(poliza.getVehiculo());
    }
    Cliente cliente = (Cliente) session.getAttribute("cliente");
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file = "../../../../Head.jsp" %>
        <base href = "http://localhost:8080/Proyectov1/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check out</title>
        <link rel="stylesheet" href="/Proyectov1/css/polizasParteFinal.css"/>
    </head>
    <body>
        <%@include file = "../../../../Header.jsp" %>
        <div class = "cuerpo">
            <div class = "cuerpo-fondo">
                <h1 class = "cuerpo-titulo">Si está de acuerdo seleccione un metodo de pago</h1>
                <table class = "cuerpo-table">
                    <thead>
                        <tr>
                          <th>Nombre</th>
                          <th>Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                      <% for (Cobertura c : poliza.getCoberturas()) { %>
                        <tr>
                          <td><%= c.getDescripcion() %></td>
                          <%if(poliza.getVehiculo().getValor()*(c.getCostoPorcentual()/100.0)>c.getCostoMinimo()){%>
                                <td><%= poliza.getVehiculo().getValor()*(c.getCostoPorcentual()/100.0) %></td>
                         <% }else{%>
                                <td><%= c.getCostoMinimo()%></td>
                         <%   } %>

                        </tr>
                      <% } %>
                    </tbody>
                </table>
                <span class = "cuerpo-table__span">Total: <%= poliza.getValorSeguro()%></span>
                <span class = "cuerpo-table__span">Plazo de pago <%= poliza.getPlazoPagos()%></span>
                <form class = "cuerpo-form" action="./presentation/cliente/polizas/misPolizas/agregar/final/submit" method="POST">
                    <label class = "form-label" for="metodoPago">Método de pago:</label>
                    <select class = "form-input" id="metodoPago" name="metodoPago" required>
                        <option value="" selected disabled>Seleccione un método de pago</option>
                        <option value="acepta">
                          <%= cliente.getTarjeta().getNumTarjeta() %>
                        </option>
                    </select>
                    <input class = "form-submit" type="submit" value="Aceptar"/>
                    <a class = "form-cancelar" href="/">Cancelar</a>
                </form>
            </div>
        </div>  
        <%@include file = "../../../../Footer.jsp" %>
    </body>
</html>
