package P03_LecturaEscritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerLinea {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P03_LecturaEscritura\\leer_linea.txt");	
		
		FileReader fr = new FileReader(f);
		
		BufferedReader bf = new BufferedReader(fr);
		
		String tmp;
		
		while((tmp = bf.readLine())!=null) {
			System.out.println(tmp);
		}
		bf.close();		
	}
}