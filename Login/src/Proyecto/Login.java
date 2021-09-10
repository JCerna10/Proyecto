/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/*
  @author JCERNA10
 */
import java.io.*;
import java.nio.file.*;
import Proyecto.Log;
import java.util.Scanner;


public class Login {

   //atributos privados
    private Scanner scn = new Scanner(System.in);
    private String usuario;
    private String contrasena;
    private String tipoUsuario;
    private boolean primerInicio;
    private Log lo;

    public String[][] getDbUsers() {
        return dbUsers;
    }

    public String getUsuario() {
        return usuario;
    }
    private String[][] dbUsers = new String[9][4];
    private int cont;

    //constructor
    public Login() {
        this.usuario = "";
        this.contrasena = "";
        this.tipoUsuario = "";
        this.cont = 0;
        this.primerInicio = true;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    ///Usado para mostrar todos los usuarios guardados en la matriz y comproba que funciona, 
    ///luego servira para que el admin cambie contraseña
    public void mostrar() {
        System.out.println("ID\tUsuario\tContraseña");
        for (int i = 0; i < cont; i++) { //que imprima el contenido empezando por el cero
            System.out.println(this.dbUsers[i][0] + "\t" + this.dbUsers[i][2] + "\t" + this.dbUsers[i][3]);
        }
    }

    ///ingresar permite hacer el login, si este es correcto devuelve verdadero, de lo contrario falso
    public boolean ingresar() {
        boolean resultado = false; // para comprobar si cuenta y pass no coindicen con ninguna línea 
        String record = null;
        FileReader in = null; //lector de archivo
        //Se comprueba que el archivo con los usuarios exista, si no existe se puede agregar mientras el
        //programa aun esta corriendo antes de presionar enter
        if (!Files.exists(Paths.get("Usuarios.txt"))) { //paths.get la ruta para crear al documento
            System.out.println("El archivo de texto no se encontro, devuelvalo a su lugar");
            System.out.println("Presione enter para continuar...");
            new java.util.Scanner(System.in).nextLine();//leer cadena
        }
        try {
            
            in = new FileReader("Usuarios.txt");// creamos un nuevo objeto de la clase y le enviamos los parámetros según el constructor.
            BufferedReader br = new BufferedReader(in); //que lea el usuario //  lector del buffer

            //Leer usuario y contraseña
            System.out.println("Bienvenido al sistema de ventas Don Diego.");
            System.out.println("Favor ingresar credenciales.");
            System.out.print("Ingresar Usuario: ");
            this.usuario = scn.nextLine();
            System.out.print("Ingresar Contrasena: ");
            this.contrasena = scn.nextLine();
            if (this.primerInicio) {
         /*mientras */  while ((record = br.readLine()) != null) //el while leera todo el documento
                //Este método lee todos los caracteres, hasta que encuentra la pulsación de la tecla <INTRO>, <RETURN> 
         {
                    String[] palabra = record.split(","); // dividir en palabras delimitadas por espacios El método split() divide un objeto de tipo String en un array (vector) de cadenas mediante la separación de la cadena en subcadenas.
                    //aca abajo se rellena la matriz de usuarios
                    this.dbUsers[cont][0] = Integer.toString(cont + 1);// se utiliza para convertir a String 
                    this.dbUsers[cont][1] = palabra[0];
                    this.dbUsers[cont][2] = palabra[1];
                    this.dbUsers[cont][3] = palabra[2];
                    this.cont++;
                }
                this.primerInicio = false;
            }

            resultado = validarCredenciales(this.usuario, this.contrasena);
            if (!resultado)//Cuando no coincide usuario y contraseña
            {
                System.out.println("Usuario o contraseña incorrecto.");
            } else {
                System.out.println("Bienvenido otra vez " + this.usuario);
            }
            in.close();
        } catch (IOException e) {
            e.getCause();
            lo.setContenido(e.getMessage()); //nos devuelve una informacion detallada de la excepcion
            lo.escribirLog(this.usuario);
        }
        return resultado;
    }

    public boolean validarCredenciales(String user, String pass) {
        boolean resultado = false;
        int i = 0;
        /*mientras */while (i < this.dbUsers.length && !resultado) { //Este método devuelve la longitud de cualquier cadena que sea igual al número de caracteres 
            if (user.equals(this.dbUsers[i][2]) && pass.equals(this.dbUsers[i][3])) {// entonces saber si dos objetos son del mismo tipo y tienen los mismos datos. 
                this.tipoUsuario = this.dbUsers[i][1];// entonces el usario es el tipo de ADMIN O VENDEDOR O INVITADO
                resultado = true;
            } else {
                i++;
            }
        }
        return resultado;
    }

    public boolean cambiarContraseña() {
        boolean resultado = false;
        String pass;
        String id;
        int cod; //variable para capturar la contraseña en numeros 
        System.out.println("Escriba su contrasena de administrador");
        pass = this.scn.nextLine();
        if (pass.equals(this.contrasena)) { // SI ES IGUAL A LA CONTRASEÑA
            mostrar();
            System.out.println("Digite el id del usuario a cambiar contraseña");
            id = this.scn.nextLine();
            cod = Integer.parseInt(id);//QUE Convierta la cadena de texto en un números enteros
            if ((cod <= this.cont) && (cod > 0)) {
                System.out.println("Digite la nueva contrasena de " + this.dbUsers[Integer.parseInt(id) - 1][2]);
                pass = this.scn.nextLine();
                this.dbUsers[Integer.parseInt(id) - 1][3] = pass;
                resultado = true;
                System.out.println("La nueva contrasena del usuario " + this.dbUsers[Integer.parseInt(id) - 1][2] + " es " + this.dbUsers[Integer.parseInt(id) - 1][3]);
            } else {
                System.out.println("Error, el usuario con ese id no se encuentra");
            }
        } else {
            System.out.println("Error, su contrasena no coincide.");
        }
        return resultado;
    }
}
