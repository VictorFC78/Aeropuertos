/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.logica;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.dto.CompaniaAerea;
import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.dto.VueloDiario;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



/**
 *
 * @author 34675
 */
public class LogicaNegocio {
    private static List<Aeropuerto> listaAeropuertos=new ArrayList<>();//lista con todos los aeropuertos
    private static List<Aeropuerto> listAeropuertosBis=new ArrayList<>();
    private static Aeropuerto aeropuertoOrigen;//aeropuerto de origen
    private static List<CompaniaAerea> listaCompaniaAerea=new ArrayList<>();
    private static List<VueloBase> listaVueloBase=new ArrayList<>();
    private static List<VueloDiario> listasVueloDiarioCsv=new ArrayList<>();
     private static SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
   // private static List<VueloDiario> listasVueloDiarioMemoria=new ArrayList<>();
    /******************************* Aeropuertos ***************************************/
    //recuperar aeropuerto por codigo iara
    public static Aeropuerto getAeropuertoSeleccionado(String iata){
        for (Aeropuerto a:listaAeropuertos){
            if(a.getIata().equals(iata)) return a;
        }
        return null;
    }
    //
    public static void setAeropuertoBase(Aeropuerto aeropuerto){
        aeropuertoOrigen=aeropuerto;
    }
    //retorna el aeropuerto base
    public static Aeropuerto getAeropuertoOrigen(){
       return aeropuertoOrigen;
    }
    //añadir un aeropuerto a la lista
    public static void anaidirAeropuerto(Aeropuerto aeropuerto){
        listaAeropuertos.add(aeropuerto);
    }
    //lista de areopueros sin el aeropuerto de origen
    public static List<Aeropuerto> getListaAeropuetosBis(){
        for (Aeropuerto a:listaAeropuertos){
            if (!a.getIata().equals(aeropuertoOrigen.getIata()))listAeropuertosBis.add(a);
        }
        return listAeropuertosBis;
    }
    //devuelve la lista completa de aeropuertos
    public static List<Aeropuerto> getListaAeropuertos(){
        return listaAeropuertos;
    }
    /**************************************************************************************/
    
    /************************** Compañias Aereas********************************************/
    //recuperar compania aerea por codigo
    public static CompaniaAerea getCompaniaAerea(String codigo){
        for (CompaniaAerea a:listaCompaniaAerea){
            if(a.getCodigo().equals(codigo))return a;
        }
        return null;
    }
    public static CompaniaAerea getCompaniaAerea(int posicion){
        return listaCompaniaAerea.get(posicion);
    }
    //comprueba que existe una compania
    public static boolean coincidenciaCompaniaAerea(CompaniaAerea compania){
       for (CompaniaAerea a:listaCompaniaAerea){
           if(a.equals(compania))return true;
       }
       return false;
    }
    //eliminar una compania por codigo
    public static boolean eliminarCompaniaAerea(String codigo){
        Iterator<CompaniaAerea> it=listaCompaniaAerea.iterator();
        while(it.hasNext()){
            if(it.next().getCodigo().equals(codigo)){
                it.remove();
                return true;
            }
        }
       return false; 
    }
    //añade una compañia aerea a la lista
    public static void anaidirCompaniaAerea(CompaniaAerea compania){
        listaCompaniaAerea.add(compania);
    }
    //modifica los datos de una compañia sin modificar su nombre ni su codigo
    public static void  modificarCompaniaAerea(String codigo,String direccion,String municipio,String tlfArpto,String tlfPajro){
        int prefijo=0;
        for (int i=0;i<listaCompaniaAerea.size();i++){
            if (listaCompaniaAerea.get(i).getCodigo().equals(codigo))prefijo=i;
        }
        listaCompaniaAerea.get(prefijo).setDireccion(direccion);
        listaCompaniaAerea.get(prefijo).setMunicipio(municipio);
        listaCompaniaAerea.get(prefijo).setTlfAeropuertos(tlfArpto);
        listaCompaniaAerea.get(prefijo).setTlfPasajeros(tlfPajro);
    }
    //devuelve la lista de companias aereas
    public static List<CompaniaAerea> getListaCompaniasAereas(){
        return listaCompaniaAerea;
    }
    //ajuste el ultimo prefijo de compañia leido del archivo Csv para la nueva creacion de compañias en memoria
    public  static void setPrefijo(){
        for(CompaniaAerea c:listaCompaniaAerea){
            CompaniaAerea.inicializarPrefijo(c.getPrefijo());
        }
    }
    //retorna una matriz de Object con los datos de todas las compa
    public static Object[][] datosCompaniasAereas(){
        Object[][]datos=new Object[listaCompaniaAerea.size()][6];
        for (int i=0;i<listaCompaniaAerea.size();i++){
            datos[i][0]=listaCompaniaAerea.get(i).getCodigo();
            datos[i][1]=listaCompaniaAerea.get(i).getNombre();
            datos[i][2]=listaCompaniaAerea.get(i).getDireccion();
            datos[i][3]=listaCompaniaAerea.get(i).getMunicipio();
            datos[i][4]=listaCompaniaAerea.get(i).getTlfAeropuertos();
            datos[i][5]=listaCompaniaAerea.get(i).getTlfPasajeros();
        }
        return datos;
    }
    
    /**************************************************************************************/
    
    /************************** Vuelos Base********************************************/
    //añadir un vuelo a la lista de vuelos base
    public static void  anaidirVueloBase(VueloBase vuelo){
        listaVueloBase.add(vuelo);
    }
    //recupera la lista de vuelos base 
    public static List<VueloBase> getListaVueloBase(){
        return listaVueloBase;
    }
    //recupera un vuelo por su codigo
    public static VueloBase getVueloBase(String codigo){
        for (VueloBase v:listaVueloBase){
            if (v.getCodigo().equals(codigo)) return v;
        }
        return null;
    }
     //elimina un vuelo segun su codigo segun su codigo
    public static boolean eliminarVueloBase(String codigo){
        //eliminamos sus vuelos diarios de la lista total
        eliminarVueloDiarioLista(codigo);
        Iterator<VueloBase> it=listaVueloBase.iterator();
        while(it.hasNext()){
            if(it.next().getCodigo().equals(codigo)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
    //modificar dato de vuelo menos el codigo de vuelo
    public static void modificarVueloBase(String codigo,Aeropuerto origen,Aeropuerto destino,
            LocalTime hSalida,LocalTime hllegada,String diasOpera,int plazas){
       int prefijo=0;
        for (int i=0;i<listaVueloBase.size();i++){
            if (listaVueloBase.get(i).getCodigo().equals(codigo))prefijo=i;
        }
        listaVueloBase.get(prefijo).setDestino(destino);
        listaVueloBase.get(prefijo).setOrigen(origen);
        listaVueloBase.get(prefijo).setHoraSalida(hSalida);
        listaVueloBase.get(prefijo).setHoraLlegada(hllegada);
        listaVueloBase.get(prefijo).setDiasOpera(diasOpera);
        listaVueloBase.get(prefijo).setPlazas(plazas);
    }
    //retorna una matriz de object con los datos de los vuelos base
    public static Object[][] datosVueloBase(){
        Object[][]datos=new Object[listaVueloBase.size()][7];
        for (int i=0;i<listaVueloBase.size();i++){
            datos[i][0]=listaVueloBase.get(i).getCodigo();
            datos[i][1]=listaVueloBase.get(i).getOrigen();
            datos[i][2]=listaVueloBase.get(i).getDestino();
            datos[i][3]=listaVueloBase.get(i).getHoraSalida();
            datos[i][4]=listaVueloBase.get(i).getHoraLlegada();
            datos[i][5]=listaVueloBase.get(i).getPlazas();
            datos[i][6]=listaVueloBase.get(i).getDiasOpera();
        }
        return datos;
    }
    //busca un vuelo base por codigo y devuelve su posicion en la lista y -1 sino existe
    private static int buscarVuelobaseCodigo(String codigo){
        for (int i=0;i<listaVueloBase.size();i++){
            if (listaVueloBase.get(i).getCodigo().equals(codigo)) return i;
        }
        return -1;
    }
    /**************************************************************************************/
    
    /************************** Vuelos Diarios********************************************/
    //añadir un vuelo diario a la lista
    public static void anaidirVueloDiarioLista(VueloDiario vuelo){
        listasVueloDiarioCsv.add(vuelo);
    }
    //anade un vuelo diario a su vuelo base mediante el codigo del vuelo base
    public static void anaidirVueloDiarioVueloBase(VueloDiario vuelo){
        int pos=0;
        if ((pos=buscarVuelobaseCodigo(vuelo.getCodigo()))!=-1){
            listaVueloBase.get(pos).anaidirVueloDiario(vuelo);
            listasVueloDiarioCsv.add(vuelo);
        }
    }
    //recuperra la lista de vuelos diarios
    public static List<VueloDiario> getListaVuelosDIarios(){
        return listasVueloDiarioCsv;
    }
    
    //recupear un vuelo diario  por su fecha en vuelo base 
    public static VueloDiario getVueloDiario(String codigo,Date fecha){
       List<VueloDiario> lista=null;
        for (VueloBase v:listaVueloBase){
            if(v.getCodigo().equals(codigo)) lista=v.getVuelosDiario();
        }
        if(lista!=null){
            for (VueloDiario vd:lista){
                if (vd.getFechaVuelo().equals(fecha)){
                    return vd;
                }
            }
        }
       return null;
    }
    //eliminar vuelo diarios de un vuelo base  mediante el codigo de vuelo base y la fecha vuelo diario
    public static boolean eliminarVueloDiarioVueloBase(String codigo,Date fecha){
        int pos=0;
        if((pos=buscarVuelobaseCodigo(codigo))!=-1){
            listaVueloBase.get(pos).eliminarVueloDiario(fecha);
            eliminarVueloDiarioLista(codigo,fecha);
            return true;
        }
        return false; 
    }
    //elimina vuelos diarios de la lista general segun su codigo
    private static void eliminarVueloDiarioLista(String codigo){
        Iterator<VueloDiario> it=listasVueloDiarioCsv.iterator();
        while(it.hasNext()){
            if(it.next().getCodigo().equals(codigo)) it.remove();
        }
    }
    //elimina vuelos diarios de la lista general segun su codigo y fecha
    private static void eliminarVueloDiarioLista(String codigo,Date fecha){
        Iterator<VueloDiario> it=listasVueloDiarioCsv.iterator();
        while(it.hasNext()){
            VueloDiario temp=it.next();
            if(temp.getCodigo().equals(codigo)& temp.getFechaVuelo().equals(fecha)){
                it.remove();
            }
        }
    }
    //aoscia cada uno de los vuelo diarios a los vuelos base
    public static void referenciarVuelosDiarioVueloBase(){
        //iteramos en la lista de vuelos diarios buscando que vuelo base contienen el mismo codigo para añadirselo
        for (VueloDiario v:listasVueloDiarioCsv){
            System.out.println("Vuelo base:"+v.getCodigo());
            VueloBase vb=getVueloBase(v.getCodigo());//recupera el vuelo seguncodifo, codigo vuelo y codigo vuelo diario es el mismo
            vb.anaidirVueloDiario(v);//le añade el vuelo diario al vuelo base
            System.out.println("Vuelo diario:"+v.getFechaVuelo());
        }
    } 

    //retorna una matriz de object con los datos de los vuelos diarios
    public static Object[][] extraerDatosVuelosDiarios(){
        Object[][] datos=new Object[listasVueloDiarioCsv.size()][6];
        for (int i=0;i<listasVueloDiarioCsv.size();i++){
            datos[i][0]=listasVueloDiarioCsv.get(i).getCodigo();
            datos[i][1]=formatoFecha.format( listasVueloDiarioCsv.get(i).getFechaVuelo());
            datos[i][2]=listasVueloDiarioCsv.get(i).getHoraSlida();
            datos[i][3]=listasVueloDiarioCsv.get(i).getHoraLlegada();
            datos[i][4]=listasVueloDiarioCsv.get(i).getPlazasOcupadas();
            datos[i][5]=listasVueloDiarioCsv.get(i).getPrecio();
        }
        return datos;
    }
}
/*
Proceso de carga en memoria:
1. Se cargan los aeropuertos
2. se eligen el aeropuerto de origen y se carga la lista de aeroouertos destinos
3. Se cargan los vuelos base en memoria
4. Se asigna a cada vuelo base sus vuelos diarios
5. Cuando se añade un vuelo diario se añade a la original y a su vuelo base
6. Cuando se elimina un vuelo base hay que eliminar sus vuelos diario de la lista total de vyuelos diarios
*/