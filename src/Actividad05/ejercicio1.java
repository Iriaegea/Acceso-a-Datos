package Actividad05;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLOutput;
import java.util.RandomAccess;
import java.util.Scanner;

public class ejercicio1 {
   static Scanner sc = new Scanner(System.in);
   static String ruta = "D:\\iriae\\Documents\\Acceso_a_datos\\Acceso-a-Datos\\DirectoriosCreados\\Entrega2\\libreria.dat";



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
        sc.nextLine();

        return opcion;
    }


        static int mostrarMenu2(){

        int  opcion;
        System.out.println("1.  De un registro determinado (por código)\n" +
                "2. ¿Cuántos libros del autor x existen en stock? (Buscar los libros de un autor determinado\n");


        System.out.println("Slecciona una opción: ");
        opcion = sc.nextInt();
        sc.nextLine();
        System.out.println();

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
            e.printStackTrace();
        }




    }

    static void listadoCompletoYValoracion(){
        int   cantidad = 0;
        double precio = 0, valorTotal = 0;


        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")){
            raf.seek(0); // empezar desde el principio pq quiero leerlos todos
            while (raf.getFilePointer()< raf.length()){ // hay q leerlos en el mismo orden q los escribí
                System.out.println("Código: " + raf.readInt());
                char[]  tituloChars = new char[TITULO_LONG];
                for (int i = 0; i < TITULO_LONG; i++) {
                    tituloChars[i] = raf.readChar();
                }
                System.out.println("Título: " + new String(tituloChars).trim()); // para impirmir bien el array
                char[] autorChars = new char[AUTOR_LONG];
                for (int i = 0; i < AUTOR_LONG; i++) {
                    autorChars[i] = raf.readChar();
                }
                System.out.println("Autor " + new String(autorChars).trim());

                precio = raf.readDouble();
                System.out.println("Precio: " + precio);
                cantidad = raf.readInt();
                System.out.println("Cantidad : " + cantidad);
                System.out.println();
                valorTotal += precio*cantidad;
                System.out.println();

            }

            System.out.println("VALOR TOTAL: " + valorTotal);
        } catch(IOException e){
            System.out.println("Error de lectura del fcihero");
        }
    }


    static void buscarCodigo(int codigo){
       try(RandomAccessFile raf = new RandomAccessFile(ruta, "r") ){
           raf.seek();
       }
    }
    static void buscarAutor(){

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
                    listadoCompletoYValoracion();
                    switch(opcion){
                        case 1:
                            buscarCodigo();
                            break;
                        case 2:
                            buscarAutor();
                            break;
                    }
                    break;
                case 3:
                    mostrarMenu2();
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
