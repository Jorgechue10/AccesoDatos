/*Clase que contiene los movimientos de una cuenta corriente*/

package UD_01_P04_FicherosBytes;

import java.io.Serializable;

public class MovimientoBancario implements Serializable{
	private String fecha;
	private String concepto;
	private int cantidad;
	private boolean tipo;
	
	public MovimientoBancario(String f, String c, int cant, boolean t) {
		fecha=f;
		concepto=c;
		cantidad=cant;
		tipo=t;		
	}	
	
	//getters
	public String getFecha() {
		return fecha; 
	}
	public String getConcepto() {
		return concepto; 
	}
	public int getCantidad() {
		return cantidad; 
	}
	public boolean getTipo() {
		return tipo; 
	}
	
	//setters
	public void setFecha(String fec) {
		fecha=fec; 
	}
	public void setConcepto(String con) {
		concepto=con; 
	}
	public void setCantidad(int can) {
		cantidad=can; 
	}
	public void setTipo(boolean tip) {
		tipo=tip; 
	}
}