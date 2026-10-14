package Actividad08;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class LibroHandler extends DefaultHandler {
    private StringBuilder texto = new StringBuilder();



    private boolean esEtiqueta = false;


    @Override
    public void startDocument(){
        System.out.println("Inicio del documento");
    }

    @Override
    public void endDocument(){
        System.out.println("Fin del documento");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        if(qName.equalsIgnoreCase("libro"))
            System.out.println("Libro: " + attributes.getValue("codigo"));
        else{
            esEtiqueta = true;
            texto.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if(esEtiqueta){
           texto.append(ch, start, length);
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName){
        if(qName.equalsIgnoreCase("titulo")){
            String textoTitulo = texto.toString().trim();
            if (!textoTitulo.isEmpty())
                System.out.println("\t\tTitulo: " + textoTitulo);
            esEtiqueta = false;
        } else if (qName.equalsIgnoreCase("autor")) {
            String textoAutor = texto.toString().trim();
            if (!textoAutor.isEmpty())
                System.out.println("\t\tTitulo: " + textoAutor);
            esEtiqueta = false;
        }else if (qName.equalsIgnoreCase("precio")) {
            String textoPrecio = texto.toString().trim();
            if (!textoPrecio.isEmpty()) {
                double doublePrecio = Double.parseDouble(textoPrecio);
                System.out.println("\t\tPrecio: " + textoPrecio);
                esEtiqueta = false;
            }
        }else if (qName.equalsIgnoreCase("cantidad")) {
            String textoCantidad = texto.toString().trim();
            if (!textoCantidad.isEmpty()){
                int intCantidad = Integer.parseInt(textoCantidad);
                System.out.println("\t\tCantidad: " + intCantidad);
                esEtiqueta = false;
            }

        }
    }
}
