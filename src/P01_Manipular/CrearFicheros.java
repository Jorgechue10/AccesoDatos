package P01_Manipular;

import java.io.File;
import java.io.IOException;

public class CrearFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f1=new File("C:\\Users\\ifc\\Desktop\\f1.txt");
		
		if(f1.exists()) {
			System.out.println("El fichero ya existe");
		}else {
			try {
				f1.createNewFile();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}			
		}
	}
}