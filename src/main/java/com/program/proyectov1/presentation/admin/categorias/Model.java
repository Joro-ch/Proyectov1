package com.program.proyectov1.presentation.admin.categorias;

import com.program.proyectov1.logic.Categoria;
import com.program.proyectov1.logic.Cobertura;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Categoria> categorias;
    List<Cobertura> coberturas;
    Categoria currentCat;

    public Model() {
        this.reset();
    }
    
    public void reset() {
        this.setCategorias(new ArrayList<Categoria>());
        this.setCoberturas(new ArrayList<Cobertura>());
        this.setCurrentCat(new Categoria());
    }
    
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }

    public Categoria getCurrentCat() {
        return currentCat;
    }

    public void setCurrentCat(Categoria currentCat) {
        this.currentCat = currentCat;
    }
    
}
