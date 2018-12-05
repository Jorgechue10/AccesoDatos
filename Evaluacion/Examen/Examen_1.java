package Examen;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Examen_1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int n=0;
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Introduce el nombre del fichero");
		String nombre_Fichero= teclado.nextLine();
		do {
			System.out.println("_____________________________________ ");
			System.out.println("|       LISTA DE REPRODUCCIÓN        |");
			System.out.println("|------------------------------------|");
			System.out.println("|0.-Crear fichero                    |");	
			System.out.println("|1.-Añadir número al principio       |");
			System.out.println("|2.-Añadir número al final           |");
			System.out.println("|3.-Mostrar el contenido del fichero |");
			System.out.println("|4.-Sustituir número                 |");
			System.out.println("|5.-Salir                            |");
			System.out.println("|____________________________________|");	
		
			n = teclado.nextInt();
			File f = new File("Evaluacion\\Examen\\"+nombre_Fichero+".dat");
			RandomAccessFile raf = new RandomAccessFile (f, "rw");		
			
			double numero;
			long posicion=0;
			
			switch (n) {
			
				case 0: 
					f.createNewFile();
				break;
			
				case 1:
					try {						
						System.out.println("Introduce un número");	
						numero=teclado.nextDouble();
						double aux;
						posicion=0;
						raf.seek(posicion);
						aux=raf.readDouble();
						raf.seek(posicion);
						raf.writeDouble(numero);
						posicion += 8;	
						
						do {
							raf.seek(posicion);
							numero=aux;
							aux=raf.readDouble();
							raf.seek(posicion);
							raf.writeDouble(numero);
							posicion += 8;								
						}while(raf.getFilePointer()!=raf.length());						
						raf.seek(posicion);
						raf.writeDouble(aux);
					}catch (EOFException e) {			
						System.out.println("No hay ningún número");
					}	
					break;
					
				case 2: 				
					System.out.println("Introduce un número");	
					numero=teclado.nextDouble();
					posicion = raf.length();
					raf.seek(posicion);
					raf.writeDouble(numero);										
					break;
					
				case 3: 
					try {
						posicion=0;
						do {						
							raf.seek(posicion);
							numero=raf.readDouble();									
							System.out.println(numero);				
							posicion += 8;	
							
						}while(raf.getFilePointer()!=raf.length());						
						
					}catch (EOFException e) {			
						System.out.println("No hay ningún número");
					}				
					break;
					
				case 4: 
					System.out.println("Introduce el número que quieres sustituir");	
					double numeroSustituir=teclado.nextDouble();
					System.out.println("Introduce el número que quieres que sea el sustituto");	
					double numeroSustituto=teclado.nextDouble();
					try {
						posicion=0;
						do {						
							raf.seek(posicion);
							numero=raf.readDouble();
							if(numero==numeroSustituir) {
								raf.seek(posicion);
								raf.writeDouble(numeroSustituto);
							}								
							posicion += 8;				
							
						}while(raf.getFilePointer()!=raf.length());						
						
					}catch (EOFException e) {			
						System.out.println("No hay ningún número");
					}	
					break;			
					
				case 5:
					raf.close();
					System.out.println("Has salido del programa");
					break;
					
				default:
					System.out.println("ERROR, debe introducir un número entre el 1 y el 5");
			}
			
		}while(n!=5);		
		teclado.close();
	}
}
