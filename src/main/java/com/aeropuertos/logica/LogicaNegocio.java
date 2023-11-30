/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.logica;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.dto.CompaniaAerea;
import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.dto.VueloDiario;
import java.time.LocalTime;
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
    private static List<VueloDiario> listasVueloDiario=new ArrayList<>();
    /******************************* Aeropuertos ***************************************/
    //recuperar aeropuerto por codigo iara
    public static Aeropuerto getAeropuertoSeleccionado(String iata){
        for (Aeropuerto a:listaAeropuertos){
            if(a.getIata().equals(iata)) return a;
        }
        return null;
    }
    //establecer aeropuerto origen y lo retorna
    public static Aeropuerto getAeropuertoOrigen(String iata){
       return aeropuertoOrigen=getAeropuertoSeleccionado(iata);
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
    //comprueba que existe una compania
    public static boolean coincidenciaCompaniaAerea(String codigo){
       for (CompaniaAerea a:listaCompaniaAerea){
           if(a.getCodigo().equals(codigo))return true;
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
    /**************************************************************************************/
    
    /************************** Vuelos Diarios********************************************/
    //añadir un vuelo diario a la lista
    public static void anaidirListaVueloDiario(VueloDiario vuelo){
        listasVueloDiario.add(vuelo);
    }
    //recuperra la lista de vuelos diarios
    public static List<VueloDiario> getListaVuelosDIarios(){
        return listasVueloDiario;
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
        //buscamos el vuelo base en la lista, buscamos en si ahy vuelodiario con esa fecah
        List<VueloDiario> lista=null;
        for (VueloBase v:listaVueloBase){
            if(v.getCodigo().equals(codigo)) lista=v.getVuelosDiario();
        }
        if (lista!=null){
            Iterator<VueloDiario> it=lista.iterator();
            while(it.hasNext()){
                if (it.next().getFechaVuelo().equals(fecha)){
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }
    //aoscia cada uno de los vuelo diarios a los vuelos base
    public static void anaidirVuelosDiarioVueloBase(){
        //iteramos en la lista de vuelos diarios buscando que vuelo base contienen el mismo codigo para añadirselo
        for (VueloDiario v:listasVueloDiario){
            VueloBase vb=getVueloBase(v.getCodigo());//recupera el vuelo seguncodifo, codigo vuelo y codigo vuelo diario es el mismo
            vb.anaidirVueloDiario(v);//le añade el vuelo diario al vuelo base
        }
        listasVueloDiario.clear();
    } 
    //retorna una matriz de object con los datos de los vuelos diarios
    public static Object[][] extraerDatosVuelosDiarios(){
        Object[][] datos=new Object[listasVueloDiario.size()][6];
        for (int i=0;i<listasVueloDiario.size();i++){
            datos[i][0]=listasVueloDiario.get(i).getCodigo();
            datos[i][0]=listasVueloDiario.get(i).getFechaVuelo();
            datos[i][0]=listasVueloDiario.get(i).getHoraSlida();
            datos[i][0]=listasVueloDiario.get(i).getHoraLlegada();
            datos[i][0]=listasVueloDiario.get(i).getPlazasOcupadas();
            datos[i][0]=listasVueloDiario.get(i).getPrecio();
        }
        return datos;
    }
}