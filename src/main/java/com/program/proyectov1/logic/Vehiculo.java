package com.program.proyectov1.logic;


public class Vehiculo {
    
    // Atributos
    
    private String numPlaca;
    private String idPropietario;
    private Modelo modelo;
    private String anio;
    private Integer valor;
    // Métodos

    public Vehiculo() {
        this.numPlaca = "";
        this.idPropietario = "";
        this.modelo = new Modelo();
        this.anio = "";
        this.valor = 0;
    }
    
    public Vehiculo(String numPlaca, String idPropietario, Modelo modelo, String anio, Integer valor) {
        this.numPlaca = numPlaca;
        this.idPropietario = idPropietario;
        this.modelo = modelo;
        this.anio = anio;
        this.valor = valor;
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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
