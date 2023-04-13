package com.program.proyectov1.presentation.registro;

import com.program.proyectov1.logic.Cliente;
import com.program.proyectov1.logic.MetodoPago;
import com.program.proyectov1.logic.Service;
import com.program.proyectov1.logic.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegistroController", urlPatterns = {"/presentation/registro/show", "/presentation/registro/registrar"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/registro/show":
                viewUrl=this.show(request);
                break;
            case "/presentation/registro/registrar":
                viewUrl = this.registrar(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
    }
    
    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        /*model.getCurrent().setId("");
        model.getCurrent().setClave("");*/
        return "/presentation/registro/View.jsp"; 
    }    
    
    public String registrar(HttpServletRequest request) {
        try {
            Map<String, String> map = this.validar(request);
            
            if (map.isEmpty()) {
                this.update(request);
                return this.registrarAction(request);
            }
            else {
                request.setAttribute("ERRORES", map);
            }
        }
        catch(Exception e) {
        }
        return "";
    }
    
    public String registrarAction(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model"); //Se toma el objeto model creado en el processrequest y que ahora tiene un usuario temp
        Service service = Service.instance();//llamamos a la instancia de service
        
        try {
            Usuario user = new Usuario();
            
            user.setId(model.getCliente().getId());
            user.setClave(model.getCliente().getClave());
            user.setTipo(model.getCliente().getTipo());
            
            service.usuarioAdd(user);
            
            System.out.println("ANTESSSSSSSSSSSSSSSSSSSSS");
            
            service.clienteAdd(model.getCliente()); //Buscamos el usuario con el id y pass igual a los del form
            
            System.out.println("DESPUEEEEEEEEEEEEEEEEEES");
            
            
            System.out.println("SI ENTRO AQUIIIIIIIIIIII");
            
            return "/presentation/login/View.jsp";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "/presentation/Error.jsp"; 
        }  
        
    }
    
    public Map<String,String> validar(HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        
        if (request.getParameter("id").isEmpty()) {
            map.put("ERROR ID", "ES REQUERIDO EL ID");
        }
        else if (request.getParameter("nombre").isEmpty()) {
            map.put("ERROR CLAVE", "ES REQUERIDA LA CLAVE");
        }
        else if (request.getParameter("nombre").isEmpty()) {
            map.put("ERROR NOMBRE", "ES REQUERIDO EL NOMBRE");
        }
        else if (request.getParameter("nombre").isEmpty()) {
            map.put("ERROR TELEFONO", "ES REQUERIDO EL TELEFONO");
        }
        else if (request.getParameter("nombre").isEmpty()) {
            map.put("ERROR CORREO", "ES REQUERIDO EL CORREO");
        }
        else if (request.getParameter("nombre").isEmpty()) {
            map.put("ERROR TITULAR", "ES REQUERIDO EL TITULAR");
        }
        else if (request.getParameter("nombre").isEmpty()) {
            map.put("ERROR NUMERO DE TARJETA", "ES REQUERIDO EL NUMERO DE TARJETA");
        }
        else if (request.getParameter("nombre").isEmpty()) {
            map.put("ERROR FECHA DE EXPIRACION", "ES REQUERIDA LA FECHA DE EXPIRACION");
        }
        else if (request.getParameter("nombre").isEmpty()) {
            map.put("ERROR CVV", "ES REQUERIDO EL CVV");
        }
        
        return map;
    }
    
    public void update(HttpServletRequest request) {
        Model model = (Model)request.getAttribute("model");
        
        model.getCliente().setId(request.getParameter("id"));
        model.getCliente().setClave(request.getParameter("clave"));
        model.getCliente().setTipo(1);
        model.getCliente().setNombre(request.getParameter("nombre"));
        model.getCliente().setTelefono(request.getParameter("telefono"));
        model.getCliente().setCorreo(request.getParameter("correo"));
        
        MetodoPago mp = new MetodoPago();
        
        mp.setTitular(request.getParameter("titular"));
        mp.setIdCliente(request.getParameter("id"));
        mp.setNumTarjeta(request.getParameter("numTarjeta"));
        mp.setFechaExp(request.getParameter("fechaExp"));
        mp.setCodigoSeguridad(request.getParameter("codigoSeguridad"));
        
        model.getCliente().setTarjeta(mp);
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
