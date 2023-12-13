/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.modelos;

/**
 *
 * @author 34675
 */
public interface IObservable {
   public void anaidirEscuchador(IEscuchador escuchador);
   public void eliminarEscuchador(IEscuchador escucjador);
   public void nofificarCambio();
}
