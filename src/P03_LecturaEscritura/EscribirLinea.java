package P03_LecturaEscritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirLinea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P03_LecturaEscritura\\escribir_linea.txt");	
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			int nLineas=10;
			
			for(int i=0;i<=nLineas;i++) {
				bw.write("Fila numero: "+i);
				bw.newLine();
			}
			bw.close();
		}catch (FileNotFoundException fn) {
			System.out.println("El fichero no se encuentra...");
		}catch (IOException io) {
			System.out.println("Error de E/S");
		}	
	}
}