package UD_01_P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ListaReproduccionMain {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int numero=0;
		Scanner teclado = new Scanner (System.in);
		do {
			System.out.println("_____________________________________ ");
			System.out.println("|       LISTA DE REPRODUCCI�N        |");
			System.out.println("|------------------------------------|");	
			System.out.println("|1.-Generar fichero                  |");
			System.out.println("|2.-Insertar datos                   |");
			System.out.println("|3.-Consultar datos de una canci�n   |");
			System.out.println("|4.-Modificar a�o de la canci�n      |");
			System.out.println("|5.-Borrar informaci�n de una canci�n|");	
			System.out.println("|6.-Mostrar canciones borradas       |");
			System.out.println("|7.-Mostrar todas las canciones      |");
			System.out.println("|8.-Salir                            |");
			System.out.println("|____________________________________|");	
		
			numero = teclado.nextInt();
			File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\Ficheros\\listaReproduccion.dat");
			RandomAccessFile raf = new RandomAccessFile (f, "rw");
			StringBuffer sb = null;
			
			ListaReproduccion l = new ListaReproduccion();		
			
			int id,anio,anioAnterior;
			String titulo, artista, duracion;
			boolean cancion_espaniola;
			char[] titulos = new char [10], artistas = new char [10], duraciones = new char [10];
			char aux;
			long posicion=0;
			
			switch (numero) {
			
			case 1: 				
				f.createNewFile();
				break;
				
			case 2: 				
				do {					
					System.out.println("Introduce el ID (El ID tiene que seer mayor que 0)");			
					id=teclado.nextInt();
				}while(id<=0);
				
				if(!l.existeID(id)) {
					System.out.println("Introduce el a�o");			
					anio=teclado.nextInt();
					teclado.nextLine();
					System.out.println("Introduce el titulo");			
					titulo=teclado.nextLine();
					System.out.println("Introduce el artista");			
					artista=teclado.nextLine();
					System.out.println("Introduce la duracion");			
					duracion=teclado.nextLine();
					System.out.println("Introduce si es una canci�n espa�ola(true) o extranjera(false)");			
					cancion_espaniola=teclado.nextBoolean();
					
					l = new ListaReproduccion(id,anio,titulo,artista,duracion,cancion_espaniola);
						
					posicion = raf.length();
					raf.seek(posicion);
					
					raf.writeInt(id);
					raf.writeInt(anio);					
					
					sb= new StringBuffer(titulo);
					sb.setLength(10);
					raf.writeChars(sb.toString());
					sb= new StringBuffer(artista);
					sb.setLength(10);
					raf.writeChars(sb.toString());
					sb= new StringBuffer(duracion);
					sb.setLength(10);
					raf.writeChars(sb.toString());
					
					raf.writeBoolean(cancion_espaniola);					
				}else 
					System.out.println("Error, ya existe una canci�n con ese ID");						
				break;
				
			case 3: 
				do {					
					System.out.println("Introduce el ID de la canci�n a consultar (El ID tiene que seer mayor que 0)");
					id=teclado.nextInt();
				}while(id<=0);
							
				if(l.existeID(id)) {
					posicion=(id-1)*69;
					raf.seek(posicion);
					id=raf.readInt();				
					anio=raf.readInt();	
					
					for(int i=0;i<titulos.length;i++) {
						aux=raf.readChar();
						titulos[i]=aux;
					}					
					titulo = new String(titulos);
					
					for(int i=0;i<artistas.length;i++) {
						aux=raf.readChar();
						artistas[i]=aux;
					}					
					artista = new String(artistas);
					
					for(int i=0;i<duraciones.length;i++) {
						aux=raf.readChar();
						duraciones[i]=aux;
					}					
					duracion = new String(duraciones);
					
					cancion_espaniola = raf.readBoolean();
					
					System.out.println("Id: "+id+" A�o: "+anio+" Titulo: "+titulo+" Artista: "+artista+" Duraci�n: "+duracion+" �Canci�n espa�ola?: "+cancion_espaniola);
				}else
					System.out.println("No existe ninguna canci�n con ese ID");				
				break;
				
			case 4: 
				do {					
					System.out.println("Introduce el ID de la canci�n para modificar su a�o (El ID tiene que seer mayor que 0)");
					id=teclado.nextInt();
				}while(id<=0);
				
				if(l.existeID(id)) {
					posicion=(id-1)*69+4;
					raf.seek(posicion);										
					anioAnterior=raf.readInt();							
					
					System.out.println("Introduce el nuevo a�o");					
					anio=teclado.nextInt();		
					
					raf.seek(posicion);
					
					raf.writeInt(anio);	
					
					for(int i=0;i<titulos.length;i++) {
						aux=raf.readChar();
						titulos[i]=aux;
					}	
					titulo = new String(titulos);
					
					System.out.println("Id: "+id+" A�o aterior: "+anioAnterior+" A�o nuevo: "+anio+" Titulo: "+titulo);
					
				}else
					System.out.println("No existe ninguna canci�n con ese ID");
				break;
				
			case 5: 
				do {					
					System.out.println("Introduce el ID de la canci�n para borrarla (El ID tiene que seer mayor que 0)");
					id=teclado.nextInt();
				}while(id<=0);
			
				if(l.existeID(id)) {
					posicion=(id-1)*69;										
					
					raf.seek(posicion);
					
					raf.writeInt(-1);	
					System.out.println("Se ha borrado la canci�n");
				}else
					System.out.println("No existe ninguna canci�n con ese ID");
				break;
				
			case 6: 
				try {
					posicion=0;
					System.out.println("CANCIONES BORRADAS:");
					do {						
						raf.seek(posicion);
						id=raf.readInt();	
						if(id==-1) {
							
							anio=raf.readInt();	
							
							for(int i=0;i<titulos.length;i++) {
								aux=raf.readChar();
								titulos[i]=aux;
							}					
							titulo = new String(titulos);
							
							for(int i=0;i<artistas.length;i++) {
								aux=raf.readChar();
								artistas[i]=aux;
							}					
							artista = new String(artistas);
							
							for(int i=0;i<duraciones.length;i++) {
								aux=raf.readChar();
								duraciones[i]=aux;
							}					
							duracion = new String(duraciones);
							
							cancion_espaniola = raf.readBoolean();
							
							System.out.println("Id: "+id+" A�o: "+anio+" Titulo: "+titulo+" Artista: "+artista+" Duraci�n: "+duracion+" �Canci�n espa�ola?: "+cancion_espaniola);
						}					
						posicion += 69;
						/*69 porque ocupan todos los elementos 69B
						2 int = 8B
						3 String = 2B * 10 * 3= 60B
						1 boolean = 1B
						Total = 69B*/	
						
					}while(raf.getFilePointer()!=raf.length());
					/*.getFilePointer nos dice hacia donde est� apuntando el puntero
					.length dice el total de bytes que ocupa la informacion escrita en el fichero*/
					
				}catch (EOFException e) {			
					System.out.println("No hay ninguna canci�n borrada");
				}	
				break;
			case 7: 
				try {
					posicion=0;
					do {						
						raf.seek(posicion);//Nos situamos en un lugar determinado del fichero para empezar a leer desde all�
						id=raf.readInt();	
						if(id!=-1) {
							anio=raf.readInt();	
							
							for(int i=0;i<titulos.length;i++) {
								aux=raf.readChar();
								titulos[i]=aux;
							}					
							titulo = new String(titulos);
							
							for(int i=0;i<artistas.length;i++) {
								aux=raf.readChar();
								artistas[i]=aux;
							}					
							artista = new String(artistas);
							
							for(int i=0;i<duraciones.length;i++) {
								aux=raf.readChar();
								duraciones[i]=aux;
							}					
							duracion = new String(duraciones);
							
							cancion_espaniola = raf.readBoolean();
							
							System.out.println("Id: "+id+" A�o: "+anio+" Titulo: "+titulo+" Artista: "+artista+" Duraci�n: "+duracion+" �Canci�n espa�ola?: "+cancion_espaniola);
						}					
						posicion += 69;
						/*69 porque ocupan todos los elementos 69B
						2 int = 8B
						3 String = 2B * 10 * 3= 60B
						1 boolean = 1B
						Total = 69B*/	
						
					}while(raf.getFilePointer()!=raf.length());
					/*.getFilePointer nos dice hacia donde est� apuntando el puntero
					.length dice el total de bytes que ocupa la informacion escrita en el fichero*/
					
				}catch (EOFException e) {			
					System.out.println("No hay ninguna canci�n en la lista");
				}	
				break;
				
			case 8:
				raf.close();
				System.out.println("Has salido del programa");
				System.out.println("                 -------------------------------");
				System.out.println("                 |            Autor            |");
				System.out.println("                 |                             |");
				System.out.println("                 |         Jorge Chueca        |");
				System.out.println("                 |                             |");
				System.out.println("                 -------------------------------");break;
				
			default:
				System.out.println("ERROR, debe introducir un n�mero entre el 1 y el 8");
			}
			
		}while(numero!=8);		
		teclado.close();
	}
}