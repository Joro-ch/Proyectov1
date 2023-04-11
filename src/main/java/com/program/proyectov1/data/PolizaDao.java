package com.program.proyectov1.data;

import com.program.proyectov1.logic.Poliza;
import jakarta.resource.cci.ResultSet;

public class PolizaDao {
    
    // ----------------------------------------------
    
    private DataBase db;
    
    public PolizaDao(DataBase db) {
        this.db = db;
    }
    
    // Métodos
    
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
