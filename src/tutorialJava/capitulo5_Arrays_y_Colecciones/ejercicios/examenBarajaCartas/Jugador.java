package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.examenBarajaCartas;

import java.util.Arrays;

public class Jugador {

	private String nombre;
	private Carta mano[] = new Carta[5];
	/**
	 * 
	 */
	public Jugador() {
	}
	/**
	 * @param nombre
	 * @param mano
	 */
	public Jugador(String nombre, Carta[] mano) {
		this.nombre = nombre;
		this.mano = mano;
	}
	
	
	public void mostrarMano() {
		for (int i = 0; i < mano.length; i++) {
			System.out.println(mano[i]);
		}
	}
	
	
	public String toString() {
		return "Jugador [nombre=" + nombre + ", mano=" + Arrays.toString(mano) + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Carta[] getMano() {
		return mano;
	}
	public void setMano(Carta[] mano) {
		this.mano = mano;
	}
	
	
}
