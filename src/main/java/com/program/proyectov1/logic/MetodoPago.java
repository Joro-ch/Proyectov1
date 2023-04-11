package com.program.proyectov1.logic;

public class MetodoPago {
    
    // Atributos
    
    private String codigo;
    private String idCliente;
    private String titular;
    private String numTarjeta;
    private String fechaExp;
    private String codigoSeguridad;
    
    // Métodos

    public MetodoPago() {
        this.codigo = "";
        this.idCliente = "";
        this.titular = "";
        this.numTarjeta = "";
        this.fechaExp = "";
        this.codigoSeguridad = "";
    }
    
    public MetodoPago(String idCliente, String titular, String numTarjeta, String fechaExp, String codigoSeguridad) {
        this.codigo = "";
        this.idCliente = idCliente;
        this.titular = titular;
        this.numTarjeta = numTarjeta;
        this.fechaExp = fechaExp;
        this.codigoSeguridad = codigoSeguridad;
    }

    public MetodoPago(String codigo, String idCliente, String titular, String numTarjeta, String fechaExp, String codigoSeguridad) {
        this.codigo = codigo;
        this.idCliente = idCliente;
        this.titular = titular;
        this.numTarjeta = numTarjeta;
        this.fechaExp = fechaExp;
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
    
}
