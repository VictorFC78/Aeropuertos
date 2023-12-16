/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aeropuertos.logica;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.dto.CompaniaAerea;
import com.aeropuertos.dto.ComparadorVuelosFecha;
import com.aeropuertos.dto.ComparadorVuelosHoras;
import com.aeropuertos.dto.Municipio;
import com.aeropuertos.dto.VueloBase;
import com.aeropuertos.dto.VueloDiario;
//import com.aeropuertos.modelos.IEscuchador;
//import com.aeropuertos.modelos.IObservable;
import com.aeropuertos.persistencia.Persistencia;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;



/**
 *
 * @author 34675
 */
public class LogicaNegocio {
    private static List<Aeropuerto> listaAeropuertos=new ArrayList<>();//lista con todos los aeropuertos
    private static List<Aeropuerto> listAeropuertosDestino=new ArrayList<>();
    private static Aeropuerto aeropuertoOrigen;//aeropuerto de origen
    private static List<CompaniaAerea> listaCompaniaAerea=new ArrayList<>();
    private static List<VueloBase> listaVuelosBaseCompleta=new ArrayList<>();
    private static List<VueloBase> listaActualVuelosBase=new ArrayList<>();
    private static List<VueloDiario> listaVuelosDiariosCompleta=new ArrayList<>();
    private static SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat formatoFechaPaneles=new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat formatoHora=new SimpleDateFormat("HH:mm");
    private static List<VueloDiario> listaActualVuelosDiarios=new ArrayList<>();
    private static List<Municipio> listaMunicipio=new ArrayList<>();
    private static final String APIKEY="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYW51em83OEBnbWFpbC5jb20iLCJqdGkiOiIxYzNmYzQxYy1lMTQ0LTRmOWEtYTA5MS0wNWUyZDA1OTAwZTMiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY5OTk4NzM3OSwidXNlcklkIjoiMWMzZmM0MWMtZTE0NC00ZjlhLWEwOTEtMDVlMmQwNTkwMGUzIiwicm9sZSI6IiJ9.jUiuQP3W2c3PM4Di-VSih5zwOHrjAiYZvsP9Lv6PQm4";
//    private static List<IEscuchador> escuchadors=new ArrayList<>();
//    public static IObservable observable=new IObservable() {
//        @Override
//        public void anaidirEscuchador(IEscuchador escuchador) {
//            escuchadors.add(escuchador);
//        }
//
//        @Override
//        public void eliminarEscuchador(IEscuchador escucjador) {
//            escuchadors.remove(escucjador);
//        }
//
//        @Override
//        public void nofificarCambio() {
//            for (IEscuchador e:escuchadors){
//                e.realizaraCambios();
//            }
//        }
//    };
 
    
    public static void inicializarSistema(){
        Persistencia.leerMunicipiosCsv();
        Persistencia.leerListaAeropuertosCsv();//cargar la lista de aeropuerto en el sistema
        Persistencia.leerCompaniaAereasCsv();//cargamos en memoria la lista de companias
        Persistencia.leerListaVuelosBaseCsv();//cargamos todo los vuelos base exixtente
        Persistencia.leerListaVuelosDiariosCsv();//cargamos todo los vuelos diarios en memoria
        //la asigancion de aeropuerto base, vuelos base y vuelos diarios se realiz cuando se agina el aeropuerto base
    }
    public static String getApiKey(){
        return APIKEY;
    }
    /**************************Municipios*********************************************/
    public static void anaidirMunicipioLista(Municipio municipio){
        listaMunicipio.add(municipio);
    }
    public static List<Municipio> getListaMunicipios(){
        return listaMunicipio;
    }

    // <editor-fold defaultstate="collapsed" desc="Aeropuertos">  
    /******************************* Aeropuertos ***************************************/
    //recuperar aeropuerto por codigo iara
    public static Aeropuerto getAeropuertoSeleccionado(String iata){
        for (Aeropuerto a:listaAeropuertos){
            if(a.getIata().equals(iata)) return a;
        }
        return null;
    }
    //establece el aeropuerto base de la aplicacion y rellena una lista con aeropuertos destino
    public static void setAeropuertoBase(Aeropuerto aeropuerto){
        aeropuertoOrigen=aeropuerto;
        rellenarListaAeropuetosDestino();
    }
    //retorna el aeropuerto base
    public static Aeropuerto getAeropuertoOrigen(){
       return aeropuertoOrigen;
    }
    //rellena una lista con todos los aeropueros destino
    private static void rellenarListaAeropuetosDestino(){
        for (Aeropuerto a:listaAeropuertos){
            if(!a.equals(aeropuertoOrigen))listAeropuertosDestino.add(a);
        }
    }
    //añadir un aeropuerto a la lista
    public static void anaidirAeropuertoPersintencia(Aeropuerto aeropuerto){
        listaAeropuertos.add(aeropuerto);
    }
    //lista de todos los aeropuertos excluyendo dse la lista el aeropuerto base
    public static List<Aeropuerto> getListaAeropuetosDestino(){
        return listAeropuertosDestino;
    }
    //devuelve la lista completa de aeropuertos
    public static List<Aeropuerto> getListaAeropuertosOriginal(){
        return listaAeropuertos;
    }// </editor-fold> 
    /**************************************************************************************/
    // <editor-fold defaultstate="collapsed" desc="Compañias">  
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
        //recupera la lista de vuelos base pertenecientes a una compañia
        List<VueloBase>lista=buscarVuelosBaseCodigoCompania(codigo);
        //eliminamos los vuelo base de la lista completa y los eliminamos de la lista actula 
        for (VueloBase v:lista){
            eliminarVueloBase(v.getCodigo());
        }  
        Iterator<CompaniaAerea> it=listaCompaniaAerea.iterator();
        while(it.hasNext()){
            if(it.next().getCodigo().equals(codigo)){
                it.remove();
                return true;
            }    
        }
       return false; 
    }
    //añade una compañia aerea a la lista en la persistencia
    public static void anaidirCompaniaAerea(CompaniaAerea compania){
        listaCompaniaAerea.add(compania);
        //observable.nofificarCambio();
        
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
    }// </editor-fold> 
    
    /**************************************************************************************/
    // <editor-fold defaultstate="collapsed" desc="Vuelos Base">  
    /************************** Vuelos Base********************************************/
    //añadir un vuelo a la lista de vuelos base
    public static void  anaidirVueloBasePersistencia(VueloBase vuelo){
        listaVuelosBaseCompleta.add(vuelo);
    }
    //anñade vuelo base a la lista desde l GUI si no existe coincidencia en la,lista
    public static boolean anaidirVueloBaseGUI(VueloBase vuelo){
        for (VueloBase v:listaVuelosBaseCompleta){//comprueba que no exista un vuelo identico
            if (v.equals(vuelo))return false;
        }
        listaActualVuelosBase.add(vuelo);//lo añade al la lista actual de trabajo
        listaVuelosBaseCompleta.add(vuelo);//lo añade a la lista total 
        return true;
    }
    //rellenar lista actual con los vuelos base que contengan al aeropuerto base
    public static void rellenarListaActualVuelosBase(){
        for(VueloBase v:listaVuelosBaseCompleta){
            if(v.getOrigen().equals(aeropuertoOrigen) || v.getDestino().equals(aeropuertoOrigen)){
                listaActualVuelosBase.add(v);
            }
        }
    }
    
    //recupera la lista con vuelos base que contenga el aeropuerto base entre los de destino u origen
    public static List<VueloBase> getListaActualVuelosBase(){
        return listaActualVuelosBase;
    }
    //recupera la lista de vuelos base 
    public static List<VueloBase> getListaVueloBaseCompleta(){
        return listaVuelosBaseCompleta;
    }
    //recupera un vuelo por su codigo
    public static VueloBase getVueloBaseListaompleta(String codigo){
        for (VueloBase v:listaVuelosBaseCompleta){
            if (v.getCodigo().equals(codigo)) return v;
        }
        return null;
    }
     //recupera un vuelo por su codigo
    public static VueloBase getVueloBaseListaActual(String codigo){
        for (VueloBase v:listaActualVuelosBase){
            if (v.getCodigo().equals(codigo)) return v;
        }
        return null;
    }

    //recupera un vuelo base por posicion
    public static VueloBase getVueloBaseListaActual(int pos){
        return listaActualVuelosBase.get(pos);
    }
     //elimina un vuelo segun su codigo segun su codigo
    public static void eliminarVueloBase(String codigo){
        //elimina todos los vuelos diarios asociados en la lista completa 
        Iterator<VueloDiario>it = listaVuelosDiariosCompleta.iterator();
        while(it.hasNext()){
            if(it.next().getCodigo().equals(codigo)) it.remove();
        }
        listaActualVuelosDiarios.clear();
        //elimino el vuelo base de la lista completa de vuelos base
        Iterator<VueloBase> itvb=listaVuelosBaseCompleta.iterator();
        while(itvb.hasNext()){
            if(itvb.next().getCodigo().equals(codigo)) itvb.remove();
        }
        //eliminamos el vuelo base de la lista actual y vaciamos lalista actual de vuelos diarios y la refrescamos
        itvb=listaActualVuelosBase.iterator();
        while(itvb.hasNext()){
            if(itvb.next().getCodigo().equals(codigo)) itvb.remove();
        }
       rellenarListaActualVuelosDiarios();
    }
    
    //modificar dato de vuelo menos el codcigo de vuelo
    public static boolean modificarVueloBase(VueloBase original,VueloBase datosNuevos){
       for (VueloBase v:listaVuelosBaseCompleta){//se comprueba si hay coincidencia en la lista actual
           if(v.equals(datosNuevos)) return false;
       }
       //se modifica el vuelo en la lista actual con lo que hay que aactualizarlos en la lista completa
       original.setCodigo(datosNuevos.getCodigo());
       original.setOrigen(datosNuevos.getOrigen()); 
       original.setDestino(datosNuevos.getDestino());
       original.setPlazas(datosNuevos.getPlazas());
       original.setHoraSalida(datosNuevos.getHoraSalida());
       original.setHoraLlegada(datosNuevos.getHoraLlegada());
       original.setDiasOpera(datosNuevos.getDiasOpera());
       //se busca el vuelo en la lista completa y se realiza los cambion
        VueloBase vueloBaselc=getVueloBaseListaompleta(original.getCodigo());
        modificarVueloBase(vueloBaselc, datosNuevos);
       return true; 
      
    }
    //retorna una matriz de object con los datos de los vuelos base
    public static Object[][] datosVueloBase(){
        Object[][]datos=new Object[listaActualVuelosBase.size()][7];
        for (int i=0;i<listaActualVuelosBase.size();i++){
            datos[i][0]=listaActualVuelosBase.get(i).getCodigo();
            datos[i][1]=listaActualVuelosBase.get(i).getOrigen();
            datos[i][2]=listaActualVuelosBase.get(i).getDestino();
            datos[i][3]=listaActualVuelosBase.get(i).getHoraSalida();
            datos[i][4]=listaActualVuelosBase.get(i).getHoraLlegada();
            datos[i][5]=listaActualVuelosBase.get(i).getPlazas();
            datos[i][6]=listaActualVuelosBase.get(i).getDiasOpera();
        }
        return datos;
    }
    //busca los vuelos base que contenga en su codigo las iniciales del codigo de una compañia
    private static List<VueloBase> buscarVuelosBaseCodigoCompania(String codigo){
        //los codigo de vuelo contienen las dos iniciales de la compania  a la que pertenecen
        List<VueloBase> lista=new ArrayList<>();
       for(VueloBase v:listaActualVuelosBase){
           if(v.getCodigo().contains(codigo)){
               lista.add(v);
           }
       }
       return lista;
    }// </editor-fold> 
    /**************************************************************************************/
    // <editor-fold defaultstate="collapsed" desc="Vuelos Diarios">  
    /************************** Vuelos Diarios********************************************/
    //añadir un vuelo diario a la lista
    public static void anaidirVueloDiarioListaPersistencia(VueloDiario vuelo){
        listaVuelosDiariosCompleta.add(vuelo);
    }
    //anade un vuelo diario a su vuelo base mediante el codigo del vuelo base
    public static boolean  anaidirVueloDiarioVueloBase(VueloBase vueloBase,VueloDiario vueloDiario){
      //buscamos que en la lista del vuelo diarios no existe ya un vuelo diario con la misma fecha
      for(VueloDiario vd:vueloBase.getVuelosDiario()){
          if (vd.equals(vueloDiario)) return false;
      }
        vueloBase.anaidirVueloDiario(vueloDiario);//lo añade a la lista del propio velo base
        listaVuelosDiariosCompleta.add(vueloDiario);//lo añade a lista completa
        listaActualVuelosDiarios.add(vueloDiario);//lo añade a la lista actual de vuelos diarios
        return true;
    }
    //rellena la lista actual de vuelo diarios que depende del aeropuerto que se haya escohgido como vuelo base
    public static void rellenarListaActualVuelosDiarios(){
        for (VueloBase v:listaActualVuelosBase){
            for(int i=0;i<v.getVuelosDiario().size();i++){
                listaActualVuelosDiarios.add(v.getVuelosDiario().get(i));
            }
        }
        ordenarListaActualVuelosDiarios();
    }
    //ordena la lista de vuelos diarios por fecha y por hora, se llama cada vez que tarbaje con todas las listas
    private static void ordenarListaActualVuelosDiarios(){
        Collections.sort(listaActualVuelosDiarios, new ComparadorVuelosHoras());
        Collections.sort(listaActualVuelosDiarios, new ComparadorVuelosFecha());

    }
    //recuperra la lista de vuelos diarios
    public static List<VueloDiario> getListaVuelosDIariosCompleta(){
        return listaVuelosDiariosCompleta;
    }
    //recupera la lista actual de vuelos diarios
    public static List<VueloDiario> getListaActualVuelosDiarios(){
        return listaActualVuelosDiarios;
    }
    //recupera un vuelo diario segun la posicion en la lista
    public static VueloDiario getVueloDiarioListaActual(int pos){
        return listaActualVuelosDiarios.get(pos);
    }
    //recuepra un vuelo diario de la lista que se esta utilizando mediante su codigo
    public static VueloDiario getVueloDiarioListaActual(String codigo){
        for (VueloDiario v:listaActualVuelosDiarios){
            if (v.getCodigo().equals(codigo))return v;
        }
        return null;
    }
    private static VueloDiario getVueloDiarioListaCompleta(String codigo){
        for (VueloDiario v:listaVuelosDiariosCompleta){
            if (v.getCodigo().equals(codigo)) return v;
        }
        return null;
    }
    //retorna una lista de vuelos diarios cuyo aeropuerto de origen coincida con el de salida
    private static List<VueloDiario> getListaVuelosDiariosSalida(){
        List<VueloDiario> lista=new ArrayList<>();
        for (VueloDiario v:listaActualVuelosDiarios){
            VueloBase vb=getVueloBaseListaActual(v.getCodigo());
            if (vb.getOrigen().equals(aeropuertoOrigen) ) lista.add(v);   
        }
        return lista;
    }
    //retorna una lista de vuelos diarios cuyo aeropuerto de destino coincida con el aeropuerto base
    private static List<VueloDiario> getListaVuelosDiariosLlegada(){
        List<VueloDiario> lista=new ArrayList<>();
        for (VueloDiario v:listaActualVuelosDiarios){
            VueloBase vb=getVueloBaseListaActual(v.getCodigo());
            if (vb.getDestino().equals(aeropuertoOrigen) ) lista.add(v);   
        }
        return lista;
    }
    //retorna una lista de vuelos diarios que coincidan con una fecha de otra lista que reciba como  paramentro
    private static List<VueloDiario> getVuelosDiariosCoincidenciaFecha(List<VueloDiario> lista,Date fecha){
        List<VueloDiario> listafinal=new ArrayList<>();
        for (VueloDiario v:lista){
            if(ValidadorDatos.compararFechas(fecha, v.getFechaVuelo())==0)listafinal.add(v);
        }
        return listafinal;
    }
    /*retorna una lista con los vuelos diarios segun fecha, recibe un boleano que determina
    si la lista es de vuelos de salida(true) de llegada(false)
     */ 
    public static List<VueloDiario> getVuelosDiariosFecha(Date fecha, boolean tipoVuelo){
        //se comprueba que la fecha es igual al dia actual o superior
        int valorFecha=ValidadorDatos.compararFechaActual(fecha);
        List<VueloDiario> lista;
        if(valorFecha>=0){
            if(tipoVuelo){
                lista=getVuelosDiariosCoincidenciaFecha(getListaVuelosDiariosSalida(), fecha);
                Collections.sort(lista,new ComparadorVuelosHoras());
                return lista;
            }else{
                lista=getVuelosDiariosCoincidenciaFecha(getListaVuelosDiariosLlegada(), fecha);
                Collections.sort(lista,new ComparadorVuelosHoras());
                return lista;
            }
        }
        return null;
    }
    //retorna una lista de vuelos diarios pertenecientes a una compañia y coincidentes con una fecha
    public static List<VueloDiario> getVuelosDiariosCompania(Date fecha, CompaniaAerea compania){
        int valorFecha=ValidadorDatos.fechaCorrectaCreacionVuelos(fecha);
        if(valorFecha>=0){
            List<VueloDiario> lista=new ArrayList<>();
            for(VueloDiario vd:listaActualVuelosDiarios){
                if(vd.getCodigo().contains(compania.getCodigo())) lista.add(vd);
            }
            return getVuelosDiariosCoincidenciaFecha(lista, fecha);
        }    
        return null;
    }
    //retorna una lista diaria de vuelo a un destino determinado un semana desde fecha
    public static List<VueloDiario> getVuelosDiariosDetino(Aeropuerto destino){
        //creamos la instancia de la feecha actual y de la fecha dentro de una semama
        GregorianCalendar gregorianFechaFinal=new GregorianCalendar();
        gregorianFechaFinal.add(Calendar.DAY_OF_YEAR,7);
        Date dateFechaFinal=gregorianFechaFinal.getTime();
        LocalDate fechaActual=LocalDate.now();
        LocalDate fechaFinal=LocalDate.parse(formatoFechaPaneles.format(dateFechaFinal));
        //recorre la lista actual de vuelos base y extrae los que tengan como arpto destino el mismo que e`l que se busca
        List<VueloBase> listaVuelosDestino=new ArrayList<>();
        for (VueloBase vb:listaActualVuelosBase){
            if(vb.getDestino().equals(destino))listaVuelosDestino.add(vb);
        }
        //extrae los vuelos diarios de los vuelos base durante la siguiente semana
        List<VueloDiario> listaVueloDiariosDestino=new ArrayList<>();
        for (VueloBase vb:listaVuelosDestino){
            for (VueloDiario vd:vb.getVuelosDiario()){//se comprueba si la fecha de cada vuelo diario esta entre las fechas comprendiads
                LocalDate fechaVuelo=LocalDate.parse(formatoFechaPaneles.format(vd.getFechaVuelo()));
                if(fechaVuelo.compareTo(fechaActual)>=0 && fechaVuelo.compareTo(fechaFinal)<=0) listaVueloDiariosDestino.add(vd);
            }
        }
        Collections.sort(listaVueloDiariosDestino, new ComparadorVuelosFecha());
        return listaVueloDiariosDestino;
    }
    //retorna una lista de vuelos completados segun fecha
    public static List<VueloDiario> getListaVuelosDiariosRecaudacion(Date fecha){
        //solo se realiza cuando la fecha la actual o dias anteriores, se compara fecha actual con la fecha pasada
     int compararFechas=ValidadorDatos.compararFechaActual(fecha);
     List<VueloDiario> lista=new ArrayList<>();
        if(compararFechas<0){
            for (VueloDiario vd:listaActualVuelosDiarios){
                if(ValidadorDatos.compararFechas(vd.getFechaVuelo(), fecha)==0)lista.add(vd);
            }
            return lista;
        }else if(compararFechas==0){
            LocalTime horaAcual=LocalTime.now();
            for (VueloDiario vd:listaActualVuelosDiarios){
                if(ValidadorDatos.compararFechas(vd.getFechaVuelo(), fecha)==0 
                    && vd.getHoraSlida().compareTo(horaAcual)<0){
                    lista.add(vd);
                }
            }
            return lista;
        }
        return null;
    }
        
    //eliminar vuelo diario de un vuelo base 
    public static boolean eliminarVueloDiarioVueloBase(VueloDiario vueloDiario){
        //buscar el vuelo base mediante el codigo del vuelo diario
        for (VueloBase v:listaActualVuelosBase){
            if(v.getCodigo().equals(vueloDiario.getCodigo())){
               v.getVuelosDiario().remove(vueloDiario);
            }
        }
        for (VueloBase vb:listaVuelosBaseCompleta){
            if(vb.getCodigo().equals(vueloDiario.getCodigo())){
               vb.getVuelosDiario().remove(vueloDiario);
               listaActualVuelosDiarios.remove(vueloDiario);
               listaVuelosDiariosCompleta.remove(vueloDiario);
                return true;
            }
        }
        return false;
    }

    //aoscia cada uno de los vuelo diarios a los vuelos base de los vuelos que contengan el aeropuerto base
    public static void referenciarVuelosDiarioVueloBase(){
        for (VueloBase vb:listaVuelosBaseCompleta){
            String codigo=vb.getCodigo();
            for (VueloDiario vd:listaVuelosDiariosCompleta){
                if (vd.getCodigo().equals(codigo))vb.getVuelosDiario().add(vd);
            }
        }
    } 

    //retorna una matriz de object con los datos de los vuelos diarios
    public static Object[][] extraerDatosVuelosDiarios(List<VueloDiario> lista){
        Object[][] datos=new Object[lista.size()][6];
        for (int i=0;i<lista.size();i++){
            datos[i][0]=lista.get(i).getCodigo();
            datos[i][1]=formatoFecha.format(lista.get(i).getFechaVuelo());
            datos[i][2]=lista.get(i).getHoraSlida();
            datos[i][3]=lista.get(i).getHoraLlegada();
            datos[i][4]=lista.get(i).getPlazasOcupadas();
            datos[i][5]=lista.get(i).getPrecio();
        }
        return datos;
    }
    //comprueba si un vuelo diario esta disponible para modificar datos
    public static boolean vueloDiarioAptoModificaciones(VueloDiario vueloDiario){
      int valorfecha=ValidadorDatos.fechaCorrectaCreacionVuelos(vueloDiario.getFechaVuelo());
        if (valorfecha==0){
            LocalTime horaActual=LocalTime.now();
            int valorHora=vueloDiario.getHoraSlida().compareTo(horaActual);
            if (valorHora>0)return true;
            return false;
        }else if(valorfecha>0) return true;
        return false;  
    }
    //modifica el vuelo diario en la listacompleta y actual
    public static boolean modificarVueloDiario(VueloDiario original,VueloDiario nuevo){
        //se comprueba que no existe ningun vuelo asociado en lalista
        for(VueloDiario v:listaVuelosDiariosCompleta){
            if(v.equals(nuevo))return false;
        }
        original.setFechaVuelo(nuevo.getFechaVuelo());
        original.setHoraSlida(nuevo.getHoraSlida());
        original.setHoraLlegada(nuevo.getHoraLlegada());
        original.setPlazasOcupadas(nuevo.getPlazasOcupadas());
        original.setPrecio(nuevo.getPrecio());
        VueloDiario vd=getVueloDiarioListaCompleta(original.getCodigo());//vuelo en la lista completa
        modificarVueloDiario(vd, nuevo);
        //una vez modificado reordenamos lalista de vuelos diarios
        ordenarListaActualVuelosDiarios();
        return true;
    }
   
// </editor-fold> 


}
/*
Proceso de carga en memoria:
1. Se cargan los aeropuertos
2. se eligen el aeropuerto de origen y se carga la lista de aeroouertos destinos
3. Se cargan los vuelos base en memoria que tengan dentro de su arpto origen y detino el vuelo base elegido
4. Se asigna a cada vuelo base sus vuelos diarios
5. Cuando se añade un vuelo diario se añade a la original y a su vuelo base
6. Cuando se elimina un vuelo base hay que eliminar sus vuelos diario de la lista total de vyuelos diarios
*/