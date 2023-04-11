package com.program.proyectov1.data;

import com.program.proyectov1.logic.Usuario;
import com.program.proyectov1.logic.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VehiculoDao {
        
    // ----------------------------------------------
    
    private DataBase db;
    
    public VehiculoDao(DataBase db) {
        this.db = db;
    }
    
    // Métodos
    
    public void create(Vehiculo v) throws Exception {
        String comando = "insert into vehiculos (numPlaca, idPropietario, modelo, anio) values (?,?,?,?)";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, v.getNumPlaca());
        stm.setString(2, v.getIdPropietario());
        stm.setString(3, v.getModelo());
        stm.setString(4, v.getAnio());
        
        db.executeUpdate(stm);
    }

    public Vehiculo read(String numPlaca) throws Exception {
        String comando = "select * from vehiculos v where v.numPlaca=?";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, numPlaca);
        
        ResultSet rs = db.executeQuery(stm);
        
        if (rs.next()) {
            return from(rs, "v");
        }
        else {
            return null;
        }
    } 
    
    public void update(Vehiculo v) throws Exception {
        String comando = "update vehiculos set idPropietario=?, modelo=?, anio=? where numPlaca=?";
        
        PreparedStatement stm = db.prepareStatement(comando);
      
        stm.setString(1, v.getIdPropietario());
        stm.setString(2, v.getModelo());
        stm.setString(3, v.getAnio());
        stm.setString(4, v.getNumPlaca());
        
        int count = db.executeUpdate(stm);
        
        if (count == 0) {
            throw new Exception("VEHICULO NO ENCONTRADO");
        } 
    }
    
    public void delete(Vehiculo v) throws Exception {
        String comando = "delete from vehiculos where numPlaca=?";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, v.getNumPlaca());
        
        int count = db.executeUpdate(stm);
        
        if(count == 0) {
            throw new Exception("VEHICULO NO ENCONTRADO");
        }
    }
    
    public Vehiculo from(ResultSet rs, String alias) throws Exception {
        Vehiculo v = new Vehiculo();
        
        v.setNumPlaca(rs.getString(alias + ".numPlaca"));
        v.setIdPropietario(rs.getString(alias + ".idPropietario"));
        v.setModelo(rs.getString(alias + ".modelo"));
        v.setAnio(rs.getString(alias + ".anio"));
        
        return v;
    }
}
