package PrimerosEjercicios;

import java.io.File;

public class renombrarFichero {
    static void main() {
        File fichero = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios\\subdir\\subejemplo.txt");
        if (fichero.exists()){
            File nuevoFichero = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios\\subdir\\subejemplo_copia.txt");
            fichero.renameTo(nuevoFichero);
        }
    }

}
