/*Para convertir de XML a HTML, primero vamos a tener que crear un fichero xsl.
 * 
 * En este ejercicio vamos a convertir el archivo ej_2_canciones.xml a un html ej_4_canciones.html
 * mediante la plantilla ej_4_cancionesPlantilla.xsl*/

package P05_Ficheros_XML;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class EJ_4_Convertir_XML_HTML {
	public static void main(String argv[]) throws IOException{ 
		String hojaEstilo = "Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\ej_4_cancionesPlantilla.xsl";
		String datosAlumnos = "Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\ej_2_canciones.xml";
		File pagHTML = new File("Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\ej_4_canciones.html");
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