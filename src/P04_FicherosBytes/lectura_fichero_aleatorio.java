/*
int -> 4B
Double -> 8B
char -> 2B
String -> 2B(char) * número de characters que haya*/

package P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.EOFException;
import java.io.RandomAccessFile;

public class lectura_fichero_aleatorio {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\Ficheros\\escritura_fichero_aleatorio.dat");
		RandomAccessFile raf = new RandomAccessFile (f, "r");	
		int id, posicion=0;
		char[] apellidos = new char [10];
		char aux;
		String apellido;
		int dpto;
		double salario;
		try {
			do {
				raf.seek(posicion);//Nos situamos en un lugar determinado del fichero para empezar a leer desde allí
				id=raf.readInt();				
				
				posicion += 36;
				/*36 porque ocupan todos los elementos 36B
				2 int = 8B
				1 Double = 8B
				1 String = 2B * 10 = 20B
				Total = 36B*/
				
				for(int i=0;i<apellidos.length;i++) {
					aux=raf.readChar();
					apellidos[i]=aux;
				}
				
				apellido = new String(apellidos);
				
				dpto = raf.readInt();
				salario = raf.readDouble();
				
				System.out.println("Id: "+id+" Apellidos: "+apellido+" Departamento: "+dpto+" Salario: "+salario);
						
			}while(raf.getFilePointer()!=raf.length());
			/*.getFilePointer nos dice hacia donde está apuntando el puntero
			.length dice el total de bytes que ocupa la informacion escrita en el fichero*/
			
			raf.close();
		}catch (EOFException e) {			
			System.out.printf("Se ha llegado al final del fichero");
		}	
	}
}