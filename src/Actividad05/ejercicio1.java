package Actividad05;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLOutput;
import java.util.RandomAccess;
import java.util.Scanner;

public class ejercicio1 {
   static Scanner sc = new Scanner(System.in);
   static String ruta = "libreria.dat";



    private static final int TITULO_LONG = 30;
    private static final int AUTOR_LONG = 50;

    static final int TAMAÑO_REGISTRO = 4 + (TITULO_LONG * 2) + (AUTOR_LONG * 2) + 8 + 4;





    static int mostrarMenu(){

        int  opcion;
        System.out.println();
        System.out.println("1. Altas\n" +
                "2. Listado del fichero completo con la valoración total del inventario\n" +
                "3. Consultas\n" +
                "4. Modificaciones\n" +
                "5. Salir\n");


        System.out.println("Selecciona una opción: ");
        opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }


        static int mostrarMenu2(){

        int  opcion;
        System.out.println();
        System.out.println("1. Buscar por código\n" +
                "2. Buscar por autor\n");


        System.out.println("Selecciona una opción: ");
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
                System.out.println("Autor: " + new String(autorChars).trim());

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


    static void buscarCodigo(){
        int codigoBuscar, posicionLibro;

        System.out.println("Escribe el codigo del libro que quieres buscar: ");
        codigoBuscar = sc.nextInt();
        sc.nextLine();

        posicionLibro = (codigoBuscar - 1) * TAMAÑO_REGISTRO;
       try(RandomAccessFile raf = new RandomAccessFile(ruta, "r") ){
           raf.seek(posicionLibro);

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
           System.out.println("Precio: " +  raf.readDouble());
           System.out.println("Cantidad : " + raf.readInt());
           System.out.println();


       }catch (IOException e){
           System.out.println("Error al buscar el libro");
       }
    }
    static void buscarAutor(){
        String autorBuscado;

        System.out.println("Escribe el nombre del autor del lbro que buscas: ");
        autorBuscado = sc.nextLine();


        try(RandomAccessFile raf = new RandomAccessFile(ruta, "r") ){
            raf.seek(0);
            double precio;
            int cantidad, codigo, totalAutor  =0;
            String titulo, autor;


            while (raf.getFilePointer()< raf.length()){

                codigo = raf.readInt();
                char[]  tituloChars = new char[TITULO_LONG];
                for (int i = 0; i < TITULO_LONG; i++) {
                    tituloChars[i] = raf.readChar();
                }
                titulo = new String(tituloChars).trim();
                char[] autorChars = new char[AUTOR_LONG];
                for (int i = 0; i < AUTOR_LONG; i++) {
                    autorChars[i] = raf.readChar();
                }
                autor = new String(autorChars).trim();

                precio = raf.readDouble();

                cantidad = raf.readInt();

                System.out.println();

                if ( autor.toLowerCase().contains(autorBuscado)){
                    System.out.println("Código: " + codigo);

                    System.out.println("Título: " + titulo);

                    System.out.println("Autor " + autor);

                    System.out.println("Precio: " + precio);

                    System.out.println("Cantidad : " + cantidad);
                    System.out.println();

                    totalAutor += cantidad;


                }


            }

            System.out.println("Libros totales del autor " + autorBuscado + " " + totalAutor);


        }catch (IOException e){
            System.out.println("Error al buscar el libro");
        }
    }


    static void modificarLibro(){
        int codigoBuscar, posicionLibro, codigo;

        System.out.println("Escribe el codigo del libro que quieres modificar: ");
        codigoBuscar = sc.nextInt();
        sc.nextLine();

        posicionLibro = (codigoBuscar - 1) * TAMAÑO_REGISTRO;  // ASI VOY DIRECTAMETE AL REGISTRO Q ES, NO TENGO Q REORRERLOS TODOS
        try(RandomAccessFile raf = new RandomAccessFile(ruta, "rw") ){
            raf.seek(posicionLibro);


            System.out.println("Libro buscado: ");


            codigo = raf.readInt();
            System.out.println("Código: " + codigo);


            char[]  tituloChars = new char[TITULO_LONG];
            for (int i = 0; i < TITULO_LONG; i++) {
                tituloChars[i] = raf.readChar();
            }
            String titulo = new String(tituloChars);
            System.out.println("Título: " + titulo.trim());


            char[] autorChars = new char[AUTOR_LONG];
            for (int i = 0; i < AUTOR_LONG; i++) {
                autorChars[i] = raf.readChar();
            }
            String autor = new String(autorChars);
            System.out.println("Autor: " + autor.trim());


            double precio = raf.readDouble();
            System.out.println("Precio: " + precio  );


            int stock = raf.readInt();
            System.out.println("Cantidad : " + stock );


            System.out.println();

            System.out.println("Nuevo precio: ");
            precio = sc.nextDouble();
            sc.nextLine();

            System.out.println("Nuevo stock: ");
            stock = sc.nextInt();
            sc.nextLine();

            raf.seek(raf.getFilePointer() - 4 - 8 );
            raf.writeDouble(precio);
            raf.writeInt(stock);


        }catch (IOException e){
            System.out.println("Error al guardar los cambios");
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
                    listadoCompletoYValoracion();
                    break;
                case 3:
                    opcion = mostrarMenu2();
                    switch(opcion){
                        case 1:
                            buscarCodigo();
                            break;
                        case 2:
                            buscarAutor();
                            break;
                    }
                    break;
                case 4:
                    modificarLibro();
                    break;
                case 5:
                    System.out.println("Has salido de la aplicación");
                    break;
                default:
                    System.out.println("Opción indorrecta");
            }
        }while (opcion != 5);



    }
}
