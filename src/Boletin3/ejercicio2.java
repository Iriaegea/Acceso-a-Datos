package Boletin3;

import java.io.*;
import java.util.Scanner;

public class ejercicio2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int contador= 0, sumaTotal = 0;
        File archivo  =new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin3\\ejercicio2.txt");
        try(DataOutputStream dos = new DataOutputStream(new FileWriter(archivo))) {
            int numero;
            do {
                System.out.println("Escribe un número entero (-1 para salir): ");
                numero = sc.nextInt();
                escritor.write(String.valueOf(numero));
            } while (numero != -1);


        }catch(IOException e){
            System.out.println("Error al escribir el archivo");
        }


        try(DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
            while(true){
                int numLido = dis.readInt();
                System.out.println(numLido);
                contador ++;
                sumaTotal += numLido;
            }



        }catch (EOFException e){
                System.out.println("error de lectura");
        } catch( IOException e ){
            System.out.println("fin del fichero");
        }


        System.out.println("MEDIA: " + sumaTotal/contador);

    }
}
