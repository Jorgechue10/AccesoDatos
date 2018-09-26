package P01_Manipular;

import java.io.FileWriter;
import java.io.IOException;

public class CrearFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//Se crea un Nuevo objeto FileWriter
			FileWriter f1 = new FileWriter("C:\\Users\\ifc\\Documents\\f1.txt");
			
			}catch(IOException ex){
			System.out.println("error al acceder al fichero");
		}	
	}
}