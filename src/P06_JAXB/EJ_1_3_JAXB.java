package P06_JAXB;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
 

public class EJ_1_3_JAXB {
 
    private static final String MIARCHIVO_XML = "src\\P06_JAXB\\Ficheros\\libreria.xml";
 
    public static void main(String[] args) throws JAXBException, IOException {
        //Se crea la lista de libros
        ArrayList<EJ_1_1_Libro> libroLista = new ArrayList<EJ_1_1_Libro>();
 
        // Creamos dos libros y los añadimos
        EJ_1_1_Libro libro1 = new EJ_1_1_Libro("Matrix", "Dolores Fuertes de Barriga","Planeta","978-84-1545-297-3" );
        libroLista.add(libro1);
        EJ_1_1_Libro libro2 = new EJ_1_1_Libro("El señor de los anillos", "Tolkien","Anaya","978-84-1545-228-7" );
        libroLista.add(libro2);
 
        // Se crea La libreria y se le asigna la lista de libros
        EJ_1_2_Libreria milibreria = new EJ_1_2_Libreria();
        milibreria.setNombre("Prueba de libreria JAXB");
        milibreria.setLugar("Tarazona, como no");
        milibreria.setListaLibro(libroLista);
 
        // Creamos el contexto indicando la clase raíz
        JAXBContext context = JAXBContext.newInstance(EJ_1_2_Libreria.class);
      
        //Creamos el Marshaller, convierte el java bean en una cadena XML
        Marshaller m = context.createMarshaller();
        
        //Formateamos el xml para que quede bien
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
        // Lo visualizamos con system out
        m.marshal(milibreria, System.out);
 
        // Escribimos en el archivo
        m.marshal(milibreria, new File(MIARCHIVO_XML));
 
        // Visualizamos ahora los datos del documento XML creado
        System.out.println("------------ Leo el XML ---------");
        
        //Se crea Unmarshaller en el cotexto de la clase Libreria
        Unmarshaller unmars = context.createUnmarshaller();
        
        //Utilizamos el método unmarshal, para obtener datos de un Reader
        EJ_1_2_Libreria libreria2 = (EJ_1_2_Libreria) unmars.unmarshal(new FileReader(MIARCHIVO_XML));
        
        //Recuperamos el array list y visualizamos
        System.out.println("Nombre de librería: "+ libreria2.getNombre());
        System.out.println("Lugar de la librería: "+ libreria2.getLugar());
        System.out.println("Libros de la librería: ");
        
        ArrayList<EJ_1_1_Libro> lista = libreria2.getListaLibro();
        for (EJ_1_1_Libro libro : lista) {
            System.out.println("\tTítulo del libro: " + libro.getNombre() 
              + " , autora: " + libro.getAutor());
 
        } 
    }
}