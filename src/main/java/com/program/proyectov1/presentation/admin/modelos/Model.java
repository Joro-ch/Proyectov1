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
    private List<String> marcas;
    private Modelo current;
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
        setCurrent(new Modelo());
    }

    public Modelo getCurrent() {
        return current;
    }

    public void setCurrent(Modelo current) {
        this.current = current;
    }
    
}
