/*Esta clase es la misma que ListaReproduccion que se encuentra en el paquete anterior*/

package UD_01_P05_Ficheros_XML;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class Cancion implements Serializable{
	private int id,anio;
	private String titulo, artista, duracion;
	private boolean cancion_espaniola;
	
	public Cancion(int i, int a, String t, String arti, String d, boolean c_esp) {
		id=i;
		anio=a;
		titulo=t;
		artista=arti;
		duracion=d;
		cancion_espaniola=c_esp;
	}
	
	public Cancion() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public boolean getCancion_espaniola() {
		return cancion_espaniola;
	}
	public void setCancion_espaniola(boolean cancion_espaniola) {
		this.cancion_espaniola = cancion_espaniola;
	}
	//Comprobamos si existe el ID
	public boolean existeID(int id_introducido) throws IOException {
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\Ficheros\\listaReproduccion.dat");
		RandomAccessFile raf = new RandomAccessFile (f, "r");
		int posicion=0;
		
		try {
			do {
				raf.seek(posicion);
				id=raf.readInt();				
				
				posicion += 69;
				/*69 porque ocupan todos los elementos 69B
				2 int = 8B
				3 String = 2B * 10 * 3= 60B
				1 boolean = 1B
				Total = 69B*/				
				if(id==id_introducido) {
					return true;
				}
			}while(raf.getFilePointer()!=raf.length());			
			raf.close();
		}catch (EOFException e) {			
			System.out.printf("");
		}
		return false;
	}
	
}
