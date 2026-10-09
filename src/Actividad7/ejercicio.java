package Actividad7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ejercicio {

    static String ruta = "libreria.dat";
    private static final int TITULO_LONG = 30;
    private static final int AUTOR_LONG = 50;
    static final int TAMAÑO_REGISTRO=  4 + ( TITULO_LONG* 2) + (AUTOR_LONG * 2) + 8 + 4;



    static void main() {
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")){

        int codigo;
        String titulo;
        String autor;
        double precio;
        int cantidad;
        raf.seek(0);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element raiz = doc.createElement("libros");
            doc.appendChild(raiz);





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

            Element libro = doc.createElement("libro");
            libro.setAttribute("Codigo" , String.valueOf(codigo));


            Element etTitulo = doc.createElement("titulo");
            etTitulo.appendChild(doc.createTextNode(titulo));
            libro.appendChild(etTitulo);

            Element etAutor = doc.createElement("autor");
            etAutor.appendChild(doc.createTextNode(autor));
            libro.appendChild(etAutor);

            Element etPrecio = doc.createElement("precio");
            etPrecio.appendChild(doc.createTextNode(String.valueOf(precio)));
            libro.appendChild(etPrecio);

            Element etCantidad = doc.createElement("cantidad");
            etCantidad.appendChild(doc.createTextNode(String.valueOf(cantidad)));
            libro.appendChild(etCantidad);


            raiz.appendChild(libro); // cuando ya tengo el libro terminado lo pego al raiz
        }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer  = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("libros.xml"));
            transformer.transform(source, result);
            System.out.println("XML creado correctamente");


    } catch(ParserConfigurationException ex){
        System.out.println("Error al crear el parser");
    }catch(TransformerException e){
            System.out.println("Error al crear el parser");
        }catch (IOException e){
            System.out.println("Error al leer el fichero");
        }



    }
}
