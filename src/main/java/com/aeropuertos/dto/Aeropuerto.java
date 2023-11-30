/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.dto;



/**
 *
 * @author 34675
 */
public class Aeropuerto {
    private String iata;
    private String nombre;
    private String municipio;
    public Aeropuerto() {
    }

    public Aeropuerto(String iata) {
        this.iata = iata;
    }
    
    
    public Aeropuerto(String iata, String nombre, String municipio) {
        this.iata = iata;
        this.nombre = nombre;
        this.municipio = municipio;
        
}

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
}
