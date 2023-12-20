
package com.aeropuertos.logica;


import com.aeropuertos.dto.VueloBase;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 * @author Victor Fernandez
 * Clase static que se utiliza para validar formatos de datos, formato IATA,formato de telefono
 * formatos Dias Opera,compara fechas y horas.
 */

public class ValidadorDatos {
   private static final String numerotlf="Formato:codigo pais + numero de hasta 12 digitos";
   private static final String prefijo="Formato:numero comprendido entre 1 y 999";
   private static final String codigo="Formato:dos vocales mayusculas o vocal mayuscula y digito";
   private static final SimpleDateFormat formatoHora=new SimpleDateFormat("HH:mm");
   private static final SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
   private static final SimpleDateFormat formatoFechaLocalDate=new SimpleDateFormat("yyyy-MM-dd");
   /**
    * Metodo que comprueba el formato de correcto de numero de telefono
    * @param numTelf numero de telefono
    * @param comp componente Swing
    * @return boolean true correcto, false incorrecto
    */
    public static boolean formatoTelefono(String numTelf,Component comp){
        if(numTelf.matches("[+]\\d{11,14}")){
            return true;
        }else{ 
            mostarErrores(numerotlf,"ERROR FORMATO TELEFONO",comp);
            return false;
        }
    }
    /**
     * metodo que retorna SimpleDateFormat HH:mm
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat getFormatoHora() {
        return formatoHora;
    }
    /**
     * metodo que retorna SimpleDateFormat dd/MM/yyyy
     * @return SimpleDateFormat
     */
    public static SimpleDateFormat getFormatoFecha() {
        return formatoFecha;
    }
    /**
     * metodo que comprueba el codigo de las compañias
     * @param codigo  Codigo de la compañia
     * @param p Componenete swing
     * @return boolean true correcto, false incorrecto
     */
    public static  boolean formatoCodigoCompania(String codigo,Component p){
         if (codigo.matches("[A-Z][1-9]"))return true;
        else if (codigo.matches("[A-Z][A-Z]"))return true;
        else{
            mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO CODIGO",p);
            return false;
        }
    }
    /**
     * metodo que comprueba el formato IATA
     * @return boolean true correcto, false incorrecto
     */
    public static boolean formatoIATA(String iata,Component p){
        if (iata.matches("[A-Z][A-Z][A-Z]"))return true;
        else{
            mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO IATA",p);
            return false;
        }
    }
    /**
     * metodo que comprueba los dias que opera un vuelo
     * @param dias Dias que opera una vuelo
     * @param p Compoenente swiong
     * @return boolean true correcto, false incorrecto
     */
    public static boolean formatoDiasOpera(String dias,Component p){
        if (dias.matches("[L]?[M]?[X]?[J]?[V]?[S]?[D]?")) return true;
        else{
            mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO DIAS QUE OPERA",p);
            return false;
        }
    }

    /**
     * metodo que compruba si la fecha de creacion de un vuelo es correcta
     * @param fecha fecha de salida del vuelo
     * @return int negatico fecha anterior, 0 mismo dia,positivo dia posterior
     */
    public static int fechaCorrectaCreacionVuelos(Date fecha){
        LocalDate fechaVuelo=LocalDate.parse(formatoFechaLocalDate.format(fecha));
        LocalDate fechaActual=LocalDate.now();//creamos una instancia del dia actual
        return fechaVuelo.compareTo(fechaActual);
    }
    /**
     * metodo que comprueba si la fecha coincide con los dias que opera el vuelobase
     * @param fechaVuelo fecha en la que se quiere opere el vuelo
     * @param v vuelobase  sobre el que se tarbaja
     * @return boolean true correcto, false incorrecto
     */
    public static boolean coincidenciaFechaDiasOpera(Date fechaVuelo,VueloBase v){
        String fechaVueloString=formatoFecha.format(fechaVuelo);//obtien la fecha vuelo en String
        LocalDate fecha=LocalDate.parse(fechaVueloString,DateTimeFormatter.ofPattern("dd/MM/yyyy"));//retoena una instancia de LocalDate de la fecha de vuelo con nuestrio formato
        DayOfWeek dia=fecha.getDayOfWeek();// retorna el dia de la semanana 
        //recorremos la fecha y comprueba si existe coincidencia en dua de la semanana
        for (int i=0;i<v.getDiasOpera().length();i++){
            if(v.getDiasOpera().charAt(i)==convertirDiaDelaSemana(dia)) return true;
        }
        return false;
       }
    /**
     * metodo que retorna un carcater en mayuscula correspondiente a los dias de la semana
     * segun el dia de la semana que recibe por parametro
     * @param dia dia de la semana
     * @return 'L'....'D'
     */
    private static char convertirDiaDelaSemana(DayOfWeek dia){
        switch(dia){
            case MONDAY -> {return 'L';}
            case TUESDAY -> {return 'M';}
            case WEDNESDAY -> {return 'X';}
            case THURSDAY -> {return 'J';}
            case FRIDAY -> {return 'V';}
            case SATURDAY -> { return 'S';}
            case SUNDAY -> {return 'D';}
            }
        return ' ';
    }
    /**
     * metodo que comprueba el foemato del precio medio billete
     * @param precio
     * @return boolean true correcto, false incorrecto
     */
    public static boolean formatoPrecio(String precio){
        if(precio.matches("\\d+,\\d+")) return true;
        else if(precio.matches("\\d+")) return true;
        return false;
        
    }
    /**
     * metodo que compara dos horas y retorna un entero  
     * @param date1 hora 1
     * @param date2 hora 2
     * @return int, negativo si hora 1 menor hora 2,0 iguales y positivo si es mayor
     */
    public static int compararHoras(Date date1,Date date2){
        //para poder comparar horas tenemos usar la clase LOCALTIME
        LocalTime localTime1=parseDateLocalTimeHora(date1);//conseguimos un localtime con la hora del date fecha1
        LocalTime localTime2=parseDateLocalTimeHora(date2);;//conseguimos un localtime con la hora del date fecha1
        return localTime1.compareTo(localTime2);
    }
    /**
     * metodo que compara dos fechas y retorna un entero
     * @param date1 fecha 1 
     * @param date2 fecha 2
     * @return int. negativo si fecha1 menor a fecha 2,0 iguales y positivo mayor
     */
    public static int compararFechas(Date date1,Date date2){
        LocalDate fecha1=parseDateLocalDateFecha(date1);
        LocalDate fecha2=parseDateLocalDateFecha(date2);
        return fecha1.compareTo(fecha2);
        
    }
    /**
     * metodo que compara una fecha con la fecha actual y retorna un entero
     * @param fecha
     * @return int, menor si la fecha es menor a la actual,0 igual y positivo mayor
     */
    public static int compararFechaActual(Date fecha){
        //solo se realiza cuando la fecha la actual o dias anteriores, se compara fecha actual con la fecha pasada
        LocalDate fechaActual=LocalDate.now();//fecha actual
        LocalDate fechaSolicitada=LocalDate.parse(formatoFechaLocalDate.format(fecha));
        return fechaSolicitada.compareTo(fechaActual);
    }
    /**
     *metodo de casting de Date a LocalTime
     * @param date
     * @return LocalTime
     */
    public static LocalTime parseDateLocalTimeHora(Date date){
        //para poder comparar horas tenemos usar la clase LOCALTIME
        String dateString=formatoHora.format(date);//string del date con el formato HH:mm
        return LocalTime.parse(dateString);//conseguimos un localtime con la hora del date fecha1
        
    }
    /**
     * metodo de casting de Date a LocalDate
     * @param date
     * @return LocalDate
     */
    public static LocalDate parseDateLocalDateFecha(Date date){
        String fechaString=formatoFecha.format(date);
        return LocalDate.parse(fechaString,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
    }
    /**
     * 
     * @param mensaje mensaje que se quiere mostarr
     * @param titulo titulo del JOptionPanel
     * @param p component padre del JOptionPanel
     */
    protected static void mostarErrores(String mensaje,String titulo,Component p){    
        JOptionPane.showMessageDialog(p, mensaje,titulo,JOptionPane.ERROR_MESSAGE);
    }
}
