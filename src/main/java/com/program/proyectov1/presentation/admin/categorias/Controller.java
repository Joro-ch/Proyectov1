package com.program.proyectov1.presentation.admin.categorias;

import com.program.proyectov1.logic.Categoria;
import com.program.proyectov1.logic.Cobertura;
import com.program.proyectov1.logic.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CategoriasController", urlPatterns = {"/presentation/admin/categorias/show", 
"/presentation/admin/categorias/agregarCat/show", "/presentation/admin/categorias/agregarCat",
"/presentation/admin/categorias/agregarCob/show", "/presentation/admin/categorias/agregarCob"})

public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("model", new Model());
        String viewUrl = "" ;
        switch(request.getServletPath()){
            case "/presentation/admin/categorias/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/admin/categorias/agregarCat/show":
                viewUrl = this.agregarCatShow(request);
                break;
            case "/presentation/admin/categorias/agregarCat":
                viewUrl = this.agregarCat(request);
                break;
            case "/presentation/admin/categorias/agregarCob/show":
                viewUrl = this.agregarCobShow(request);
                break;
            case "/presentation/admin/categorias/agregarCob":
                viewUrl = this.agregarCob(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }
    
    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(HttpServletRequest request) {
        setearCategorias(request);
        return "/presentation/admin/categorias/View.jsp"; 
    } 
    
    public String agregarCatShow(HttpServletRequest request){
        return this.agregarCatShowAction(request);
    }
        
    public String agregarCatShowAction(HttpServletRequest request) {
        setearCategorias(request);
        return "/presentation/admin/categorias/agregarCat/View.jsp";
    } 
    
    public String agregarCat(HttpServletRequest request) {
        try {
            Map<String, String> map = this.validarCat(request);
            
            if (map.isEmpty()) {
                this.updateCat(request);
                return agregarCatAction(request);
            }
            else {
                request.setAttribute("ERRORES", map);
            }
        }
        catch(Exception e) {
        }
        return "";
    }
    
    public String agregarCatAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model"); //Se toma el objeto model creado en el processrequest y que ahora tiene un usuario temp
        Service service = Service.instance();//llamamos a la instancia de service
        
        try {
            service.categoriaAdd(model.getCurrentCat());
            model.setCategorias(service.getCategorias());
            return "/presentation/admin/categorias/View.jsp";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "/presentation/Error.jsp"; 
        }  
    }
    
    public String agregarCobShow(HttpServletRequest request) {
        return agregarCobShowAction(request);
    } 
    
    public String agregarCobShowAction(HttpServletRequest request) {
        setearCategorias(request);
        return "/presentation/admin/categorias/agregarCob/View.jsp";
    }
    
    public String agregarCob(HttpServletRequest request) {
        try {
            Map<String, String> map = this.validarCob(request);
            
            if (map.isEmpty()) {
                this.updateCob(request);
                return agregarCobAction(request);
            }
            else {
                request.setAttribute("ERRORES", map);
            }
        }
        catch(Exception e) {
        }
        return "";
    }
    
    public String agregarCobAction(HttpServletRequest request) {
        setearCategorias(request);
        return "/presentation/admin/categorias/View.jsp";
    }
    
    Map<String,String> validarCat(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();//Se crea un hashmap con donde se da el error y el mensaje de error.
        if (request.getParameter("descripcion").isEmpty()){//Si est[a vacia
            errores.put("ERROR DESCRIPCION","DESCRIPCION REQUERIDA");
        }
        return errores;
    }
    
    Map<String,String> validarCob(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();//Se crea un hashmap con donde se da el error y el mensaje de error.
        if (request.getParameter("categoria").isEmpty()){//Si est[a vacia
            errores.put("ERROR CATEGORIA","CATEGORIA REQUERIDA");
        }
        if (request.getParameter("descripcion").isEmpty()){//Si est[a vacia
            errores.put("ERROR DESCRIPCION","DESCRIPCION REQUERIDA");
        }
        if (request.getParameter("costo minimo").isEmpty()){//Si est[a vacia
            errores.put("ERROR COSTO MINIMO","COSTO MINIMO REQUERIDO");
        }
        if (request.getParameter("costo porcentual").isEmpty()){//Si est[a vacia
            errores.put("ERROR COSTO PORCENTUAL","COSTO PORCENTUAL REQUERIDO");
        }
        return errores;
    }
    
    public void updateCat(HttpServletRequest request) {
        Model model = (Model)request.getAttribute("model");
        
        Categoria c = model.getCurrentCat();
        
        c.setDescripcion(request.getParameter("descripcion"));
        
        model.getCategorias().add(c);
    }
    
    public void updateCob(HttpServletRequest request) {
        Model model = (Model)request.getAttribute("model");
        Cobertura cob = new Cobertura();
        try {
            Categoria c = model.getCategoria((String) request.getAttribute("descripcion"));
            
            cob.setDescripcion((String) request.getAttribute("descripcion"));
            cob.setCostoMinimo((int) request.getAttribute("costo minimo"));
            cob.setCostoPorcentual((int) request.getAttribute("costo porcentual"));
            cob.setCategoria((int) request.getAttribute("categoria"));
            
            c.getCoberturas().add(cob);
            setearCategorias(request);
        }
        catch(Exception ex) {
        }
    }
    
    public void setearCategorias(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        
        try {
            model.setCategorias(service.getCategorias());
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
