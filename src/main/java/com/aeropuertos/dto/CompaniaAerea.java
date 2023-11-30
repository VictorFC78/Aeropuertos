
package com.aeropuertos.dto;

import java.io.Serializable;


public class CompaniaAerea implements Serializable{
    private String nombre;
    private String direccion;
    private String municipio;
    private String tlfPasajeros;
    private String tlfAeropuertos;
    private String codigo;
    private int prefijo;
    private static int incPref;
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public CompaniaAerea(int prefijo,String nombre, String direccion, String municipio, String tlfPasajeros, String tlfAeropuertos,String codigo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.tlfPasajeros = tlfPasajeros;
        this.tlfAeropuertos = tlfAeropuertos;
        this.prefijo=prefijo;
        this.codigo=codigo;
    }
    
    public CompaniaAerea(String nombre, String direccion, String municipio, String tlfPasajeros, String tlfAeropuertos,String codigo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.tlfPasajeros = tlfPasajeros;
        this.tlfAeropuertos = tlfAeropuertos;
        this.prefijo=setPrefijo();
        this.codigo=codigo;
    }

    public int getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    public CompaniaAerea() {
    }

  
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTlfPasajeros() {
        return tlfPasajeros;
    }

    public void setTlfPasajeros(String tlfPasajeros) {
        this.tlfPasajeros = tlfPasajeros;
    }

    public String getTlfAeropuertos() {
        return tlfAeropuertos;
    }

    public void setTlfAeropuertos(String tlfAeropuertos) {
        this.tlfAeropuertos = tlfAeropuertos;
    }
    private static int setPrefijo(){
        incPref++;
        return incPref;
    }
    public static void inicializarPrefijo(int valor){
        incPref=valor;
    }
 

    @Override
    public boolean equals(Object obj) {
        CompaniaAerea compania=(CompaniaAerea)obj;
        if (this.getCodigo().equals(compania.getCodigo()) 
                || this.getNombre().equals(compania.getNombre())) return true;
        return false;
    }
   
}
