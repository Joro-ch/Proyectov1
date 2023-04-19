package com.program.proyectov1.presentation.cliente.polizas;

import com.program.proyectov1.logic.Service;
import jakarta.servlet.ServletException;
import com.program.proyectov1.presentation.cliente.polizas.Model;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PolizasController", urlPatterns = {"/presentation/cliente/polizas/nuevaPoliza/show" , "/presentation/cliente/polizas/misPolizas/show"})
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

}
