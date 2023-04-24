<%-- 
    Document   : View
    Created on : Apr 12, 2023, 10:23:53 AM
    Author     : Laptop Camilo
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="alreadyAdded[]" value="{}"/>
<!DOCTYPE html>
<%  Map<String,String> errores = (Map<String,String>) session.getAttribute("errores");
    session.removeAttribute("errores");
%>
<html>
    <head>
        <link rel="stylesheet" href="/Proyectov1/css/polizas.css"/>
        <%@ include file = "../../../Head.jsp"%>
        <title> Poliza </title>
    </head>
    <body>
        <%@ include file = "../../../Header.jsp"%>
        <div class = "cuerpo">
            <form class = "cuerpo-form" action="./presentation/cliente/polizas/misPolizas/agregar" method="POST">
                <h1 class = "cuerpo-form__titulo"> Póliza </h1>

                <i class="fas fa-hashtag cuerpo-form__icon cuerpo-form__item"></i>
                <input class = "cuerpo-form__input cuerpo-form__item" autocomplete="off" type = "text" id = "id" placeholder="Ingrese la Placa" name="placa" required>    
                <i class="fas fa-car cuerpo-form__icon cuerpo-form__item"></i>
                <select class="cuerpo-form__item cuerpo-form__input" id = "marca" name="modelo">
                    <option value="" disabled selected>Seleccione un modelo</option>
                    <c:forEach var="marca" items="${marcas}">
                        <optgroup label = "${marca}">
                            <c:forEach var="modelo" items="${modelos}">
                                <c:set var="opcion" value="${modelo.getModelo()}"/>
                                <c:if test="${!selectOptions.contains(opcion)}">
                                    <c:if test="${modelo.getMarca() eq marca}">
                                        <option value="${modelo.getModelo()}:${modelo.getMarca()}:${modelo.getAnio()}" > ${modelo.getMarca()} ${modelo.getModelo()} </option>
                                        <c:set var="selectOptions" value="${selectOptions},${opcion}"/>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </optgroup>
                    </c:forEach>
                </select>
                <i class="fas fa-calendar cuerpo-form__icon cuerpo-form__item"></i>
                <input type="number" min="1990" max="2023" class ="cuerpo-form__item cuerpo-form__input" name="anio" placeholder="Escriba el año del vehiculo" required>
                

                <i class="fas fa-dollar-sign cuerpo-form__icon cuerpo-form__item"></i>
                <input class = "cuerpo-form__input cuerpo-form__item" autocomplete="off" type = "text" id = "valor" placeholder="Ingrese el Valor" name="valor" required>
                
                <div class = "cuerpo-form__item cuerpo-form__radio">
                    <i class="fas fa-credit-card cuerpo-form__icon cuerpo-form__item" id="iconCheck"></i>
                    <label class="cuerpo-form__label cuerpo-form__item radio">
                        <input type="radio" name="opcion" value="trimestral" required>
                        <span class="checkmark">Trimestral</span>
                    </label>
                    <label class="cuerpo-form__label cuerpo-form__item radio">
                        <input type="radio" name="opcion" value="semestral" required>
                        <span class="checkmark">Semestral</span>
                    </label>
                    <label class="cuerpo-form__label cuerpo-form__item radio">
                        <input type="radio" name="opcion" value="anual" required>
                        <span class="checkmark">Anual</span>
                    </label>
                </div>
                <input class = "cuerpo-form__Submit" type="submit" value="Siguiente">
            </form>
            <div class="errores-container">
                    <div class="error-message <%=erroneo("anio_null",errores)%>"> <%= title("anio_null",errores)%></div>
                    <div class="error-message <%=erroneo("placa",errores)%>"> <%= title("placa",errores)%></div>
                    
            </div>
        </div>
        <%@ include file = "../../../Footer.jsp" %>
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
