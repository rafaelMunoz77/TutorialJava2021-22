package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.entidades;

public class Materia {
	private int id;
	private String nombre;
	private String acronimo;
	private int cursoId;
	
	/**
	 * 
	 */
	public Materia() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param acronimo
	 * @param cursoId
	 */
	public Materia(int id, String nombre, String acronimo, int cursoId) {
		this.id = id;
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.cursoId = cursoId;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", acronimo=" + acronimo + ", cursoId=" + cursoId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}
	
	
}
