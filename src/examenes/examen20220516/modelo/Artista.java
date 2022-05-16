package examenes.examen20220516.modelo;

public class Artista {
	private int id;
	private String nombre;
	private int idDisciplina;
	private int idMunicipio;
	private byte[] imagen;
	
	/**
	 * 
	 */
	public Artista() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param idDisciplina
	 * @param idMunicipio
	 */
	public Artista(int id, String nombre, int idDisciplina, int idMunicipio, byte[] imagen) {
		this.id = id;
		this.nombre = nombre;
		this.idDisciplina = idDisciplina;
		this.idMunicipio = idMunicipio;
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return nombre;
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

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	
}
