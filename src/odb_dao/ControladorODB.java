package odb_dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import negocio.Materia;


public class ControladorODB {
	/* esto siempre tiene que estar*/
	private static ControladorODB instancia;
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private ControladorODB(){
		this.emf = null;
		this.em = null;
	}
	
	public static ControladorODB getInstancia(){
		if(instancia == null)
			instancia = new ControladorODB();
		return instancia;
	}
	/* --- hasta aca ---*/
	
	//Abro DB - Si no existe la crea
	private void conexionOBD() {
        this.emf = Persistence.createEntityManagerFactory("C:\\Users\\nicolas\\Desktop\\Base de Datos\\WorkSpace\\ObjDBBD\\inscripciones1.odb");
        this.em = this.emf.createEntityManager();
	}
	
	// Cierro DB
	private void desconexionOBD() {
		this.em.close();
		this.emf.close();
	}
	
	/* OJO, ABRIR Y CERRAR CONEXIONES EN UNA APLICACION PEQUEÑA ES VIABLE, PERO CUANDO ES UNA RED GRANDE
	 * DONDE LOS USUARIOS ESTAN CONSTANTEMENTE ABRIENDO Y CERRANDO CONEXIONES PUEDE RELENTIZAR LA APLICACION
	 * PARA ESOS CASOS SE UTILIZA UN POOL DE CONEXIONES.*/
	
	//Persistir
	public void cargarOBD(Object aux){
		this.conexionOBD();
        this.em.getTransaction().begin();
        this.em.persist(aux);
        this.em.getTransaction().commit();        
        this.desconexionOBD();
	}
	
	public ArrayList<Materia> getMateriasOBD(){
		this.conexionOBD();

        //Todas las materias
        javax.persistence.Query query = em.createQuery("SELECT m FROM Materia m");
    	
        // We query the database and populate "resultado" with the result of executing the query
        @SuppressWarnings("unchecked")
		ArrayList<Materia> resultado = (ArrayList<Materia>) query.getResultList();
        this.desconexionOBD();
        
        return resultado;
	}

}