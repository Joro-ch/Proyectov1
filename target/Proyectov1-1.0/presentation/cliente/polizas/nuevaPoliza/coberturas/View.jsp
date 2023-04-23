<%-- 
    Document   : View
    Created on : Apr 23, 2023, 9:17:05 AM
    Author     : gorki
--%>
<%@page import="com.program.proyectov1.logic.Cobertura"%>
<%@page import="com.program.proyectov1.presentation.cliente.polizas.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Model model = (Model)request.getAttribute("model");

%>
<!DOCTYPE html>
<html>
    <head>
        <base href = "http://localhost:8080/Proyectov1/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="./presentation/cliente/polizas/misPolizas/agregar/part2/submit">
            <h2>Selecicone una o más coberturas</h2>
            <%for(Cobertura c: model.getCoberturas()){ %>
                <input type="checkbox" name="coberturas" value="<%= c.getId() %>"><%= c.getDescripcion() %>

            <%}%>
            <input type="submit" value="Guardar">

        </form>

    </body>
</html>
