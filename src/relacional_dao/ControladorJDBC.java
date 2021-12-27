package relacional_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.Materia;

public class ControladorJDBC {

	private static ControladorJDBC instancia;
	private String connectionUrl = "jdbc:sqlserver://localhost;databaseName=HibernateAI;user={Usuario};password={Contraseña}";
	private Statement stmt;
	private Connection con;
	
	private ControladorJDBC() {
		try {
			con = DriverManager.getConnection(connectionUrl); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ControladorJDBC getInstancia() {
		if(instancia == null )
			instancia = new ControladorJDBC();
		return instancia;
	}
	
	public List<Materia> getMaterias(){
		List<Materia> aux = new ArrayList<Materia>();
		try {
			stmt = con.createStatement();
			ResultSet resultado = stmt.executeQuery("select * from Materias");
			while(resultado.next()) {
				Materia m = new Materia(resultado.getString("idMateria"),resultado.getString("descripcion"));
				aux.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
	
}
