/*Clase que escribe en un fichero de bytes una lista de 10 nombres y edades*/

package P04_FicherosBytes;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AD_1_1_EdadesByte_escritura {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File f = new File("Unidad_01_Ficheros\\P04_FicherosBytes\\Ficheros\\ad_1_edades.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		DataOutputStream dataOS = new DataOutputStream(fileout);
		
		String[] nombres = new String[10];
		nombres[0]="Isabel";
		nombres[1]="Pepe";
		nombres[2]="Juan";
		nombres[3]="Alex";
		nombres[4]="Oscar";
		nombres[5]="Tono";
		nombres[6]="Fran";
		nombres[7]="Jorge";
		nombres[8]="Marisa";
		nombres[9]="Elena";
		
		int[] edades = new int[10];
		edades[0]=20;
		edades[1]=19;
		edades[2]=18;
		edades[3]=17;
		edades[4]=16;
		edades[5]=15;
		edades[6]=14;
		edades[7]=13;
		edades[8]=12;
		edades[9]=11;
		
		for(int i=0;i<10;i++) {
			dataOS.writeUTF(nombres[i]);
			dataOS.writeInt(edades[i]);
		}
		dataOS.close();			
	}
}