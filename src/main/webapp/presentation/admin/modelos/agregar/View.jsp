<%-- 
    Document   : View
    Created on : Apr 15, 2023, 6:04:23 PM
    Author     : gorki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Modelo</title>
        <link rel="stylesheet" href="/Proyectov1/css/Vmodelos.css">
    </head>
    <body class="add_body">
        <%@ include file = "../../../Header.jsp"%>
        <main class="fondo">
            <form action="./presentation/admin/modelos/agregar/new" method="POST" enctype="multipart/form-data">
            <label for="brand">Marca:</label>
            <select id="brand" name="marca">
                <option value="Toyota">Toyota</option>
                <option value="Honda">Honda</option>
                <option value="Nissan">Nissan</option>
            </select>
            <label for="model">Modelo:</label>
            <input type="text" id="model" name="modelo">
            <label for="year">Año: </label>
            <input type="text" id="year" name="anio">
            <label for="image">Imagen(JPG):</label>
            <input type="file" id="image" name="imagen" accept="image/jpeg">
            <input type="submit" value="Aceptar">
        </form>
        </main>
        <%@ include file = "../../../Footer.jsp"%>
    </body>
</html>
