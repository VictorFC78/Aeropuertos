/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.pruebas;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.dto.CompaniaAerea;
import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.dto.VueloDiario;

import com.aeropuertos.gui.PantallaPrincipal;
import com.aeropuertos.logica.LogicaNegocio;

import com.aeropuertos.persistencia.Persistencia;

import java.util.List;


/**
 *
 * @author 34675
 */
public class Pruebas {
    public static void main(String[] args) {
        Persistencia.leerCompaniaAereasCsv();
        List<CompaniaAerea> listaCA=LogicaNegocio.getListaCompaniasAereas();
        Persistencia.leerListaAeropuertosCsv();
        List<Aeropuerto> listaAe=LogicaNegocio.getListaAeropuertos();
        Persistencia.leerListaVuelosBaseCsv();
        Persistencia.leerListaVuelosDiariosCsv();
        List<VueloBase> listaVB=LogicaNegocio.getListaVueloBase();
        List<VueloDiario> listaD=LogicaNegocio.getListaVuelosDIarios();
        LogicaNegocio.referenciarVuelosDiarioVueloBase();
        System.out.println("Lista Compañias:"+listaCA.size());
        System.out.println("Lista Vuelos Base:"+listaVB.size());
        System.out.println("Lista Vuelos Diarios:"+listaD.size());
        PantallaPrincipal principal=new PantallaPrincipal();
        principal.setVisible(true);
        
        
       
        
    }
}
