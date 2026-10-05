package Actividad05;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.Scanner;

public class ejercicio1 {
   static Scanner sc = new Scanner(System.in);
   static String ruta = "Acceso-a-Datos\\DirectoriosCreados\\Entrega2";
   static int codigo = 1;


    private static final int TITULO_LONG = 30;
    private static final int AUTOR_LONG = 50;


    static int mostrarMenu(){

        int  opcion;
        System.out.println("1. Altas\n" +
                "2. Listado del fichero completo con la valoración total del inventario\n" +
                "3. Consultas\n" +
                "4. Modificaciones\n" +
                "5. Salir\n");


        System.out.println("Slecciona una opción: ");
        opcion = sc.nextInt();

        return opcion;
    }


        static int mostrarMenu2(){

        int  opcion;
        System.out.println("3.1.  De un registro determinado (por código)\n" +
                "3.2. ¿Cuántos libros del autor x existen en stock? (Buscar los libros de un autor determinado\n");


        System.out.println("Slecciona una opción: ");
        opcion = sc.nextInt();

        return opcion;
    }


    static void altas(){
        String titulo, autor;
        double precio;
        int stock;

        System.out.println("Escribe el título del libro: ");
        titulo = sc.nextLine();
        System.out.println("Escribe el autor: ");
        autor = sc.nextLine();
        System.out.println("Escribe el precio: ");
        precio = sc.nextDouble();
        System.out.println("Stock: ");
        stock = sc.nextInt();

        try(RandomAccessFile raf = new RandomAccessFile(ruta, "rw")){
            StringBuffer sbTitulo = new StringBuffer(titulo);
            sbTitulo.setLength(TITULO_LONG);
            StringBuffer sbAutor = new StringBuffer(autor);
            sbAutor.setLength(AUTOR_LONG);
            raf.writeChars(sbTitulo.toString());
            raf.writeChars(sbAutor.toString());
            raf.writeDouble(precio);
            raf.writeInt(stock);





        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }



        codigo ++;
    }




    static void main() {



        int opcion = 0;
        do{
            opcion = mostrarMenu();
            switch (opcion){
                case 1:
                    altas();
                    break;
                case 2:
                    break;
                case 2:
                    break;
                case 4:
                    break;
                case 5:
                    break,
                default:
                    System.out.println("Opción indorrecta");
            }
        }while (opcion != 5);



    }
}
