package P06_JAXB_Mapear_Clase_a_XML;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
 

public class EJ_2_3_JAXB {
 
    private static final String MIARCHIVO_XML = "Unidad_01_Ficheros\\P06_JAXB\\Ficheros\\ej_2_canciones.xml";
 
    public static void main(String[] args) throws JAXBException, IOException {
        //Se crea la lista de libros
        ArrayList<EJ_2_1_Cancion> cancionLista = new ArrayList<EJ_2_1_Cancion>();
 
        // Creamos dos libros y los añadimos
        EJ_2_1_Cancion libro1 = new EJ_2_1_Cancion(1, 2012,"Hola","Jorge","3 minutos",true);
        cancionLista.add(libro1);
        EJ_2_1_Cancion libro2 = new EJ_2_1_Cancion(2, 2018,"Manuel","Juan","2 minutos",false);
        cancionLista.add(libro2);
 
        // Se crea La libreria y se le asigna la lista de libros
        EJ_2_2_ListaCanciones miListaCanciones = new EJ_2_2_ListaCanciones();
        miListaCanciones.setListaCanciones(cancionLista);
 
        // Creamos el contexto indicando la clase raíz
        JAXBContext context = JAXBContext.newInstance(EJ_2_2_ListaCanciones.class);
      
        //Creamos el Marshaller, convierte el java bean en una cadena XML
        Marshaller m = context.createMarshaller();
        
        //Formateamos el xml para que quede bien
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
        // Lo visualizamos con system out
        m.marshal(miListaCanciones, System.out);
 
        // Escribimos en el archivo
        m.marshal(miListaCanciones, new File(MIARCHIVO_XML));
 
        // Visualizamos ahora los datos del documento XML creado
        System.out.println("------------ Leo el XML ---------");
        
        //Se crea Unmarshaller en el cotexto de la clase Libreria
        Unmarshaller unmars = context.createUnmarshaller();
        
        //Utilizamos el método unmarshal, para obtener datos de un Reader
        EJ_2_2_ListaCanciones lista2 = (EJ_2_2_ListaCanciones) unmars.unmarshal(new FileReader(MIARCHIVO_XML));
        
        ArrayList<EJ_2_1_Cancion> lista = lista2.getListaCanciones();
        for (EJ_2_1_Cancion cancion : lista) {
            System.out.println("\tTitulo de la cancion: "+cancion.getTitulo()
            +"\n\tArtista de la canción: "+cancion.getArtista()+"\n");
 
        } 
    }
}