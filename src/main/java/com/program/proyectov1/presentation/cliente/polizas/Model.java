package com.program.proyectov1.presentation.cliente.polizas;

import com.program.proyectov1.logic.Cobertura;
import com.program.proyectov1.logic.Modelo;
import com.program.proyectov1.logic.Poliza;
import com.program.proyectov1.logic.Vehiculo;
import java.util.ArrayList;
import java.util.List;


public final class Model {
    private List<Cobertura> coberturas;
    private List<Modelo> modelos;
    private List<String> marcas;
    private Vehiculo vehiculo;
    private Poliza poliza;
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
        setVehiculo(new Vehiculo());
        setPoliza(new Poliza());
        setCoberturas(new ArrayList<>());
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }
}
