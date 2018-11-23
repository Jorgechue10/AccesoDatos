/*Para convertir de XML a HTML, primero vamos a tener que crear un fichero xsl 
 * (en este caso lo voy a crear en la carpeta ficheros).
 * 
 * En este ejercicio vamos a convertir el archivo canciones.xml a un html
 * mediante la plantilla cancionesPlantilla.xsl*/

package P05_Ficheros_XML;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class EJ_4_Convertir_XML_HTML {
	public static void main(String argv[]) throws IOException{ 
		String hojaEstilo = "Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\cancionesPlantilla.xsl";
		String datosAlumnos = "Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\canciones.xml";
		File pagHTML = new File("Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\canciones.html");
		FileOutputStream os = new FileOutputStream(pagHTML); //crear fichero HTML
  
		Source estilos =new StreamSource(hojaEstilo);//fuente XSL
		Source datos =new StreamSource(datosAlumnos);//fuente XML
		Result result = new StreamResult(os);        //resultado de la transformación
  
		try{     
			Transformer transformer =  
               TransformerFactory.newInstance().newTransformer(estilos);   
			transformer.transform(datos, result);	//obtiene el HTML
		}
		catch(Exception e){System.err.println("Error: "+e);}
  
		os.close();  //cerrar fichero 		
		}
}