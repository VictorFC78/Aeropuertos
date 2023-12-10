/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.componentes;

import java.io.Serializable;

/**
 *
 * @author 34675
 */
public class DtoEditorApiRestFull implements Serializable{
    private String municipio;
    private String apikey;

    public DtoEditorApiRestFull() {
    }

    public DtoEditorApiRestFull(String municipio, String apikey) {
        this.municipio = municipio;
        this.apikey = apikey;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
    
}
