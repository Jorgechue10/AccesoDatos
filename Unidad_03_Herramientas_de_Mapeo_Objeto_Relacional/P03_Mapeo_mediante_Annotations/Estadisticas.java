package P03_Mapeo_mediante_Annotations;

import javax.persistence.*;

@Entity
@Table(name="estadisticas")
public class Estadisticas implements java.io.Serializable {

	@Id
    @Column(name="temporada")
	private String temporada;

	@Id
	@Column(name="jugador")
	private int jugador;
	
	@Column(name="Puntos_por_partido")
	private float Puntos_por_partido;
	
	@Column(name="Asistencias_por_partido")
	private float Asistencias_por_partido;
	
	@Column(name="Tapones_por_partido")
	private float Tapones_por_partido;
	
	@Column(name="Rebotes_por_partido")
	private float Rebotes_por_partido;
	

	
	// Las relaciones también se mapean
	//private Set jugadoreses = new HashSet(0);
	//private Set partidosesForEquipoVisitante = new HashSet(0);
	//private Set partidosesForEquipoLocal = new HashSet(0);

	public Estadisticas() {
	}

	public Estadisticas(String temporada, int jugador) {
		this.temporada = temporada;
		this.jugador = jugador;
	}

	public Estadisticas(String temporada, int jugador, float Puntos_por_partido, float Asistencias_por_partido, 
			float Tapones_por_partido, float Rebotes_por_partido) {
		this.temporada = temporada;
		this.jugador = jugador;
		this.Puntos_por_partido = Puntos_por_partido;
		this.Asistencias_por_partido = Asistencias_por_partido;
		this.Tapones_por_partido = Tapones_por_partido;
		this.Rebotes_por_partido = Rebotes_por_partido;


		
	}
	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public int getJugador() {
		return jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

	public float getPuntos_por_partido() {
		return Puntos_por_partido;
	}

	public void setPuntos_por_partido(float puntos_por_partido) {
		Puntos_por_partido = puntos_por_partido;
	}

	public float getAsistencias_por_partido() {
		return Asistencias_por_partido;
	}

	public void setAsistencias_por_partido(float asistencias_por_partido) {
		Asistencias_por_partido = asistencias_por_partido;
	}

	public float getTapones_por_partido() {
		return Tapones_por_partido;
	}

	public void setTapones_por_partido(float tapones_por_partido) {
		Tapones_por_partido = tapones_por_partido;
	}

	public float getRebotes_por_partido() {
		return Rebotes_por_partido;
	}

	public void setRebotes_por_partido(float rebotes_por_partido) {
		Rebotes_por_partido = rebotes_por_partido;
	}
}