package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio05_CentroEducativoTerceraParte.entidades;

public class TipologiaSexo {

	private int id;
	private String descripcion;
	
	/**
	 * 
	 */
	public TipologiaSexo() {
	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public TipologiaSexo(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return this.descripcion;
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
