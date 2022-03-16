package examenes.examen20220315;

public class Patata extends Articulo {

	private boolean tieneTierra;
	
	
	
	/**
	 * @param id
	 * @param nombre
	 * @param precioUnitario
	 * @param unidades
	 */
	public Patata(int id, String nombre, double precioUnitario, int unidades, boolean tieneTierra) {
		super(id, nombre, precioUnitario, unidades);
		this.tieneTierra = tieneTierra;
	}



	@Override
	public String getDescripcion() {
		return "Patata [tieneTierra=" + tieneTierra + ", getId()=" + getId() + ", getNombre()=" + getNombre()
		+ ", getPrecioUnitario()=" + getPrecioUnitario() + ", getUnidades()=" + getUnidades() + "]";
	}



	public boolean isTieneTierra() {
		return tieneTierra;
	}



	public void setTieneTierra(boolean tieneTierra) {
		this.tieneTierra = tieneTierra;
	}


	
	
}
