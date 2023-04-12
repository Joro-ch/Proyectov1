<%@page import="com.program.proyectov1.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>

<header>
    <nav>
        <div class = "nav-logo">
            <a class = "nav-logo__imagen" href = "/Proyectov1/presentation/index.jsp">  <img src="/Proyectov1/images/logo.png" alt=""> </a>
            <a class = "nav-logo__titulo" href = "/Proyectov1/presentation/index.jsp"> Seguros Infinitos </a>
        </div>
        <% if (usuario != null && usuario.getTipo()==1){ %>
        <div class = "nav-menu">
            <ul class = "nav-menu__Items">
                <li class = "nav-menu__item"> <a href = ""> Opcion1 </a> </li>
                <li class = "nav-menu__item"> <a href = ""> Opcion2 </a> </li>
                <li class = "nav-menu__item"> <a href = ""> Opcion3 </a> </li>
            </ul>
        </div>
        <% } 
           if(usuario != null && usuario.getTipo()==2){ 
        %>
        <div class = "nav-menu">
            <ul class = "nav-menu__Items">
                <li class = "nav-menu__item"> <a href = ""> ADMIN1 </a> </li>
                <li class = "nav-menu__item"> <a href = ""> ADMIN2 </a> </li>
                <li class = "nav-menu__item"> <a href = ""> ADMIN3 </a> </li>
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

