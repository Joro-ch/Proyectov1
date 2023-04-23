<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../Head.jsp"%>
        <link rel="stylesheet" href="/Proyectov1/css/login.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Login </title>
    </head>
    <body>
        <%@ include file = "../Header.jsp"%>
        
        <div class = "cuerpo">
            <form class = "cuerpo-form" action="./presentation/login/login" method="POST">
                <h1 class = "cuerpo-form__titulo cuerpo-form__item"> Login </h1>
                <img class ="cuerpo-form__image cuerpo-form__item" src="/Proyectov1/images/loginicon1.png" alt=""/>
                <i class = "fas fa-user cuerpo-form__input-Id-icon cuerpo-form__item"></i>
                <input class = "cuerpo-form__input-Id cuerpo-form__item" autocomplete="on" type = "text" id = "id" placeholder="Ingrese su Cédula" name="id">
                <i class = "fas fa-key cuerpo-form__input-Clave-icon cuerpo-form__item"></i>
                <input class = "cuerpo-form__input-Clave cuerpo-form__item" autocomplete="off" type = "password" id = "clave" placeholder="Ingrese su Clave" name="pass">
                <input class = "cuerpo-form__input-Sumit cuerpo-form__item" type="submit" value="Ingresar">
                <h4 class = "cuerpo-form__MensajeRegistro cuerpo-form__item"> ¿No tienes cuenta? </h4>
                <a href="presentation/registro/show" class = "cuerpo-form__input-RegistroButton cuerpo-form__item"> Registrarse </a>
            </form>
        </div>
        
        <!-- <footer class = "footer"></footer> -->
    </body>
</html>
