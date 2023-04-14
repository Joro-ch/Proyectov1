/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.program.proyectov1.presentation.admin.modelos;
import com.program.proyectov1.logic.Modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Laptop Camilo
 */
public class Model {
    private List<Modelo> modelos;

    public Model() {
        this.reset();
    }

    
    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }
    
    public void reset(){
        setModelos(new ArrayList<>());        
    }
}
