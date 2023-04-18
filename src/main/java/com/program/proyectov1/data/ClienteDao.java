package com.program.proyectov1.data;

import com.program.proyectov1.logic.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDao {
    
    // ----------------------------------------------
    
    private DataBase db;
    
    public ClienteDao(DataBase db) {
        this.db = db;
    }
    
    // Métodos
    
    public void create(Cliente c) throws Exception {
        String comando = "insert into clientes (usuario, nombre, telefono, correo, metodoPago) values (?,?,?,?,?)";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, c.getId());
        stm.setString(2, c.getNombre());
        stm.setString(3, c.getTelefono());
        stm.setString(4, c.getCorreo());
        stm.setString(5, c.getTarjeta().getNumTarjeta());
        
        db.executeUpdate(stm);
    }

    public Cliente read(String id) throws Exception {
        String comando = "select * from clientes c where c.usuario=?";
        
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
    
    public void update(Cliente c) throws Exception {
        String comando = "update clientes set nombre=?, telefono=?, correo=? where usuario=?";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, c.getNombre());
        stm.setString(2, c.getTelefono());
        stm.setString(3, c.getCorreo());
        stm.setString(4, c.getId());
        
        int count = db.executeUpdate(stm);
        
        if (count == 0) {
            throw new Exception("CLIENTE NO ENCONTRADO");
        } 
    }
    
    public void delete(Cliente c) throws Exception {
        String comando = "delete from clientes where usuario=?";
        
        PreparedStatement stm = db.prepareStatement(comando);
        stm.setString(1, c.getId());
        
        int count = db.executeUpdate(stm);
        
        if(count == 0) {
            throw new Exception("CLIENTE NO ENCONTRADO");
        }
    }
    
    public Cliente from(ResultSet rs, String alias) throws Exception {
        UsuarioDao u = new UsuarioDao(db);
        MetodoPagoDao m = new MetodoPagoDao(db);
        Cliente c = new Cliente();
        
        c.setId(rs.getString(alias + ".usuario"));
        c.setClave(u.read(c.getId()).getClave());
        c.setNombre(rs.getString(alias + ".nombre"));
        c.setTelefono(rs.getString(alias + ".telefono"));
        c.setCorreo(rs.getString(alias + ".correo"));
        c.setTarjeta(m.read(rs.getString(alias + ".metodoPago")));
        
        return c;
    }
    
}
