
package com.aeropuertos.componentes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApirestFullTemperaturas implements Serializable{
    private DatosClima datosClima;
    public ApirestFullTemperaturas(String municipio,String apiKey) throws IOException {
        if(municipio!=null && apiKey!=null){
        this.datosClima=extaerDatosPeticion(peticionApirest(municipio,apiKey));
        }
    }
    
    public DatosClima getDatosClima() {
        return datosClima;
    }
    
    private  DatosClima extaerDatosPeticion(String uri) throws MalformedURLException, IOException{
        if(!uri.isEmpty()){
        URL url = new URL(uri);//variable URL para la peticion
        HttpURLConnection conexion=(HttpURLConnection)url.openConnection();
        conexion.setRequestMethod("GET");//establece el metodo GET como peticion
        //recuperamos el contenido de la peticion
        BufferedReader bfr=new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        //leemos todas las lineas y las guardamos en datoCompleto
        String datoUnitario;
        String datoCompleto="";
        while((datoUnitario=bfr.readLine())!=null){
            datoCompleto+=datoUnitario;
        }
        bfr.close();
        JSONArray array=new JSONArray(datoCompleto);//array que contiene todos los objetos json
        JSONObject prediccion=null;//objeto json para el json de prediccion
        for (Object obj:array){//extraer el json de prediccion
            prediccion=((JSONObject)obj).getJSONObject("prediccion");
         }
        JSONArray dia=(JSONArray)prediccion.get("dia");//extrae el array json de dia
        JSONObject temperatura=null;//objeto json para el json de prediccion
        for (Object obj:dia){//extrae l json de tempetarura
            temperatura=((JSONObject)obj).getJSONObject("temperatura");
         }
        int max=temperatura.getInt("maxima");//recuperamos la temperatura maxima
        int min=temperatura.getInt("minima");//recuperamos la temperatura minima
        return new DatosClima(String.valueOf(min), String.valueOf(max));
        }
            return null;
    }
    //metodo peticion al apirest y devuelve un string con la URL de los datos de la peticion
    private  String  peticionApirest(String municipio,String apiKey) throws MalformedURLException, IOException{
        //establecemos la URL  a la que vamos a solicitar los datos
        URL url=new URL("https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/"+municipio);
        //obtenemos un objeto tipo HttpUrlCoinecction abriendo la conexion con la url
        HttpURLConnection conexion=(HttpURLConnection)url.openConnection();
        conexion.setDoOutput(true);//establece el metodo de salida en true
        conexion.setRequestMethod("GET");//establece el metodo GET como peticion
        conexion.setRequestProperty("accept", "application/json");//estalece cabeceras
        conexion.setRequestProperty("api_key", apiKey);
        //recuperamos el contenido de la peticion
        BufferedReader bfr=new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        //leemos todas las lineas y las guardamos en datoCompleto
        String datoUnitario;
        String datoCompleto="";
        while((datoUnitario=bfr.readLine())!=null){
            datoCompleto+=datoUnitario;
        }
        bfr.close();
        //añadimos corchete al principio al final para poder tratarlo como un JSON
        String datoJson="["+datoCompleto+"]";
        //transformamos el string en un Array de json
        JSONArray array=new JSONArray(datoJson);
        //ietramos en el array para extraer al url que contiene los datos
        String urldatos="";
        for (Object obj:array){
          urldatos=((JSONObject)obj).getString("datos");
        }
     return urldatos ;
    }
}//"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYW51em83OEBnbWFpbC5jb20iLCJqdGkiOiI1YjZiYjlkOC0zN2E4LTRlZDUtYWM4OS1mNWUyMDkxZGI4MjQiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTcwMDMwODA1MywidXNlcklkIjoiNWI2YmI5ZDgtMzdhOC00ZWQ1LWFjODktZjVlMjA5MWRiODI0Iiwicm9sZSI6IiJ9.AMmaLLtPURPjV5rzIcJBjpKXxbHQWUNycdDjFulNHfs"
