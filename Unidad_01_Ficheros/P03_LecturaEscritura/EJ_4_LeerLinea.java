package P03_LecturaEscritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EJ_4_LeerLinea {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("Unidad_01_Ficheros\\P03_LecturaEscritura\\Ficheros\\leer_linea.txt");	
		
		FileReader fr = new FileReader(f);
		
		BufferedReader bf = new BufferedReader(fr);
		
		String tmp;
		
		while((tmp = bf.readLine())!=null) {
			System.out.println(tmp);
		}
		bf.close();		
	}
}