package Boletin2;

import java.io.FileWriter;
import java.io.IOException;

public class ejercicio1 {

    public static boolean esPrimo(int n){
        boolean primo = true;
        for(int i = 2; i <= Math.sqrt(n); i++){
           if (n%i == 0){
               primo = false;
           }
        }

        return primo;

    }




    static void main() {

        try {
            FileWriter escribir = new FileWriter("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\primos.dat");
            for (int i = 1; i <= 500  ; i++) {
                if(esPrimo(i)){
                    System.out.println(i + " es primo");
                escribir.write(String.valueOf(i) + "\n");

                }
            }
            escribir.close();
        } catch (IOException e){
            System.out.println("error al escribir en el archivo");
        }

    }
}
