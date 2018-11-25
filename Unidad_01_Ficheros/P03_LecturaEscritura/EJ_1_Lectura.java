/*Clase que lee un fichero de texto carácter a carácter*/

package P03_LecturaEscritura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EJ_1_Lectura {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//Se puede hacer de dos maneras, una poniendo en la cabecera throws IOException
		//y otra poniendo el try catch(IOException)		
		
		//Indicamos el fichero que queremos leer
		File f1 = new File("Unidad_01_Ficheros\\P03_LecturaEscritura\\Ficheros\\ej_1_fichero_lectura.txt");				
			
		// Flujo de entrada al fichero
		FileReader fichero_leer = new FileReader(f1);
		int i; //Caracter actual
		
		//Leemos el fichero hasta que devuelva -1 que quiere decir que ya no hay mas texto
		while((i=fichero_leer.read())!=-1) {
			System.out.print((char)i);
		}
		fichero_leer.close();//Cerrar fichero
	
		
		//Ahora hacemos lo mismo con un caracter
		System.out.println("\n");
		
		FileReader fichero_leerCaracter = new FileReader(f1);
		
		char b[] = new char[30];
		
		//Leemos el fichero hasta que devuelva -1 y lo metemos en un array char
		while((i=fichero_leerCaracter.read(b))!=-1) {
			System.out.print(b);
		}	
		fichero_leerCaracter.close();
	}
}