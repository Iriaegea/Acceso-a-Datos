package Actividad04;

import java.io.*;
import java.util.Scanner;

public class main {

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

        Libro libro = new Libro(titulo, autor, isbn, precio, stock);
        File archivo = new File("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\Entrega1\\libros.dat");

        if (!archivo.exists() || archivo.length() == 0){
         try (ObjectOutputStream obxecto = new ObjectOutputStream(new FileOutputStream(archivo))) {
            obxecto.writeObject(libro);
            return true;

        } catch (IOException e) {
            
            return false;
        }

        } else {
            try (ObjectOutputStream obxeto = new MiObjectOutputStream(new FileOutputStream(archivo, true))){
                obxeto.writeObject(libro);
                return true;
            }catch (IOException e){
                return false;
            }

        }
       


    }


    public static void listarLibrosGuardados(){
        try (ObjectInputStream objeto = new ObjectInputStream(new FileInputStream("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\Entrega1\\libros.dat"))){
            while(true){
                Libro libro = (Libro) objeto.readObject();
                System.out.println(libro);
            }

        }catch(EOFException e){

        } catch (IOException | ClassNotFoundException  e){

        }
    }


    public static void consultarLibro(String isbn ){
        try (ObjectInputStream objeto = new ObjectInputStream(new FileInputStream("D:\\iriae\\Documents\\Acceso a Datos\\DirectoriosCreados\\Entrega1\\libros.dat"))){

        while(true){
            Libro libro = (Libro) objeto.readObject();
            if(libro.getIsbn().equalsIgnoreCase(isbn)){
                System.out.println("Libro encontrado: " + libro);
                break;
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
