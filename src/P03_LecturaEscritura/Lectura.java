package P03_LecturaEscritura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File f1 = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P03_LecturaEscritura\\fichero_lectura.txt");		
		
		//Se puede hacer de dos maneras, una poniendo en la cabecera throws IOException
		//y otra poniendo el try catch(IOException)		
			
		// Flujo de entrada al fichero
		FileReader fichero_leer = new FileReader(f1);
		int i; //Caracter actual
		
		while((i=fichero_leer.read())!=-1) {//Lee el fichero hasta que devuelve -1 que quiere decir que ya no hay mas texto
			System.out.print((char)i);
		}
		fichero_leer.close();//Cerrar fichero
	
		
		//Ahora hacemos lo mismo con un caracter
		System.out.println("\n");
		
		FileReader fichero_leerCaracter = new FileReader(f1);
		
		char b[] = new char[30];
		
		while((i=fichero_leerCaracter.read(b))!=-1) {//Lee el fichero hasta que devuelve -1 y lo mete en un array char
			System.out.print(b);
		}	
		fichero_leerCaracter.close();
	}
}