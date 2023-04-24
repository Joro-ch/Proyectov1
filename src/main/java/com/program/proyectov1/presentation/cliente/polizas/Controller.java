package com.program.proyectov1.presentation.cliente.polizas;

import com.program.proyectov1.logic.*;
import jakarta.servlet.ServletException;
import com.program.proyectov1.presentation.cliente.polizas.Model;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PolizasController", urlPatterns = {"/presentation/cliente/polizas/nuevaPoliza/show" , "/presentation/cliente/polizas/misPolizas/show",
"/presentation/cliente/poliza/agregar","/presentation/cliente/polizas/misPolizas/agregar","/presentation/cliente/polizas/misPolizas/agregar/part2",
"/presentation/cliente/polizas/misPolizas/agregar/part2/submit","/presentation/cliente/polizas/misPolizas/agregar/final",
"/presentation/cliente/polizas/misPolizas/agregar/final/submit","/presentation/cliente/polizas/misPolizas/datos"})
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
                    if(viewUrl == "success"){
                        response.sendRedirect(request.getContextPath()+"/presentation/cliente/polizas/misPolizas/agregar/part2");
                        return;
                    }else if(viewUrl == "error"){
                        response.sendRedirect(request.getContextPath()+"/presentation/cliente/polizas/nuevaPoliza/show");
                        return;
                    }
                    break;
                case "/presentation/cliente/polizas/misPolizas/agregar/part2":
                    HttpSession session = request.getSession(true);
                    if(session.getAttribute("poliza")==null){
                        response.sendRedirect(request.getContextPath()+"/presentation/cliente/polizas/nuevaPoliza/show");//Si no existe una poliza iniciada, lo envia al inicio.
                        return;
                    }
                    viewUrl = this.showPart2(request);
                    break;
                case "/presentation/cliente/polizas/misPolizas/agregar/part2/submit":
                    session = request.getSession(true);
                    if(session.getAttribute("poliza")==null){
                        response.sendRedirect(request.getContextPath()+"/presentation/cliente/polizas/nuevaPoliza/show");//Si no existe una poliza iniciada, lo envia al inicio.
                        return;
                    }
                    viewUrl = this.addCoberturas(request);
                    if(viewUrl =="success"){
                        response.sendRedirect(request.getContextPath()+"/presentation/cliente/polizas/misPolizas/agregar/final");
                        return;
                    }
                    break;
                case "/presentation/cliente/polizas/misPolizas/agregar/final":
                    session = request.getSession(true);
                    if(session.getAttribute("poliza")==null){
                        response.sendRedirect(request.getContextPath()+"/presentation/cliente/polizas/nuevaPoliza/show");//Si no existe una poliza iniciada, lo envia al inicio.
                        return;
                    }
                    viewUrl = this.selectMetododePago(request);
                    break;
                case "/presentation/cliente/polizas/misPolizas/agregar/final/submit":
                    viewUrl = this.guardaPoliza(request);
                    if(viewUrl == "success"){
                        response.sendRedirect(request.getContextPath()+"/presentation/cliente/polizas/misPolizas/show");//Si no existe una poliza iniciada, lo envia al inicio.
                        return;
                    }
                    break;
                case "/presentation/cliente/polizas/misPolizas/datos":
                    viewUrl = this.showDatosPoliza(request);
                    break;
            }
            request.getRequestDispatcher(viewUrl).forward( request, response); 
        }
    }

    private String selectMetododePago(HttpServletRequest request) {
        //Este metodo realmente solo simula la seleccion del metodo de pago, además de esto va a mostrar lo que se va a pagar.
        return "/presentation/cliente/polizas/nuevaPoliza/metodoDePago/View.jsp";
    }

    private String addCoberturas(HttpServletRequest request) {
        //Validacion de que se elija 1 como minimo.
        Model model = (Model)request.getAttribute("model");
        Map<String,String> errores = this.validaCoberturas(request);
        if(errores.isEmpty()){
            this.RecuperarCoberturas(request);
            HttpSession session = request.getSession(true);
            Poliza poliza = (Poliza) session.getAttribute("poliza");
            String [] coberturasSeleccionadas = request.getParameterValues("coberturas");
            for(String sC:coberturasSeleccionadas){
                for (Cobertura c:
                        model.getCoberturas()) {
                    if(c.getId().equals(sC)){
                        poliza.getCoberturas().add(c);
                        break;
                    }
                }
            }
            poliza.precioTotal();
            return "success";
        }else{
            return "/presentation/cliente/polizas/nuevaPoliza/coberturas/View.jsp";
        }
    }

    private Map<String,String> validaCoberturas(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        String[] coberturasSeleccionadas = request.getParameterValues("coberturas");
        if(coberturasSeleccionadas == null || coberturasSeleccionadas.length == 0){
            errores.put("coberturas", "Debe seleccionar al menos una cobertura");
        }
        return errores;
    }
    private String showPart2(HttpServletRequest request) {
        Model model = (Model)request.getAttribute("model");
        Service service = Service.instance();
        try{
            model.setCoberturas(service.getCoberturas());
            return "/presentation/cliente/polizas/nuevaPoliza/coberturas/View.jsp";
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return "/presentation/Error.jsp";
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
        this.RecuperarPolizasCliente(request);
        return "/presentation/cliente/polizas/misPolizas/View.jsp"; 
    }  
    
    public String showDatosPoliza(HttpServletRequest request){
        return showDatosPolizaAction(request);
    }
    
    public String showDatosPolizaAction(HttpServletRequest request){
        this.RecuperarPolizaCliente(request);
        return "/presentation/cliente/polizas/misPolizas/datosPoliza/View.jsp"; 
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
    public void RecuperarCoberturas(HttpServletRequest request){
        Service service = Service.instance();
        Model model= (Model) request.getAttribute("model");
        try {
            model.setCoberturas(service.getCoberturas());
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
    
    public void RecuperarPolizasCliente(HttpServletRequest request){
      Service service = Service.instance();
      HttpSession session = request.getSession(true);
      Model model= (Model) request.getAttribute("model");
      model.setCurrent((Usuario)session.getAttribute("usuario"));
      try {
          model.setPolizas(service.polizasCliente((String)model.getCurrent().getId()));
          request.setAttribute("polizas", model.getPolizas());
      }catch (Exception ex) {
      } 
    }
    public void RecuperarPolizaCliente(HttpServletRequest request){
      Service service = Service.instance();
      Model model= (Model) request.getAttribute("model");
      try {
          model.setPoliza(service.polizaFind(request.getParameter("poliza")));
          request.setAttribute("poliza", model.getPoliza());
      }catch (Exception ex) {
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
         try{
            if(errores.isEmpty()){
                
                this.updateModelVehiculo(request);
                return this.addNewVehiculoActions(request);
            }else{
                request.getSession().setAttribute("errores", errores);
                return "error";
            } 
         }catch(Exception ex){
             
             System.out.println(ex.getMessage());
             return "/presentation/Error.jsp";
         }
         
    }

    private Map<String, String> validaFormVehiculos(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        Map<String, String> errores = new HashMap<>();
        if(request.getParameter("placa").isBlank()){
            errores.put("placa","Debe de ingresar la placa");
        }else if(this.validaPlaca(request)){
            errores.put("placa", "Placa existente");
        }
       
        if(request.getParameter("modelo").isBlank()){
            errores.put("modelo","Debe de ingresar el modelo");
        }
    
        if(request.getParameter("anio").isBlank()){
            errores.put("anio","Debe de ingresar el anio");
        }else if(this.validaAnio(request)){
            this.RecuperarModelos(request);
            String anios ="Los anios disponibles para ese modelo son: ";
            String valores = request.getParameter("modelo");
            System.out.println(valores);
            String[] valoresArreglo = valores.split(":");
            String modelo = valoresArreglo[0];
            String marca = valoresArreglo[1];
            String anio = valoresArreglo[2];
            System.out.println(modelo);
            for(Modelo m: model.getModelos()){
                if(m.getModelo().equals(modelo)){
                    anios = anios + m.getAnio() + " ";
                }
            }
            errores.put("anio_null", anios);
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
            System.out.println("Entra a hacer update al vehiculo");
            HttpSession session = request.getSession(true);
            Service service = Service.instance();
            Model model = (Model) request.getAttribute("model");
            model.getVehiculo().setNumPlaca(request.getParameter("placa"));
            model.getVehiculo().setAnio(request.getParameter("anio"));
            Usuario user = (Usuario)session.getAttribute("usuario");
            model.getVehiculo().setIdPropietario(user.getId());;
            model.getVehiculo().setValor(Double.parseDouble(request.getParameter("valor")));
            String valores = request.getParameter("modelo");
            String[] valoresArreglo = valores.split(":");
            String modelo = valoresArreglo[0];
            String marca = valoresArreglo[1];
            String anio = valoresArreglo[2];
           
            Modelo m = service.getModelo(modelo, anio);
            
            
            model.getVehiculo().setModelo(m);
            

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private String addNewVehiculoActions(HttpServletRequest request) {
        try{
            Model model = (Model)request.getAttribute("model");
            Poliza poliza = new Poliza();
            poliza.setCodigo(model.getVehiculo().getNumPlaca()+model.getVehiculo().getIdPropietario());
            poliza.setPlazoPagos(request.getParameter("opcion"));
            poliza.setVehiculo(model.getVehiculo());
            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaComoString = fechaActual.format(formatoFecha);
            poliza.setFechaInicioVigencia(fechaComoString);
            HttpSession session = request.getSession(true);
            session.setAttribute("poliza",poliza);
            return "success";
        }catch (Exception ex){
            ex.getMessage();
            return "/presentation/Error.jsp";
        }
    }

    private Boolean validaPlaca(HttpServletRequest request) {
            
            Service service = Service.instance();
            try{
                
                Vehiculo vehiculo = service.checkPlaca(request.getParameter("placa"));
                
                if(vehiculo == null) {
                    
                    return false;
                }else{
                    return true;
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return true;
            }
    }
    private Boolean validaAnio(HttpServletRequest request){
        Service service = Service.instance();
        try{
                String valores = request.getParameter("modelo");
                String[] valoresArreglo = valores.split(":");
                String modelo = valoresArreglo[0];
                Modelo m = service.getModelo(modelo,request.getParameter("anio") );
                
                if(m == null) {
                    return true;
                }else{
                    return false;
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return true;
            }
    }

    private String guardaPoliza(HttpServletRequest request) {
        try{
            Service service = Service.instance();
            HttpSession session = request.getSession(true);
            Poliza poliza = (Poliza)session.getAttribute("poliza");
            
            service.vehiculoAdd(poliza.getVehiculo());
            service.polizaAdd(poliza);
            return "success";
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return "/presentation/Error.jsp";
        }
    }

   

}
