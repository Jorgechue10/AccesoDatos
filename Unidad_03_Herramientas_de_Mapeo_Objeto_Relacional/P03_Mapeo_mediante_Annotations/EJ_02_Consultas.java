package P03_Mapeo_mediante_Annotations;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EJ_02_Consultas {

	public static void main(String[] args) {
		
		try {
			
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			
			System.out.println("Creada la session Factory, se abre session");
			
			Session session = sessionFactory.openSession();	
			
			
			//--------------CONSULTAS----------------------				
			Scanner teclado = new Scanner (System.in);
			
			//CONSULTA 1 -> Consultar datos de un equipo pasandole el nombre
			/*System.out.println("\nCONSULTA 1 -> Consultar datos de un equipo pasandole el nombre.");
			System.out.println("Intrduce el nombre del equipo:");			
			String nombre = teclado.nextLine();
			
			Query query = session.createQuery("FROM Equipos where nombre = '"+nombre+"'");			
			List<Equipos> equipos = query.list();
			
			for (Equipos equipo : equipos) {
				System.out.println("Nombre: "+equipo.getNombre()+" Ciudad: "+equipo.getCiudad()+
						" Coferencia: "+equipo.getConferencia()+" División: "+equipo.getDivision());
			}*/
			
			
			//CONSULTA 2 -> Consultar los jugadores de un equipo pasandole el nombre del equipo
			/*System.out.println("\nCONSULTA 2 -> Consultar los jugadores de un equipo pasandole el nombre del equipo.");
			System.out.println("Intrduce el nombre del equipo:");			
			String nombreEquipo = teclado.nextLine();
			
			Query query = session.createQuery("FROM Jugadores where Nombre_equipo = '"+nombreEquipo+"'");			
			List<Jugadores> jugadores = query.list();
			
			for (Jugadores jugador : jugadores) {
				System.out.println("Código: "+jugador.getCodigo()+" Nombre: "+jugador.getNombre());
			}*/
			
			
			//CONSULTA 3 -> Consultar la ficha del jugador pasado por teclado
			/*System.out.println("\nCONSULTA 3 -> Consultar la ficha del jugador pasado por teclado.");
			System.out.println("Intrduce el nombre del jugador:");			
			String nombreJugador = teclado.nextLine();
			
			Query query = session.createQuery("FROM Jugadores where nombre like '%"+nombreJugador+"%'");			
			List<Jugadores> jugadores = query.list();
			
			for (Jugadores jugador : jugadores) {
				System.out.println("Código: "+jugador.getCodigo()+" Nombre: "+jugador.getNombre()+" Procedencia:"+
				jugador.getProcedencia()+" Altura: "+jugador.getAltura()+" Peso: "+jugador.getPeso()+" Posicion: "+
						jugador.getPosicion()+" Equipos: "+jugador.getEquipos());
			}*/
			
			
			//CONSULTA 4 -> CONSULTA 4 -> Consultar los datos, estadísticas, nombre del equipo y ciudad del equipo de un jugador pasando su código
			/*System.out.println("\nCONSULTA 4 -> Consultar los datos, estadísticas, nombre del equipo y ciudad del equipo de un jugador pasando su código.");
			System.out.println("Intrduce el codigo del jugador:");			
			
			int codigoJugador = teclado.nextInt();
			
			
			System.out.println("------DATOS-----");
			
			Query query = session.createQuery("FROM Jugadores where codigo = "+codigoJugador);			
			List<Jugadores> jugadores = query.list();
			
			String nombreEquipo = "";
			
			for (Jugadores jugador : jugadores) {
				System.out.println("Código: "+jugador.getCodigo()+" Nombre: "+jugador.getNombre()+" Procedencia:"+
						jugador.getProcedencia()+" Altura: "+jugador.getAltura()+" Peso: "+jugador.getPeso()+" Posicion: "+
						jugador.getPosicion()+" Equipos: "+jugador.getEquipos());
				nombreEquipo = jugador.getEquipos();
			}
			
			
			System.out.println("\n------ESTADISTICAS POR PARTIDO-----");
			
			Query query2 = session.createQuery("FROM Estadisticas where jugador = "+codigoJugador);			
			List<Estadisticas> estadisticas = query2.list();
			
			for (Estadisticas estadistica : estadisticas) {
				System.out.println("Temporada: "+estadistica.getTemporada()+" Puntos: "+
						estadistica.getPuntos_por_partido()+" Asistencias: "+estadistica.getAsistencias_por_partido()+
						" Tapones: "+estadistica.getTapones_por_partido()+" Rebotes: "+estadistica.getRebotes_por_partido());
			}
			
			
			System.out.println("\n------NOMBRE Y CIUDAD DEL EQUIPO-----");
			
			Query query3 = session.createQuery("FROM Equipos where nombre = '"+nombreEquipo+"'");			
			
			Equipos equipos2 = (Equipos) query3.uniqueResult();
			
			System.out.println("Nombre del equipo: "+equipos2.getNombre()+" Ciudad: "+equipos2.getCiudad());*/
			
			
			
			//--------------------------EJERCICIOS-----------------------------------
			
			/*Ejercicio 1: Realiza un programa Java en el que se le pase el código de un jugador y muestre los datos del jugador: 
			 * nombre, altura, peso, posición, equipo y procedencia del jugador. Verificar que se introduce un número 
			 * y que el número se corresponde con un jugador válido o mostrar un mensaje en caso contrario.*/
			
			/*System.out.println("Intrduce el código del jugador:");			
			int codigoJugador = teclado.nextInt();
			
			Query query = session.createQuery("FROM Jugadores where codigo = "+codigoJugador);	
			
			if (query.uniqueResult() != null) {
				
				Jugadores jugador = (Jugadores) query.uniqueResult();
				
				
				System.out.println("Código: " + jugador.getCodigo() + " Nombre: " + jugador.getNombre() 
				+ " Altura: " + jugador.getAltura() + " Peso: " + jugador.getPeso() + " Posicion: " + jugador.getPosicion()
				+ " Equipos: " + jugador.getEquipos() + " Procedencia:" + jugador.getProcedencia());
				
			}else System.out.println("No hay ningún jugador con ese código");*/		
			
			
			
			/*Ejercicio 2: Realiza un programa Java en el que se le pase el nombre de un equipo, y si el nombre es válido, 
			 * que muestre los nombres de los jugadores de dicho equipo.*/
			
			/*System.out.println("Intrduce el nombre del equipo:");			
			String nombreEquipo = teclado.nextLine();
			
			Equipos equipo = (Equipos)session.get(Equipos.class, nombreEquipo);
			
			if (equipo != null) {
				
				Query query = session.createQuery("FROM Jugadores where Nombre_equipo = '"+nombreEquipo+"'");			
				List<Jugadores> jugadores = query.list();
				
				for (Jugadores jugador : jugadores) {
					System.out.println("Código: "+jugador.getCodigo()+" Nombre: "+jugador.getNombre());
				}
				
			}else System.out.println("No hay ningún equipo con ese nombre");*/
			

			
			/*Ejercicio 3: Realiza un programa Java en el que se le pase el código de un jugador y muestre los datos del jugador:
			 * nombre, altura, peso, posición, procedencia, equipo y ciudad del equipo, así como sus estadísticas: 
			 * temporada, puntos, asistencias, tapones y rebotes. Deberán estar ordenadas cronológicamente de más antiguas a más nuevas.*/
			
			System.out.println("Intrduce el codigo del jugador:");				
			int codigoJugador = teclado.nextInt();			
			
			Jugadores jugador = (Jugadores)session.get(Jugadores.class, codigoJugador);
			
			if (jugador != null) {				
				
				System.out.println("\n------DATOS-----");
				
				Query query = session.createQuery("FROM Jugadores where codigo = "+codigoJugador);	
				
				jugador = (Jugadores) query.uniqueResult();
				
				System.out.println("Código: " + jugador.getCodigo() + " Nombre: " + jugador.getNombre() 
				+ " Altura: " + jugador.getAltura() + " Peso: " + jugador.getPeso() + " Posicion: " + jugador.getPosicion()
				+ " Equipos: " + jugador.getEquipos() + " Procedencia:" + jugador.getProcedencia());
				
				
				System.out.println("\n------ESTADISTICAS POR PARTIDO-----");
				
				Query query2 = session.createQuery("FROM Estadisticas where jugador = "+codigoJugador);			
				List<Estadisticas> estadisticas = query2.list();
				
				for (Estadisticas estadistica : estadisticas) {
					System.out.println("Temporada: "+estadistica.getTemporada()+" Puntos: "+
							estadistica.getPuntos_por_partido()+" Asistencias: "+estadistica.getAsistencias_por_partido()+
							" Tapones: "+estadistica.getTapones_por_partido()+" Rebotes: "+estadistica.getRebotes_por_partido());
				}
				
				
				System.out.println("\n------NOMBRE Y CIUDAD DEL EQUIPO-----");
				
				Query query3 = session.createQuery("FROM Equipos where nombre = '" + jugador.getEquipos() + "'");			
				
				Equipos equipo = (Equipos) query3.uniqueResult();
				
				System.out.println("Nombre del equipo: " + equipo.getNombre() + " Ciudad: " + equipo.getCiudad());
				
				
			}else System.out.println("No hay ningún jugador con ese código");
				
			
			sessionFactory.close();
			teclado.close();
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}