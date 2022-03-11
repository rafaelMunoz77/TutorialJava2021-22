package examenes.examen20220310;

public class Jugador {

	private String nombre;
	private int puntuacion;
	/**
	 * 
	 */
	public Jugador() {
	}
	/**
	 * @param nombre
	 * @param puntuacion
	 */
	public Jugador(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", puntuacion=" + puntuacion + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
}
