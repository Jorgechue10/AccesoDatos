package P03_LecturaEscritura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LecturaEscritura {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File f1 = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P03_LecturaEscritura\\fichero.txt");		
		
		//Se puede hacer de dos maneras, una poniendo en la cabecera throws IOException
		//y otra poniendo el try catch(IOException)		
			
		FileReader fichero_leer = new FileReader(f1);
		int i; //Caracter actual
		
		while((i=fichero_leer.read())!=-1) {
			System.out.print((char)i);
		}				
	}
}