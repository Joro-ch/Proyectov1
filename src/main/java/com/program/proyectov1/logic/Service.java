package com.program.proyectov1.logic;

import com.program.proyectov1.data.CategoriaDao;
import com.program.proyectov1.data.ClienteDao;
import com.program.proyectov1.data.CoberturaDao;
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
    CategoriaDao caDao;
    CoberturaDao coDao;
    
    private Service(){
        Database = new DataBase();
        usuarioDao = new UsuarioDao(Database);
        clienteDao = new ClienteDao(Database);
        mpDao = new MetodoPagoDao(Database);
        moDao = new ModeloDao(Database);
        caDao = new CategoriaDao(Database);
        coDao = new CoberturaDao(Database);
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
    
    public void tarjetaUpdate(MetodoPago mp) throws Exception {
        mpDao.update(mp);
    }
    
    public List<Modelo> getModelos() throws Exception {
        return moDao.modelos();
    }
    
    public List<String> getMarcas() throws Exception {
        return moDao.marcas();
    }
    
    public void ModeloAdd(Modelo modelo) throws Exception{
        System.out.println("ENtro al service antes de modelo dao");
        moDao.create(modelo);
    }
    
    public void categoriaAdd(Categoria c) throws Exception {
        caDao.create(c);
    }
    
    public Categoria categoriaFind(String id) throws Exception {
        return caDao.read(id);
    }
    
    public List<Categoria> getCategorias() throws Exception {
        return caDao.categorias();
    }
    
    public void coberturaAdd(Cobertura c) throws Exception {
        coDao.create(c);
    }
    
    public Cobertura coberturaFind(String id) throws Exception {
        return coDao.read(id);
    }
    
    public List<Cobertura> getCoberturas() throws Exception {
        return coDao.coberturas();
    }
    
    public Modelo getModelo() throws Exception{
        return null;
    }
    
}

