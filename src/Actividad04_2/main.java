package Actividad04_2;

import Actividad04.Libro;
import Actividad04.MiObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    static  String ruta = "DirectoriosCreados\\Entrega1\\libros.dat";
    static Scanner sc = new Scanner(System.in);


    public static int mostrarMenu(){
        int opcion;
        boolean numeroCorrecto = true;
        do{
            System.out.println("MENU:\n" +
                    "1. Insertar nuevo libro\n" +
                    "2. Listar libros guardados\n" +
                    "3. Consultar libro\n" +
                    "0 Salir\n");

                System.out.println("Escribe una opción (1-2-3-0)");
                opcion = sc.nextInt();
                sc.nextLine();

                if (opcion == 1 || opcion == 2 || opcion == 3 || opcion ==0){
                    numeroCorrecto=true;
                } else {
                    numeroCorrecto = false;
                }


        }while(opcion != 0 && !numeroCorrecto);

        return opcion;
    }

    public static boolean añadirLibro() {
        String titulo, autor, isbn;
        double precio;
        int stock;
        System.out.println("Vamos a añadir un libro");
        System.out.println("Titulo: ");
        titulo = sc.nextLine();
        System.out.println("Autor: ");
        autor = sc.nextLine();
        System.out.println("Isbn: ");
        isbn = sc.nextLine();
        System.out.println("Precio: ");
        precio = sc.nextDouble();
        sc.nextLine();
        System.out.println("Stock: ");
        stock = sc.nextInt();
        sc.nextLine();
       Libro libro = new Actividad04.Libro(titulo, autor, isbn, precio, stock);
        File archivo = new File(ruta);
        ArrayList<Libro> arrayLibros;

        if(archivo.length() == 0 || !archivo.exists()){
            arrayLibros = new ArrayList<>();
        }else{
            try(ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(archivo))
            ){

                arrayLibros = (ArrayList<Libro>) lectura.readObject();


            } catch (IOException | ClassNotFoundException  e){
                System.out.println("Error al listar");
                e.printStackTrace();

            }
        }

        /*if(archivo.length() ==0 || !archivo.exists()){
            try (ObjectOutputStream obxecto = new ObjectOutputStream(new FileOutputStream(archivo))) {
                arrayLibros = new ArrayList<>();
                arrayLibros.add(libro);
                obxecto.writeObject(arrayLibros);


            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            try(ObjectOutputStream obxecto = new ObjectOutputStream(new FileOutputStream(archivo ));
                ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(archivo))
            ){

                ArrayList<Libro> arrayViejo = (ArrayList<Libro>) lectura.readObject();
                arrayViejo.add(libro);
                obxecto.writeObject((arrayViejo));

            }catch(EOFException e){

            } catch (IOException | ClassNotFoundException  e){
                System.out.println("Error al listar");
                e.printStackTrace();
                return false;
            }
        }*/
        return true;
    }


    public static void listarLibrosGuardados(){
        try (ObjectInputStream objeto = new ObjectInputStream(new FileInputStream(ruta))){
            while(true){
                ArrayList<Libro> arrayViejo = (ArrayList<Libro>) objeto.readObject();
                for(Libro libro : arrayViejo){
                    System.out.println(libro);
                }

            }

        }catch(EOFException e){

        } catch (IOException | ClassNotFoundException  e){
            System.out.println("Error al listar");
            e.printStackTrace();

        }
    }


    public static void consultarLibro(String isbn ){
        try (ObjectInputStream objeto = new ObjectInputStream(new FileInputStream(ruta))){

        while(true){
            ArrayList<Libro> arrayViejo = (ArrayList<Libro>) objeto.readObject();

            for(Libro libro : arrayViejo){
                if(libro.getIsbn().equalsIgnoreCase(isbn)){
                    System.out.println("Libro encontrado: " + libro);

                }
            }

        }

        }catch( EOFException e){
            System.out.println("Libro no encontrado");
        } catch (IOException | ClassNotFoundException  e){

        }
    }



    static void main() {
        int opcion;
        String isbn;



            do{
                opcion = mostrarMenu();

                switch(opcion){
                    case 1:
                        if (añadirLibro()){
                            System.out.println("Libro añadido");
                        } else {
                            System.out.println("Error al añadir el libro");
                        }
                        break;
                    case 2:
                        listarLibrosGuardados();
                        break;
                    case 3:
                        System.out.println("Escribe el isbn del libro que quieres buscar: ");
                        isbn = sc.nextLine();
                        consultarLibro(isbn);
                        break;
                    default:
                        System.out.println("Has salido del programa");
                        break;
                }
            }while(opcion != 0);








    }
}
