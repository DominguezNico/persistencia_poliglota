package negocio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private long id;
	
	private String calle;
	private int numero;
	private String codigoPostal;
	private String localidad;
	
	public Direccion(String calle, int numero, String codigoPostal, String localidad) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String toString(){
		return calle + " " + numero + " CP: " +  codigoPostal + " " + localidad;
	}
}
