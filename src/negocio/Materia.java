package negocio;

import view.MateriaView;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private long id;
    
	private String codigo ;
	private String descripcion;
	private boolean habilitada;
	
	public Materia(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.habilitada = true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isHabilitada() {
		return habilitada;
	}

	public void deshabilitar() {
		this.habilitada = false;
	}
	
	public MateriaView toView()
	{
		return new MateriaView(codigo, descripcion, habilitada);
	}

	public boolean soyLaMateria(String codigo) {
		return this.codigo.equals(codigo);
	}
}
