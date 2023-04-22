<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.program.proyectov1.presentation.admin.categorias.Model" %>
<%@page import="com.program.proyectov1.logic.Categoria" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Categoria> categorias = model.getCategorias();
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file = "../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Agregar </title>
    </head>
    <body>
        <%@include file = "../../../Header.jsp" %>
        
        <div class = "cuerpo">
            <form class = "cuerpo-form" action = "./presentation/admin/categorias/agregarCob" method = "POST" > 
                <h1> Cobertura </h1>
                <i class = "fas fa-user cuerpo-form__icon"></i>
                <select>
                    <option value="" disabled selected>Seleccione una Categoria</option>
                    <% for(Categoria c:categorias) { %>
                    <option value="categoria"> <%=c.getDescripcion()%> </option>
                    <% } %>
                </select>
                <i class = "fas fa-user cuerpo-form__icon"></i>
                <input type = "text" id = "id" name = "descripcion" placeholder = "Ingrese la Descripción" autocomplete = "off">
                <i class = "fas fa-user cuerpo-form__icon"></i>
                <input type = "text" id = "id" name = "costo minimo" placeholder = "Ingrese el Costo Mínimo" autocomplete = "off">
                <i class = "fas fa-user cuerpo-form__icon"></i>
                <input type = "text" id = "id" name = "costo porcentual" placeholder = "Ingrese el Costo Porcentual" autocomplete = "off">
                <input type="submit" value = "Agregar">
            </form>
        </div>
        
        <%@include file = "../../../Footer.jsp" %>
    </body>
</html>
