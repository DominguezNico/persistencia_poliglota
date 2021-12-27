package mongodb_dao;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;


import com.mongodb.client.FindIterable;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import negocio.Materia;



public class ControladorMongoDB {
	private static ControladorMongoDB instancia;
	private String conexionUrl="mongodb+srv://{user}:{password}@{urlMongoDB}";
	private MongoClientURI uri;
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	/*
	private ConnectionString connectionString;
	private MongoClientSettings settings;
	private MongoClient mongoClient;
	
	
*/
	
	private ControladorMongoDB() {
		try {
			uri = new MongoClientURI(conexionUrl);
			mongoClient = new MongoClient(uri);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ControladorMongoDB getInstancia(){
		if(instancia == null)
			instancia = new ControladorMongoDB();
		return instancia;
	}
	
	public List<Materia> getMaterias(){
	
		List<Materia> aux = new ArrayList<Materia>();
		database= mongoClient.getDatabase("Materias");

		collection= database.getCollection("Materias");
		
		FindIterable<Document> cursor = collection.find();
		
		Iterator<Document> iter = cursor.iterator();
		while (iter.hasNext()) {
			Document var=iter.next();
			System.out.println(var);
			aux.add(new Materia(var.get("_id").toString(), var.get("descripcion").toString()));
		}
		
		
		return aux;
	}
	
	public void insertarMaterias(String id, String materia) {
		MongoDatabase database = mongoClient.getDatabase("Materias");			
		MongoCollection<Document> collection = database.getCollection("Materias");
		
		Document document = new Document("descripcion", materia );
		collection.insertOne(document);
	}
	
}
