package P03_Mapeo_mediante_Annotations;

import javax.persistence.*;

@Entity
@Table(name="equipos")
public class Equipos implements java.io.Serializable {

	@Id
    @Column(name="Nombre")
	private String nombre;

	@Column(name="Ciudad")
	private String ciudad;
	
	@Column(name="Conferencia")
	private String conferencia;
	
	@Column(name="Division")
	private String division;
	
	// Las relaciones también se mapean

	public Equipos() {
	}

	public Equipos(String nombre) {
		this.nombre = nombre;
	}

	public Equipos(String nombre, String ciudad, String conferencia, String division) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.conferencia = conferencia;
		this.division = division;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getConferencia() {
		return conferencia;
	}

	public void setConferencia(String conferencia) {
		this.conferencia = conferencia;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
}
