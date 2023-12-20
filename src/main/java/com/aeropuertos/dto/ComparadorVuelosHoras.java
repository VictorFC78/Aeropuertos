/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.dto;

import java.util.Comparator;

/**
 *@author Victor Fernandez
 * Clase que hereda de Comparator, recibe por parametro dos objetos de VueloDiario
 * y se comparan por sus horas de salida
 */
public class ComparadorVuelosHoras implements Comparator<VueloDiario>{

    @Override
    public int compare(VueloDiario o1, VueloDiario o2) {
        return o1.getHoraSlida().compareTo(o2.getHoraSlida());
    }
    
}
