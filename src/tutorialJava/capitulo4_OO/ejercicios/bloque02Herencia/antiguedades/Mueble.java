package tutorialJava.capitulo4_OO.ejercicios.bloque02Herencia.antiguedades;

public class Mueble extends Antiguedad {

	String color;
	
	public Mueble() {
	}

	public Mueble(String anioFabricacion, String origen, float precio, String color) {
		super(anioFabricacion, origen, precio);
		this.color = color;
	}

	@Override
	public String toString() {
		return "Mueble [anioFabricacion=" + anioFabricacion + ", origen=" + origen + ", precio=" + precio + ", color="
				+ color + "]";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
}
