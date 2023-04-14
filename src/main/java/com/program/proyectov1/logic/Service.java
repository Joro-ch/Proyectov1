package com.program.proyectov1.logic;

import com.program.proyectov1.data.ClienteDao;
import com.program.proyectov1.data.DataBase;
import com.program.proyectov1.data.MetodoPagoDao;
import com.program.proyectov1.data.UsuarioDao;
import com.program.proyectov1.data.ModeloDao;
import java.util.List;

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
    MetodoPagoDao mpDao;
    ModeloDao moDao;
    private Service(){
        Database = new DataBase();
        usuarioDao = new UsuarioDao(Database);
        clienteDao = new ClienteDao(Database);
        mpDao = new MetodoPagoDao(Database);
        moDao = new ModeloDao(Database);
        
    }

    public Usuario usuarioFind(String cedula,String clave) throws Exception{
        if (clave.equals(usuarioDao.read(cedula).getClave())){
            return usuarioDao.read(cedula);
        }
        return null;
        // Falta verificar clave
    }
    
    public void usuarioAdd(Usuario usuario) throws Exception {
       usuarioDao.create(usuario);
    }

    public Cliente clienteFind(Usuario usuario) throws Exception{
        return clienteDao.read(usuario.getId());
    }
    
    public void clienteAdd(Cliente cliente) throws Exception {
       clienteDao.create(cliente);
    }

    public void clienteUpdate(Cliente cliente) throws Exception{
        clienteDao.update(cliente);
    } 

    public void tarjetaAdd(MetodoPago mp) throws Exception {
        mpDao.create(mp);
    }
    
    public List<Modelo> getModelos() throws Exception{
        return moDao.modelos();
    }
    
    public void ModeloAdd(Modelo modelo) throws Exception{
        moDao.create(modelo);
    }
}

