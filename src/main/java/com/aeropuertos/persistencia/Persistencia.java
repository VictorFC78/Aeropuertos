/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.persistencia;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.dto.CompaniaAerea;
import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.dto.VueloDiario;
import com.aeropuertos.logica.LogicaNegocio;
import java.io.File;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 34675
 */
public class Persistencia {
    private static final File AEROPUERTOS=new File("aeropuertos.csv");
    private static final File COMPANIAS=new File("companias.csv");
    private static final File VUELOS_BASE=new File("Vuelos_base.csv");
    private static final File VUELOS_DIARIOS=new File("Vuelos_Diarios.csv");
    private static SimpleDateFormat formatoHora=new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
    
    /*******************************Metodos Comunes**************************************/
    //convertir de string a localTime
   private static LocalTime parseStringLocalTime(String hora){ 
       return LocalTime.parse(hora);
   }
   //convertir localtime a srring con formatoHora HH:mm.
   private static String parseLocalTimeString(LocalTime time){      
      return time.format(DateTimeFormatter.ofPattern("HH:mm"));
   }
   //convertir de string a Date
   private static Date parseStrinDate(String fecha){
       return formatoFecha.parse(fecha,new ParsePosition(0));
   }
   //convertir de Date a String
   private static String parseDateString(Date fecha){
        return formatoHora.format(fecha);
   }
    /****************************************************************************************/
   
    /****************************Aeropuertos***************************************************/
    public static void  leerListaAeropuertosCsv(){
        if (AEROPUERTOS.exists()){
        DocumentoCsv csv;//creamos el documento que contendra el contenido del archivo csv
        ApiCsv apiCsv = new ApiCsv();//creamos el manejador de archivos csv   
        csv = apiCsv.leerCSV(AEROPUERTOS);
        int datosLinea = csv.getTamanioDatos() / csv.getNumLineas();
        int indice = 0;
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < csv.getTamanioDatos(); i++) {
            temp.add(csv.getElemnto(i));
            indice++;
            if (indice == datosLinea) {
                LogicaNegocio.anaidirAeropuertoPersintencia(new Aeropuerto(temp.get(0), temp.get(1), temp.get(2)));
                indice = 0;
                temp.clear();
            }
       } 
    }   
}
   /*****************************C****************************************************************/
    
    /*****************************Compañias*******************************************************/
    //lee los datosCsv de un archivo csv y carga en la lista de compañias las compañias existentes en el csva
   public static void leerCompaniaAereasCsv(){
       if(COMPANIAS.exists()){
        DocumentoCsv csv;//creamos el documento que contendra el contenido del archivo csv
        ApiCsv manejadorCsv = new ApiCsv();//creamos el manejador de archivos csv
        csv = manejadorCsv.leerCSV(COMPANIAS);//recuperamos el documento asociado al csv
        ArrayList<String> datosCsv = csv.getDatos();//recuperamos todos los datosCsv del archivo
        //crear compañias cuyo datosCsv de cada una ocupan el tamalo total de los datosCsv entre nº lineas
        int datosLinea = datosCsv.size() / csv.getNumLineas();//numero de datosCsv `por linea
        int indice = 0;
        ArrayList<String> temp = new ArrayList<>();//array temporalpara datos de una compañia
        for (int i = 0; i < datosCsv.size(); i++) {//recorre todos los datos del documento
            temp.add(datosCsv.get(i));//añadimos al array temporal cada elemento del documento
            indice++;
            if (indice == datosLinea) {//comprueba si se ha rellenado una linea
                String[] datos = extraerDatosCompaniaCsv(temp);//pasamos los d
                LogicaNegocio.anaidirCompaniaAerea(new CompaniaAerea(Integer.parseInt(datos[0]),
                        datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]));
                temp.clear();
                indice = 0;
            }
            LogicaNegocio.setPrefijo();//estable el prefijo de compañia en el ultimo para las siguintes compalias
        }
    }
   }
      
   //devuelve los datosCsv de una compañia que recibe de datoa de un array de un csv
    private static String [] extraerDatosCompaniaCsv(ArrayList<String> lista){
       String[] datos=new String[7];
       datos[0]=lista.get(0);
       datos[1]=lista.get(1);
       datos[2]=lista.get(2);
       datos[3]=lista.get(3);
       datos[4]=lista.get(4);
       datos[5]=lista.get(5);
       datos[6]=lista.get(6);
       return datos;
    }
  //escribir fichero CSV las compañias que contiene la lista de compañias
    public static boolean escribirCompaniaCsv(){
        if (LogicaNegocio.getListaCompaniasAereas().isEmpty()) return false;
        else{
        DocumentoCsv csv=new DocumentoCsv();//creamos documento csv
        ApiCsv manejadorCsv=new ApiCsv();
        //rellenamos los datosCsv del documento csv
        List<CompaniaAerea> lista=LogicaNegocio.getListaCompaniasAereas();
        ArrayList<String> datos=new ArrayList<>();
        for (int i=0;i<lista.size();i++){
            datos.add(String.valueOf(lista.get(i).getPrefijo()));
            datos.add(lista.get(i).getNombre());
            datos.add(lista.get(i).getDireccion());
            datos.add(lista.get(i).getMunicipio());
            datos.add(lista.get(i).getTlfPasajeros());
            datos.add(lista.get(i).getTlfAeropuertos());
            datos.add(lista.get(i).getCodigo());
        }
        csv.setDatos(datos);
        csv.setNumLineas(lista.size());
        manejadorCsv.escribirCSV(COMPANIAS, csv,false);
        
        } 
       return true;
    } 
    /*************************************************************************************************/
    
    
    /*********************************Vuelos Base*****************************************************/
    //recupera un documento con tod los datos del csv
   private static DocumentoCsv extraerDatosCsvVuelosBase(){
       DocumentoCsv csv=new DocumentoCsv();
       ApiCsv apiCsv=new ApiCsv();
       csv=apiCsv.leerCSV(VUELOS_BASE);
       return csv;
   }
   
   public static void leerListaVuelosBaseCsv(){
        
        List<Aeropuerto> listaAeropuertos=extraerDatosAeropuertos();//recupera la lista con todos los aeropuertos del csv
        List<String> listaDatosVuelo=extraerDatosVuelo();//todos los datos correspodientes a cada vuelo sin los aeropuertos
        int j=0;
        int deplazamiento=0;
        Aeropuerto origen=null;
        Aeropuerto destino=null;
        for (int i=0;i<listaAeropuertos.size();i++){
            if(j<2){
                if(j==0) {origen=listaAeropuertos.get(i);}
                if(j==1) {destino=listaAeropuertos.get(i);}
            }
            j++;
            if(j>=2){
                ArrayList<String> temp =new ArrayList<>();
                for (int k=deplazamiento;k<deplazamiento+5;k++){
                    temp.add(listaDatosVuelo.get(k));
                }
                deplazamiento+=5;
                String codigo=temp.get(0);
                String hSalida=temp.get(2);//convertir a localtime
                String hLlegada=temp.get(3);//convertir alocaltime
                String diasOpera=temp.get(4);
                int plazas=Integer.parseInt(temp.get(1));
                VueloBase vuelo=new VueloBase(codigo,origen,destino,plazas,
                        parseStringLocalTime(hSalida),parseStringLocalTime(hLlegada),diasOpera);
                LogicaNegocio.anaidirVueloBasePersistencia(vuelo);
                temp.clear();
                j=0;
            }
        }
       }
    
     //extraer del DocumentoCsv los datos del aeropuerto de destino y origen, y los devuelve en una lista de aeropuertos
    private static  List<Aeropuerto> extraerDatosAeropuertos(){
        DocumentoCsv csv=extraerDatosCsvVuelosBase();
        ArrayList<String> totalDatos=csv.getDatos();//total de todos los datos del csv
        List<Aeropuerto> aeropuertos=new ArrayList<>();
        ArrayList<String> temp=new ArrayList<>();
        int j=0;
        for(int i=0;i<csv.getTamanioDatos();i++){
            if (j<6){
                temp.add(totalDatos.get(i));
                if(j==2 || j==5){
                aeropuertos.add(new Aeropuerto(temp.get(0),temp.get(1),temp.get(2)));
                temp.clear();
            }
            }
            j++;
            if (j==11){
                j=0;
            }  
        }
        return aeropuertos;
    }
     //extraer del DocumentoCsv los datos correspondientes al vuelo con excepcion del los aeropuertos y los devuelve el una lista
    private static List<String> extraerDatosVuelo(){
        DocumentoCsv csv=extraerDatosCsvVuelosBase();
        ArrayList<String> totalDatos=csv.getDatos();//total de todos los datos del csv
        List<String> datosVuelo=new ArrayList<>();
        int j=0;
        for(int i=0;i<csv.getTamanioDatos();i++){
            if (j>5 && j<11){
                datosVuelo.add(totalDatos.get(i));
            }
            j++;
            if (j==11){
                j=0;
            }  
        }
        return datosVuelo;
    }
    
    //escribir vuelos base al fichero csv
    public static void escribirListaVuelosBaseCsv(){
        //borrar el ficehro para garbar todos los datos
       if(VUELOS_BASE.exists())VUELOS_BASE.delete();
        //comprueba que la lista no esta 
        List<VueloBase> listaVB=LogicaNegocio.getListaVueloBase();
        if (!listaVB.isEmpty()){
            ArrayList<String> temp=new ArrayList<>();
                //recorremos la lista de vuelos extraemos los aeropuertos loe escribimos y despues escribimos los de mas atributos
                for (VueloBase v:listaVB){
                    escribirLineaDatos(datosAeropuertos(v.getOrigen()));//escribe lina de aeropuerto origen
                    escribirLineaDatos(datosAeropuertos(v.getDestino()));//escribe linea aeropuerto destino
                    escribirLineaDatos(datosPropiosVuelo(v));//escribe linea con el resto datos de vuelosbase
                }   
        }    
    }
    //extrae los datos de los aeropuertos para utilizarlos en la escritura del Csv
    private static ArrayList<String> datosAeropuertos(Aeropuerto aeropuerto){
        ArrayList<String> temp=new ArrayList<>();
        temp.add(aeropuerto.getIata());
        temp.add(aeropuerto.getNombre());
        temp.add(aeropuerto.getMunicipio());
        return temp;
    }
     //extrae los restantes datos del vuelo exceptuando los aeropuertos para utilzarlos en la escritura del csv
    private static ArrayList<String> datosPropiosVuelo(VueloBase vuelo){
        ArrayList<String> temp=new ArrayList<>();
        temp.add(vuelo.getCodigo());
        temp.add(String.valueOf(vuelo.getPlazas()));
        temp.add(parseLocalTimeString(vuelo.getHoraSalida()));
        temp.add(parseLocalTimeString(vuelo.getHoraLlegada()));
        temp.add(vuelo.getDiasOpera());
        return temp;
        
    }
     //escribe en el archivo una linea con los datos correspondientes,con apertura en la ultima linea
    private static void escribirLineaDatos(ArrayList<String> lista){
        DocumentoCsv csv=new DocumentoCsv();
        ApiCsv apiCsv=new ApiCsv();
        csv.setDatos(lista);
        csv.setNumLineas(1);
        apiCsv.escribirCSV(VUELOS_BASE, csv, true);
    }
     /***************************************************************************************************/
    
     /*********************************Vuelos Diarios*****************************************************/
    //recupera toda la informacion de los vuelos diarios del csv y los guarda en una variable DocuemntoCsv
    private static DocumentoCsv extraerDatosVuelosDiariosCsv(){
        
        if(VUELOS_DIARIOS.exists()& VUELOS_DIARIOS.length()!=0){
         // recupera los datos del csv en una lista de string el numero de lineas total, cada linea va a ocupar 6 datos 
         DocumentoCsv csv=new DocumentoCsv();
         ApiCsv apiCsv=new ApiCsv();
         csv=apiCsv.leerCSV(VUELOS_DIARIOS);
            return csv;
        }
        return null;
    }
    //guarda en una lista en memoria los vuelos diarion
    public static void leerListaVuelosDiariosCsv(){
        DocumentoCsv csv;
        if ((csv =extraerDatosVuelosDiariosCsv())!=null){
        List<String> datos=csv.getDatos();
         ArrayList<String> temp=new ArrayList<>();
         //recorremos la lista y utilizamos un array temporal para guardar los 6 datos y craer el vuelo diario
         int j=0;
         for (int i=0;i<datos.size();i++){
             //añade seis elementos a la lista
             if(j<6){
                 temp.add(datos.get(i));
             }
             j++;
             //cuando la lista tenga seis elementos creamos el vuelo, vaciamos la lista y ponemos a cero el contador
             if(j==6){
                 VueloDiario vueloD=new VueloDiario(temp.get(0), parseStrinDate(temp.get(1)),
                         parseStringLocalTime(temp.get(2)),parseStringLocalTime(temp.get(3))
                         ,Integer.parseInt(temp.get(4)),Double.parseDouble( temp.get(5)));
                 LogicaNegocio.anaidirVueloDiarioLista(vueloD);
                 j=0;
                 temp.clear();
                }
            }
        }
    }
     //escribe los vuelos diarios en memoria al archivo csv
    public static void escribirVuelosDiariosCsv() {
        //extraer todos lod datos de la lista en memoria, crea una lista de strings y el numero total de linea 
        if(!LogicaNegocio.getListaVuelosDIarios().isEmpty()){
            //recorremos la lista para extaer los vuelos diarios y sus datos
            List<VueloDiario> lista=LogicaNegocio.getListaVuelosDIarios();
            ArrayList<String> datos=new ArrayList<>();
            for (int i=0;i<lista.size();i++){
                String[] temp=extarerDatosListaVuelosDiarios(lista.get(i));//extrae datos de cada vuelo
                for (int j=0;j<temp.length;j++){
                    datos.add(temp[j]);
                }
            }
            DocumentoCsv csv=new DocumentoCsv();
            ApiCsv apiCsv=new ApiCsv();
            csv.setDatos(datos);
            csv.setNumLineas(lista.size());
            apiCsv.escribirCSV(VUELOS_DIARIOS, csv, false);
        }
    }
    //extrae los datos para guardarlos en memoria csv
     public static String[] extarerDatosListaVuelosDiarios(VueloDiario vuelo){
        if (vuelo!=null){
            String datos[]=new String[6];
            datos[0]=vuelo.getCodigo();
            datos[1]=parseDateString(vuelo.getFechaVuelo());
            datos[2]=parseLocalTimeString(vuelo.getHoraSlida());
            datos[3]=parseLocalTimeString(vuelo.getHoraLlegada());
            datos[4]=String.valueOf(vuelo.getPlazasOcupadas());
            datos[5]=String.valueOf(vuelo.getPrecio());
            return datos;
        }
        return null;
    }
}

