package P04_FicherosBytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EJ_1_LeerEscribirBytes {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("Unidad_01_Ficheros\\P04_FicherosBytes\\Ficheros\\datos.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		FileInputStream filein = new FileInputStream(f);
		
		int i;
		
		for(i=0;i<100;i++) {
			fileout.write(i);
		}
		fileout.close();
		
		while((i=filein.read())!=-1) {
			System.out.println(i);
		}
		filein.close();		
	}
}