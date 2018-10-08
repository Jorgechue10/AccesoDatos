/*
 * Este programa crea un fichero de tipo binario, escribe en él los nombres y edades de 10 personas,
 * y después los lee y los envía a la salida estándar
 * */

package P04_FicherosBytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class edadesByte {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\edades.dat");
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
		
		int i;
		for(i=0;i<10;i++) {
			dataOS.writeUTF(nombres[i]);
			dataOS.writeInt(edades[i]);
		}
		dataOS.close();	
		
		FileInputStream filein = new FileInputStream(f);
		DataInputStream dataIS = new DataInputStream(filein);
		
		try {
			while(true){
				for(i=0;i<10;i++) {
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