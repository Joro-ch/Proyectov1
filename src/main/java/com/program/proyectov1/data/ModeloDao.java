package com.program.proyectov1.data;

import jakarta.resource.cci.ResultSet;

public class ModeloDao {
        
    // ----------------------------------------------
    
    private DataBase db;
    
    public ModeloDao(DataBase db) {
        this.db = db;
    }
    
    // Métodos
    
    public void create(String u) throws Exception {
        
    }

    public String read(String id) throws Exception {
        return new String();
    } 
    
    public void update(String u) throws Exception {
        
    }
    
    public void delete(String u) throws Exception {
    
    }
    
    public String from(ResultSet rs, String alias) throws Exception {
        return new String();
    }
}
