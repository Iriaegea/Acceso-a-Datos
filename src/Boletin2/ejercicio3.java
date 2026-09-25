package Boletin2;

import java.io.*;

public class ejercicio3 {
    static File cosa1 = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\pares.txt");
    static File cosa2 = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\impares.txt");

    public static void crearFicheros(){

        try{
            cosa1.createNewFile();
            cosa2.createNewFile();
        } catch(IOException e){
            System.out.println("Error al craer un archivo");
        }


        try{
            FileWriter escritor1 = new FileWriter("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\pares.txt");
            FileWriter escritor2 = new FileWriter("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\impares.txt");
            for (int i = 1; i <=10 ; i++) {
                if(i%2 == 0){
                    escritor1.write(String.valueOf(i + "\n"));
                } else {
                    escritor2.write(String.valueOf(i) + "\n");
                }
            }

            escritor1.close();
            escritor2.close();
        } catch(IOException e){
            System.out.println("Error al escribir el archivo");
        }



    }





    static void main() {
        crearFicheros();
        try{
            BufferedReader lectorPares = new BufferedReader(new FileReader("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\pares.txt"));
            BufferedReader lectorImpares = new BufferedReader(new FileReader("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\impares.txt"));
            String liña, liña2;
            FileWriter escritor = new FileWriter("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin2\\resultado.txt");


            while((liña = lectorImpares.readLine()) != null | (liña2 = lectorPares.readLine()) != null){
                if(liña != null){
                    escritor.write(liña + "\n");
                }
                if(liña2 != null){
                    escritor.write(liña2 +"\n");
                }

            }
            escritor.close();
            lectorImpares.close();
            lectorPares.close();


        } catch (IOException e){
            System.out.println("Error al leer oarchivo");
        }





    }
}
