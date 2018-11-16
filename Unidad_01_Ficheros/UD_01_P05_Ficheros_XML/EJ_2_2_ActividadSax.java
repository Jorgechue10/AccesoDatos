/*Realizar lo mismo que el PruebaSax, pero esta vez con un contador para 
 * que te cuente el número de canciones que son españolas*/

package UD_01_P05_Ficheros_XML;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class EJ_2_2_ActividadSax {

	public static void main(String[] args)
            throws FileNotFoundException, IOException, SAXException{
		
	 XMLReader  procesadorXML = XMLReaderFactory.createXMLReader();
	 GestionContenido2 gestor= new GestionContenido2();  
	 procesadorXML.setContentHandler(gestor);
	 InputSource fileXML = new InputSource(""
	 		+ "src\\P05_Ficheros_XML\\Ficheros\\canciones.xml");	    
     procesadorXML.parse(fileXML);        	      
	}
}

class GestionContenido2 extends DefaultHandler {	 
		int contador;
	    public GestionContenido2() {
	        super();
	    }	    
	    public void startDocument() {
	        System.out.println("Comienzo del Documento XML");
	    }	    
	    public void endDocument() {
	        System.out.println("Final del Documento XML");
	        
	        System.out.println("Hay "+contador+" canciones españolas");
	    }	 	    
	    public void startElement(String uri, String nombre,
	              String nombreC, Attributes atts) {
	        System.out.printf("\t Principio Elemento: %s %n",nombre);	 	        
	    } 	
	    public void endElement(String uri, String nombre, 
                        String nombreC) {
	        System.out.printf("\tFin Elemento: %s %n", nombre);
	    }	
	    public void characters(char[] ch, int inicio, int longitud) 
                                          throws SAXException {
		   String car=new String(ch, inicio, longitud);
         //quitar saltos de l�nea	
		   car = car.replaceAll("[\t\n]","");	   
		   System.out.printf ("\t Caracteres: %s %n", car);		
		   
		   if(car.equals("true"))
			   contador++;	
	    }	

}//fin GestionContenido