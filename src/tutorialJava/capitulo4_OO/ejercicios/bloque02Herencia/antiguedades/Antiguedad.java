package tutorialJava.capitulo4_OO.ejercicios.bloque02Herencia.antiguedades;

public class Antiguedad {

	protected String anioFabricacion;
	protected String origen;
	protected float precio;
	
	
	public Antiguedad() {
	}


	/**
	 * @param anioFabricacion
	 * @param origen
	 * @param precia
	 */
	public Antiguedad(String anioFabricacion, String origen, float precio) {
		this.anioFabricacion = anioFabricacion;
		this.origen = origen;
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Antiguedad [anioFabricacion=" + anioFabricacion + ", origen=" + origen + ", precio=" + precio + "]";
	}


	public String getAnioFabricacion() {
		return anioFabricacion;
	}


	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecia(float precio) {
		this.precio = precio;
	}

	
	
}
