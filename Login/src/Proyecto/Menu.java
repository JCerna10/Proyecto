/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.util.Scanner;
import Proyecto.Login;
import Proyecto.Bitacora;
import Proyecto.Ventas;
import Proyecto.Log;
import Proyecto.Catalogo;

/**
 *
 * @author JCERNA10
 */
public class Menu {

    private Scanner teclado;

    public void MenuAdmin(Login l, Ventas[] v, Catalogo[] catalogo, int contVentas, Log lo) {
        int opcion = 0;

        Bitacora b = new Bitacora();
        teclado = new Scanner(System.in);
        do {
            System.out.println("Bienvenido" + " ");
            System.out.println("1. Venta Nueva");
            System.out.println("2. Consultar inventarios");
            System.out.println("3. Cambiar contraseña");
            System.out.println("4. Cerrar sesión");
            System.out.print("Digite la opcion: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                //REALIZAR VENTA
                case 1:
                    v[0].mostrarCatalogoVenta(catalogo);
                    v[contVentas].agregarProductos(catalogo, contVentas, l, lo);
                    break;
                case 2:
                    //CONSULTAR INVENTARIOS
                    v[0].consultarInventario(catalogo, l);
                    break;
                case 3:
                    //CAMBIAR CONTRASEÑA     
                    if (l.cambiarContraseña()) {
                        b.cerrarSesion(l, lo);
                        System.out.print("Volviendo a la pantalla de inicio de sesion");
                        opcion = 4;
                    }
                    break;
                case 4:
                    //SALIR DEL SISTEMA
                    b.cerrarSesion(l, lo);
                    System.out.println("Saliendo del sistema....");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            System.out.println();
        } while (opcion != 4);
    }
  
    
    public void MenuVendedor(Login l, Ventas[] v, Catalogo[] catalogo, int contVentas, Log lo) {
        int opcion = 0;
        Bitacora b = new Bitacora();
        teclado = new Scanner(System.in);
        do {
            System.out.println("Bienvendio" + " ");
            System.out.println("1. Venta Nueva");
            System.out.println("2. Consultar inventarios");
            System.out.println("3. Cerrar sesión");
            System.out.print("Digite la opcion: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                //REALIZAR VENTA
                case 1: {
                    v[0].mostrarCatalogoVenta(catalogo);
                    v[contVentas].agregarProductos(catalogo, contVentas, l, lo);
                }
                break;
                case 2:
                    //CONSULTAR INVENTARIOS
                    v[0].consultarInventario(catalogo, l);
                    break;
                case 3:
                    //SALIR DEL SISTEMA  
                    b.cerrarSesion(l, lo);
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            System.out.println();
        } while (opcion != 3);
    }

    public void MenuInvitado(Login l, Ventas[] v, Catalogo[] catalogo, int contVentas, Log lo) {
        int opcion = 0;
        Bitacora b = new Bitacora();
        teclado = new Scanner(System.in);
        do {
            System.out.println("Bienvendio" + " ");
            System.out.println("1. Consultar precios");
            System.out.println("2. Cerrar sesión");
            System.out.print("Digite la opcion: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                //CONSULTAR PRECIOS
                case 1: {
                    System.out.println("Consultando precios...");
                    v[0].mostrarCatalogoVenta(catalogo);
                }
                break;
                case 2:
                    //SALIR DEL SISTEMA   
                    b.cerrarSesion(l, lo);
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            System.out.println();
        } while (opcion != 2);
    }

}
