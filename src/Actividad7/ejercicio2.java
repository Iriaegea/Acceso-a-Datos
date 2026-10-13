package Actividad7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ejercicio2 {
    static String ruta = "D:\\iriae\\Documents\\Acceso_a_datos\\Acceso-a-Datos\\src\\Actividad7\\librosMini.xml";


    private static void switchElement (Node nodo){
        Element elemento = (Element) nodo;
        switch(elemento.getNodeName()){
            case "libro":
                System.out.println("Libro " + elemento.getAttribute("codigo"));

                //getChildNodes da todos los nodos hijos asI q puedo recorrerlos
                NodeList hijos = elemento.getChildNodes(); // tengo q recorrer cada nodo hijo, si no me quedo solo con el primero
                for(int i = 0; i < hijos.getLength(); i++ ){
                    switchElement(hijos.item(i));
                }

                break;

            case "titulo":
                System.out.println("\t\tTítulo: " + elemento.getTextContent());
                break;
            case "autor":
                System.out.println("\t\tAutor: " + elemento.getTextContent());
                break;
            case "precio":
                System.out.println("\t\tPrecio: " + elemento.getTextContent());
                break;
            case "cantidad":
                System.out.println("\t\tCantidad: " + elemento.getTextContent());
                break;

        }
    }

    static void main() {
        File fichero = new File(ruta);
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder  = factory.newDocumentBuilder();
            Document doc = builder.parse(fichero);
            doc.getDocumentElement().normalize();


            NodeList libreria = doc.getElementsByTagName("libro");
            for(int i = 0; i < libreria.getLength();i++){
                Node nodo = libreria.item(i);
                if(nodo.getNodeType() == Node.ELEMENT_NODE)
                    switchElement(nodo);
            }




        }catch (ParserConfigurationException ex){
            System.err.println("Error al crear el parser");
        } catch (IOException | SAXException e){
            System.err.println("Error al parsear el fichero");
        }
    }
}
