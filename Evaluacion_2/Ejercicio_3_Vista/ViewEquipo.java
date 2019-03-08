package Ejercicio_3_Vista;

import java.util.List;

import Ejercicio_3_Modelo.Equipo;

public class ViewEquipo {
	
	
	public void viewEquipo(Equipo equipo) {
		System.out.println("Datos del equipo: " +equipo.getNombre());
	}
	
	public void viewTodosEquipos(List<Equipo> equipos) {
		for (Equipo equipo: equipos) {
			System.out.println("Datos del equipo: "+ equipo.getNombre());
		}
	}
}
