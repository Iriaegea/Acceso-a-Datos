package Actividad05;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.Scanner;

public class ejercicio1 {
   static Scanner sc = new Scanner(System.in);
   static String ruta = "Acceso-a-Datos\\DirectoriosCreados\\Entrega2";



    private static final int TITULO_LONG = 30;
    private static final int AUTOR_LONG = 50;

    static final int TAMAÑO_REGISTRO = Integer.BYTES + TITULO_LONG * Character.BYTES + AUTOR_LONG * Character.BYTES + Double.BYTES + Integer.BYTES;





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
        sc.nextLine();
        System.out.println("Stock: ");
        stock = sc.nextInt();
        sc.nextLine();

        try(RandomAccessFile raf = new RandomAccessFile(ruta, "rw")){
            int codigo = (int) (raf.length() / TAMAÑO_REGISTRO) + 1;
            raf.seek(raf.length());

            StringBuffer tituloFijo = new StringBuffer(titulo);
            tituloFijo.setLength(TITULO_LONG);

            StringBuffer autorFijo = new StringBuffer(autor);
            autorFijo.setLength(AUTOR_LONG);

            raf.writeInt(codigo);
            raf.writeChars(tituloFijo.toString());
            raf.writeChars(autorFijo.toString());
            raf.writeDouble(precio);
            raf.writeInt(stock);

            System.out.println("Libro añadido con código " + codigo );

        } catch (IOException e) {
            System.out.println("Error al guardar el libro");
        }




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
                    break;
                default:
                    System.out.println("Opción indorrecta");
            }
        }while (opcion != 5);



    }
}
