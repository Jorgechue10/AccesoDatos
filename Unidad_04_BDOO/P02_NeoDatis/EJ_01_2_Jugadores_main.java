package P02_NeoDatis;

import java.io.File;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class EJ_01_2_Jugadores_main {

	public static void main(String[] args) {

		//Primero borro el archivo si existe para no insertar los mismos campos
		//cada vez que ejecuto el programa
		File f = new File("Unidad_04_BDOO\\P02_NeoDatis\\Data\\equipos.db");
		f.delete();
		
		//Creo la conexión
		ODB odb = ODBFactory.open("Unidad_04_BDOO\\P02_NeoDatis\\Data\\equipos.db");

		
		//--------------------------INSERCCIÓN DE DATOS------------------------
		//Creo paises
		EJ_01_3_Paises p1 = new EJ_01_3_Paises(1, "España");
		EJ_01_3_Paises p2 = new EJ_01_3_Paises(2, "Rusia");
		EJ_01_3_Paises p3 = new EJ_01_3_Paises(3, "Brasil");
		EJ_01_3_Paises p4 = new EJ_01_3_Paises(4, "Portugal");
		
		// Creo los jugadores
		EJ_01_1_Jugadores j1= new EJ_01_1_Jugadores ("María", "voleibol", "Madrid", 14, new EJ_01_3_Paises(1,"España"));
		EJ_01_1_Jugadores j2= new EJ_01_1_Jugadores ("Miguel", "tenis", "Madrid", 15, new EJ_01_3_Paises(2,"Rusia"));
		EJ_01_1_Jugadores j3= new EJ_01_1_Jugadores ("Mario", "baloncesto", "Guadalajara", 15, new EJ_01_3_Paises(3,"Brasil"));
		EJ_01_1_Jugadores j4= new EJ_01_1_Jugadores ("Alicia", "tenis", "Madrid", 14, new EJ_01_3_Paises(4,"Portugal"));
		// Inserto los objetos
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		
		
		//---------------------------------MOSTRAR DATOS-------------------------
		// Genero un conjunto de objetos y los traigo del ODB conectado
		Objects<EJ_01_1_Jugadores> objects=odb.getObjects(EJ_01_1_Jugadores.class);

		// Imprimo cuantos objetos me he traido de la BD
		System.out.println(objects.size() + " jugadores:");

		int i = 1; // Meramente estético. Así muestra listados los objetos

		// Mientras haya objetos, los capturo y muestro
		while(objects.hasNext()){

		      // Creo un objeto Jugadores y almaceno ahí el objeto
			EJ_01_1_Jugadores jug= objects.next();
		     
		      // Imprimo las propiedades que me interes de ese objeto
		      System.out.println((i++) + "\t: " + jug.getNombre() + "*" 
		      + jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
		} // Fin del While
		
		
		//CONSULTA
		System.out.println("--------------------------------");
		System.out.println("Jugadores cuyo deporte es tenis:");
		/* Genero la consulta. Llamo a la clase Jugadores
		 * La condición será que la propiedad deporte sea igual a tenis
		 */
		IQuery query = new CriteriaQuery(EJ_01_1_Jugadores.class, Where.equal("deporte", "tenis"));

		// Y ya, por capricho persona, ordeno el resultado por nombre y edad
		query.orderByDesc("nombre,edad");

		// Cargo los objetos pasando como parámetro del odb nuestra consulta
		Objects<EJ_01_1_Jugadores> objects2 = odb.getObjects(query);
		mostrarDatos(objects2);	
		
		
		//CONSULTA CON OQL
		
		
		
		//BORRAR OBJETOS
		// Hacemos la consulta para borrar
		IQuery query2 = new CriteriaQuery(EJ_01_3_Paises.class, Where.equal("nombrePais", "Brasil"));

		// Nos posicionamos en el primer resultado
		EJ_01_3_Paises paisBorrar=(EJ_01_3_Paises) odb.getObjects(query2).getFirst();

		// Y lo borramos
		odb.delete(paisBorrar);
		odb.close();
	}
	
	public static void mostrarDatos(Objects<EJ_01_1_Jugadores> object) {
		
		System.out.println(object.size() + " jugadores:");

		int i = 1;

		while(object.hasNext()){		      
			EJ_01_1_Jugadores jug= object.next();		
			
		   System.out.println((i++) + "\t: " + jug.getNombre() + "*" 
		      + jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
		}
	}
}