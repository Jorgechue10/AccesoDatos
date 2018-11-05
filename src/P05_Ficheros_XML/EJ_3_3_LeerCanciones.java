/*Leemos la lista donde se encuentran las canciones*/

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
		 xstream.alias("DatosCanciones", Cancion.class);
		 xstream.addImplicitCollection(EJ_3_1_ListaCanciones.class, "lista");
		 
		 EJ_3_1_ListaCanciones listadoTodas = (EJ_3_1_ListaCanciones) xstream.fromXML(new FileInputStream ("src\\P05_Ficheros_XML\\Ficheros\\canciones_xs.xml"));		
		 System.out.println("Numero de Canciones: " +
				 listadoTodas.getListaCanciones().size());
		 
		 List<Cancion> listaCanciones = new ArrayList<Cancion>();
		 listaCanciones = listadoTodas.getListaCanciones();
					        
		 Iterator <Cancion> iterador = listaCanciones.listIterator(); 
		 while( iterador.hasNext() ) {
			 Cancion c = (Cancion) iterador.next(); 
			 System.out.printf("Titulo: %s, edad: %d %n", 
					 c.getTitulo(), c.getAnio());        
		 }    
		 System.out.println("Fin de listado .....");
		    
	} //fin main
}//fin LeerPersonas