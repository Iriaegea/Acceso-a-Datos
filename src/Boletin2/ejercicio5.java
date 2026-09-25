package Boletin2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ejercicio5 {
    static void main() {
        try{
            FileWriter escritor = new FileWriter("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\holav2.java");
            BufferedReader lector = new BufferedReader(new FileReader("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\hola.java"));
            String liña;
            String pegar;
            String frase;
            while((liña = lector.readLine())!=null){
                pegar = "";
                frase = liña.toString();
                for(String letra : liña){

                }

            }
            escritor.close();
            lector.close();
        }catch (IOException e){
            System.out.println("Error al leer el archivo");
        }

    }
}
