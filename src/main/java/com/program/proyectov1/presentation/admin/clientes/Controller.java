/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.program.proyectov1.presentation.admin.clientes;

import com.program.proyectov1.logic.Service;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Laptop Camilo
 */
@WebServlet(name = "ClientesController", urlPatterns = {"/presentation/admin/clientes/show", "/presentation/admin/clientes/polizas"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("model",new Model());
            String viewUrl = "";
            switch(request.getServletPath()){
                    case "/presentation/admin/clientes/show":
                        viewUrl = this.show(request);
                        break;
                    case "/presentation/admin/clientes/polizas":
                        System.out.println("a;slkdhkf;kajshdf;laksj;dlfasd               "+ request.getParameter("id"));
                        viewUrl = "/presentation/admin/clientes/polizasCliente/View.jsp";
                        break;
            }
            request.getRequestDispatcher(viewUrl).forward( request, response);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        this.RecuperarClientes(request);
        return "/presentation/admin/clientes/listaClientes/View.jsp"; 
    }
    
    public void RecuperarClientes(HttpServletRequest request){
        Service service = Service.instance();
        Model model= (Model) request.getAttribute("model");
        try {
            model.setClientes(service.getClientes());
            request.setAttribute("clientes", model.getClientes());
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
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
