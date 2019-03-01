package P01_Introduccion_JavaBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * Bean con los atributos correspondientes a los campos de la tabla de base
 * de datos.
 * @author chuidiang
 */
public class EJ_2_1_Persona {
	int id;
	String nombre;
	Date fechaNacimiento;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/** Para poder escribir el bean en pantalla de forma rápida */
	public String toString()
	{
		return ""+id+" "+nombre+" "+formateador.format(fechaNacimiento);
	}
	
	/** Para escribir las fechas en un formato más mejor */
	private static SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
}