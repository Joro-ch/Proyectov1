package com.program.proyectov1.data;

import com.program.proyectov1.logic.Cobertura;
import com.program.proyectov1.logic.Poliza;
import com.program.proyectov1.logic.Service;
import com.program.proyectov1.logic.Vehiculo;
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
        Service service = Service.instance();
        String comando = "SELECT * FROM polizas where asegurado = ?";
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, cliente);
        java.sql.ResultSet rs = db.executeQuery(stm);
        List<Poliza> polizas = new ArrayList<>();
        while (rs.next()) {
            String codigo = rs.getString("codigo");
            Integer valorSeguro = rs.getInt("valorSeguro");
            Vehiculo vehiculo = service.vehiculoFind(rs.getString("placaVehiculo"));
            String plazoPagos = rs.getString("plazoPagos");
            String fechaInicioVigencia = rs.getString("fechaInicioVigencia");
            List<Cobertura> coberturas = service.coberturasPoliza(codigo);
            Poliza polizaTemo = new Poliza(vehiculo,valorSeguro,plazoPagos,fechaInicioVigencia,coberturas);
            polizas.add(polizaTemo);
        }
        return polizas;
    }
    
    
    
    public void create(Poliza u) throws Exception {
        
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
