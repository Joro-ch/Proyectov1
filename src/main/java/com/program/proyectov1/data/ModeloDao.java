package com.program.proyectov1.data;

import jakarta.resource.cci.ResultSet;
import java.sql.PreparedStatement;
import com.program.proyectov1.logic.Modelo;
import java.util.ArrayList;
import java.util.List;

public class ModeloDao {
        
    // ----------------------------------------------
    
    private DataBase db;
    
    public ModeloDao(DataBase db) {
        this.db = db;
    }
    
    // Métodos
    
    public void create(Modelo m) throws Exception {
        String comando = "insert into metodosDePago (modelo,anio,marca,imagen) values (?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, m.getModelo());
        stm.setString(2, m.getAnio());
        stm.setString(3, m.getMarca());
        stm.setString(4, m.getImagen());
        
        db.executeUpdate(stm);
    }

    public String read(String modelo, String anio) throws Exception {
        String comando = "select * from modelos m where m.modelo=? and anio=?";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, modelo);
        stm.setString(2,anio);
        
        ResultSet rs = (ResultSet) db.executeQuery(stm);
        
        if (rs.next()) {
            return from(rs, "m");
        }
        else {
            return null;
        }
    } 
    
    public List<Modelo> modelos() throws Exception{
        String comando = "select * from modelos";
        PreparedStatement stm = db.prepareStatement(comando);
        java.sql.ResultSet rs = stm.executeQuery();
        List<Modelo> modelos = new ArrayList<>();
        while(rs.next()){
            String modelo = rs.getString("modelo");
            String anio = rs.getString("anio");
            String marca = rs.getString("marca");
            String imagen = rs.getString("imagen");
            
            Modelo modeloTemp = new Modelo(modelo,anio,marca,imagen);
            modelos.add(modeloTemp);
        }
        return modelos; 
    }
    
    public void update(String u) throws Exception {
        
    }
    
    public void delete(String u) throws Exception {
    
    }
    
    public String from(ResultSet rs, String alias) throws Exception {
        return new String();
    }
}
