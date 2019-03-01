package vistas;

import java.util.List;
import modelos.Jugador;

public class ViewJugador {
	
	
	public void viewJugador(Jugador jugador) {
		System.out.println("Datos del jugador: " +jugador);
	}
	
	public void viewTodosJugadores(List<Jugador> jugadores) {
		for (Jugador jugador: jugadores) {
			System.out.println("Datos del jugador: "+ jugador);
		}
	}
}
