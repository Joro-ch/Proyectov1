package com.program.proyectov1.presentation.admin.categorias;

import com.program.proyectov1.logic.Categoria;
import com.program.proyectov1.logic.Cobertura;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Categoria> categorias;
    List<Cobertura> coberturas;
    Categoria currentCat;
    Cobertura currentCob;

    public Model() {
        this.reset();
    }
    
    public void reset() {
        this.setCategorias(new ArrayList<Categoria>());
        this.setCoberturas(new ArrayList<Cobertura>());
        this.setCurrentCat(new Categoria());
        this.setCurrentCob(new Cobertura());
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

    public Cobertura getCurrentCob() {
        return currentCob;
    }

    public void setCurrentCob(Cobertura currentCob) {
        this.currentCob = currentCob;
    }
    
    public Categoria getCategoria(String id) {
        Categoria cat;
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId().equals(id)) {
                cat = categorias.get(i);
                currentCat = cat;
                return cat;
            }
        }
        return null;
    }
    
}
