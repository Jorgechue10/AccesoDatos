/*Clase donde escribimos las canciones del fichero ej_1_canciones.dat en el objeto ListaCanciones 
 * de la clase anterior y las metemos en el XML ej_3_canciones_xs.xml*/

package P05_Ficheros_XML;

import java.io.*;
import com.thoughtworks.xstream.XStream;

public class EJ_3_2_EscribirCanciones {

	public static void main(String[] args) 
			throws IOException, ClassNotFoundException{
		
		File f = new File("Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\ej_1_canciones.dat"); 
   		FileInputStream fileIn =new FileInputStream(f);//flujo de entrada   
    
		//conecta el flujo de bytes al flujo de datos
    	ObjectInputStream objectIn = new ObjectInputStream(fileIn);      
    
		System.out.println ("Comienza el proceso de creación "
				+ "del fichero a XML ...");
				
		//Creamos un objeto Lista de Personas
		EJ_3_1_ListaCanciones listaCanciones = new EJ_3_1_ListaCanciones();	 
     
		try {
			while (true) { //lectura del fichero
			//leer una Canción
			EJ_1_1_Cancion cancion= (EJ_1_1_Cancion) objectIn.readObject();    
			listaCanciones.add(cancion); //añadir una canción a la lista  
			}	
		}catch (EOFException eo) {}
    
		objectIn.close();  //cerrar stream de entrada     
		
		try {
			XStream xstream = new XStream();   
			//cambiar de nombre a las etiquetas XML
			xstream.alias("listaCanciones", EJ_3_1_ListaCanciones.class);	
			xstream.alias("cancion", EJ_1_1_Cancion.class);
			
			
			//Cambiar el nombre de los atributos de la etiqueta Cancion
			/*xstream.aliasField("Titulo cancion", EJ_1_1_Cancion.class, "titulo");
			xstream.aliasField("Nombre artista", EJ_1_1_Cancion.class, "artista");	*/		
			
			//quitar etiqueta lista (atributo de la EJ_3_1_ListaCanciones)
			xstream.addImplicitCollection(EJ_3_1_ListaCanciones.class, "lista");
			//Insertar los objetos en el XML
			xstream.toXML(listaCanciones, new FileOutputStream
					("Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\ej_3_canciones_xs.xml"));	
			System.out.println("Creado fichero XML....");
		
		}catch (Exception e) {
			e.printStackTrace();
		}	    
	} // fin main
} //fin EscribirPersonas