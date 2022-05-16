package examenes.examen20220516.modelo;

public class Disciplina {
	private int id;
	private String descripcion;
	
	/**
	 * 
	 */
	public Disciplina() {
	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public Disciplina(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", descripcion=" + descripcion + "]";
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
