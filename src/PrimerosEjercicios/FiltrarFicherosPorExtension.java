package PrimerosEjercicios;

import java.io.File;

public class FiltrarFicherosPorExtension {
    static void main() {
        File dirEjercicios = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios");
        String[] contenido = dirEjercicios.list();
        for(String nombreArchivo :contenido){
            File archivoActual = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios\\" + nombreArchivo);
            if(archivoActual.isFile()){
                if(nombreArchivo.endsWith(".pdf")){
                    System.out.println(nombreArchivo + " es un pdf");
                } else {
                    System.out.println(nombreArchivo + " no es un pdf");
                }
            } else {
                System.out.println(archivoActual.getName() + " es un directorio");
            }

        }
    }
}
