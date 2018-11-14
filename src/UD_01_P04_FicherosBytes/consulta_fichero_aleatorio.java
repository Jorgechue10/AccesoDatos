/*Lo que vamos a hacer es en vex de leer todos los empleados, solo queremos leer uno (consulta)*/

package UD_01_P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class consulta_fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\Ficheros\\escritura_fichero_aleatorio.dat");
		RandomAccessFile raf = new RandomAccessFile (f, "r");	
		
		int id=5;
		int posicion=(id-1)*36;//Restamos -1 porque tenemos que empezar a leer una posici�n antes
		
		char[] apellidos = new char [10];
		char aux;
		String apellido;
		int dpto;
		double salario;
		
		raf.seek(posicion);//Nos situamos en un lugar determinado del fichero para empezar a leer desde all�
		id=raf.readInt();				
		
		posicion += 36;
		
		for(int i=0;i<apellidos.length;i++) {
			aux=raf.readChar();
			apellidos[i]=aux;
		}
		
		apellido = new String(apellidos);
		
		dpto = raf.readInt();
		salario = raf.readDouble();
		
		System.out.println("Id: "+id+" Apellidos: "+apellido+" Departamento: "+dpto+" Salario: "+salario);
		
		raf.close();
	}
}