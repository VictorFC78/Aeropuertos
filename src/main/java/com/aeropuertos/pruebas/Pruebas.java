/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.pruebas;
import com.aeropuertos.gui.PantallaPrincipal;
import com.aeropuertos.logica.LogicaNegocio;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;




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
