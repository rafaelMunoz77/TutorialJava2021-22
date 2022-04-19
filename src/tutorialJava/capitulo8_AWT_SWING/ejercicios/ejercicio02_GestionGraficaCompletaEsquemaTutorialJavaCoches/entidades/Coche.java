package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades;

public class Coche {
	private int id;
	private int idFabricante;
	private String bastidor;
	private String modelo;
	private String color;
	
	/**
	 * 
	 */
	public Coche() {
	}

	/**
	 * @param id
	 * @param idFabricante
	 * @param bastidor
	 * @param modelo
	 * @param color
	 */
	public Coche(int id, int idFabricante, String bastidor, String modelo, String color) {
		this.id = id;
		this.idFabricante = idFabricante;
		this.bastidor = bastidor;
		this.modelo = modelo;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Bastidor=" + bastidor + " - " + modelo + " - " + color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}

	public String getBastidor() {
		return bastidor;
	}

	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
