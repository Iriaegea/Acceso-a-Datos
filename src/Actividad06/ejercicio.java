package Actividad06;

import java.util.Scanner;

public class ejercicio {
    static Scanner sc = new Scanner(System.in);

    static int mostrarMenu(){
        int opcion;
        System.out.println("1. Añadir nueva nota.\n" +
                "2. Listar notas.\n" +
                "3. Leer una nota.\n" +
                "4. Eliminar una nota.\n" +
                "5. Respaldar las notas.\n" +
                "0. SALIR");

        System.out.println();

        System.out.print("Selecciona una opción: ");
        return opcion = sc.nextInt();

    }


    static void main() {
        int opcion;

        opcion = mostrarMenu();

        switch(opcion){
            case 1:
                anadirNota();
                break;
            case 2:
                listarNotas();
                break;
            case 3:
                leerNota();
                break;
            case 4:
                eliminarNota();
                break;
            case 5:
                respaldarNotas();
                break;
            case 0:
                System.out.println("Has salido del programa");
                break;
            default:
                System.out.println("Opción incorrecta");
                break;



        }
    }
}
