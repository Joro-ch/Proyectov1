package com.program.proyectov1.logic;

import com.program.proyectov1.data.ClienteDao;
import com.program.proyectov1.data.DataBase;
import com.program.proyectov1.data.UsuarioDao;

public class Service {
    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance; 
    }
    DataBase Database;
    UsuarioDao usuarioDao;
    ClienteDao clienteDao;
    
    private Service(){
        Database = new DataBase();
        usuarioDao = new UsuarioDao(Database);
        clienteDao = new ClienteDao(Database);
    }

    public Usuario usuarioFind(String cedula,String clave) throws Exception{
        return usuarioDao.read(cedula);
        // Falta verificar clave
    }

    public Cliente clienteFind(Usuario usuario) throws Exception{
        return clienteDao.read(usuario.getId());
    }

    public void clienteUpdate(Cliente cliente) throws Exception{
        clienteDao.update(cliente);
    } 
}

