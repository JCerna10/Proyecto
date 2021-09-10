/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.io.BufferedWriter; //almacenando en el búfer caracteres que leen a la perfección caracteres, matrices o líneas.
import java.io.File; //representa un fichero o directorio de nuestro sistema de archivos. También nos es útil ya que puede pasarse como parámetro para las principales clases que manejan ficheros, como FileReader, FileInputStream, FileWriter
import java.io.FileWriter; //nos permiten leer y escribir datos y de archivos. O Podemos abrir un fichero de texto para leer usando la clase FileReader
import java.util.Calendar; //para convertir entre un objeto de tipo Date y un conjunto de campos enteros como(año),(mes),(día), hora), etc.
import java.util.GregorianCalendar; //es una implementación del calendario gregoriano que es usado en casi todo el mundo (es el que conocemos).
/**
 *
 * @author roger
 */
public class Log {
    //atributo privado
    private String contenido;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido += contenido + "\n";
    }

    public Log() {
        this.contenido = "";
    }
    //atributos privadas
    private String fecha, dia, mes, anio;
    private Calendar c;
    private int hora = 0, minutos = 0, segundos = 0;
    private Calendar calendario;
    private String dato;

    public void escribirLog(String user) { // en este metodo para leer el código almacenado.
        this.c = new GregorianCalendar();
        this.calendario = Calendar.getInstance();
        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH) + 1);
        anio = Integer.toString(c.get(Calendar.YEAR));
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        fecha = dia + "-" + mes + "-" + anio;
        dato = user + "_" + fecha + "_" + hora + ":" + minutos + ":" + segundos + "_";
        
        //se creal el archivo y se escribe dentro de el lo que contiene 
        //variable dato + contenido
        try {
            File file = new File("log/LG" + "_" + fecha + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);//abrir el fichero de texto para leer usando FileReader
            BufferedWriter bw = new BufferedWriter(fw); // almacenando en el búfer 
            bw.write(dato + contenido);
            bw.newLine();
            bw.close();
            this.contenido = "";
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
