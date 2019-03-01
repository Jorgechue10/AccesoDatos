package daos;


import java.util.List;

import driverMongoDB.MongoDBConnection;
import interfaz_daos.JugadorDao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import com.mongodb.MongoClient;
import com.mongodb.client.*;


import com.mongodb.client.FindIterable; 
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase;  
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;

import modelos.Jugador;

public class JugadorDaoMongoDBImp implements JugadorDao {

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Jugador jugador) {
		// TODO Auto-generated method stub
		return false;
	}

}
