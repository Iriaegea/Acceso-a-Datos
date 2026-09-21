package PrimerosEjercicios;

import java.io.File;
import java.io.IOException;

public class crearUnFichero {
    static void main() {
        try {
            File fich1 = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios\\ejercicio1.txt");
            if(!fich1.exists()){
                fich1.createNewFile();
                System.out.println("Fichero creado: " + fich1.getName());

            } else {
                System.out.println("El fichero ya existe");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero");
        }

    }
}
