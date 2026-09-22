package PrimerosEjercicios;

import java.io.File;

public class listarContenidoDirectorio {
    static void main() {
        File ejercicios = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios");
        String[] archivos = ejercicios.list();

        for (String archivo : archivos ){
            File archivoActual = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios\\"+archivo);
            if (archivoActual.isFile()){
                System.out.println("El archivo " + archivo + " es un file");
            } else {
                System.out.println("El archivo " + archivo + " es un directorio");
            }
        }


    }
}
