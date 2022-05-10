package examenes.examen20220509.modelo;

public class Idioma {
	private int id;
	private String descripcion;
	private int idPais;
	
	/**
	 * 
	 */
	public Idioma() {
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param idPais
	 */
	public Idioma(int id, String descripcion, int idPais) {
		this.id = id;
		this.descripcion = descripcion;
		this.idPais = idPais;
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

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	
	
}
