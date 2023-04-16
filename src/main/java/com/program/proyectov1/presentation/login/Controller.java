package com.program.proyectov1.presentation.login;

import com.program.proyectov1.logic.Cliente;
import com.program.proyectov1.logic.Service;
import com.program.proyectov1.logic.Usuario;
import com.program.proyectov1.presentation.login.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginController", urlPatterns = {"/presentation/login/show","/presentation/login/login","/presentation/login/logout", "/presentation/cliente/cuenta/miCuenta"})
public class Controller extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/login/show":
                viewUrl=this.show(request);
                break;
            case "/presentation/login/login":
                viewUrl = this.login(request);
                break;
            case "/presentation/login/logout":
                viewUrl = this.logout(request);
                break;
            case "/presentation/cliente/cuenta/miCuenta":
                viewUrl = "/presentation/cliente/cuenta/miCuenta/View.jsp";
                break;
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
    }
    
    
//  Metodos para el show del login
    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setId("");
        model.getCurrent().setClave("");
        return "/presentation/login/View.jsp"; 
    }  
    
//  Metodos para el login :o
    public String login(HttpServletRequest request){
        try{
            Map<String,String> errores =  this.validar(request);//Revisamos que no hayan errores 
            if(errores.isEmpty()){//Si no hay errores vamos a crear darle a actualizar el model y crear un usuario temporal con los datos del form
                this.updateModel(request);          
                return this.loginAction(request);//Ahora que el model tiene un usuario temporal, vamos a ir a las acciones. 
            }
            else{
                request.setAttribute("errores", errores);//.Si hay errores, o sea que hay campos vacios entonces hay que devolver los errores.
                return "/presentation/login/View.jsp"; 
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";//Si hay un error inesperado se envia a la pagina de error D:             
        }   
    }
    
    public String loginAction(HttpServletRequest request){
        Model model= (Model) request.getAttribute("model"); //Se toma el objeto model creado en el processrequest y que ahora tiene un usuario temp
        Service service = Service.instance();//llamamos a la instancia de service
        HttpSession session = request.getSession(true);//Se crea una sesion, esta se guarda hasta que se hace logout.
        try {
            Usuario real = service.usuarioFind(model.getCurrent().getId(),model.getCurrent().getClave());//Buscamos el usuario con el id y pass igual a los del form
            if(real == null){throw new Exception();}
            //utilizando el temporal.Si existe el usuario seguimos, sino una exepcion.
            session.setAttribute("usuario", real);//A la session le vamos a agregar un atributo con el nombre usuario que va a traer el objeto
            String viewUrl="";
            switch(real.getTipo()){ //Ahora vamos a determinar el tipo
                case 1:
                    model.setCurrentC(service.clienteFind(model.getCurrent()));
                    session.setAttribute("cliente", model.getCurrentC());
                    viewUrl = "/presentation/cliente/cuenta/miCuenta/View.jsp";//Esto es un usuario comun.
                    break;
                case 2:
                    viewUrl="/presentation/admin/dashboard/View.jsp"; //Esto es un admin. 
                    break;             
            }
            return viewUrl;
        } catch (Exception ex) {
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaFld","Usuario o clave incorrectos");
            errores.put("claveFld","Usuario o clave incorrectos");
            return "/presentation/Error.jsp"; 
        }  
    }
//Metodos para el logout
     public String logout(HttpServletRequest request){
        return this.logoutAction(request);
    }
    
    public String logoutAction(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/presentation/login/View.jsp"; 
        //return "/presentation/login/show";
    }
    
//Validacion de los espacios >>:
    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();//Se crea un hashmap con donde se da el error y el mensaje de error.
        if (request.getParameter("id").isEmpty()){//Si est[a vacia
            errores.put("cedulaFld","Cedula requerida");
        }

        if (request.getParameter("pass").isEmpty()){
            errores.put("claveFld","Clave requerida");
        }
        return errores;
    }
    
//Creacion de un usuario momentaneo
    void updateModel(HttpServletRequest request){
       Model model= (Model) request.getAttribute("model");
       model.getCurrent().setId(request.getParameter("id"));
       model.getCurrent().setClave(request.getParameter("pass"));
       //Se creo un usuario temporal para poder seguir con lo necesario
   }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
