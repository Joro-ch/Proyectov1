<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.program.proyectov1.logic.Cobertura"%>
<%@page import="com.program.proyectov1.presentation.cliente.polizas.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>

<%
    Usuario usuario2 = (Usuario) session.getAttribute("usuario");
    if(usuario2 == null || usuario2.getTipo() != 1){
        response.sendRedirect(request.getContextPath() + "/Inicio");
    }
    Model model = (Model)request.getAttribute("model");
    Map<String,String> errores = (Map<String,String>) session.getAttribute("errores");
    session.removeAttribute("errores");
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
            <div class="errores-container">
                <div class="error-message <%=erroneo("coberturas",errores)%>"> <%= title("coberturas",errores)%></div>
                    
            </div>
        </div>

        <%@include file = "../../../../Footer.jsp" %>
            
    </body>
</html>
<%!
    private String erroneo(String campo, Map<String,String>errores){
        if ( (errores!=null) && (errores.get(campo)!=null) )
            return "is-invalid";
        else
            return "";
    }
    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

%>
