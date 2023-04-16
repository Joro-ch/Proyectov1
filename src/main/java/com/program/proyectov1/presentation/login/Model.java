package com.program.proyectov1.presentation.login;

import com.program.proyectov1.logic.Cliente;
import com.program.proyectov1.logic.Usuario;

public class Model {
    Usuario current;
    Cliente currentC;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Usuario());  
        setCurrentC(new Cliente());
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

    public Cliente getCurrentC() {
        return currentC;
    }

    public void setCurrentC(Cliente currentC) {
        this.currentC = currentC;
    }
    
}
