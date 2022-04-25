package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.entidades;

public class Curso {
	private int id;
	private String descripcion;
	
	/**
	 * 
	 */
	public Curso() {
	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public Curso(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
