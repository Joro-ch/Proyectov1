<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.program.proyectov1.logic.Cliente"%>
<% Cliente cliente = (Cliente) session.getAttribute("cliente"); %>


<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../../../Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> EDITAR </title>
        <link rel="stylesheet" href="/Proyectov1/css/register.css">
    </head>
    <body>
        <%@ include file = "../../../Header.jsp"%>
        
        <div class = "cuerpo">
            <form class = "cuerpo-form" action = "./presentation/cliente/cuenta/editarCuenta/enviar" method = "POST">
                <img class ="cuerpo-form__img" src="/Proyectov1/images/loginicon1.png" alt=""/>
                <div class = "cuerpo-form__DatosUsuario">
                    <h2 class ="cuerpo-form__DatosUsuario-titulo"> Datos del Cliente </h2>
                    <i class = "fas fa-id-card cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="id" autocomplete="off" value = "<%= cliente.getId() %>" name = "id" readonly>
                    <i class = "fas fa-key cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="password" id="clave" autocomplete="off" value = "<%= cliente.getClave() %>" name="clave" required>
                    <i class = "fas fa-user cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="nombre" autocomplete="off" value = "<%= cliente.getNombre() %>" name="nombre" required>
                    <i class = "fas fa-phone cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="telefono" autocomplete="off" value = "<%= cliente.getTelefono() %>" name="telefono" required>
                    <i class = "fas fa-envelope cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="email" id="correo" autocomplete="off" value = "<%= cliente.getCorreo() %>" name="correo" required>
                </div>
                <div class = "cuerpo-form__DatosTarjeta">
                    <h2 class ="cuerpo-form__DatosTarjeta-titulo cuerpo-form__item"> Datos de la Tarjeta </h2>
                    <i class = "fas fa-users cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="titular" autocomplete="off" value = "<%= cliente.getTarjeta().getTitular() %>" name="titular" required>
                    <i class = "fas fa-credit-card cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="numTarjeta" autocomplete="off" value = "<%= cliente.getTarjeta().getNumTarjeta() %>" name="numTarjeta" required>
                    <i class = "fas fa-calendar cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="date" id="fechaExp" autocomplete="off" value = "<%= cliente.getTarjeta().getFechaExp()%>" name="fechaExp" required>
                    <i class = "fas fa-lock cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="codigoSeguridad" autocomplete="off" value = "<%= cliente.getTarjeta().getCodigoSeguridad() %>" name="codigoSeguridad" required>
                </div>
                <input class = "cuerpo-form__Submit" type="submit" value="Editar">
            </form>
        </div>
        
        <%@include file = "../../../Footer.jsp" %>
    </body>
</html>
