package examenes.examen20220315;

public class Gelatina extends Articulo {

	private String sabor;
	
	
	
	/**
	 * @param id
	 * @param nombre
	 * @param precioUnitario
	 * @param unidades
	 */
	public Gelatina(int id, String nombre, double precioUnitario, int unidades, String sabor) {
		super(id, nombre, precioUnitario, unidades);
		this.sabor = sabor;
	}



	@Override
	public String getDescripcion() {
		return "Gelatina [sabor=" + sabor + ", getId()=" + getId() + ", getNombre()=" + getNombre()
		+ ", getPrecioUnitario()=" + getPrecioUnitario() + ", getUnidades()=" + getUnidades() + "]";
	}



	public String getSabor() {
		return sabor;
	}



	public void setSabor(String sabor) {
		this.sabor = sabor;
	}



}
