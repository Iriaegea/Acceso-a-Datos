package Boletin2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio2 {
    static void main() {
        try{

            FileReader leer = new FileReader("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\primos.dat");
            int caracter;
            while((caracter = leer.read())!=-1){
                System.out.print((char) caracter);
            }
            leer.close();
        } catch (IOException e){
            System.out.println("Error al leer el archivo");
        }
    }
}
