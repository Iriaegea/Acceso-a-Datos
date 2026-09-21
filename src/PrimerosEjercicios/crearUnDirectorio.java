package PrimerosEjercicios;

import java.io.File;
import java.io.IOException;

public class crearUnDirectorio {
    static void main() {



                File dir1 = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\ejercicios");
                if (!dir1.exists()){
                    dir1.mkdir();
                    System.out.println("directorio creado!" + dir1.getName());
                } else {
                    System.out.println("El directorio ya existe");
                }

    }


}
