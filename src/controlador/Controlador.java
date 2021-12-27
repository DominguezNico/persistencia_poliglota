package controlador;

import java.util.List;

import mongodb_dao.ControladorMongoDB;
import negocio.Materia;
import neo4j_dao.ControladorNeo4j;
import odb_dao.ControladorODB;
import relacional_dao.ControladorJDBC;

public class Controlador  {
	
	
	/* Inicio del singleton*/
	private static Controlador instancia;
	
	private Controlador(){

	}
	public static Controlador getInstancia(){
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	/* Fin del singleton*/
	
	public void agregarMateria(String codigo, String descripcion) {
		Materia m = new Materia(codigo, descripcion);
		ControladorODB.getInstancia().cargarOBD(m);
	}

	public List<Materia> getMaterias() {
		List<Materia> materias =  ControladorODB.getInstancia().getMateriasOBD();
		return materias;
	}
	
	public List<Materia> getMateriasJDBC() {
		List<Materia> materias =  ControladorJDBC.getInstancia().getMaterias();
		return materias;
	}
	
	public List<Materia> getMateriasMongoDB() {
		List<Materia> materias =  ControladorMongoDB.getInstancia().getMaterias();
		return materias;
	}
	
	public void cargarMateriasMongoDB(String id, String materia) {
		ControladorMongoDB.getInstancia().insertarMaterias(id,materia);
	}
	
	public List<Materia> getMateriasNeo4j() {
		List<Materia> materias =  ControladorNeo4j.getInstancia().getMaterias();
		
		return materias;
	}
	
	public void cargarMateriasNeo4j(String codigo,String descripcion) {
		ControladorNeo4j.getInstancia().cargarMateria(codigo, descripcion);
	}
}