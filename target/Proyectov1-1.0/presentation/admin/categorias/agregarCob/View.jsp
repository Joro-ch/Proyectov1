<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.program.proyectov1.presentation.admin.categorias.Model" %>
<%@page import="com.program.proyectov1.logic.Categoria" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>

<%
    Usuario usuario2 = (Usuario) session.getAttribute("usuario");
    if(usuario2 == null || usuario2.getTipo() != 2){
        response.sendRedirect(request.getContextPath() + "/Inicio");
    }
    Model model = (Model) request.getAttribute("model");
    List<Categoria> categorias = model.getCategorias();
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file = "../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Agregar </title>
        <link rel = "stylesheet" href = "/Proyectov1/css/agregarCobertura.css"/>
    </head>
    <body>
        <%@include file = "../../../Header.jsp" %>
        
        <div class = "cuerpo">
            <form class = "cuerpo-form" action = "./presentation/admin/categorias/agregarCob" method = "POST" > 
                <h1 class = "cuerpo-form__titulo"> Cobertura </h1>
                <i class = "fas fa-list cuerpo-form__icon"></i>
                <select class = "cuerpo-form__input" id = "categoria" name = "categoria" required>
                    <option value="" disabled selected>Seleccione una Categoria</option>
                    <% for(Categoria c:categorias) { %>
                    <option id = "categoria" value="<%=c.getId()%>"> <%=c.getId()%> - <%=c.getDescripcion()%> </option>
                    <% } %>
                </select>
                <i class = "fas fa-pen cuerpo-form__icon"></i>
                <input class = "cuerpo-form__input" type = "text" id = "descripcion" name = "descripcion" placeholder = "Ingrese la Descripción" autocomplete = "off" required>
                <i class = "fas fa-dollar-sign cuerpo-form__icon"></i>
                <input class = "cuerpo-form__input" type = "text" id = "costoMinimo" name = "costo minimo" placeholder = "Ingrese el Costo Mínimo" autocomplete = "off" required>
                <i class = "fas fa-percent cuerpo-form__icon"></i>
                <input class = "cuerpo-form__input" type = "text" id = "costoPorcentual" name = "costo porcentual" placeholder = "Ingrese el Costo Porcentual" autocomplete = "off" required>
                <input class = "cuerpo-form__submit" type="submit" value = "Agregar">
            </form>
        </div>
        
        <%@include file = "../../../Footer.jsp" %>
    </body>
</html>
