
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file = "../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Agregar </title>
        <link rel = "stylesheet" href = "/Proyectov1/css/agregarCategorias.css"/>
    </head>
    <body>
        
        <%@include file = "../../../Header.jsp" %>
        
        <div class = "cuerpo">
            <form class = "cuerpo-form" action = "./presentation/admin/categorias/agregar" method = "POST">
                <h1 class = "cuerpo-form__titulo"> Categoria </h1>
                <i class = "fas fa-user cuerpo-form__icon"></i>
                <input class = "cuerpo-form__input" type = "text" id = "id" placeholder = "Ingrese la Descripción" name = "descripcion">
                <input class = "cuerpo-form__submit" type = "submit" value = "Agregar">
            </form>
        </div>
        
        <%@include file = "../../../Footer.jsp" %>
        
    </body>
</html>
