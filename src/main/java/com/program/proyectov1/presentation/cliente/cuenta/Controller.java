package com.program.proyectov1.presentation.cliente.cuenta;

import com.program.proyectov1.logic.Cliente;
import com.program.proyectov1.logic.MetodoPago;
import com.program.proyectov1.logic.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CuentaController", urlPatterns = {"/presentation/cliente/cuenta/editarCuenta/show", "/presentation/cliente/cuenta/editarCuenta/enviar"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("model", new Model());
        
        String viewUrl = "";
        switch(request.getServletPath()){
            case "/presentation/cliente/cuenta/editarCuenta/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/cliente/cuenta/editarCuenta/enviar":
                viewUrl = this.enviar(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }

    public String show (HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction (HttpServletRequest request) {
        /*
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setId("");
        model.getCurrent().setClave("");
        */
        return "/presentation/cliente/cuenta/editarCuenta/View.jsp";
    }
    
    public String enviar(HttpServletRequest request) {
        try {
            Map<String, String> map = this.validar(request);
            
            if (map.isEmpty()) {
                this.update(request);
                return enviarAction(request);
            }
            else {
                request.setAttribute("ERRORES", map);
            }
        }
        catch(Exception e) {
        }
        return "";
    }
    
    public String enviarAction(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model"); //Se toma el objeto model creado en el processrequest y que ahora tiene un usuario temp
        Service service = Service.instance();//llamamos a la instancia de service
        HttpSession session = request.getSession(true);//Se crea una sesion, esta se guarda hasta que se hace logout.
        try {
            Cliente cliente = new Cliente();
            
            cliente.setId(model.getCurrentC().getId());
            cliente.setClave(model.getCurrentC().getClave());
            cliente.setNombre(model.getCurrentC().getNombre());
            cliente.setTelefono(model.getCurrentC().getTelefono());
            cliente.setCorreo(model.getCurrentC().getCorreo());
            cliente.setTarjeta(model.getCurrentC().getTarjeta());
            
            MetodoPago mp = model.getCurrentC().getTarjeta();
            service.tarjetaUpdate(mp);
            
            service.clienteUpdate(model.getCurrentC()); 
            
            session.setAttribute("cliente", cliente);
            
            return "/presentation/cliente/cuenta/miCuenta";
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
        
        model.getCurrentC().setId(request.getParameter("id"));
        model.getCurrentC().setClave(request.getParameter("clave"));
        model.getCurrentC().setTipo(1);
        model.getCurrentC().setNombre(request.getParameter("nombre"));
        model.getCurrentC().setTelefono(request.getParameter("telefono"));
        model.getCurrentC().setCorreo(request.getParameter("correo"));
        
        MetodoPago mp = new MetodoPago();
        
        mp.setTitular(request.getParameter("titular"));
        mp.setNumTarjeta(request.getParameter("numTarjeta"));
        mp.setFechaExp(request.getParameter("fechaExp"));
        mp.setCodigoSeguridad(request.getParameter("codigoSeguridad"));
        
        model.getCurrentC().setTarjeta(mp);
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
