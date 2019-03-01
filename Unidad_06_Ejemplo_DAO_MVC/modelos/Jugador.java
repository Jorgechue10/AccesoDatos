package modelos;

public class Jugador {

	
	private int codigo;
	
	private String nombre;
	private String nombre_equipo;
	private String procedencia;
	private String altura;
	private String posicion;
	private int peso;
	
	
	public Jugador() {
		
	}
	
	public Jugador(int codigo, String nombre, String nombre_equipo, String procedencia, String altura, String posicion,
			int peso) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nombre_equipo = nombre_equipo;
		this.procedencia = procedencia;
		this.altura = altura;
		this.posicion = posicion;
		this.peso = peso;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre_equipo() {
		return nombre_equipo;
	}
	public void setNombre_equipo(String nombre_equipo) {
		this.nombre_equipo = nombre_equipo;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		
		return this.codigo+", "+this.nombre+", "+this.nombre_equipo+", "+this.posicion+", "+this.altura+", "+this.procedencia+", "+this.peso;
		
	}
	
	
	
}
