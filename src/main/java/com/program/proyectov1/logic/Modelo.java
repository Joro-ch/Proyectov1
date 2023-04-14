/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.program.proyectov1.logic;

/**
 *
 * @author Laptop Camilo
 */
public class Modelo {
 
    private String modelo;
    private String anio;
    private String marca;
    private byte [] imagen;

    public Modelo(String modelo, String anio, String marca, byte[] imagen) {
        this.modelo = modelo;
        this.anio = anio;
        this.marca = marca;
        this.imagen = imagen;
    }   
    
    public String getModelo(){
        return modelo;
    }

    public String getAnio() {
        return anio;
    }

    public String getMarca() {
        return marca;
    }

    public byte[] getImagen() {
        return imagen;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    
    
    
}
