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
import java.util.Optional;
import java.util.stream.Collectors;



/**Clase LogicaNegocio, clase static que contiene toda la logica para gestion de la aplicacion
 *@author Victor Fernandez
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
    /**
     * metodo que inicializa todo la aplicacion cargando en memoria los aeropuertos, compañias,
     * vuelos base y vuelos diarios, para ello se apoya de las clases Persistencia,ApiCsv y DocumentoCsv
     */
    public static void inicializarSistema(){
        Persistencia.leerMunicipiosCsv();
        Persistencia.leerListaAeropuertosCsv();//cargar la lista de aeropuerto en el sistema
        Persistencia.leerCompaniaAereasCsv();//cargamos en memoria la lista de companias
        Persistencia.leerListaVuelosBaseCsv();//cargamos todo los vuelos base exixtente
        Persistencia.leerListaVuelosDiariosCsv();//cargamos todo los vuelos diarios en memoria
        //la asigancion de aeropuerto base, vuelos base y vuelos diarios se realiz cuando se agina el aeropuerto base
    }
    /**
     * @return  APIKEY, retorna un string que contiene la contraseña para una ApiRestFull
     */
    public static String getApiKey(){
        return APIKEY;
    }
    /**************************Municipios*********************************************/
    /**
     * metodo que añade un municipio a la lista de municipios en memoria
     * @param municipio 
     */
    public static void anaidirMunicipioLista(Municipio municipio){
        listaMunicipio.add(municipio);
    }
    /**
     * metodo que retorna la lista de minicipios en memoria
     * @return Lista de Municipios
     */
    public static List<Municipio> getListaMunicipios(){
        return listaMunicipio;
    }

    // <editor-fold defaultstate="collapsed" desc="Aeropuertos">  
    /******************************* Aeropuertos ***************************************/
    /**
     * metodo que retorna un Aeropuerto por su codigo IATA
     * @param iata codigo IATA del aeropuerto
     * @return el Aeropuerto con codigo IATA correspondiente
     */
    public static Aeropuerto getAeropuertoCodigo(String iata){
        for (Aeropuerto a:listaAeropuertos){
            if(a.getIata().equals(iata)) return a;
        }
        return null;
    }
    /**
     * metodo que establece el aeropuertobase de la aplicacion y crea un lista de aeropuertos destino
     * @param aeropuerto 
     */
    public static void setAeropuertoBase(Aeropuerto aeropuerto){
        aeropuertoOrigen=aeropuerto;
        rellenarListaAeropuetosDestino();
    }
    /**
     * metodo que retorna en aeropuerto base de la aplicacion
     * @return retona aeropuerto base
     */
    public static Aeropuerto getAeropuertoOrigen(){
       return aeropuertoOrigen;
    }
    /**
     * rellena una lista con los aeropuertos de destino de la aplicacion
     */
    private static void rellenarListaAeropuetosDestino(){
//        for (Aeropuerto a:listaAeropuertos){
//            if(!a.equals(aeropuertoOrigen))listAeropuertosDestino.add(a);
//        }
         listAeropuertosDestino=listaAeropuertos.stream()
                 .filter(p->!p.equals(aeropuertoOrigen)).collect(Collectors.toList());
    }
    /**
     * añade un aeropuerto a la lista inicial de aeropuertos
     * @param aeropuerto aeropuerto a añadir a la lista
     */
    public static void anaidirAeropuertoLista(Aeropuerto aeropuerto){
        listaAeropuertos.add(aeropuerto);
    }
    /**
     * metodo que retorna la lista de aeropuertos de destino
     * @return lista de aeropuertos de destino
     */
    public static List<Aeropuerto> getListaAeropuetosDestino(){
        return listAeropuertosDestino;
    }
    /**
     * retorna la lista original de aeropuertos
     * @return lista de aeropuertos
     */
    public static List<Aeropuerto> getListaAeropuertosOriginal(){
        return listaAeropuertos;
    }// </editor-fold> 
    /**************************************************************************************/
    // <editor-fold defaultstate="collapsed" desc="Compañias">  
    /************************** Compañias Aereas********************************************/
    /**
     * metodo que retorna una compañia por su codigo
     * @param codigo Codigo de la compañia
     * @return compañia
     */
    public static CompaniaAerea getCompaniaAerea(String codigo){
//        for (CompaniaAerea a:listaCompaniaAerea){
//            if(a.getCodigo().equals(codigo))return a;
//        }
//        return null;
        Optional<CompaniaAerea> op=listaCompaniaAerea.stream().filter(p->p.getCodigo().equals(codigo)).findFirst();
        return op.isPresent()? op.get():null;
    }
    /**
     * metodo que retorna una compañia aerea por su posicion en la lista
     * @param posicion posicion de la compañia en la lista
     * @return CompaniaAerea
     */
    public static CompaniaAerea getCompaniaAerea(int posicion){
        return listaCompaniaAerea.get(posicion);
    }
    /**
     * metodo que comprueba si existe en la lista una compañia con los mismos datos que una compañia recien creada
     * @param compania compañia que se quiere buscar coincidencia en la lista
     * @return boolean, true si existe coincidencia, flase si no.
     */
    public static boolean coincidenciaCompaniaAerea(CompaniaAerea compania){
       for (CompaniaAerea a:listaCompaniaAerea){
           if(a.equals(compania))return true;
       }
       return false;
    }
    
    /**
     * metodo que elimina una compañia de la lista segun su codigo
     * @param codigo Codigo de la comapañia a eliminar
     * @return boolean, true si la elimina, false no
     */
    public static boolean eliminarCompaniaAerea(String codigo){
        //recupera la lista de vuelos base pertenecientes a una compañia
        List<VueloBase>lista=buscarVuelosBaseCodigoCompania(codigo);
        //eliminamos los vuelo base de la lista completa y los eliminamos de la lista actula 
//        for (VueloBase v:lista){
//            eliminarVueloBase(v.getCodigo());
//        }
        lista.forEach(v->eliminarVueloBase(v.getCodigo()));
        Iterator<CompaniaAerea> it=listaCompaniaAerea.iterator();
        while(it.hasNext()){
            if(it.next().getCodigo().equals(codigo)){
                it.remove();
                return true;
            }    
        }
       return false; 
    }
    /**
     * metodo que añade una compañia aerea a la lista de compañias
     * @param compania compañia que se quiere añadir a la lista
     */
    public static void anaidirCompaniaAerea(CompaniaAerea compania){
        listaCompaniaAerea.add(compania);    
    }
    /**
     * metodo que retorna la lista de compañias aereas
     * @return lista de compañias aereas
     */
    public static List<CompaniaAerea> getListaCompaniasAereas(){
        return listaCompaniaAerea;
    }
    /**
     * metodo que ajusta el prefijo de las compañias aereas para cuando se crea una nueva compañia aerea
     * que no exista ya en el archivo el prefijo
     */
    public  static void setPrefijo(){
        for(CompaniaAerea c:listaCompaniaAerea){
            CompaniaAerea.inicializarPrefijo(c.getPrefijo());
        }
    }
    /**
     * metodo que extrae todos los atributos de todas las compañias aereas y los devuelve en 
     * una matriz aobject
     * @return matrtiz Object 
     */
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
    /**
     * metodo que añade un vuelo base a la lista completa de vuelos base
     * @param vuelo vuelo base que se quiere añadir a la lista
     */
    public static void  anaidirVueloBaseListaCompleta(VueloBase vuelo){
        listaVuelosBaseCompleta.add(vuelo);
    }
    /**
     * metodo que añade un vuelo base a lista completa de vuelos base y a la lista de vuelos base 
     * que se haya cargado en el sistema segun aeropuerto seleccionado,sino existe coincidencia en las listas
     * @param vuelo vuelo que se quiere añadir a la lista
     * @return boolean, true si lo añade, false si no
     */
    public static boolean anaidirVueloBase(VueloBase vuelo){
        for (VueloBase v:listaVuelosBaseCompleta){//comprueba que no exista un vuelo identico
            if (v.equals(vuelo))return false;
        }
        listaActualVuelosBase.add(vuelo);//lo añade al la lista actual de trabajo
        listaVuelosBaseCompleta.add(vuelo);//lo añade a la lista total 
        return true;
    }
    /**
     * metodo que rellena una lista de vuelos base dependiendo del,aeropuerto que escoga como base 
     * descartando todos aquellos que no tengan el aeropuerto base entre su origen o destino
     */
    public static void rellenarListaActualVuelosBase(){
        for(VueloBase v:listaVuelosBaseCompleta){
            if(v.getOrigen().equals(aeropuertoOrigen) || v.getDestino().equals(aeropuertoOrigen)){
                listaActualVuelosBase.add(v);
            }
        }
    }
    
    /**
     * metodo que retorna la lista de vuelos base que contienen el aeropuerto base entre su
     * aeropuerto origen o destino
     * @return lista de vuelos base actual
     */
    public static List<VueloBase> getListaActualVuelosBase(){
        return listaActualVuelosBase;
    }
    /**
     * metodo que recupera  la lista de vuelos baase completa
     * @return lista de vuelos base completa
     */ 
    public static List<VueloBase> getListaVueloBaseCompleta(){
        return listaVuelosBaseCompleta;
    }
    /**
     * metodo que retorna un vuelo base segun su codigo
     * @param codigo Codigo del vuelo baase
     * @return vuelo base sellecionado
     */
    public static VueloBase getVueloBaseListaompleta(String codigo){
        for (VueloBase v:listaVuelosBaseCompleta){
            if (v.getCodigo().equals(codigo)) return v;
        }
        
        return null;
    }
    /**
     * metodo que retorna un vuelo base de la lista actula segun su codigo
     * @param codigo Codigo del vuelo base
     * @return el vuelo base seleccionado o null
     */
    public static VueloBase getVueloBaseListaActual(String codigo){
        for (VueloBase v:listaActualVuelosBase){
            if (v.getCodigo().equals(codigo)) return v;
        }
        return null;
    }

    /**
     * metodo que recupera un vuelo base segun su posicion en la lista actiual
     * @param pos posicion del vuelo en la lista actual
     * @return vuelo base buscado o null
     */
    public static VueloBase getVueloBaseListaActual(int pos){
        return listaActualVuelosBase.get(pos);
    }
    /**
     * metodo que elimina un vuelo base de todas la listas, lista actual y lista completa
     * por su codigo
     * @param codigo  Codigo del vuelo base a eliminar
     */
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
    
    /**
     * metodo que modifica los atributos de un vuelo diario
     * @param original vuelo base original, vuelo a modificar
     * @param datosNuevos vuelo base con los datos nuevos 
     * @return boolean, true si realizo la modificacion, false si no.
     */
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
    /**
     * metodo que extrae todos los atributos de todos los vuelos base de la lista actual
     * y los retorna en una matriz object
     * @return matriz Object 
     */
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
    /**
     * metodo que retorna una lista de vuelos base pertenecientes a una compañia segun el codigo
     * de la compañia
     * @param codigo Codigo de la compañia
     * @return lista vuelos base
     */
    private static List<VueloBase> buscarVuelosBaseCodigoCompania(String codigo){
        //los codigo de vuelo contienen las dos iniciales de la compania  a la que pertenecen
        List<VueloBase> lista=new ArrayList<>();
//       for(VueloBase v:listaActualVuelosBase){
//           if(v.getCodigo().contains(codigo)){
//               lista.add(v);
//           }
//       }
       listaActualVuelosBase.forEach(vb->{
           if(vb.getCodigo().contains(codigo))lista.add(vb);
       });
       return lista;
    }// </editor-fold> 
    /**************************************************************************************/
    // <editor-fold defaultstate="collapsed" desc="Vuelos Diarios">  
    /************************** Vuelos Diarios********************************************/
    /**
     * metodo que añade un vuelo diario a la lista completa
     * @param vuelo vuelo diario que se quiere añadir
     */
    public static void anaidirVueloDiarioListaCompleta(VueloDiario vuelo){
        listaVuelosDiariosCompleta.add(vuelo);
    }
    /**
     * metodo que añade un vuelo diario a la lista de vuelos diarios corresponieente del vuelo base
     * del que depende
     * @param vueloBase vuelo base 
     * @param vueloDiario vuelo diario a añadir a lista vuelos diarios del vuelo base
     * @return boolean, true si lo añade, false si no.
     */
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
    /**
     * metodo que rellena la lista actual de vuelos diarios, vuelos que contengan al aeropuerto base 
     * entre su aeropuerto origen o destino
     */
    public static void rellenarListaActualVuelosDiarios(){
        for (VueloBase v:listaActualVuelosBase){
            for(int i=0;i<v.getVuelosDiario().size();i++){
                listaActualVuelosDiarios.add(v.getVuelosDiario().get(i));
            }
        }
        ordenarListaActualVuelosDiarios();
    }
    /**
     * metodo que ordena la lista actual y completa de vuelos diarios de forma ascendente
     * en fecha y hora
     */
    private static void ordenarListaActualVuelosDiarios(){
        Collections.sort(listaActualVuelosDiarios,(v1,v2)->{
            return v1.getHoraSlida().compareTo(v2.getHoraSlida());
        });
        Collections.sort(listaActualVuelosDiarios, (v1,v2)->{
            SimpleDateFormat formato =new SimpleDateFormat("yyyy-MM-dd");
            LocalDate dateVule1=LocalDate.parse(formato.format(v1.getFechaVuelo()));
            LocalDate dateVule2=LocalDate.parse(formato.format(v2.getFechaVuelo()));
            return dateVule1.compareTo(dateVule2);
        });
        //Collections.sort(listaActualVuelosDiarios, new ComparadorVuelosFecha());   
    }
    /**
     * metodo que retorna la lista completa de vuelos diarios
     * @return lista completa vuelos diarios
     */
    public static List<VueloDiario> getListaVuelosDiariosCompleta(){
        return listaVuelosDiariosCompleta;
    }
    /**
     * metodo que retorna la lista actiual de vuelos diarios, lista que depende del
     * aeropuerto base seleccionado
     * @return lista actual vuelos diarios
     */
    public static List<VueloDiario> getListaActualVuelosDiarios(){
        return listaActualVuelosDiarios;
    }
    /**
     * retorna un vuelo diario de la lista actual segun su posicion en la lista
     * @param pos posicion del vuelo buscado
     * @return vuelo diario buscado
     */
    public static VueloDiario getVueloDiarioListaActual(int pos){
        return listaActualVuelosDiarios.get(pos);
    }
    /**
     * metodo que retorna un vuelo diario segun su codigo
     * @param codigo codigo de vuelo diario buscado
     * @return vuelo diario buscado
     */
    public static VueloDiario getVueloDiarioListaActual(String codigo){
//        for (VueloDiario v:listaActualVuelosDiarios){
//            if (v.getCodigo().equals(codigo))return v;
//        }
        VueloDiario v=(VueloDiario)listaActualVuelosDiarios.stream()
                .filter(v1->v1.getCodigo().equals(codigo));
        return v;
        //return null;
    }
    /**
     * metodo que retorna un vuelo diario de la lista completa segun su codigo
     * @param codigo Codigo del vuelo buscado
     * @return vuelo diario o null
     */
    private static VueloDiario getVueloDiarioListaCompleta(String codigo){
        for (VueloDiario v:listaVuelosDiariosCompleta){
            if (v.getCodigo().equals(codigo)) return v;
        }
        return null;
    }
    /**
     * metodo que retorna una lista de vuelos diarios que tengan como aeropuerto de origen
     * el aeropuerto base
     * @return lista de vuelos diarios
     */
    private static List<VueloDiario> getListaVuelosDiariosSalida(){
        List<VueloDiario> lista=new ArrayList<>();
        for (VueloDiario v:listaActualVuelosDiarios){
            VueloBase vb=getVueloBaseListaActual(v.getCodigo());
            if (vb.getOrigen().equals(aeropuertoOrigen) ) lista.add(v);   
        }
        return lista;
    }
    /**
     * metodo que retorna una lista de vuelos diarios cuyo aeropuerto de destino sea el aeropuerto base
     * @return lista vuelos diarios
     */
    private static List<VueloDiario> getListaVuelosDiariosLlegada(){
        List<VueloDiario> lista=new ArrayList<>();
        for (VueloDiario v:listaActualVuelosDiarios){
            VueloBase vb=getVueloBaseListaActual(v.getCodigo());
            if (vb.getDestino().equals(aeropuertoOrigen) ) lista.add(v);   
        }
        return lista;
    }
    /**
     * metodo que retorna una lista de vuelos diarios que coincidan con una fecha
     * @param lista lista de vuelos diarios donde se busca los vuelos con misma fecah
     * @param fecha fecha de los vuelos
     * @return lista vuelos diarios
     */
    private static List<VueloDiario> getVuelosDiariosCoincidenciaFecha(List<VueloDiario> lista,Date fecha){
        List<VueloDiario> listafinal=new ArrayList<>();
        for (VueloDiario v:lista){
            if(ValidadorDatos.compararFechas(fecha, v.getFechaVuelo())==0)listafinal.add(v);
        }
        return listafinal;
    }
    /**
     * metodo que retorna una lista de vuelos diarios que coincidan con una fecha, segun el parametro tipo de vuelo
     * true para vuelos cuuyo aeropuerto origen sea igual al aeropuerto base y false el de destino
     * @param fecha fecha de busqueda
     * @param tipoVuelo true vuelo salida, flase vuelo llegada
     * @return 
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
    /**
     * metodo que retorna una lista de vuelos diarios que pertenezca a una compañia y una fecha concreta
     * @param fecha fecha de busqueda
     * @param compania compañia de busqueda
     * @return lista de vuelos diarios
     */
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
    /**
     * metodo que retorna una lista de vuelos diarios segun su aeropuerto de destino, 
     * y cuya fecha de salida sea la actual hasta una semana en adelante
     * @param destino aeropuerto de destino
     * @return lista vuelos diarios
     */
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
    /**
     * retorna una lista de vuelos diarios de una determinada fecha, siempre igual o menor a la actual
     * y de vuelod que ya hayan despegado.z
     * @param fecha fecha de busqueda
     * @return  lista vuelos diarios o null
     */
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
    /**
     * metodo que elimina un vuelo diario de la lista de vuelo base,de la lista actual y completa
     * @param vueloDiario vuelo diario a eliminar
     * @return  boolean, true si se elimina, false si no.
     */
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

    /**
     * metodo que asigan los vuelos diarios a los vuelos base a los que pertenecen
     */
    public static void referenciarVuelosDiarioVueloBase(){
        for (VueloBase vb:listaVuelosBaseCompleta){
            String codigo=vb.getCodigo();
            for (VueloDiario vd:listaVuelosDiariosCompleta){
                if (vd.getCodigo().equals(codigo))vb.getVuelosDiario().add(vd);
            }
        }
    } 

    /**
     * extrae todos los atributos de todos los vuelos diarios de una lista y los devuelve en una matriz de objetos
     * @param lista liusta de vuelos diarios
     * @return matriz Object
     */
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
    /**
     * metodo que comprueba si un vuelo es apto para modificar sus atributos
     * @param vueloDiario vuelo que se quiere modificar
     * @return  boolean, true si se puede modificar, false si no.
     */
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
    /**
     * metodo que modifica los atributos de un vuelo diario
     * @param original vuelo diario a modificar
     * @param nuevo vuelo diario con los nuevos datos
     * @return boolean si se modifico, false sino
     */
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
