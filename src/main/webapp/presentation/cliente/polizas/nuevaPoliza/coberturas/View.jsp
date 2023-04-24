<%@page import="com.program.proyectov1.logic.Cobertura"%>
<%@page import="com.program.proyectov1.presentation.cliente.polizas.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    Model model = (Model)request.getAttribute("model");
    boolean first = true;
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file = "../../../../Head.jsp" %>
        <base href = "http://localhost:8080/Proyectov1/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Coberturas </title>
        <link rel="stylesheet" href="/Proyectov1/css/polizasPart2.css"/>
    </head>
    <body>
        
        <%@include file = "../../../../Header.jsp" %>
        
        <div class = "cuerpo">
            <form class = "cuerpo-form" action="./presentation/cliente/polizas/misPolizas/agregar/part2/submit">
                <h2 class = "cuerpo-form__titulo"> Seleccione una o más coberturas </h2>
                <table class = "cuerpo-form__table">
                    <tbody class = "cuerpo-form__table-cuerpo" > 
                        <%for(Cobertura c: model.getCoberturas()){ %>
                        <tr class = "tableRow">
                            <td> <input class = "cuerpo-form__input" type="checkbox" name="coberturas" value="<%= c.getId() %>"> </td>
                            <td> <span class = "cuerpo-form__info"> <%= c.getId() %> - <%= c.getDescripcion() %> </span> </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <input class = "cuerpo-form__submit" type="submit" value="Guardar">
            </form>
        </div>

        <%@include file = "../../../../Footer.jsp" %>
            
    </body>
</html>
