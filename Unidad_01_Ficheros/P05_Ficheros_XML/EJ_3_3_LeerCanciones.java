/*Clase que lee el objeto ListaCanciones en el que se encuentran todas las canciones*/

package P05_Ficheros_XML;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;

public class EJ_3_3_LeerCanciones {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		 XStream xstream = new XStream();
			
		 xstream.alias("ListaCanciones", EJ_3_1_ListaCanciones.class);	
		 xstream.alias("DatosCanciones", EJ_1_1_Cancion.class);
		 xstream.addImplicitCollection(EJ_3_1_ListaCanciones.class, "lista");
		 
		 EJ_3_1_ListaCanciones listadoTodas = (EJ_3_1_ListaCanciones) xstream.fromXML(
				 new FileInputStream ("Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\ej_3_canciones_xs.xml"));		
		 System.out.println("Numero de Canciones: " +
				 listadoTodas.getListaCanciones().size());
		 
		 List<EJ_1_1_Cancion> listaCanciones = new ArrayList<EJ_1_1_Cancion>();
		 listaCanciones = listadoTodas.getListaCanciones();
					        
		 Iterator <EJ_1_1_Cancion> iterador = listaCanciones.listIterator(); 
		 while( iterador.hasNext() ) {
			 EJ_1_1_Cancion c = (EJ_1_1_Cancion) iterador.next(); 
			 System.out.printf("Titulo: %s, edad: %d %n", 
					 c.getTitulo(), c.getAnio());        
		 }    
		 System.out.println("Fin de listado .....");
		    
	} //fin main
}//fin LeerPersonas