package P06_JAXB;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType; 

/*anotacion para establecer rl orden en el que se introducirán 
 * los elementos en el mfichero xml*/
@XmlType(propOrder = {"id", "anio", "titulo", "artista","duracion","cancion_espaniola"})

public class EJ_2_1_Cancion implements Serializable{
	private int id,anio;
	private String titulo, artista, duracion;
	private boolean cancion_espaniola;
	
	public EJ_2_1_Cancion(int i, int a, String t, String arti, String d, boolean c_esp) {
		id=i;
		anio=a;
		titulo=t;
		artista=arti;
		duracion=d;
		cancion_espaniola=c_esp;
	}
	
	public EJ_2_1_Cancion() {
		
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
}
