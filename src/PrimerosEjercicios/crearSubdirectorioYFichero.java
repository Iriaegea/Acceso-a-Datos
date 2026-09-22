package PrimerosEjercicios;

import java.io.File;
import java.io.IOException;

public class crearSubdirectorioYFichero {
    static void main() {
        try {
            File dirEjercicios = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios\\subdir");
            if (!dirEjercicios.exists()) {
                dirEjercicios.mkdir();
                File fichero = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios\\subdir\\subejemplo.txt");
                if(!fichero.exists()){
                    fichero.createNewFile();
                } else {
                    System.out.println("El fichero ya existe");
                }

            } else {
                System.out.println("El directorio ya existe");
            }
        }catch (IOException e){
                System.out.println("Error al crear el fichero");
            }





    }
}
