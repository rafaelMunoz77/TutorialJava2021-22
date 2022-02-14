package tutorialJava.capitulo4_OO.ejercicios.bloque02Herencia.articulosComestibles;

public class Articulo {

	protected String codigo;
	protected String nombre;
	protected float precio;
	/**
	 * 
	 */
	public Articulo() {
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param precio
	 */
	public Articulo(String codigo, String nombre, float precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
