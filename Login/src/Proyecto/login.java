/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/*
  @author JCERNA10
 */
import java.util.Scanner;

public class login {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int login = 0, pass = 0, intentos = 1, maximo = 2;

        while ((login != 1010) || (pass != 1111) && (intentos < maximo)) {

            System.out.print("Ingreso Usuario: ");
            login = teclado.nextInt();

            System.out.print("Ingrese Contraseña:");
            pass = teclado.nextInt();

            if (intentos == 3) {
                System.out.println("acceso denegado..");
                intentos = intentos - maximo;
            }

            intentos++;

        }

        System.out.println("usuario y contraseña correcta ");

    }

}
