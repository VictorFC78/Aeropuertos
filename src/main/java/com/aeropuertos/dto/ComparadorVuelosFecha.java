/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;

/**
 *@author Victor Fernandez
 * Clase que hereda de Comprator, recibe por parametro dos objetos de VueloDiario
 * y se comparan por sus fechas de vuelo
 */
public class ComparadorVuelosFecha implements Comparator<VueloDiario> {

    @Override
    public int compare(VueloDiario o1, VueloDiario o2) {
        SimpleDateFormat formato =new SimpleDateFormat("yyyy-MM-dd");
        LocalDate dateVule1=LocalDate.parse(formato.format(o1.getFechaVuelo()));
        LocalDate dateVule2=LocalDate.parse(formato.format(o2.getFechaVuelo()));
        return dateVule1.compareTo(dateVule2);
    }
    
}
