package com.program.proyectov1.presentation.admin.categorias;

import com.program.proyectov1.logic.Categoria;
import com.program.proyectov1.logic.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CategoriasController", urlPatterns = {"/presentation/admin/categorias/show", "/presentation/admin/categorias/agregar/show", "/presentation/admin/categorias/agregar"})
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
            case "/presentation/admin/categorias/agregar/show":
                viewUrl = this.agregarShow(request);
                break;
            case "/presentation/admin/categorias/agregar":
                viewUrl = this.agregar(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }
    
    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
 
        try {        
            model.setCategorias(service.getCategorias());
            return "/presentation/admin/categorias/View.jsp"; 
        } catch (Exception ex) {
            return "";
        }
    } 
    
    public String agregarShow(HttpServletRequest request){
        return this.agregarShowAction(request);
    }
        
    public String agregarShowAction(HttpServletRequest request) {
        return "/presentation/admin/categorias/agregar/View.jsp";
    } 
    
    public String agregar(HttpServletRequest request) {
        try {
            Map<String, String> map = this.validar(request);
            
            if (map.isEmpty()) {
                this.update(request);
                return agregarAction(request);
            }
            else {
                request.setAttribute("ERRORES", map);
            }
        }
        catch(Exception e) {
        }
        return "";
    }
    
    public String agregarAction(HttpServletRequest request) {
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
    
    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();//Se crea un hashmap con donde se da el error y el mensaje de error.
        if (request.getParameter("descripcion").isEmpty()){//Si est[a vacia
            errores.put("ERROR DESCRIPCION","DESCRIPCION REQUERIDA");
        }
        return errores;
    }
    
    public void update(HttpServletRequest request) {
        Model model = (Model)request.getAttribute("model");
        
        Categoria c = model.getCurrentCat();
        
        c.setDescripcion(request.getParameter("descripcion"));
        
        model.getCategorias().add(c);
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
