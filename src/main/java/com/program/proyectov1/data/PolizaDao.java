package com.program.proyectov1.data;

import com.program.proyectov1.logic.Poliza;
import jakarta.resource.cci.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PolizaDao {
    
    // ----------------------------------------------
    
    private DataBase db;
    
    public PolizaDao(DataBase db) {
        this.db = db;
    }
    
    // Métodos
    
    public List<Poliza> polizas(String cliente) throws Exception{
        String comando = "SELECT * FROM polizas where asegurado = ?";
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, cliente);
        java.sql.ResultSet rs = db.executeQuery(stm);
        List<Poliza> polizas = new ArrayList<>();
        while (rs.next()) {
            //String modelo = rs.getString("modelo");
            //Poliza poliza = "";
           // clientes.add(cliente);
        }
        return polizas;
    }
    
    public void create(Poliza u) throws Exception {
        //El codigo es la cedula del asegurado+placa o sea 111999
        String comando = "Insert into polizas values(?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, u.getCodigo());
        stm.setString(2, u.getVehiculo().getIdPropietario());
        stm.setString(3, u.getVehiculo().getNumPlaca());
        stm.setString(4, Double.toString(u.getValorSeguro()));
        stm.setString(5, u.getPlazoPagos());
        stm.setString(6, u.getFechaInicioVigencia());


        db.executeUpdate(stm);

    }

    public Poliza read(String id) throws Exception {
        return new Poliza();
    } 
    
    public void update(Poliza u) throws Exception {
        
    }
    
    public void delete(Poliza u) throws Exception {
    
    }
    
    public Poliza from(ResultSet rs, String alias) throws Exception {
        return new Poliza();
    }
}
