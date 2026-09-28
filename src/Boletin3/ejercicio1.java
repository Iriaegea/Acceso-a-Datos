package Boletin3;

import java.io.*;

public class ejercicio1 {
    static void main() {
        File archivo2 = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin3\\copiaAlgo.txt");
        File archivo = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\algo.txt");
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivo));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivo2))){
           byte[] buffer = new byte[8192];
            int byteLeido;
            while((byteLeido=bis.read(buffer))!= -1){ //ojo hay que meter el bufer en el read para q sepa cuánto leer
                bos.write(buffer, 0, byteLeido); // ya está en bytes
            }
            bos.flush(); // para leer los que han quedao sueltos
        } catch ( IOException e){
            System.out.println("Error al leer el fichero");
        }
    }
}
