/*Clase que inserta datos al final del fichero aleatorio*/

package P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EJ_4_4_Insertar_final_fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File f = new File("Unidad_01_Ficheros\\P04_FicherosBytes\\Ficheros\\ej_4_fichero_aleatorio.dat");
		
		RandomAccessFile raf = new RandomAccessFile (f, "rw");
		
		int id = 11;
		String apellidos = "García";
		int dpto = 12;
		double salario = 1000;
		
		long posicion = raf.length();		
		raf.seek(posicion);
		
		raf.writeInt(id);//número de empleado
		
		StringBuffer sb = null;
		sb= new StringBuffer(apellidos);
		sb.setLength(10);
		raf.writeChars(sb.toString());
		
		raf.writeInt(dpto);
		raf.writeDouble(salario);	
		
		raf.close();
	}
}