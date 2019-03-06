package Ejercicio1;

import java.io.File;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Principal {

	static ODB odb;
	
	public static void main(String[] args) {
		
		File f = new File("Evaluacion2\\Ejercicio1\\equipos.db");
		f.delete();
		
		odb = ODBFactory.open("Evaluacion2\\Ejercicio1\\equipos.db");
		
		Equipo equipo1 = new Equipo("Recreativo de Huelva", 0, 0, 1889, 5);
		Equipo equipo2 = new Equipo("Athletic Club", 8, 23, 1898, 83);
		Equipo equipo3 = new Equipo("Barcelona", 22, 26, 1899, 83);
		
		Equipo equipo4 = new Equipo("Espanyol", 0, 4, 1900, 79);
		Equipo equipo5 = new Equipo("Real Madrid", 32, 18, 1902, 83);
		Equipo equipo6 = new Equipo("Sabadell", 0, 0, 1903, 14);
		Equipo equipo7 = new Equipo("Atlético de Madrid", 9, 10, 1903, 77);
		Equipo equipo8 = new Equipo("Sevilla", 1, 5, 1905, 70);
		Equipo equipo9 = new Equipo("Sporting de Gijón", 0, 0, 1905, 40);
		Equipo equipo10 = new Equipo("Deportivo de La Coruña", 1, 2, 1906, 42);
		Equipo equipo11 = new Equipo("Betis", 1, 2, 1907, 49);
		/*Equipo equipo12 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo13 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo14 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo15 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo16 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo17 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo18 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo19 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo20 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo21 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo22 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo23 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo24 = new Equipo("Barcelona", 22, 26, 1899, 83);
		Equipo equipo25 = new Equipo("Barcelona", 22, 26, 1899, 83);*/
		
		odb.store(equipo1);	
		odb.store(equipo2);	
		odb.store(equipo3);	
		odb.store(equipo4);	
		odb.store(equipo5);	
		odb.store(equipo6);	
		odb.store(equipo7);	
		odb.store(equipo8);	
		odb.store(equipo9);	
		odb.store(equipo10);	
		odb.store(equipo11);	
		
		
		//Consultas
		consulta1();
		consulta2();
		
		odb.close();
	}
	
	public static void consulta1() {
		
		ICriterion criterio1 = Where.not(Where.equal("ligas", 0));
		
		IQuery consulta = new CriteriaQuery(Equipo.class, Where.and().add(criterio1)).orderByAsc("fundacion");
		
		Equipo equipo =(Equipo) odb.getObjects(consulta).getFirst();
		System.out.println("Nombre: " + equipo.getNombre());
	}
	
	public static void consulta2() {
		
		IQuery consulta = new CriteriaQuery(Equipo.class).orderByAsc("enPrimera");
		
		Equipo equipo =(Equipo) odb.getObjects(consulta).getFirst();
		System.out.println("Nombre: " + equipo.getNombre());
	}
}