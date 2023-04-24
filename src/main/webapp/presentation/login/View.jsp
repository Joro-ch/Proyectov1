<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<%  Map<String,String> errores = (Map<String,String>) session.getAttribute("errores");
    session.removeAttribute("errores");
%>
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
                <input class = "cuerpo-form__input-Id cuerpo-form__item" autocomplete="off" type = "text" id = "id" placeholder="Ingrese su Cédula" name="id" required>
                <i class = "fas fa-key cuerpo-form__input-Clave-icon cuerpo-form__item"></i>
                <input class = "cuerpo-form__input-Clave cuerpo-form__item" autocomplete="off" type = "password" id = "clave" placeholder="Ingrese su Clave" name="pass" required>
                <input class = "cuerpo-form__input-Sumit cuerpo-form__item" type="submit" value="Ingresar">
                
                <h4 class = "cuerpo-form__MensajeRegistro cuerpo-form__item"> ¿No tienes cuenta? </h4>
                <a href="presentation/registro/show" class = "cuerpo-form__input-RegistroButton cuerpo-form__item"> Registrarse </a>
            </form>
            <div class="errores-container">
                    <div class="error-message <%=erroneo("cedulaFld",errores)%>"> <%= title("cedulaFld",errores)%></div>
            </div>
        </div>
        
        <%@ include file = "../Footer.jsp"%>
        
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