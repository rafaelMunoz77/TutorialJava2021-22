package examenes.examen20220315;

public abstract class Articulo {
	private int id;
	private String nombre;
	private double precioUnitario;
	private int unidades;
	/**
	 * 
	 */
	public Articulo() {
	}
	/**
	 * @param id
	 * @param nombre
	 * @param precioUnitario
	 * @param unidades
	 */
	public Articulo(int id, String nombre, double precioUnitario, int unidades) {
		this.id = id;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.unidades = unidades;
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract String getDescripcion();
	
	
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
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	
}
