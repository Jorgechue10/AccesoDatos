package P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class escritura_fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\Ficheros\\escritura_fichero_aleatorio.dat");
		f.createNewFile();
		
		RandomAccessFile raf = new RandomAccessFile (f, "rw");//el modo rw si no existe el fichero lo crea
		
		StringBuffer sb = null;
		
		String[] apellidos = new String[10];
		apellidos[0]="Martinez";
		apellidos[1]="Sanchez";
		apellidos[2]="Hernandez";
		apellidos[3]="Fernandez";
		apellidos[4]="Perez";
		apellidos[5]="Alonso";
		apellidos[6]="Rodriguez";
		apellidos[7]="Moreno";
		apellidos[8]="Lopez";
		apellidos[9]="Navas";
		
		int [] dpto = new int[10];
		dpto[0]=20;
		dpto[1]=19;
		dpto[2]=18;
		dpto[3]=17;
		dpto[4]=16;
		dpto[5]=15;
		dpto[6]=14;
		dpto[7]=13;
		dpto[8]=12;
		dpto[9]=11;
		
		double[] salario = new double[10];
		salario[0]=100;
		salario[1]=200;
		salario[2]=300;
		salario[3]=400;
		salario[4]=500;
		salario[5]=600;
		salario[6]=700;
		salario[7]=800;
		salario[8]=900;
		salario[9]=950;
		
		for(int i=0;i<10;i++) {	
			raf.writeInt(i+1);//número de empleado
			
			sb= new StringBuffer(apellidos[i]);
			sb.setLength(10);
			raf.writeChars(sb.toString());
			
			raf.writeInt(dpto[i]);
			raf.writeDouble(salario[i]);	
		}
	}
}