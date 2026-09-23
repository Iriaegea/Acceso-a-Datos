package Boletin1;

import java.io.File;
import java.io.IOException;

public class crearOtroFichero {
    static void main() {
        try {
            File fich2 = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios\\ejercicio2.txt");
            if (!fich2.exists()){
                fich2.createNewFile();
            } else {
                System.out.println("El fichero ya existe");
            }
        } catch (IOException e){
            System.out.println("Error al crear el fichero");
        }
    }
}
