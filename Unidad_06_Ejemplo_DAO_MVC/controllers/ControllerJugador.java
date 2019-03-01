package controllers;


import java.util.ArrayList;
import java.util.List;

import daos.JugadorDaoMySQLImp;
import interfaz_daos.JugadorDao;
import daos.JugadorDaoMongoDBImp;
import modelos.Jugador;
import vistas.ViewJugador;

public class ControllerJugador {
	
	private ViewJugador vista = new ViewJugador();
	
	
	public ControllerJugador() {
	}
	
	public void create(Jugador jugador) {
		JugadorDao dao = new JugadorDaoMySQLImp();
		JugadorDao daoMongo = new JugadorDaoMongoDBImp();
	//	dao.create(jugador);
		daoMongo.create(jugador);
	}
	
	public void update(Jugador jugador) {
		JugadorDao dao = new JugadorDaoMySQLImp();
		dao.update(jugador);
	}
	
	public void remove(Jugador jugador) {
		JugadorDao dao = new JugadorDaoMySQLImp();
		dao.delete(jugador);
	}
	
	public void viewJugadores() {
		
		//MySQL
		List<Jugador> jugadores = new ArrayList<Jugador>();
		JugadorDao dao = new JugadorDaoMySQLImp();
		
		
		 jugadores = dao.read();
		 vista.viewTodosJugadores(jugadores);
		
		
		///Mongo
		/*JugadorDao daoMongo = new JugadorDaoMongoDBImp();
		List<Jugador> jugadoresMongo = new ArrayList<Jugador>();
		jugadoresMongo = daoMongo.read();
		vista.viewTodosJugadores(jugadoresMongo);*/
		
		
	}
	
	public void viewJugador(Jugador jugador) {
		vista.viewJugador(jugador);
	}
}
