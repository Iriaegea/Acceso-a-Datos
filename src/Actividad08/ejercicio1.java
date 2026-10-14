package Actividad08;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/*Ejercicio 1
Codifica un programa que lea el fichero libreria.xml de la actividad anterior y muestre su
contenido por pantalla utilizando SAX .*/
public class ejercicio1 {
    static void main() {
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            LibroHandler handler = new LibroHandler();

            saxParser.parse(new File("libros.xml"), handler);


        }catch (Exception e) {
            System.err.println("Error al procesar el documento XML.");
        }
    }
}
