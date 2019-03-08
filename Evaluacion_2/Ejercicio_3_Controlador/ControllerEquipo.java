package Ejercicio_3_Controlador;


import java.util.ArrayList;
import java.util.List;

import Ejercicio_3_DAOS.EquipoDaoMySQLI;
import Ejercicio_3_Interfaz_DAOS.EquipoDao;
import Ejercicio_3_Modelo.Equipo;
import Ejercicio_3_Vista.ViewEquipo;

public class ControllerEquipo {
	
	private ViewEquipo vista = new ViewEquipo();
	
	
	public ControllerEquipo() {
	}
	
	public void create(Equipo equipo) {
		EquipoDao dao = new EquipoDaoMySQLI();
		dao.create(equipo);
	}
	
	public void update(Equipo equipo) {
		EquipoDao dao = new EquipoDaoMySQLI();
		dao.update(equipo);
	}
	
	public void remove(Equipo equipo) {
		EquipoDao dao = new EquipoDaoMySQLI();
		dao.delete(equipo);
	}
	
	public void viewEquipos() {
		
		List<Equipo> equipos = new ArrayList<Equipo>();
		EquipoDao dao = new EquipoDaoMySQLI();
		
		equipos = dao.read();
		 vista.viewTodosEquipos(equipos);
	}
	
	public void viewEquipo(Equipo equipo) {
		vista.viewEquipo(equipo);
	}
}
