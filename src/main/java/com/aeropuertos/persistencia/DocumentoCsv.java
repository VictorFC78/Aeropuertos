/*
Clase que maneja un objeto que contiene un arraylist de string y un entero, estos dos variables
contiene todos los datos que va leerse de un archivo Csv y las lineas de dicho archivo
*/
package com.aeropuertos.persistencia;

import java.util.ArrayList;
import java.util.Iterator;


public class DocumentoCsv {
    private ArrayList<String> datos;
    private int numLineas;
   
   
    public DocumentoCsv(ArrayList<String> datos,int lineas){
        this.datos=datos;
        this.numLineas=lineas;
        
    }
    public DocumentoCsv(){
        
    }
    
    public ArrayList<String> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }

    public int getNumLineas() {
        return numLineas;
    }
    public int getTamanioDatos(){
        return datos.size();
    }
    public String getElemnto(int indice){
        return datos.get(indice);
    }
    public void setNumLineas(int numLineas) {
        this.numLineas = numLineas;
    }
    public void anaidirDatos(String dato){
        datos.add(dato);
    }
    public boolean eliminarDatos(String dato){
        Iterator<String> it=datos.iterator();
        String temporal;
        while (it.hasNext()){
            temporal=it.next();
            if (temporal.equals(dato)){
                it.remove();
                return true;
            }
        }
        return false;
    }
}
