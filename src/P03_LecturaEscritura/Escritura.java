package P03_LecturaEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f1 = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P03_LecturaEscritura\\fichero_escritura.txt");	
		
		FileWriter fichero_escribir = new FileWriter(f1);
		String cadena = "Tarazona Mo-La";
		char cadena_array[] = cadena.toCharArray();
		
		for(int i=0; i<cadena_array.length;i++) {			
			fichero_escribir.write(cadena_array[i]);
		}
		
		fichero_escribir.append("***");//Este metodo escribe al final del fichero
		
		fichero_escribir.close();
	}
}