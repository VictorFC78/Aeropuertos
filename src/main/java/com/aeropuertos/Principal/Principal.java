/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.Principal;
import com.aeropuertos.gui.PantallaPrincipal;
import com.aeropuertos.logica.LogicaNegocio;





/**
 *
 * @author Victor Fernandez
 */
public class Principal {
    public static void main(String[] args) {
        LogicaNegocio.inicializarSistema();
        PantallaPrincipal principal=new PantallaPrincipal();
        principal.setVisible(true);
        
        
       
    }
    
}
