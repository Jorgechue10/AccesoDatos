package UD_01_P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class insertar_final_fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\Ficheros\\escritura_fichero_aleatorio.dat");
		
		RandomAccessFile raf = new RandomAccessFile (f, "rw");
		
		int id = 11;
		String apellidos = "Garc�a";
		int dpto = 12;
		double salario = 1000;
		
		long posicion = raf.length();		
		raf.seek(posicion);
		
		raf.writeInt(id);//n�mero de empleado
		
		StringBuffer sb = null;
		sb= new StringBuffer(apellidos);
		sb.setLength(10);
		raf.writeChars(sb.toString());
		
		raf.writeInt(dpto);
		raf.writeDouble(salario);	
		
		raf.close();
	}
}