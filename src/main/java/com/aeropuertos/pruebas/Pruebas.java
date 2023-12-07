/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.pruebas;
import com.aeropuertos.gui.PantallaPrincipal;
import com.aeropuertos.logica.LogicaNegocio;




/**
 *
 * @author 34675
 */
public class Pruebas {
    public static void main(String[] args) {
        LogicaNegocio.inicializarSistema();
        PantallaPrincipal principal=new PantallaPrincipal();
        principal.setVisible(true);
   
    }
}
