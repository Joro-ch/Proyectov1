package com.program.proyectov1.presentation.cliente.cuenta;

import com.program.proyectov1.logic.Cliente;

public class Model {
    Cliente currentC;

    public Model() {
        this.reset();
    }
    
    public void reset () {
        this.currentC = new Cliente();
    }

    public Cliente getCurrentC() {
        return currentC;
    }

    public void setCurrentC(Cliente currentC) {
        this.currentC = currentC;
    }
}
