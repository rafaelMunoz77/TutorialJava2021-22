package tutorialJava.capitulo4_OO.ejercicios.bloque0.alinesVsHumanos;

public class Personaje {

	protected int vida;
	protected int potencia;
	protected int precision;
	
	/**
	 * 
	 */
	public Personaje() {
		this.vida = (int) Math.round(Math.random() * (100 - 90) + 90);
		this.potencia = (int) Math.round(Math.random() * (30 - 20) + 20);
		this.precision = (int) Math.round(Math.random() * (70 - 50) + 50);
	}
	
	/**
	 * @param vida
	 * @param potencia
	 * @param precision
	 */
	public Personaje(int vida, int potencia, int precision) {
		this.vida = vida;
		this.potencia = potencia;
		this.precision = precision;
	}
	

	


	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	
	

}
