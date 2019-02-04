package P02_NeoDatis;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class EJ_01_3_Jugadores_main {

	public static void main(String[] args) {

		//Primero borro el archivo si existe para no insertar los mismos campos
		//cada vez que ejecuto el programa
		File f = new File("Unidad_04_BDOO\\P02_NeoDatis\\Data\\equipos.db");
		f.delete();
		
		//Creo la conexión
		ODB odb = ODBFactory.open("Unidad_04_BDOO\\P02_NeoDatis\\Data\\equipos.db");

		
		//--------------------------INSERCCIÓN DE DATOS------------------------
		//Creo paises
		/*EJ_01_2_Paises p1 = new EJ_01_2_Paises(1, "España");
		EJ_01_2_Paises p2 = new EJ_01_2_Paises(2, "Rusia");
		EJ_01_2_Paises p3 = new EJ_01_2_Paises(3, "Brasil");
		EJ_01_2_Paises p4 = new EJ_01_2_Paises(4, "Portugal");*/
		
		// Creo los jugadores
		EJ_01_1_Jugadores j1= new EJ_01_1_Jugadores ("María", "Voleibol", "Madrid", 14, new EJ_01_2_Paises(1,"España"));
		EJ_01_1_Jugadores j2= new EJ_01_1_Jugadores ("Miguel", "Tenis", "Madrid", 15, new EJ_01_2_Paises(2,"Rusia"));
		EJ_01_1_Jugadores j3= new EJ_01_1_Jugadores ("Mario", "Baloncesto", "Guadalajara", 15, new EJ_01_2_Paises(3,"Brasil"));
		EJ_01_1_Jugadores j4= new EJ_01_1_Jugadores ("Alicia", "Tenis", "Madrid", 14, new EJ_01_2_Paises(4,"Portugal"));
		
		// Inserto los objetos
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		
		
		//---------------------------------MOSTRAR DATOS-------------------------
		System.out.println("----------------------------------MOSTRAR DATOS----------------------------------");
		
		/*Para mostrar los datos crearemos un conjunto de objetos genéricos parametrizado al tipo de objeto que 
		 * queremos traernos. En este caso, Objects<Jugadores>. En él cargaremos todos los objetos del tipo 
		 * Jugadores que nos traeremos desde la base de datos.
		Posteriormente recorreremos el conjunto hasta el final y accederemos a las propiedades que queramos imprimir
		con los getters anteriormente configurados.*/
		
		// Genero un conjunto de objetos y los traigo del ODB conectado
		Objects<EJ_01_1_Jugadores> objects=odb.getObjects(EJ_01_1_Jugadores.class);

		// Imprimo cuantos objetos me he traido de la BD
		System.out.println("Jugadores totales " + objects.size() + ":");

		System.out.println("        --------------------------------------------------------------------------");
		System.out.printf("  %-5s | %-12s | %-15s | %-15s | %-4s | %-12s |\n","", "NOMBRE", "DEPORTE",
				"CIUDAD", "EDAD", "PAÍS");
		System.out.println("--------|--------------|-----------------|-----------------|------|--------------|");
		
		int i = 1; // Meramente estético. Así muestra listados los objetos

		// Mientras haya objetos, los capturo y muestro
		while(objects.hasNext()){

			// Creo un objeto Jugadores y almaceno ahí el objeto
			EJ_01_1_Jugadores jug= objects.next();
		     
			// Imprimo las propiedades que me interese de ese objeto		    
		    System.out.printf("| %-5d | %-12s | %-15s | %-15s |  %-3d | %-12s |\n", (i++), jug.getNombre(), 
		    		jug.getDeporte(), jug.getCiudad(), jug.getEdad(), jug.getPais().getNombrePais());
		    System.out.println("|-------|--------------|-----------------|-----------------|------|--------------|");
		} // Fin del While
	
		
		//------------------------------CONSULTAS----------------------------------------
		System.out.println("\n----------------------------------CONSULTAS----------------------------------");
		
		/*Claro, puede darse el caso de que no queramos listar todos los objetos de un tipo determinado, 
		sino que queramos sólos los que tengan X propiedad o cumplan tal condición.

		Para ello deberemos crear un objeto IQuery, que a su vez será un objeto CriteriaQuery, donde recibirá 
		dos parámetros. El primero será el tipo de objeto que queramos consutar, y el segundo la condición impuesta. 
		Un Where en toda regla, básicamente.

		Hecho esto, nos traeremos todos los objetos igual que en ejemplo anterior, pero pasando como parámetro del
		ODB nuestra consulta. Y ya imprimiríamos los resultados como vimos en el anterior punto.*/
		
		//--------------CONSULTA 1-----------------
		System.out.print("-Consulta 1-> Jugadores cuyo deporte es tenis: ");
		/* Genero la consulta. Llamo a la clase Jugadores
		 * La condición será que la propiedad deporte sea igual a Tenis*/
		IQuery consulta1 = new CriteriaQuery(EJ_01_1_Jugadores.class, Where.equal("deporte", "Tenis"));

		// Y ya, por capricho persona, ordeno el resultado por nombre y edad
		consulta1.orderByAsc("nombre,edad");

		// Cargo los objetos pasando como parámetro del odb nuestra consulta
		Objects<EJ_01_1_Jugadores> objects_consulta1 = odb.getObjects(consulta1);
		mostrarDatos(objects_consulta1);	
		
		
		//------------------------CONSULTA 2: Uso de ICriterion----------------	
		
		/*También podemos separar este proceso un poco más, por si nos resulta más claro verlo de otra forma. 
		 * El único cambio que haremos será crear un objeto ICriterion donde realizaremos la consulta, y 
		 * pasaremos ese objeto como segundo parámetro de nuestro objeto CriteriaQuery. Tal que así.*/
				
		//Vamos realizar una consulta para que muestre los jugadores cuya edad sea 14
		System.out.print("\n-Consulta 2: Uso de ICriterion-> Jugadores cuya edad sea 14: ");
		
		// Realizo la condición sobre la propiedad edad
		ICriterion criterio = Where.equal("edad", 14);

		/* Creo el objeto para realizar la consulta y mando el ICriterion
		 * como segundo parámetro*/
		CriteriaQuery cunsulta2 = new CriteriaQuery(EJ_01_1_Jugadores.class, criterio);

		// Y cargo todo en un objeto, como siempre
		Objects<EJ_01_1_Jugadores> objects_consulta2 = odb.getObjects(cunsulta2);
		mostrarDatos(objects_consulta2);
		
		
		//-------------------CONSULTA 3----------------
		//Tenemos varias formas de lanzar un where. Por ejemplo:

		// Jugadores cuyo nombre empieza por M
		System.out.print("\n-Consulta 3-> Jugadores cuyo nombre empieza por M: ");
		ICriterion criterio2 = Where.like("nombre","M%");
		
		CriteriaQuery cunsulta3 = new CriteriaQuery(EJ_01_1_Jugadores.class, criterio2);
		Objects<EJ_01_1_Jugadores> objects_consulta3 = odb.getObjects(cunsulta3);
		mostrarDatos(objects_consulta3);
		
		
		//---------------------CONSULTA 4------------------------------
		//Jugadores mayores de 14 años		
		System.out.print("\n-Consulta 4-> Jugadores mayores de 14 años: ");
		ICriterion criterio3 = Where.gt("edad",14);
		
		CriteriaQuery cunsulta4 = new CriteriaQuery(EJ_01_1_Jugadores.class, criterio3);
		Objects<EJ_01_1_Jugadores> objects_consulta4 = odb.getObjects(cunsulta4);
		mostrarDatos(objects_consulta4);

		/*Where.gt -> mayor que
		Where.gt -> mayor o igual
		Where.lt -> menor que
		Where.le -> menor o igual
		Where.not -> Distinto a
		Where.isNull(“atributo”) si un atributo es nulo
		Where.isNotNull(“atributo”) si un atributo es no nulo*/
		
		
		//---------------------CONSULTA 5------------------------
		// Jugadores que no empiezan por M
		System.out.print("\n-Consulta 5-> Jugadores que no empiezan por M: ");
		ICriterion criterio4 = Where.not(Where.like("nombre","M%"));
		
		CriteriaQuery cunsulta5 = new CriteriaQuery(EJ_01_1_Jugadores.class, criterio4);
		Objects<EJ_01_1_Jugadores> objects_consulta5 = odb.getObjects(cunsulta5);
		mostrarDatos(objects_consulta5);

		
		//---------------------CONSULTA 6------------------------
		// Jugadores de 15 años de Madrid
		System.out.print("\n-Consulta 6-> Jugadores de 15 años de Madrid: ");
		ICriterion criterio5 = new And().add(Where.equal("ciudad", "Madrid")).add(Where.equal("edad",15));
		
		CriteriaQuery cunsulta6 = new CriteriaQuery(EJ_01_1_Jugadores.class, criterio5);
		Objects<EJ_01_1_Jugadores> objects_consulta6 = odb.getObjects(cunsulta6);
		mostrarDatos(objects_consulta6);
		
		
		//---------------------CONSULTA 7------------------------
		// Jugadores >= de 14 años y de Madrid
		System.out.print("\n-Consulta 7-> Jugadores >= de 14 años y de Madrid: ");
		ICriterion criterio6 = new And().add(Where.equal("ciudad", "Madrid")).add(Where.ge("edad",14));
		
		CriteriaQuery cunsulta7 = new CriteriaQuery(EJ_01_1_Jugadores.class, criterio6);
		Objects<EJ_01_1_Jugadores> objects_consulta7 = odb.getObjects(cunsulta7);
		mostrarDatos(objects_consulta7);
		
		
		/*Y también podemos realizar consultas complejas, todo lo que queramos complicarnos es posible. 
		 * Las voy a pasar un poco rápido porque esto es una breve aproximación.*/
		
		
		//---------------------CONSULTA 8------------------------
		// Suma de edades
		System.out.print("\n-Consulta 8-> Sumar las edades de todos los jugadores: ");	
		Values val = odb.getValues(new ValuesCriteriaQuery(EJ_01_1_Jugadores.class).sum("edad"));
		ObjectValues ov= val.nextValues();
		BigDecimal value = (BigDecimal)ov.getByAlias("edad");
		// También valdría: 
		//BigDecimal value = (BigDecimal)ov.getByIndex(0);
		System.out.println(value + " años");

		
		//---------------------CONSULTA 9------------------------
		// Calcular el número total de jugadores
		System.out.print("\n-Consulta 9-> Calcular el número total de jugadores: ");	
		Values val2 = odb.getValues(new ValuesCriteriaQuery(EJ_01_1_Jugadores.class).count("nombre"));
		ObjectValues ov2= val2.nextValues();
		BigInteger value2 = (BigInteger)ov2.getByAlias("nombre");
		System.out.println(value2 + " jugadores");

		
		//---------------------CONSULTA 10------------------------
	 	// Calcular la Media de edades
		System.out.print("\n-Consulta 10-> Calcular la Media de edades: ");	
		Values val3 = odb.getValues(new ValuesCriteriaQuery(EJ_01_1_Jugadores.class).avg("edad"));
		ObjectValues ov3= val3.nextValues();
		BigDecimal value3 = (BigDecimal)ov3.getByAlias("edad");
		System.out.println(value3 + " años");

		
		//---------------------CONSULTA 11------------------------
	 	// Mostrar la edad máxima y mínima
		/*System.out.print("\n-Consulta 11-> Mostrar la edad máxima y mínima: ");	
		Values val4 = odb.getValues(((ValuesCriteriaQuery) new ValuesCriteriaQuery(EJ_01_1_Jugadores.class.max("edad", "edad_max")).min("edad", "edad_min"));
		ObjectValues ov4= val4.nextValues();
		BigDecimal maxima = (BigDecimal)ov4.getByAlias("edad_max");
		BigDecimal minima = (BigDecimal)ov4.getByAlias("edad_min");*/
		
		
		//------------------------BORRAR OBJETOS-------------------------------
		/*Para borrar un objeto crearemos un objeto IQuery para traernos a memoria los objetos a borrar.
		 * Nos posicionamos en el primero objeto y lo borramos usando el ODB.*/

		//------------Borrar los jugadores cuyo nombre sea María-------------
		//Primero muestro todos los objetos de la tabla para ver que existe
		System.out.print("\nMostrar todos los datos: ");
		objects=odb.getObjects(EJ_01_1_Jugadores.class);
		mostrarDatos(objects);
		
		// Hacemos la consulta para borrar a María
		IQuery consulta_borrar = new CriteriaQuery(EJ_01_1_Jugadores.class, Where.equal("nombre", "María"));

		// Nos posicionamos en el primer resultado
		EJ_01_1_Jugadores jug=(EJ_01_1_Jugadores) odb.getObjects(consulta_borrar).getFirst();

		// Y lo borramos
		odb.delete(jug);
		System.out.println("\n-Se ha borrado la jugadora María");
		
		//Vuelvo a mostrar todos los elementos de la tabla para comprobar que se ha borrado el objeto
		System.out.print("Mostrar todos los datos: ");
		objects=odb.getObjects(EJ_01_1_Jugadores.class);
		mostrarDatos(objects);
		
		//--------------Borrar el país Brasil
		// Hacemos la consulta para borrar
		IQuery consulta_borrar2 = new CriteriaQuery(EJ_01_2_Paises.class, Where.equal("nombrePais", "Brasil"));

		// Nos posicionamos en el primer resultado
		EJ_01_2_Paises paisBorrar=(EJ_01_2_Paises) odb.getObjects(consulta_borrar2).getFirst();

		// Y lo borramos
		odb.delete(paisBorrar);
		
		//Mostramos todos los jugadores
		objects=odb.getObjects(EJ_01_1_Jugadores.class); 
		mostrarDatos(objects);
		
		
		/*Al mostrar todos los jugadores, comprobamos que aún pone que Mario es de Brasil, pero si nos vamos
		 * al archivo .jar de neodatis y lo abrimos, se nos abre una interfaz donde podemos visualizar las 
		 * bases de datos que tengamos. Para ello nos vamos a arriba a la izaquierda y le damos a NeoDatis ODB,
		 * y después a Open Database. Ahí buscamos la base de datos que hayamos generado al ejecutar el programa
		 * y le damos a connect, no hace falta poner ni usuario ni contraseña. Una vez dentro veremos los objetos
		 * que se encuentran en la base de datos, para ver los datos de los objetos, hacemos click-derecho sobre
		 * el objeto, en este caso Paises, y le damos a 'Table view', y ahí podemos comprobar como se ha borrado
		 * el país Brasil, y si vemos los datos de los Jugadores, podemos comprobar que Mario que tenía como país
		 * Brasil, ahora aparece en pais.idPais 'Deleted Object' y en pais.nombrePais '?'.*/
		
		
		//----------------------MODIFICACIÓN DE OBJETOS--------------------------
		/*Como viene siendo habitual, creamos con un IQuery con los objetos que queramos modificar, cargaremos el 
		 * objeto en la clase Jugadores de Java, le cambiaremos la propiedad que deseemos usando los setters que 
		 * programamos al principio y volveremos a almacenar el objeto en la base de datos.*/
		IQuery query = new CriteriaQuery(EJ_01_1_Jugadores.class, Where.equal("nombre", "Miguel"));

		// A Miguel le ponemos como deporteel fútbol
		EJ_01_1_Jugadores jug_modficacion=(EJ_01_1_Jugadores) odb.getObjects(query).getFirst();
		jug_modficacion.setDeporte("Fútbol");
		odb.store(jug_modficacion);
		System.out.println("\n-Se ha modificado el deporte de Miguel, ahora juega al Fútbol");
		
		//Mostramos todos los jugadores
		System.out.print("Mostrar todos los datos: ");
		objects=odb.getObjects(EJ_01_1_Jugadores.class); 
		mostrarDatos(objects);
		
		odb.close();
	}
	
	public static void mostrarDatos(Objects<EJ_01_1_Jugadores> object) {
		
		System.out.println(object.size() + " resultados obtenidos.");

		System.out.println("        --------------------------------------------------------------------------");
		System.out.printf("  %-5s | %-12s | %-15s | %-15s | %-4s | %-12s |\n","", "NOMBRE", "DEPORTE",
				"CIUDAD", "EDAD", "PAÍS");
		System.out.println("--------|--------------|-----------------|-----------------|------|--------------|");
		
		int i = 1;

		while(object.hasNext()){

			EJ_01_1_Jugadores jug= object.next();
		    
		    System.out.printf("| %-5d | %-12s | %-15s | %-15s |  %-3d | %-12s |\n", (i++), jug.getNombre(), 
		    		jug.getDeporte(), jug.getCiudad(), jug.getEdad(), jug.getPais().getNombrePais());
		    System.out.println("|-------|--------------|-----------------|-----------------|------|--------------|");
		}
	}
}