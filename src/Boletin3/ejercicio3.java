package Boletin3;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ejercicio3 {
    static void main() {
        int productos = 1;
        int codigo=0;
        double precioTotalAcumulado = 0;
        String nombre = "";
        double precio;

        Scanner sc = new Scanner(System.in);
        File archivo = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\EjerciciosBoletin3\\productos.dat");
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo)) ){
            do{
                System.out.println("Introduce un producto: ");
                System.out.println("CODIGO: ");
                codigo = sc.nextInt();
                sc.nextLine();
                System.out.println("NOMBRE: ");
                nombre = sc.nextLine();
                System.out.println("PRECIO: ");
                precio = sc.nextDouble();
                sc.nextLine();


                dos.writeInt(codigo);
                dos.writeUTF(nombre);// al escribir string hay q poner el salto de linea
                dos.writeDouble(precio);



                precioTotalAcumulado+= precio;
                productos ++;
            }while(productos <= 2);

        }catch(IOException e){
            System.out.println("Error al escribir el archivo");
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream(archivo))){
            productos = 1;
            System.out.println("LISTA DE PRODUCTOS: ");

            while(true){

                System.out.println("PRODUCTO " + productos);
                System.out.println("CÓDIGO: " + dis.readInt());
                System.out.println("NOMBRE: " + dis.readUTF());
                System.out.println("PRECIO: " + dis.readDouble());
                productos ++;
                System.out.println();

            }
        }catch(EOFException e){

        } catch(IOException e){
            System.out.println("Error al leer el archivo");
        }

    }
}
