package test;

import java.util.List;

import controlador.Controlador;
import negocio.Materia;

public class Test {

	public static void main(String[] args) {
		/* Cargo materias en ObjectDB
		System.out.println("Voy a Guardar 3 Materias");
		Controlador.getInstancia().agregarMateria("3.1.5.698", "Nueva Materia 1");
		Controlador.getInstancia().agregarMateria("3.1.5.699", "Nueva Materia 2");
		Controlador.getInstancia().agregarMateria("3.1.5.700", "Nueva Materia 3");
		System.out.println("Materias Guardadas");*/
		
		//List<Materia> materias = Controlador.getInstancia().getMaterias();  //obtener materias de la BD objectDB
		
		//List<Materia> materias = Controlador.getInstancia().getMateriasJDBC(); //obtener materias de la BD SQL
		
		//List<Materia> materias=Controlador.getInstancia().getMateriasMongoDB(); //obtener materias de la BD MongoDB
		
		//List<Materia> materias=Controlador.getInstancia().getMateriasNeo4j(); //obtener materias de la BD Neo4j
		
		//Controlador.getInstancia().cargarMateriasNeo4j("'2'", "'Analisis matematico I'");
		
		List<Materia> materias=Controlador.getInstancia().getMateriasMongoDB(); //obtener materias de la BD MongoDB
		
		Controlador.getInstancia().cargarMateriasMongoDB("","Analisis matematico I");
		
		for(Materia materia : materias) {
			System.out.println(materia.getDescripcion());
		}
	}
}