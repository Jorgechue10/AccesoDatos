package daos;


import java.util.List;

import driverMongoDB.MongoDBConnection;
import interfaz_daos.EquipoDao;
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

import modelos.Equipo;

public class EquipoDaoMongoDBImp implements EquipoDao {

	@Override
	public boolean create(Equipo equipo) {
		
		boolean created = false;
		
		try {			
			
			MongoDBConnection mdbc = new MongoDBConnection();
			MongoCollection coleccion= mdbc.getCollection("equipos");
			
			Document doc = new Document();
			
			doc.append("nombre",equipo.getNombre());
			doc.append("ciudad",equipo.getCiudad());
			doc.append("conferencia", equipo.getConferencia());
			doc.append("division", equipo.getDivision());
	
			coleccion.insertOne(doc);
			created = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public List<Equipo> read() {
		
		MongoDBConnection mdbc = new MongoDBConnection();
		MongoCollection coleccion= mdbc.getCollection("equipos");
		MongoCursor<Document> cursor = coleccion.find().iterator();
		
		List<Equipo> listaEquipos= new ArrayList<Equipo>();
		
		try {
		    while (cursor.hasNext()) {   
		    	
		        Document dbObj = cursor.next();
		        
		        String nombre = dbObj.getString("Nombre");
		        String ciudad = dbObj.getString("Ciudad");
		        String conferencia = dbObj.getString("Conferencia");
		        String division = dbObj.getString("Division");
		        
		        Equipo j = new Equipo(nombre, ciudad, conferencia, division);
		        
		        listaEquipos.add(j);
		    }
		} finally {
		    cursor.close();
		}
		
		return listaEquipos;
	}

	@Override
	public boolean update(Equipo equipo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Equipo equipo) {
		// TODO Auto-generated method stub
		return false;
	}

}
