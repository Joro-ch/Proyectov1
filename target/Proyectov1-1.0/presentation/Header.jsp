<%@page import="com.program.proyectov1.logic.Usuario"%>
<% Usuario usuario = (Usuario) session.getAttribute("usuario");  %>

<header>
    <nav>
        <div class = "nav-logo">
            <a class = "nav-logo__imagen" href = "/Proyectov1/Inicio">  <img src="/Proyectov1/images/logo.png" alt=""> </a>
            <a class = "nav-logo__titulo" href = "/Proyectov1/Inicio"> Seguros Infinitos </a>
        </div>
        <% if (usuario != null && usuario.getTipo()==1){ %>
        <div class = "nav-menu">
            <ul class = "nav-menu__Items">
                <li class = "nav-menu__item"> <a href = "presentation/cliente/polizas/nuevaPoliza/show"> Comprar </a> </li>
                <li class = "nav-menu__item"> <a href = "presentation/cliente/polizas/misPolizas/show"> Mis Polizas </a> </li>
                <li class = "nav-menu__item"> <a href = "presentation/cliente/cuenta/miCuenta"> Mi Cuenta </a> </li>
            </ul>
        </div>
        <% } 
           if(usuario != null && usuario.getTipo()==2){ 
        %>
        <div class = "nav-menu">
            <ul class = "nav-menu__Items">
                <li class = "nav-menu__item"> <a href = "presentation/admin/clientes/show"> Listado Clientes y P�lizas </a> </li>
                <li class = "nav-menu__item"> <a href = "presentation/admin/modelos/show"> Modelos y Marcas </a> </li>
                <li class = "nav-menu__item"> <a href = "presentation/admin/categorias/show"> Categorias y Coberturas </a> </li>
            </ul>
        </div>
        <% } 
            if(usuario == null){
        %>
        <div class = "nav-usuario">
            <a href = "presentation/login/show"> <i class = "fas fa-user"></i> Login </a>
        </div>
        <% }else{ %>
        <div class = "nav-usuario">
            <a href = "presentation/login/logout"> <i class = "fas fa-user"></i> Logout from <%=usuario.getId() %> </a>
        </div>
        <% } %>
    </nav>
</header>

