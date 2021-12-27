package neo4j_dao;

import org.neo4j.driver.*;
import org.neo4j.driver.Record;

import negocio.Materia;

import static org.neo4j.driver.Values.parameters;

import java.util.ArrayList;
import java.util.List;


public class ControladorNeo4j {
	private static ControladorNeo4j instancia;
	private Driver driver;
	
	
	private ControladorNeo4j() {
		driver=GraphDatabase.driver("bolt://{ip dada por neo4j}",AuthTokens.basic("{user dado por neo4j}","{contraseña dada por neo4j}"));
	}
	
	public static ControladorNeo4j getInstancia() {
		if(instancia == null )
			instancia = new ControladorNeo4j();
		return instancia;
	}
	
	
	private void desconexionNeo4j() {
		this.driver.close();
	}
	
	    
	public List<Materia> getMaterias(){

				Session session = driver.session(SessionConfig.forDatabase("neo4j"));
				ArrayList<Materia> materias = new ArrayList<Materia>();
				String cypherQuery ="match (n:materias) return n.descripcion as descripcion ,n.codigo as codigo ";
				
				List<Record> result = (List<Record>) session.readTransaction(
						tx -> tx.run(cypherQuery, parameters("limit","10"))
			            .list());
		
				for (Record record : result) {
			        materias.add(new Materia(record.get("codigo").asString(),record.get("descripcion").asString()));
				}
				this.desconexionNeo4j();
				return materias;
	} 
	
	public void cargarMateria(String codigo, String descripcion){
		Session session = driver.session(SessionConfig.forDatabase("neo4j"));
		String cypherQuery ="create (n:materias {codigo:"+codigo+",descripcion:"+descripcion+"})";
		
		session.writeTransaction(
				tx -> tx.run(cypherQuery));
		this.desconexionNeo4j();
	}
}
