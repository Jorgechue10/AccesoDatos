package P03_Mapeo_mediante_Annotations;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class AD_Consultas {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		try {
			
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			
			System.out.println("Creada la session Factory, se abre session");
			
			Session session = sessionFactory.openSession();		
			
			//--------------------------EJERCICIOS-----------------------------------
			
			/*Ejercicio 1: Realiza un programa Java en el que se le pase el código de un jugador y muestre los datos del jugador: 
			 * nombre, altura, peso, posición, equipo y procedencia del jugador. Verificar que se introduce un número 
			 * y que el número se corresponde con un jugador válido o mostrar un mensaje en caso contrario.*/
			
			System.out.println("\nIntrduce el código del jugador:");			
			int codigoJugador = teclado.nextInt();
			
			Query query = session.createQuery("FROM Jugadores where codigo = "+codigoJugador);	
			
			Jugadores jugador = (Jugadores) query.uniqueResult();
			
			if (jugador != null) {					
				
				System.out.println("Código: " + jugador.getCodigo() + " Nombre: " + jugador.getNombre() 
				+ " Altura: " + jugador.getAltura() + " Peso: " + jugador.getPeso() + " Posicion: " + jugador.getPosicion()
				+ " Equipos: " + jugador.getEquipos() + " Procedencia:" + jugador.getProcedencia());
				
			}else System.out.println("No hay ningún jugador con ese código");	
			
			
			
			/*Ejercicio 2: Realiza un programa Java en el que se le pase el nombre de un equipo, y si el nombre es válido, 
			 * que muestre los nombres de los jugadores de dicho equipo.*/
			
			System.out.println("\nIntrduce el nombre del equipo:");			
			String nombreEquipo = teclado.nextLine();
			nombreEquipo = teclado.nextLine();
			
			Equipos equipo = (Equipos)session.get(Equipos.class, nombreEquipo);
			
			if (equipo != null) {
				
				Query query2 = session.createQuery("FROM Jugadores where Nombre_equipo = '"+nombreEquipo+"'");			
				List<Jugadores> jugadores = query2.list();
				
				for (Jugadores jugador2 : jugadores) {
					System.out.println("Código: " + jugador2.getCodigo() + " Nombre: " + jugador2.getNombre());
				}
				
			}else System.out.println("No hay ningún equipo con ese nombre");
			

			
			/*Ejercicio 3: Realiza un programa Java en el que se le pase el código de un jugador y muestre los datos del jugador:
			 * nombre, altura, peso, posición, procedencia, equipo y ciudad del equipo, así como sus estadísticas: 
			 * temporada, puntos, asistencias, tapones y rebotes. Deberán estar ordenadas cronológicamente de más antiguas a más nuevas.*/
			
			System.out.println("\nIntrduce el codigo del jugador:");				
			codigoJugador = teclado.nextInt();			
			
			jugador = (Jugadores)session.get(Jugadores.class, codigoJugador);
			
			if (jugador != null) {				
				
				query = session.createQuery("FROM Jugadores jug INNER JOIN Estadisticas est ON jug.codigo = est.jugador"
						+ " WHERE jug.codigo = '" + codigoJugador +"'");
				List<Object[]> objetos = query.list();
				
				boolean seguir = true;
				
				for (Object[] row: objetos) {
					//crear objetos jugador y estadisiticas a partir de la consulta de varias clases
					Jugadores jug = (Jugadores)row[0];
					Estadisticas est = (Estadisticas) row[1];
					
					//escribir solo una vez los datos del jugador
					if(seguir)
						System.out.println("---DATOS DEL JUGADOR---\n" 
						+ "Nombre: " + jug.getNombre() + " | Procedencia: " + jug.getProcedencia()
						+ " | Altura: " + jug.getAltura() + " | Peso: " + jug.getPeso()
						+ " | Posición: " + jug.getPosicion() + " | Nombre Equipo: " + jug.getEquipos()
						+ "\n---ESTADISTICAS---");
					
					//escribir todas las estadisticas del jugador
				    System.out.println("Temporada: " + est.getTemporada() + " | Puntos partido: " + est.getPuntos_por_partido()
				    +" | Asistencias partido: " + est.getAsistencias_por_partido() 
				    +" | Tapones partido: " + est.getTapones_por_partido()
				    +" | Rebotes partido: " + est.getRebotes_por_partido());
				    seguir = false;
				}
				
				
			}else System.out.println("No hay ningún jugador con ese código");
				
			
			//--------------------------------------------------------------------------------------
			
			sessionFactory.close();
			teclado.close();
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}