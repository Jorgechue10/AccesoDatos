package UD_01_P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class lectura_de_objetos_Persona {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\Ficheros\\personas.dat");
		
		FileInputStream filein = new FileInputStream(f);
		ObjectInputStream objectin = new ObjectInputStream(filein);
		
		Persona p;
		
		try {
			while(true){
					p=(Persona)objectin.readObject();
					System.out.println("Nombre: "+p.getNombre()+", Edad: "+p.getEdad());
			}
		}catch (EOFException eo) {
			System.out.println("");
		}	
		objectin.close();
	}
}