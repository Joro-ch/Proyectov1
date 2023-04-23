<%-- 
    Document   : View
    Created on : Apr 23, 2023, 10:59:20 AM
    Author     : gorki
--%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check out</title>
    </head>
    <body>
        <table>
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
                        <td><%= Double.valueOf(poliza.getVehiculo().getValor()*(c.getCostoPorcentual()/100.0)).intValue(); %></td>
                 <% }else{%>
                        <td><%= c.getCostoMinimo()%></td>
                 <%   } %>

                </tr>
              <% } %>
            </tbody>
        </table>
            <span>Total: <%= poliza.getValorSeguro()%></span>
        <form action="./presentation/cliente/polizas/misPolizas/agregar/final/submit">
            <h1>Si está de acuerdo seleccione un metodo de pago</h1>
                <label for="metodoPago">Método de pago:</label>
            <select id="metodoPago" name="metodoPago">
                <option value="" selected disabled>Seleccione un método de pago</option>
                <option value="acepta">
                  <%= cliente.getTarjeta().getNumTarjeta() %>
                </option>
            </select>
            <input type="submit" value="Aceptar"/>
            <a href="/" class="cancelar">Cancelar</a>
        </form>
    </body>
</html>
