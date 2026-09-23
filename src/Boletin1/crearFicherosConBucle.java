package Boletin1;

import java.io.File;
import java.io.IOException;

public class crearFicherosConBucle {
    static void main() {
        for (int i = 1; i <=5; i++) {
            try{
                File ficherito = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios\\ej"+i+".pdf");
                if(!ficherito.exists()){
                    ficherito.createNewFile();
                    System.out.println(ficherito.getName());
                } else {
                    System.out.println("El fichero " + ficherito.getName() + " ya existe.");
                }
            }catch(IOException e){
                System.out.println("Error al crear el fichero " + i);

            }
        }

    }
}
