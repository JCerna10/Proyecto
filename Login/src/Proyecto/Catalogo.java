/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author roger
 */
public class Catalogo {

    public Catalogo() {
        super();
    }

    public static void main(java.lang.String[] args) {

        // Definimos una ArrayList
        List<String> list = new ArrayList<>();

        // Añadimos elementos
        list.add("HUEVOS");
        list.add("POLLO");
        list.add("FOSFOROS");
        list.add("DULCES");
        list.add("MARGARINA");
        list.add("JABON");
        list.add("CARNE");
        list.add("GASEOSA");
        list.add("DESECHABLES");

        // Obtenemos un Iterador y recorremos la lista.
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}

     

