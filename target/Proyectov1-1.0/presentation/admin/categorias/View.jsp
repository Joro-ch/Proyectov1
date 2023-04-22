<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.program.proyectov1.logic.Categoria"%>
<%@page import="com.program.proyectov1.logic.Cobertura"%>
<%@page import="com.program.proyectov1.presentation.admin.categorias.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Categoria> categorias = model.getCategorias();
%>
    
<!DOCTYPE html>
<html>
    <head>
        <%@include file = "../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Listado </title>
        <link rel="stylesheet" href="/Proyectov1/css/categorias.css"/>
    </head>
    <body>
        
        <%@include file = "../../Header.jsp" %>
        
        <div class = "cuerpo">
            <h1 class = "cuerpo-titulo"> Categorias </h1>
            <div class = "cuerpo-fondo">
                
                <table class = "cuerpo-tabla">
                    <thead class = "cuerpo-tabla__encabezado">
                        <tr> <td class = "td-1"> ID </td> <td> Descripcion </td>  <td> Coberturas </td> </tr>
                    </thead>
                    <tbody class = "cuerpo-tabla__cuerpo">
                        <% for(Categoria c:categorias) { %>

                        <tr>
                            <td class = "table-image">
                                <h3> <%= c.getId() %> </h3>
                            </td>
                            <td class = "table-calificacion">
                                <h3> <%= c.getDescripcion() %> </h3>
                            </td>
                            <td class = "table-coberturas">
                                <% for(Cobertura co:c.getCoberturas()) { %>
                                <h3>  <%= co.getDescripcion() %> </h3>
                                <% } %>
                            </td>
                        </tr>

                        <% } %>
                    </tbody>
                </table>  
                <a class = "cuerpo-tabla__categoriaButton" href="presentation/admin/categorias/agregarCat/show"> Agregar Categoria </a>
                <a class = "cuerpo-tabla__coberturaButton" href = "presentation/admin/categorias/agregarCob/show">  Agregar Coberturas </a>
            </div>
        </div>
        
        <%@include file = "../../Footer.jsp" %>
        
    </body>
</html>
