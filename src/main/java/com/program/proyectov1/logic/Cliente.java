package com.program.proyectov1.logic;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    
    // Atributos
    private String nombre;
    private String telefono;
    private String correo;
    private MetodoPago tarjeta;
    private List<Poliza> polizas;
    
    // Métodos

    public Cliente() {
        this.nombre = "";
        this.telefono = "";
        this.correo = "";
        this.tarjeta = new MetodoPago();
        this.polizas = new ArrayList<>();
    }
    
    public Cliente(String nombre, String telefono, String correo, MetodoPago tarjeta, List<Poliza> polizas) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.tarjeta = tarjeta;
        this.polizas = polizas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public MetodoPago getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(MetodoPago tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<Poliza> getPolizas() {
        return polizas;
    }

    public void setPolizas(List<Poliza> polizas) {
        this.polizas = polizas;
    }
    
}
