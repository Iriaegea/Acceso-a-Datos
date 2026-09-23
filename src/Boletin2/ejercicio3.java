package Boletin2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ejercicio3 {
    static File cosa1 = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\pares.txt");
    static File cosa2 = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\impares.txt");

    public static void crearFicheros(){

        try{
            cosa1.createNewFile();
            cosa2.createNewFile();
        } catch(IOException e){
            System.out.println("Error al craer un archivo");
        }


        try{
            FileWriter escritor1 = new FileWriter("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\pares.txt");
            FileWriter escritor2 = new FileWriter("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\impares.txt");
            for (int i = 1; i <=10 ; i++) {
                if(i%2 == 0){
                    escritor1.write(String.valueOf(i));
                } else {
                    escritor2.write(String.valueOf(i));
                }
            }
        } catch(IOException e){
            System.out.println("Error al escribir el archivo");
        }



    }




    public static String leerPares(){
        try{

        }catch(){

        }
    }


    public static String leerImpares(){

    }

    static void main() {
        boolean seguir = true;
        String linea = "hola";

        crearFicheros();


        while(seguir){
        leerPares();
        linea = leerImpares();

        if(linea = null){
            seguir = false;
        }

        }




    }
}
