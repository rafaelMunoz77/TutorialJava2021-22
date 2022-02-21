package examenes.examen20220218.ejercicioB_HashMapConCromosBaloncesto;

public class Cromo {
	private int codigo;
	private String nombre;
	private int rebotes;
	private int puntos;
	
	
	/**
	 * 
	 */
	public Cromo() {
	}
	
	/**
	 * @param codigo
	 * @param nombre
	 * @param rebotes
	 * @param puntos
	 */
	public Cromo(int codigo, String nombre, int rebotes, int puntos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.rebotes = rebotes;
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Cromo [codigo=" + codigo + ", nombre=" + nombre + ", rebotes=" + rebotes + ", puntos=" + puntos + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRebotes() {
		return rebotes;
	}

	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	

}
