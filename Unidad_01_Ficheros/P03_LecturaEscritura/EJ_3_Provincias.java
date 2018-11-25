/*Clase que escribe en un fichero de texto las provincias
 * que se han introducido en un array de String*/

package P03_LecturaEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EJ_3_Provincias {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f1 = new File("Unidad_01_Ficheros\\P03_LecturaEscritura\\Ficheros\\ej_3_provincias.txt");	
		
		
		// ¡¡CUIDADO!! Hay que tener cuidado, ya que el FileWriter sobreescribe el archivo existente,
		//puedes perder lo que tengas en el archivo anterior
		FileWriter fichero_escribir = new FileWriter(f1);
		
		String provincias[] = new String[10];
		provincias[0]="Zaragoza";
		provincias[1]="Huesca";
		provincias[2]="Teruel";
		provincias[3]="Madrid";
		provincias[4]="Barcelona";
		provincias[5]="Valencia";
		provincias[6]="Sevilla";
		provincias[7]="Granada";
		provincias[8]="Alicante";
		provincias[9]="Segovia";
		
		
		for(int i=0; i<provincias.length;i++) {			
			fichero_escribir.write(provincias[i]+"\r\n");
		}
		
		fichero_escribir.close();		
	}
}