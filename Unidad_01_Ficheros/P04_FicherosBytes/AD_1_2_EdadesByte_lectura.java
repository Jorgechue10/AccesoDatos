/*Clase que lee de un fichero de bytes una lista de nombres y edades, 
 * y enviar la lectura a la salida estandar.*/

package P04_FicherosBytes;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AD_1_2_EdadesByte_lectura {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f = new File("Unidad_01_Ficheros\\P04_FicherosBytes\\Ficheros\\ad_1_edades.dat");
		f.createNewFile();
		
		String[] nombres = new String[10];
		int[] edades = new int[10];
		
		FileInputStream filein = new FileInputStream(f);
		DataInputStream dataIS = new DataInputStream(filein);
		
		try {
			while(true){
				for(int i=0;i<10;i++) {
					nombres[i]=dataIS.readUTF();
					edades[i]=dataIS.readInt();
					System.out.println("Perosna "+(i+1)+": Nombre: "+nombres[i]+", Edad: "+edades[i]);					
				}				
			}
		}catch (EOFException eo) {
			System.out.println("");
		}
	}
}
