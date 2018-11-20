package P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EJ_3_2_Lectura_de_objetos {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		File f = new File("Unidad_01_Ficheros\\P04_FicherosBytes\\Ficheros\\personas.dat");
		
		FileInputStream filein = new FileInputStream(f);
		ObjectInputStream objectin = new ObjectInputStream(filein);
		
		EJ_3_0_Persona p;
		
		try {
			while(true){
					p=(EJ_3_0_Persona)objectin.readObject();
					System.out.println("Nombre: "+p.getNombre()+", Edad: "+p.getEdad());
			}
		}catch (EOFException eo) {
			System.out.println("");
		}	
		objectin.close();
	}
}