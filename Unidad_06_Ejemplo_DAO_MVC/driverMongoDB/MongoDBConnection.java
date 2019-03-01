package driverMongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;  

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;


import java.util.Arrays;

public class MongoDBConnection {
	
	public MongoDBConnection() {}

	public MongoClient createClient() {
	
		// Creating a Mongo client 
	      MongoClient mongo = new MongoClient("localhost",27017);
	      System.out.println("crea el cliente");
	      return mongo;
	}
	
	public MongoDatabase getDatabase() {
		MongoClient mcli = this.createClient();
		MongoDatabase db = mcli.getDatabase("nba_MySQL");
		System.out.println("devuelve la bd");
		return db;
	}
	
	public MongoCollection getCollection(String collectionName) {
		
		MongoDatabase db = this.getDatabase();
		MongoCollection<Document> collection = db.getCollection(collectionName);
		System.out.println("devuelve la colección");
		return collection;
		
		
	}
}
