package P03_De_MySQL_a_NeoDatis;

import java.util.Set;

public class C1Centros {

	private Integer codCentro;
	private String nomCentro;
	private C1Profesores director;
	private String direccion;
	private String localidad;
	private String provincia;
	private Set<C1Profesores> setprofesores;
	public C1Centros(Integer codCentro, String nomCentro, C1Profesores director, String direccion, String localidad,
			String provincia, Set<C1Profesores> setprofesores) {
		super();
		this.codCentro = codCentro;
		this.nomCentro = nomCentro;
		this.director = director;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.setprofesores = setprofesores;
	}
	
	public C1Centros(){}

	public Integer getCodCentro() {
		return codCentro;
	}

	public void setCodCentro(Integer codCentro) {
		this.codCentro = codCentro;
	}

	public String getNomCentro() {
		return nomCentro;
	}

	public void setNomCentro(String nomCentro) {
		this.nomCentro = nomCentro;
	}

	public C1Profesores getDirector() {
		return director;
	}

	public void setDirector(C1Profesores director) {
		this.director = director;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Set<C1Profesores> getSetprofesores() {
		return setprofesores;
	}

	public void setSetprofesores(Set<C1Profesores> setprofesores) {
		this.setprofesores = setprofesores;
	}
	

}
