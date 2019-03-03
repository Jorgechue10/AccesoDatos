package P02_Mapeo_mediante_XML;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import P01_Tablas_Mapeadas_a_Java.Jugadores;

public class HibernateAplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Jugadores jugador = new Jugadores(614);
		jugador.setNombre("Jorge Chueca");
		session.save(jugador);
		transaction.commit();
		System.out.println("Se ha guardado satisfactoriamente el jugador");
		sessionFactory.close();
		
	}
}