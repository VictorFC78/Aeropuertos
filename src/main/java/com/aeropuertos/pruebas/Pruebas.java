/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.pruebas;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.dto.CompaniaAerea;
import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.gui.ConsultarCompaniasAereas;
import com.aeropuertos.gui.ConsultarVuelosBase;
import com.aeropuertos.logica.LogicaNegocio;
import com.aeropuertos.persistencia.Persistencia;
import java.awt.Frame;
import java.util.List;

/**
 *
 * @author 34675
 */
public class Pruebas {
    public static void main(String[] args) {
        Persistencia.leerCompaniaAereasCsv();
        List<CompaniaAerea> lista=LogicaNegocio.getListaCompaniasAereas();
        System.out.println("lista compañias:"+lista.size());
        System.out.println("ultimo prefijo:"+lista.get(2).getPrefijo());
        //CompaniaAerea c=new CompaniaAerea("elmio","jhgkjgj","ljhlkjh","uygiuyg","22222","VY");
        //System.out.println("ultimo prefijo:"+c.getPrefijo());
        //LogicaNegocio.anaidirCompaniaAerea(c);
        //Persitencia.escribirCompaniaCsv();
        Persistencia.leerListaAeropuertosCsv();
        List<Aeropuerto> listaAe=LogicaNegocio.getListaAeropuertos();
        System.out.println("lista aeropuertos:"+listaAe.size());
        Persistencia.leerListaVuelosBaseCsv();
        List<VueloBase> listaVB=LogicaNegocio.getListaVueloBase();
        System.out.println("lista Vuelos:"+listaVB.size());
        Frame frame=new Frame();
        ConsultarVuelosBase dialogo=new ConsultarVuelosBase(frame, true);
        dialogo.setVisible(true);
       
        
    }
}
