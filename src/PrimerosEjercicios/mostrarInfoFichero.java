package PrimerosEjercicios;

import java.io.File;

public class mostrarInfoFichero {
    static void main() {
        File fich1 = new File("..\\ejercicios\\ejercicio1.txt");
        System.out.println("Nombre: " + fich1.getName());
        System.out.println("Ruta: " + fich1.getPath());
        System.out.println("Ruta absoluta: " + fich1.getAbsolutePath() ) ;
        System.out.println("Ruta del directorio padre: " + fich1.getParent());
        if(fich1.canWrite()){
            System.out.println("Se puede escribir?:  si");
        } else {
            System.out.println("Se puede escribir?:  no");
        }

        if(fich1.canRead()){
            System.out.println("Se puede leer?:  si");
        } else {
            System.out.println("Se puede leer?:  no");
        }

        System.out.println("Tamaño en bytes: " + fich1.length());
    }
}
