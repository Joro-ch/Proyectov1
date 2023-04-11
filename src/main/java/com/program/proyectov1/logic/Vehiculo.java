package com.program.proyectov1.logic;


public class Vehiculo {
    
    // Atributos
    
    private String numPlaca;
    private String idPropietario;
    private String modelo;
    private String anio;
    
    // Métodos

    public Vehiculo() {
        this.numPlaca = "";
        this.idPropietario = "";
        this.modelo = "";
        this.anio = "";
    }
    
    public Vehiculo(String numPlaca, String idPropietario, String modelo, String anio) {
        this.numPlaca = numPlaca;
        this.idPropietario = idPropietario;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
}
