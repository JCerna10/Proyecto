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

    private Scanner teclado;
    private String usuario;
    private String Contraseña;
    private String nivel;
    int i;

    public login() {
    }

    public login(String usuario, String Contraseña, String nivel) {
        this.usuario = usuario;
        this.Contraseña = Contraseña;
        this.nivel = nivel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void inicializar() {
        teclado = new Scanner(System.in);
        System.out.print("Bienvenido al sistema de ventas\n");
        System.out.print("Favor ingresar usuario y contraseña\n");
        do {
            System.out.print("Ingrese su usuario: ");
            usuario = teclado.next();
            System.out.print("Ingrese su Contraseña: ");
            Contraseña = teclado.next();
            if (usuario.isEmpty() || Contraseña.isEmpty()) {
                System.out.print("Error, falta usuario o contraseña");
            } else {
                if (usuario.equals("admin") && Contraseña.equals("admin123")) {
                    System.out.print("Bienvenido " + usuario);
                    int i = 0;

                } else {
                    if (usuario.equals("vendedor") && Contraseña.equals("vendedor123")) {
                        System.out.print("Bienvenido " + usuario);
                        i = 0;

                    } else {
                        if (usuario.equals("invitado") && Contraseña.equals("invitado123")) {
                            System.out.print("Bienvenido " + usuario);
                            i = 0;

                        } else {
                            System.out.print("Error, su Usuario o Contraseña son incorrectos");
                        }
                    }
                }
            }

        } while (i > 0);
    }
}
