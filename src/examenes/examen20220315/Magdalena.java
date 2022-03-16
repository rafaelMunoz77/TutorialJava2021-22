package examenes.examen20220315;

public class Magdalena extends Articulo {

	private String relleno;
	
	
	
	/**
	 * @param id
	 * @param nombre
	 * @param precioUnitario
	 * @param unidades
	 */
	public Magdalena(int id, String nombre, double precioUnitario, int unidades, String relleno) {
		super(id, nombre, precioUnitario, unidades);
		this.relleno = relleno;
	}



	@Override
	public String getDescripcion() {
		return "Magdalena [relleno=" + relleno + ", getId()=" + getId() + ", getNombre()=" + getNombre()
		+ ", getPrecioUnitario()=" + getPrecioUnitario() + ", getUnidades()=" + getUnidades() + "]";
	}



	public String getRelleno() {
		return relleno;
	}



	public void setRelleno(String relleno) {
		this.relleno = relleno;
	}


	
}
