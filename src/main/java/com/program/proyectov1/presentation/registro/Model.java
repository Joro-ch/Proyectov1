
package com.program.proyectov1.presentation.registro;

import com.program.proyectov1.logic.Usuario;


public class Model {
    Usuario current;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Usuario());        
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }
}
