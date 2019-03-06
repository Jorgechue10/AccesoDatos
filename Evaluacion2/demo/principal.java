package demo;

import controlador.ControllerEquipo;
import modelo.Equipo;

public class principal {

	public static void main(String[] args) {

		//Equipos
		ControllerEquipo controller = new ControllerEquipo();
		
		
		Equipo equipo = new Equipo("Real Zaragoza", 0, 6, 1932, 59);
		//controller.create(equipo);
		
		//Ordenar por ligas ganadas
		controller.viewEquipos();
		
		Equipo equipo2 = new Equipo("Barcelona", 23, 26, 1899, 83);
		controller.update(equipo2);
		
		Equipo equipo3 = new Equipo();
		equipo3.setNombre("Mérida");
		//controller.remove(equipo3);
		
	}
}