package examenes.examen20220310;

public class Jugada {
	private int id;
	private String descripcion;
	private int puntuacion;
	private int probabilidad;
	/**
	 * 
	 */
	public Jugada() {
	}
	/**
	 * @param id
	 * @param descripcion
	 * @param puntuacion
	 * @param probabilidad
	 */
	public Jugada(int id, String descripcion, int puntuacion, int probabilidad) {
		this.id = id;
		this.descripcion = descripcion;
		this.puntuacion = puntuacion;
		this.probabilidad = probabilidad;
	}
	@Override
	public String toString() {
		return "Jugada [id=" + id + ", descripcion=" + descripcion + ", puntuacion=" + puntuacion + ", probabilidad="
				+ probabilidad + "]";
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
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public int getProbabilidad() {
		return probabilidad;
	}
	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}
	
	
}
