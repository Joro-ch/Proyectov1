<%-- 
    Document   : View
    Created on : Apr 12, 2023, 10:23:53 AM
    Author     : Laptop Camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/Proyectov1/css/polizas.css"/>
        <%@ include file = "../../../Head.jsp"%>
        <title> Poliza </title>
    </head>
    <body>
        <%@ include file = "../../../Header.jsp"%>
        <div class = "cuerpo">
            <form class = "cuerpo-form" action="./presentation/cliente/poliza/agregar" method="POST">
                <h1 class = "cuerpo-form__titulo"> Póliza </h1>

                <i class="fas fa-hashtag cuerpo-form__icon cuerpo-form__item"></i>
                <input class = "cuerpo-form__input cuerpo-form__item" autocomplete="off" type = "text" id = "id" placeholder="Ingrese la Placa" name="placa" required>    
                <i class="fas fa-car cuerpo-form__icon cuerpo-form__item"></i>
                <select class="cuerpo-form__item cuerpo-form__input" id = "marca" required>
                    <option value="">Seleccione una marca</option>
                    <option value="Toyota">Toyota-Hilux</option>
                    <option value="Honda">Honda-Civic</option>
                    <option value="Ford">Ford-Raptor</option>
                    <option value="Chevrolet">Chevrolet-Camaro</option>
                </select>

                <i class="fas fa-calendar cuerpo-form__icon cuerpo-form__item"></i>
                <input type="number" min="1990" max="2023" class ="cuerpo-form__item cuerpo-form__input" placeholder="Escriba el año del vehiculo" required>
                

                <i class="fas fa-dollar-sign cuerpo-form__icon cuerpo-form__item"></i>
                <input class = "cuerpo-form__input cuerpo-form__item" autocomplete="off" type = "text" id = "valor" placeholder="Ingrese el Valor" name="valor" required>
                
                <div class = "cuerpo-form__item cuerpo-form__radio">
                    <i class="fas fa-credit-card cuerpo-form__icon cuerpo-form__item" id="iconCheck"></i>
                    <label class="cuerpo-form__label cuerpo-form__item radio">
                        <input type="radio" name="opcion">
                        <span class="checkmark">Trimestral</span>
                    </label>
                    <label class="cuerpo-form__label cuerpo-form__item radio">
                        <input type="radio" name="opcion">
                        <span class="checkmark">Semestral</span>
                    </label>
                    <label class="cuerpo-form__label cuerpo-form__item radio">
                        <input type="radio" name="opcion">
                        <span class="checkmark">Anual</span>
                    </label>
                </div>
                <input class = "cuerpo-form__Submit" type="submit" value="Siguiente">
            </form>
        </div>
        <%@ include file = "../../../Footer.jsp" %>
    </body>
</html>
