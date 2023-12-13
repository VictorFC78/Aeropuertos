
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


public class ValidadorDatos {
   private static final String numerotlf="Formato:codigo pais + numero de hasta 12 digitos";
   private static final String prefijo="Formato:numero comprendido entre 1 y 999";
   private static final String codigo="Formato:dos vocales mayusculas o vocal mayuscula y digito";
   private static final SimpleDateFormat formatoHora=new SimpleDateFormat("HH:mm");
   private static final SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
   private static final SimpleDateFormat formatoFechaLocalDate=new SimpleDateFormat("yyyy-MM-dd");
    public static boolean formatoTelefono(String numTelf,Component p){
        if(numTelf.matches("[+]\\d{11,14}")){
            return true;
        }else{ 
            mostarErrores(numerotlf,"ERROR FORMATO TELEFONO",p);
            return false;
        }
        
    }

    public static SimpleDateFormat getFormatoHora() {
        return formatoHora;
    }

    public static SimpleDateFormat getFormatoFecha() {
        return formatoFecha;
    }
    
    public static  boolean formatoCodigoCompania(String codigo,Component p){
         if (codigo.matches("[A-Z][1-9]"))return true;
        else if (codigo.matches("[A-Z][A-Z]"))return true;
        else{
            mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO CODIGO",p);
            return false;
        }
    }
    public static boolean formatoCodigoVuelo(String codigo,Component p){
         if (codigo.matches("\\d{1,4}"))return true;
        
        else{
            mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO CODIGO",p);
            return false;
        }
    }
    public static boolean formatoIATA(String iata,Component p){
         if (iata.matches("[A-Z][A-Z][A-Z]"))return true;
        else{
                mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO IATA",p);
        
            return false;
        }
    }
    public static boolean formatoHora(String hora,Component p){
        if(hora.matches("\\d{2}:\\d{2}"))return true;
        else{
                mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO HORA",p);
        
            return false;
        }
    }
    public static boolean formatoNumVuelo(String vuelo,Component p){
        if(vuelo.matches("\\d{1,4}")) return true;
        else{
                mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO NUMERO VUELO",p);
        
            return false;
        }
    }
    public static boolean formatoDiasOpera(String dias,Component p){
        if (dias.matches("[L]?[M]?[X]?[J]?[V]?[S]?[D]?")) return true;
        else{
                mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO DIAS QUE OPERA",p);
        
            return false;
        }
    }
    public static boolean formatoPlazas(String plazas,Component p){
        if(plazas.matches("\\[1-9]{1,3}")) return true;
        else{
            mostarErrores(ValidadorDatos.codigo,"ERROR FORMATO PLAZAS",p);
            return false;
        }
    }
    //comprueba que el vuelo que se va a crear tiene un fecha igual o superior al dia de creacion
    public static int fechaCorrectaCreacionVuelos(Date fecha){
        LocalDate fechaVuelo=LocalDate.parse(formatoFechaLocalDate.format(fecha));
        LocalDate fechaActual=LocalDate.now();//creamos una instancia del dia actual
        return fechaVuelo.compareTo(fechaActual);
    }
    //comorueba si la fecha introducida coincide con dias de la semana que opera el vuelo
    public static boolean coincidenciaFechaDiasOpera(Date fechaVuelo,VueloBase v){
        DateTimeFormatter dformato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaVueloString=formatoFecha.format(fechaVuelo);//obtien la fecha vuelo en String
        LocalDate fecha=LocalDate.parse(fechaVueloString, dformato);//retoena una instancia de LocalDate de la fecha de vuelo con nuestrio formato
        DayOfWeek dia=fecha.getDayOfWeek();// retorna el dia de la semanana 
        //recorremos la fecha y comprueba si existe coincidencia en dua de la semanana
        for (int i=0;i<v.getDiasOpera().length();i++){
            if(v.getDiasOpera().charAt(i)==convertirDiaDelaSemana(dia)) return true;
        }
        return false;
       }
    //retorna un caracter asociado al dia de la semana
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
    //comprueba el formato del precio
    public static boolean formatoPrecio(String precio){
        if(precio.matches("\\d+,\\d+")) return true;
        else if(precio.matches("\\d+")) return true;
        return false;
        
    }
    //compreba que una hora pasada por primer parametro es mayor menor o igual
    public static int compararHoras(Date date1,Date date2){
        //para poder comparar horas tenemos usar la clase LOCALTIME
        LocalTime localTime1=parseDateLocalTimeHora(date1);//conseguimos un localtime con la hora del date fecha1
        LocalTime localTime2=parseDateLocalTimeHora(date2);;//conseguimos un localtime con la hora del date fecha1
        return localTime1.compareTo(localTime2);
    }
    //retorna valor negivo si date1 menor date2 ,0 igual y positivo mayor
    public static int compararFechas(Date date1,Date date2){
        LocalDate fecha1=parseDateLocalDateFecha(date1);
        LocalDate fecha2=parseDateLocalDateFecha(date2);
        return fecha1.compareTo(fecha2);
        
    }
    public static int compararFechaActual(Date fecha){
        //solo se realiza cuando la fecha la actual o dias anteriores, se compara fecha actual con la fecha pasada
        LocalDate fechaActual=LocalDate.now();//fecha actual
        LocalDate fechaSolicitada=LocalDate.parse(formatoFechaLocalDate.format(fecha));
        return fechaSolicitada.compareTo(fechaActual);
    }
    //parsea un Date a LocatIme
    public static LocalTime parseDateLocalTimeHora(Date date){
        //para poder comparar horas tenemos usar la clase LOCALTIME
        String dateString=formatoHora.format(date);//string del date con el formato HH:mm
        return LocalTime.parse(dateString);//conseguimos un localtime con la hora del date fecha1
        
    }
    public static LocalDate parseDateLocalDateFecha(Date date){
        String fechaString=formatoFecha.format(date);
        return LocalDate.parse(fechaString,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
    }
    protected static void mostarErrores(String mensaje,String titulo,Component p){    
        JOptionPane.showMessageDialog(p, mensaje,titulo,JOptionPane.ERROR_MESSAGE);
    }
}
