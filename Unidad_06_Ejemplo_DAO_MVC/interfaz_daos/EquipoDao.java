package interfaz_daos;

import java.util.List;

import modelos.Equipo;

public interface EquipoDao {
	
	public boolean create(Equipo equipo);
	public List<Equipo>read();
	public boolean update(Equipo equipo);
	public boolean delete(Equipo equipo);
	
}
