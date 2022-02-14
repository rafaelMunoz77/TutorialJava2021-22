package tutorialJava.capitulo4_OO.ejercicios.bloque02Herencia.antiguedades;

public class Joya extends Antiguedad {

	private String material;
	
	public Joya() {
	}

	public Joya(String anioFabricacion, String origen, float precio, String material) {
		super(anioFabricacion, origen, precio);
		this.material = material;
	}

	@Override
	public String toString() {
		return "Joya [anioFabricacion=" + anioFabricacion + ", origen=" + origen + ", precio=" + precio + ", material="
				+ material + "]";
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	
}
