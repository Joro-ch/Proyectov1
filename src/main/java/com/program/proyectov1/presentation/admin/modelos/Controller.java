/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.program.proyectov1.presentation.admin.modelos;

import com.program.proyectov1.logic.Modelo;
import com.program.proyectov1.presentation.admin.modelos.Model;
import com.program.proyectov1.logic.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Laptop Camilo
 */
@WebServlet(name = "Controller", urlPatterns = {"/presentation/admin/modelos/show","/presentation/admin/modelos/agregar","/presentation/admin/modelos/agregar/new"})
@MultipartConfig
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setAttribute("model", new Model());
            RecuperarModelos(request);
            String viewUrl="";
            switch(request.getServletPath()){
                case "/presentation/admin/modelos/show":
                    viewUrl=this.show(request);
                break;
                case "/presentation/admin/modelos/agregar":
                    viewUrl="/presentation/admin/modelos/agregar/View.jsp";
                break;
                case "/presentation/admin/modelos/agregar/new":
                    String result = this.addModelo(request);
                    if (result.equals("success")) {
                        response.sendRedirect(request.getContextPath() + "/presentation/admin/modelos/show");
                        return;
                    } else {
                        viewUrl = result;
                        request.getRequestDispatcher(viewUrl).forward(request, response);
                    }
                break;
                
        }
            request.getRequestDispatcher(viewUrl).forward( request, response); 
        }
    }
    
    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        model.setModelos(new ArrayList<>());
        return "/presentation/admin/modelos/View.jsp"; 
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
    
    public void updateModel(HttpServletRequest request){
        Model model= (Model) request.getAttribute("model");
        model.setModelos((List<Modelo>) request.getAttribute("modelos"));
        System.out.println(model.getModelos().get(0).getModelo());
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

    private String addModelo(HttpServletRequest request) {
        Map<String,String> errores = this.validar(request);
        try{
            if(errores.isEmpty()){
               this.updateModelNew(request);
               return this.addModeloActions(request);
            }else{
                request.setAttribute("errores", errores);//.Si hay errores, o sea que hay campos vacios entonces hay que devolver los errores.
                return "/presentation/admin/modelos/agregar/View.jsp";
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return "/presentation/Error.jsp"; 
        }
    }
    
    private String addModeloActions(HttpServletRequest request) {
        Model model = (Model)request.getAttribute("model");
        Service service = Service.instance();
        try{
            service.ModeloAdd(model.getCurrent());
            return "success"; 
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return "/presentation/Error.jsp"; 
        }
    }
    private Map<String,String> validar(HttpServletRequest request){
        Map<String, String> errores = new HashMap<>();
        try{
        if (request.getParameter("marca").isEmpty()){//Si est[a vacia
            errores.put("marca","marca requerida");
        }

        if (request.getParameter("modelo").isEmpty()){
            errores.put("modelo","modelo requerida");
        }
        if (request.getParameter("anio").isEmpty()){
            errores.put("anio","anio requerida");
        }
        if (request.getPart("imagen").getSize()<0 || request.getPart("imagen")== null){
            errores.put("imagen","modelo requerida");
        }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return errores;
    }

    private void updateModelNew(HttpServletRequest request) {
        Model model = (Model)request.getAttribute("model");
        try{
          model.getCurrent().setMarca(request.getParameter("marca"));
          model.getCurrent().setModelo(request.getParameter("modelo"));
          model.getCurrent().setAnio(request.getParameter("anio"));
          model.getCurrent().setImagen(this.imagenToByte((Part)request.getPart("imagen")));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private byte[] imagenToByte(Part part) throws Exception{
            try (InputStream inputStream = part.getInputStream()) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
            return outputStream.toByteArray();
        }
    }

    
}
