package com.program.proyectov1.presentation.registro;

import com.program.proyectov1.logic.Cliente;


public class Model {
    Cliente cliente;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCliente(new Cliente());        
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
