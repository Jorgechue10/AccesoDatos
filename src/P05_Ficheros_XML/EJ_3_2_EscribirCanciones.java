/*Escribimos las canciones en una lista de la clase anterior 
 * y las metemos en un xml*/

package P05_Ficheros_XML;

import java.io.*;
import com.thoughtworks.xstream.XStream;

public class EJ_3_2_EscribirCanciones {

	public static void main(String[] args) 
			throws IOException, ClassNotFoundException{
		
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src"
				+ "\\P05_Ficheros_XML\\Ficheros\\canciones.dat"); 
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
			Cancion cancion= (Cancion) objectIn.readObject();    
			listaCanciones.add(cancion); //añadir una canción a la lista  
			}	
		}catch (EOFException eo) {}
    
		objectIn.close();  //cerrar stream de entrada     
		
		try {
			XStream xstream = new XStream();   
			//cambiar de nombre a las etiquetas XML
			xstream.alias("ListaCanciones", EJ_3_1_ListaCanciones.class);	
			xstream.alias("DatosCanciones", Cancion.class);
			
			
			//Cambiar el nombre de los atributos de la etiqueta Cancion
			xstream.aliasField("Titulo cancion", Cancion.class, "titulo");
			xstream.aliasField("Nombre artista", Cancion.class, "artista");			
			
			//quitar etiqueta lista (atributo de la EJ_3_1_ListaCanciones)
			xstream.addImplicitCollection(EJ_3_1_ListaCanciones.class, "lista");
			//Insertar los objetos en el XML
			xstream.toXML(listaCanciones, new FileOutputStream
					("src\\P05_Ficheros_XML\\Ficheros\\canciones_xs.xml"));	
			System.out.println("Creado fichero XML....");
		
		}catch (Exception e) {
			e.printStackTrace();
		}	    
	} // fin main
} //fin EscribirPersonas