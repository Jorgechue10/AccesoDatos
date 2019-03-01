package vistas;

import java.util.List;

import modelos.Equipo;

public class ViewEquipo {
	
	
	public void viewEquipo(Equipo equipo) {
		System.out.println("Datos del equipo: " +equipo);
	}
	
	public void viewTodosEquipos(List<Equipo> equipos) {
		for (Equipo equipo: equipos) {
			System.out.println("Datos de los equipos: "+ equipo);
		}
	}
}
