package com.program.proyectov1.presentation.cliente.polizas;

import com.program.proyectov1.logic.Modelo;
import com.program.proyectov1.logic.Service;
import com.program.proyectov1.logic.Usuario;
import jakarta.servlet.ServletException;
import com.program.proyectov1.presentation.cliente.polizas.Model;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PolizasController", urlPatterns = {"/presentation/cliente/polizas/nuevaPoliza/show" , "/presentation/cliente/polizas/misPolizas/show",
"/presentation/cliente/poliza/agregar"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setAttribute("model", new Model());
            String viewUrl="";
            switch(request.getServletPath()){
                case "/presentation/cliente/polizas/nuevaPoliza/show":
                    viewUrl = this.showNuevaPoliza(request);
                    break;
                case "/presentation/cliente/polizas/misPolizas/show":
                    viewUrl = this.showMisPolizas(request);
                    break;
                case "/presentation/cliente/polizas/misPolizas/agregar":
                    viewUrl = this.addNewVehiculo(request);
                    break;
            }
            request.getRequestDispatcher(viewUrl).forward( request, response); 
        }
    }
    
//  Metodos para el show de las Polizas del Cliente
    public String showNuevaPoliza(HttpServletRequest request){
        return this.showNuevaPolizaAction(request);
    }
        
    public String showNuevaPolizaAction(HttpServletRequest request){
        this.RecuperarMarcas(request);
        this.RecuperarModelos(request);
        return "/presentation/cliente/polizas/nuevaPoliza/View.jsp"; 
    }  
    
    public String showMisPolizas(HttpServletRequest request){
        return this.showMisPolizasAction(request);
    }
        
    public String showMisPolizasAction(HttpServletRequest request){
        return "/presentation/cliente/polizas/misPolizas/View.jsp"; 
    }  
    
    public void RecuperarMarcas(HttpServletRequest request){
        Service service = Service.instance();
        Model model= (Model) request.getAttribute("model");
        try {
            model.setMarcas(service.getMarcas());
            request.setAttribute("marcas", model.getMarcas());
        } catch (Exception ex) {
        }
        
    }
    
    public void RecuperarModelos(HttpServletRequest request){
        Service service = Service.instance();
        Model model= (Model) request.getAttribute("model");
        try {
            model.setModelos(service.getModelos());
            request.setAttribute("modelos", model.getModelos());
        } catch (Exception ex) {
        }
        
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

    private String addNewVehiculo(HttpServletRequest request) {
         Map<String, String> errores = this.validaFormVehiculos(request);
         if(errores.isEmpty()){
             //this.updateModelVehiculo();
             return this.addNewVehiculoActions(request);
         }else{
             return "/presentation/Error.jsp";
         }
    }

    private Map<String, String> validaFormVehiculos(HttpServletRequest request) {
        
        Map<String, String> errores = new HashMap<>();
        if(request.getParameter("placa").isBlank()){
            errores.put("placa","Debe de ingresar la placa");
        }
        if(request.getParameter("modelo").isBlank()){
            errores.put("modelo","Debe de ingresar el modelo");
        }
        if(request.getParameter("anio").isBlank()){
            errores.put("anio","Debe de ingresar el anio");
        }
        if(request.getParameter("opcion").isBlank()){
            errores.put("opcion","Debe de seleccionar un periodo");
        }
        if(request.getParameter("valor").isBlank()){
            errores.put("valor","Debe de ingresar un valor");
        }
        
        
        
        return errores;
    }

    private void updateModelVehiculo(HttpServletRequest request) {
        try{
            Model model = (Model) request.getAttribute("model");
            HttpSession session = request.getSession(true);
            model.getVehiculo().setNumPlaca(request.getParameter("placa"));
            model.getVehiculo().setAnio(request.getParameter("anio"));
            Usuario user = (Usuario)session.getAttribute("usuario");
            model.getVehiculo().setIdPropietario(user.getId());
            String valores = request.getParameter("modelo");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private String addNewVehiculoActions(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}
