package com.program.proyectov1.data;

import com.program.proyectov1.logic.Categoria;
import com.program.proyectov1.logic.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoriaDao {
    
    // ----------------------------------------------
    
    private DataBase db;
    
    public CategoriaDao(DataBase db) {
        this.db = db;
    }
    
    // Métodos
    
    public void create(Categoria c) throws Exception {
        String comando = "insert into categorias (id, descripcion) values (?,?)";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, c.getId());
        stm.setString(2, c.getDescripcion());
        
        db.executeUpdate(stm);
    }

    public Categoria read(String id) throws Exception {
        String comando = "select * from categorias c where c.id=?";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, id);
        
        ResultSet rs = db.executeQuery(stm);
        
        if (rs.next()) {
            return from(rs, "c");
        }
        else {
            return null;
        }
    } 
    
    public void update(Categoria c) throws Exception {
        String comando = "update clientes set descripcion=? where id=?";
        
        PreparedStatement stm = db.prepareStatement(comando);
        
        stm.setString(1, c.getDescripcion());
        stm.setString(2, c.getId());
        
        int count = db.executeUpdate(stm);
        
        if (count == 0) {
            throw new Exception("CATEGORIA NO ENCONTRADO");
        } 
    }
    
    public void delete(Categoria c) throws Exception {
        String comando = "delete from categorias where id=?";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, c.getId());
        
        int count = db.executeUpdate(stm);
        
        if(count == 0) {
            throw new Exception("CATEGORIA NO ENCONTRADO");
        }
    }
    
    public Categoria from(ResultSet rs, String alias) throws Exception {
        Categoria c = new Categoria();
        
        c.setId(rs.getString(alias + ".id"));
        c.setDescripcion(rs.getString(alias + ".descripcion"));
        
        return c;
    }
}
