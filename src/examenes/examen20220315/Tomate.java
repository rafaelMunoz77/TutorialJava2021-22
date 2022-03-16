package examenes.examen20220315;

public class Tomate extends Articulo {

	private String color;
	
	
	
	/**
	 * @param id
	 * @param nombre
	 * @param precioUnitario
	 * @param unidades
	 */
	public Tomate(int id, String nombre, double precioUnitario, int unidades, String color) {
		super(id, nombre, precioUnitario, unidades);
		this.color = color;
	}


	@Override
	public String getDescripcion() {
		return "Tomate [color=" + color + ", getId()=" + getId() + ", getNombre()=" + getNombre()
		+ ", getPrecioUnitario()=" + getPrecioUnitario() + ", getUnidades()=" + getUnidades() + "]";
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	
}
