package UD_01_P04_FicherosBytes;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private int edad;
	private String nombre;
	
	public Persona(int e, String n) {
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