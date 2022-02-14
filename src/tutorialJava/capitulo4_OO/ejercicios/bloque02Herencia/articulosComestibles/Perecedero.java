/**
 * 
 */
package tutorialJava.capitulo4_OO.ejercicios.bloque02Herencia.articulosComestibles;

/**
 * @author rafae
 *
 */
public class Perecedero extends Articulo {
	
	protected String fecha;
	
	/**
	 * 
	 */
	public Perecedero() {
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param precio
	 */
	public Perecedero(String codigo, String nombre, float precio, String fecha) {
		super(codigo, nombre, precio);
		this.fecha = fecha;
	}

	
	
	
	@Override
	public String toString() {
		return "Perecedero [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", fecha=" + fecha + "]";
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
}
