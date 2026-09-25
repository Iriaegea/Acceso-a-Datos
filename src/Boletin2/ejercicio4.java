package Boletin2;

import java.io.*;
import java.util.Scanner;

public class ejercicio4 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String palabraPropuesta;
        String[] array;
        int contador = 0;
        try{
            File algo = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\algo.txt");
            algo.createNewFile();
            FileWriter escritor = new FileWriter("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\algo.txt");
            escritor.write("Hola hola hola hola");
            escritor.close();

        } catch (IOException e){
            System.out.println("Error al crear el archivo");
        }

        System.out.println("Escribe la palabra que quieres contar: ");
        palabraPropuesta = sc.nextLine();
        try {
            BufferedReader lector = new BufferedReader(new FileReader("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\algo.txt"));
            String liña;
            while ((liña = lector.readLine())!=null){
                array = liña.split(" ");
                for (String palabra : array){
                    if(palabra.equalsIgnoreCase(palabraPropuesta)){
                        contador ++;
                    }
                }

            }
            lector.close();
        } catch (IOException e){
            System.out.println("Error al leer el archivo algo.txt");
        }


        System.out.println("Contador = " + contador);
    }
}
