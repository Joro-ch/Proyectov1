package com.program.proyectov1.logic;

import java.util.ArrayList;
import java.util.List;

public class Poliza {
    
    // Atributos
    private String codigo;
    private Vehiculo vehiculo;
    private Integer valorSeguro;
    private String plazoPagos;
    private String fechaInicioVigencia;
    private List<Cobertura> coberturas;
    
    // Métodos

    public Poliza() {
        this.codigo = "";
        this.vehiculo = new Vehiculo();
        this.valorSeguro = 0;
        this.plazoPagos = "";
        this.fechaInicioVigencia = "";
        this.coberturas = new ArrayList<>();
    }
    
    public Poliza(Vehiculo vehiculo, Integer valorSeguro, String plazoPagos, String fechaInicioVigencia, List<Cobertura> coberturas) {
        this.codigo = "";
        this.vehiculo = vehiculo;
        this.valorSeguro = valorSeguro;
        this.plazoPagos = plazoPagos;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.coberturas = coberturas;
    }

    public Poliza(String codigo, Vehiculo vehiculo, Integer valorSeguro, String plazoPagos, String fechaInicioVigencia, List<Cobertura> coberturas) {
        this.codigo = codigo;
        this.vehiculo = vehiculo;
        this.valorSeguro = valorSeguro;
        this.plazoPagos = plazoPagos;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.coberturas = coberturas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Integer getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(Integer valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public String getPlazoPagos() {
        return plazoPagos;
    }

    public void setPlazoPagos(String plazoPagos) {
        this.plazoPagos = plazoPagos;
    }

    public String getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(String fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }
    
    // Métodos Específicos
    
    public void addCobertura(Cobertura cobertura) {
        coberturas.add(cobertura);
    }
    
    public void precioTotal(){
        Integer total =0;
        for(Cobertura c: this.coberturas){
            if(this.vehiculo.getValor()*(c.getCostoPorcentual()/100.0)>c.getCostoMinimo()){
                total+=  Double.valueOf(this.vehiculo.getValor()*(c.getCostoPorcentual()/100.0)).intValue();
            }else{
                total+= c.getCostoMinimo();
            }
        }
        this.setValorSeguro(total);
    }
    
}
