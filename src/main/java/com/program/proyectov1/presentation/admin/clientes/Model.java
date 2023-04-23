/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.program.proyectov1.presentation.admin.clientes;

import com.program.proyectov1.logic.Cliente;
import com.program.proyectov1.logic.Modelo;
import com.program.proyectov1.logic.Poliza;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laptop Camilo
 */
public class Model {
    private List<Cliente> clientes;
    private List<Poliza> polizas;
    
    
    public Model() {
        this.reset();
    }

    public List<Poliza> getPolizas() {
        return polizas;
    }

    public void setPolizas(List<Poliza> polizas) {
        this.polizas = polizas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void reset(){
        setClientes(new ArrayList<>());
    }
    
}
