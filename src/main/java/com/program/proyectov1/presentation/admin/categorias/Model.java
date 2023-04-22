package com.program.proyectov1.presentation.admin.categorias;

import com.program.proyectov1.logic.Categoria;
import com.program.proyectov1.logic.Cobertura;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Categoria> categorias;
    Categoria currentCat;

    public Model() {
        this.reset();
    }
    
    public void reset() {
        this.setCategorias(new ArrayList<Categoria>());
        this.setCurrentCat(new Categoria());
    }
    
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCurrentCat() {
        return currentCat;
    }

    public void setCurrentCat(Categoria currentCat) {
        this.currentCat = currentCat;
    }
    
    public Categoria getCategoria(String cat) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getDescripcion().equals(cat)) {
                return categorias.get(i);
            }
        }
        return null;
    }
    
}
