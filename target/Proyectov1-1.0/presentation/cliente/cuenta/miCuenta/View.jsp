<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.program.proyectov1.logic.Cliente"%>
<% Cliente cliente = (Cliente) session.getAttribute("cliente"); %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> CUENTA </title>
        <link rel="stylesheet" href="/Proyectov1/css/cuenta.css">
    </head>
    <body>
        <%@ include file = "../../../Header.jsp"%>
        
        <div class = "fondo"></div>
        
        <div class = "cuerpo">
            <div class = "cuerpo__fondo"> 
                <% if (cliente != null) { %>
                <h1 class = "cuerpo__Titulo"> <%=cliente.getNombre()%>  </h1>
                <div class = "cuerpo-DatosUsuario">
                    <h2 class = "cuerpo-DatosTarjeta__Titulo"> Datos del Usuario </h2>
                    <i class = "fas fa-user cuerpo-form__input-Id-icon cuerpo-DatosUsuario__icon"></i>
                    <h4 class = "cuerpo-DatosUsuario__item"> Nombre: <%=cliente.getNombre()%> </h4>
                    <i class = "fas fa-id-card cuerpo-form__input-Id-icon cuerpo-DatosUsuario__icon"></i>
                    <h4 class = "cuerpo-DatosUsuario__item"> Cédula: <%=cliente.getId()%> </h4>
                    <i class = "fas fa-key cuerpo-form__input-Id-icon cuerpo-DatosUsuario__icon"></i>
                    <h4 class = "cuerpo-DatosUsuario__item"> Contraseña: <%=cliente.getClave()%> </h4>
                    <i class = "fas fa-phone cuerpo-form__input-Id-icon cuerpo-DatosUsuario__icon"></i>
                    <h4 class = "cuerpo-DatosUsuario__item"> Télefono: <%=cliente.getTelefono()%> </h4>
                    <i class = "fas fa-envelope cuerpo-form__input-Id-icon cuerpo-DatosUsuario__icon"></i>
                    <h4 class = "cuerpo-DatosUsuario__item"> Correo: <%=cliente.getCorreo()%> </h4>
                </div>
                <div class = "cuerpo-DatosTarjeta">
                    <h2 class = "cuerpo-DatosTarjeta__Titulo"> Datos de la Tarjeta </h2>
                    <i class = "fas fa-users cuerpo-form__input-Id-icon cuerpo-DatosTarjeta__icon"></i>
                    <h4 class = "cuerpo-DatosTarjeta__item"> Titular: <%=cliente.getTarjeta().getTitular()%> </h4>
                    <i class = "fas fa-credit-card cuerpo-form__input-Id-icon cuerpo-DatosTarjeta__icon"></i>
                    <h4 class = "cuerpo-DatosTarjeta__item"> Número de Tarjeta: <%=cliente.getTarjeta().getNumTarjeta()%> </h4>
                    <i class = "fas fa-calendar cuerpo-form__input-Id-icon cuerpo-DatosTarjeta__icon"></i>
                    <h4 class = "cuerpo-DatosTarjeta__item"> Fecha de Expiración: <%=cliente.getTarjeta().getFechaExp()%> </h4>
                    <i class = "fas fa-lock cuerpo-form__input-Id-icon cuerpo-DatosTarjeta__icon"></i>
                    <h4 class = "cuerpo-DatosTarjeta__item"> CVV: <%=cliente.getTarjeta().getCodigoSeguridad()%> </h4>
                </div>
                <a href = "presentation/cliente/cuenta/editarCuenta/show" class = "cuerpo-EditarButton"> Editar Datos </a>
                <% } else { %>
            
                <h1> Error </h1>
            
                <% } %>
            </div>
        </div>
        
        <%@include file = "../../../Footer.jsp" %>
    </body>
</html>
