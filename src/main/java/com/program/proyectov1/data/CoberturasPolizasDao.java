package com.program.proyectov1.data;

import com.program.proyectov1.logic.Cobertura;
import jakarta.resource.cci.ResultSet;
import java.sql.PreparedStatement;

public class CoberturasPolizasDao {
    
    // ----------------------------------------------
    
    private DataBase db;
    
    public CoberturasPolizasDao(DataBase db) {
        this.db = db;
    }
    
    // Métodos
    
    public void create(String cId, String pId) throws Exception {
          String comando = "insert into coberturasPolizas (codigoPoliza,idCobertura) values (?,?)";
          PreparedStatement stm = db.prepareStatement(comando);
          stm.setString(1, pId);
          stm.setString(2, cId);
        
        
          db.executeUpdate(stm);
    }

    public Cobertura read(String id) throws Exception {
        return new Cobertura();
    } 
    
    public void update(Cobertura u) throws Exception {
        
    }
    
    public void delete(Cobertura u) throws Exception {
    
    }
    
    public Cobertura from(ResultSet rs, String alias) throws Exception {
        return new Cobertura();
    }
}
