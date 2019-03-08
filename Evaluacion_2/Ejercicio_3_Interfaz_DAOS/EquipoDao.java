package Ejercicio_3_Interfaz_DAOS;

import java.util.List;

import Ejercicio_3_Modelo.Equipo;

public interface EquipoDao {
	
	public boolean create(Equipo equipo);
	public List<Equipo>read();
	public boolean update(Equipo equipo);
	public boolean delete(Equipo equipo);	
}