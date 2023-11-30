/*Api para leer y escribir en archivos CSV, no tiene variables de instancia
,para ello leer recibe un fichero y devuelve un objeto de clase DocumentoCsv
,para escribir recibe un fichero y un objeto DocumentoCsv
*/

package com.aeropuertos.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ApiCsv {

   public ApiCsv () {
       
   }
   //lee los datos de un archivo csv y devuelve un objeto documento con todos los datos y las lineas que ocupan
   public DocumentoCsv leerCSV(File fichero){
       if (fichero.length()!=0){
       BufferedReader bfr=null;
       ArrayList<String> datos=new ArrayList<>();
       int lineas=0;
      try {
          bfr=new BufferedReader(new FileReader(fichero));
          //lee lineas hasta el fianl del archivo
          String linea;
          while((linea=bfr.readLine())!=null){
              //divide la linea en tringss cuando encuentre ; y los guarda en una array de strings
              String[]datoslinea=linea.split(";");
              //relleno el arraylist con los datos del string
              for (int i=0;i<datoslinea.length;i++){
                  datos.add(datoslinea[i]);
              }
              lineas++;
          }
      } catch (FileNotFoundException ex) {
          System.out.println("No se encuentro el archivo");
          return null;
      } catch (IOException ex) {
          System.out.println("Error al leer");
      }finally{
           try {
               bfr.close();
           } catch (IOException ex) {
               
           }
      }
      return new DocumentoCsv(datos, lineas);
   } 
       return null;
   }
   //escribe los datos en un fichero que recibe de un objeto documento que contiene todos los datos y las lineas que ocupan
   public void escribirCSV(File fichero, DocumentoCsv csv, boolean anaidir){
       PrintWriter prw=null;
       int j=0;
       if(csv.getNumLineas()!=0){
       int datosLinea=csv.getTamanioDatos()/csv.getNumLineas();
       try {
           prw = new PrintWriter(new FileWriter(fichero,anaidir));
           //recorremos el array escribiendo los elemntos por linea incluyendo ;
           for (int i=0;i<csv.getTamanioDatos();i++){
               prw.print(csv.getElemnto(i));
               prw.print(";");
               j++;
               if(j==datosLinea){
                   prw.println();
                   j=0;
               }
           }
       } catch (FileNotFoundException ex) {
           
       }   catch (IOException ex) {
               Logger.getLogger(ApiCsv.class.getName()).log(Level.SEVERE, null, ex);
           }finally{
           prw.close();
       }
      } 
   }

}   