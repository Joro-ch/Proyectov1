package com.program.proyectov1.presentation.cliente.polizas;

import com.program.proyectov1.logic.Modelo;
import java.util.ArrayList;
import java.util.List;


public final class Model {
    private List<Modelo> modelos;
    private List<String> marcas;
   
    public Model() {
        this.reset();
    }

    public List<String> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<String> marcas) {
        this.marcas = marcas;
    }
    
    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }
    
    public void reset(){
        setModelos(new ArrayList<>());
        setMarcas(new ArrayList<>());
    }
    
}
