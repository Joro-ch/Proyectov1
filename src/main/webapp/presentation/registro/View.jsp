<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../Head.jsp"%>
        <link rel="stylesheet" href="/Proyectov1/css/register.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registro </title>
    </head>
    <body>
        <%@ include file = "../Header.jsp"%>
        
        <div class = "cuerpo">
            <form class = "cuerpo-form" action = "./presentation/registro/registrar" method = "POST">
                <img class ="cuerpo-form__img" src="/Proyectov1/images/loginicon1.png" alt=""/>
                <div class = "cuerpo-form__DatosUsuario">
                    <h2 class ="cuerpo-form__DatosUsuario-titulo"> Datos del Cliente </h2>
                    <i class = "fas fa-id-card cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="id" autocomplete="off" placeholder="Ingrese su Cédula" name="id">
                    <i class = "fas fa-key cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="password" id="clave" autocomplete="off" placeholder="Ingrese su Clave" name="clave">
                    <i class = "fas fa-user cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="nombre" autocomplete="off" placeholder="Ingrese su Nombre" name="nombre">
                    <i class = "fas fa-phone cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="telefono" autocomplete="off" placeholder="Ingrese su Télefono" name="telefono">
                    <i class = "fas fa-envelope cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="email" id="correo" autocomplete="off" placeholder="Ingrese su Correo" name="correo">
                </div>
                <div class = "cuerpo-form__DatosTarjeta">
                    <h2 class ="cuerpo-form__DatosTarjeta-titulo cuerpo-form__item"> Datos de la Tarjeta </h2>
                    <i class = "fas fa-users cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="titular" autocomplete="off" placeholder="Ingrese el Titular" name="titular">
                    <i class = "fas fa-credit-card cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="numTarjeta" autocomplete="off" placeholder="Ingrese el Número de Tarjeta" name="numTarjeta">
                    <i class = "fas fa-calendar cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="date" id="fechaExp" autocomplete="off" placeholder="Ingrese la Fecha de Expiración" name="fechaExp">
                    <i class = "fas fa-lock cuerpo-form__input-icon"></i>
                    <input class = "cuerpo-form__input" type="text" id="codigoSeguridad" autocomplete="off" placeholder="Ingrese el Codigo de Seguridad (CVV)" name="codigoSeguridad">
                </div>
                <input class = "cuerpo-form__Submit" type="submit" value="Registrarse">
            </form>
        </div>
        
        <!-- <footer class = "footer"></footer> -->
    </body>
</html>
