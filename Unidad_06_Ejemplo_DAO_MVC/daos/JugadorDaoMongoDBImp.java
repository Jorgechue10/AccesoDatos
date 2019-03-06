package daos;

import driverMongoDB.MongoDBConnection;
import interfaz_dao.EquipoDao;

import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import org.bson.Document;


import java.util.ArrayList;
import java.util.List;

import modelos.Jugador;

public class JugadorDaoMongoDBImp implements EquipoDao {

	@Override
	public boolean create(Jugador jugador) {
		
		boolean created = false;
		
		try {			
			
			MongoDBConnection mdbc = new MongoDBConnection();
			MongoCollection coleccion= mdbc.getCollection("jugadores");
			
			Document doc = new Document();
			
			doc.append("codigo", jugador.getCodigo());
			doc.append("nombre",jugador.getNombre());
			doc.append("nombre_equipo",jugador.getNombre_equipo());
			doc.append("procedencia", jugador.getProcedencia());
			doc.append("altura", jugador.getAltura());
			doc.append("peso", jugador.getPeso());
			doc.append("posicion", jugador.getPosicion());
	
			coleccion.insertOne(doc);
			created = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public List<Jugador> read() {
		
		MongoDBConnection mdbc = new MongoDBConnection();
		MongoCollection coleccion= mdbc.getCollection("jugadores");
		MongoCursor<Document> cursor = coleccion.find().iterator();
		
		List<Jugador> listaJugadores= new ArrayList<Jugador>();
		
		try {
		    while (cursor.hasNext()) {   
		    	
		        Document dbObj = cursor.next();
		        
		        String nombre = dbObj.getString("Nombre");
		        String procedencia = dbObj.getString("Procedencia");
		        String nombre_equipo = dbObj.getString("Nombre_equipo");
		        String altura = dbObj.getString("Altura");
		        String posicion = dbObj.getString("Posicion");
		        int peso = dbObj.getInteger("Peso"); 
		        int codigo = dbObj.getInteger("codigo");
		        Jugador j = new Jugador(codigo, nombre, nombre_equipo, procedencia, altura, posicion, peso);
		        
		        listaJugadores.add(j);
		    }
		} finally {
		    cursor.close();
		}
		
		return listaJugadores;
	}

	@Override
	public boolean update(Jugador jugador) {
		
		boolean updated = false;
		
		try {
			
			MongoDBConnection mdbc = new MongoDBConnection();
			MongoCollection coleccion= mdbc.getCollection("jugadores");
			
			coleccion.updateOne(eq("codigo", jugador.getCodigo()), 
					combine(set("nombre", jugador.getNombre()), 
							set("procedencia", jugador.getProcedencia()), 
							set("nombre_equipo", jugador.getNombre_equipo()),
							set("posicion", jugador.getPosicion()),
							set("altura", jugador.getAltura()),
							set("peso", jugador.getPeso())));
	        
			updated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return updated;
	}

	@Override
	public boolean delete(Jugador jugador) {
		
		boolean deleted = false;
		
		try {
			
			MongoDBConnection mdbc = new MongoDBConnection();
			MongoCollection coleccion= mdbc.getCollection("jugadores");
			coleccion.deleteMany(eq("codigo", jugador.getCodigo()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return deleted;
	}
}