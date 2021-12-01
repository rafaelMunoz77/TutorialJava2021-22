package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.examenBarajaCartas;

public class Carta {
	private int valor;
	private String palo;
	private int id;
	
	/**
	 * 
	 */
	public Carta() {
	}

	/**
	 * @param valor
	 * @param palo
	 * @param id
	 */
	public Carta(int valor, String palo, int id) {
		this.valor = valor;
		this.palo = palo;
		this.id = id;
	}

	
	
	public String traduceValor (int valor) {
		switch (valor) {
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		case 14:
			return "As";
		default:
			return "" + valor;
		}
	}
	
	

	public String toString() {
		return "Carta [valor=" + traduceValor(valor) + ", palo=" + palo + ", id=" + id + "]";
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
