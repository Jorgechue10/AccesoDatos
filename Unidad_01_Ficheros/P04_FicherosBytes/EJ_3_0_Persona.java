package P04_FicherosBytes;

import java.io.Serializable;

public class EJ_3_0_Persona implements Serializable{
	
	private int edad;
	private String nombre;
	
	public EJ_3_0_Persona(int e, String n) {
		edad=e;
		nombre=n;
	}
	
	public String getNombre() {
		return nombre; 
	}
	public int getEdad() {
		return edad; 
	}
	
	public void setNombre(String n) {
		nombre=n; 
	}
	public void setEdad(int x) {
		edad=x; 
	}
}