package P03_Mapeo_mediante_Annotations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EJ_01_PruebaHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			
			System.out.println("Creada la session Factory, se abre session");
			
			Session session = sessionFactory.openSession();
			
			System.out.println("Crea la transacción");
			
			Transaction tr = session.beginTransaction();
			
			System.out.println("Crea el modelo");
			
			//---------CONSULTAS-----------------------		
			/*Equipos equipo = (Equipos)session.get(Equipos.class, "Raptors");
			
			System.out.println("Nombre: "+equipo.getNombre()+" Ciudad: "+equipo.getCiudad()+
					" Coferencia: "+equipo.getConferencia()+" División: "+equipo.getDivision());
			
			Equipos equipo2 = (Equipos)session.load(Equipos.class, "Celtics");
			
			System.out.println("Nombre: "+equipo2.getNombre()+" Ciudad: "+equipo2.getCiudad()+
					" Coferencia: "+equipo2.getConferencia()+" División: "+equipo2.getDivision());*/
			
			
			//-----------------INSERCIÓN----------------------
			Equipos equipo = (Equipos)session.get(Equipos.class, "Raptors");
			
			Jugadores j = new Jugadores(615, equipo.getNombre(), "Jorge Chueca", "Tarazona","7-2", 225, "C");
			
			/*System.out.println("set variables");			
			Jugadores j = new Jugadores();
			j.setCodigo(614);
			j.setNombre("Pedro Perez");*/
			
			//Almacenar datos			
			System.out.println("almacena el jugador");
			session.save(j);
			
			System.out.println("Commit");
			tr.commit();
			
			System.out.println("Se guardó satisfactoriamente el jugador");
			
			
			sessionFactory.close();
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}		
	}
}