package tutorialJava.capitulo4_OO.ejercicios.bloque0.alinesVsHumanos;

public class CampoBatalla {

	private Humano arrayHumanos[] = new Humano[5];
	private Alien arrayAliens[] = new Alien[5];
	
	/**
	 * 
	 */
	public CampoBatalla() {
//		inicializaArrayAliens();
//		inicializaArrayHumanos();
		
		inicializaArrayPersonajes(arrayAliens, true);
		inicializaArrayPersonajes(arrayHumanos, false);
	}
	
	
	/**
	 * 
	 * @param array
	 */
	public void inicializaArrayPersonajes (Personaje array[], boolean esAlien) {
		// Inicializo el array con Aliens o Humanos
		for (int i = 0; i < array.length; i++) {
			System.out.println("Personaje antes de construir: " + array[i]);
			if (esAlien == true) {
				array[i] = new Alien();
			}
			else {
				array[i] = new Humano();
			}
			System.out.println("Personaje después de construir: " + array[i]);
		}
		
		// Ahora duplico la cantidad de vida del último elemento del array
		Personaje ultimoElemento = array[array.length - 1];
		ultimoElemento.setVida(ultimoElemento.getVida() * 2);
	}
	
	
	/**
	 * 
	 */
	public void inicializaArrayAliens () {
		// Inicializo el array de los Aliens
		for (int i = 0; i < arrayAliens.length; i++) {
			arrayAliens[i] = new Alien();
		}
		// Creo un apuntador al último alien del array
		Alien ultimoAlien = arrayAliens[arrayAliens.length-1];
		ultimoAlien.setVida(ultimoAlien.getVida() * 2);
	}
	
	/**
	 * 
	 */
	public void inicializaArrayHumanos () {
		// Inicializo el array de los Humanos
		for (int i = 0; i < arrayHumanos.length; i++) {
			arrayHumanos[i] = new Humano();
		}
		// Creo un apuntador al último alien del array
		Humano ultimo = arrayHumanos[arrayHumanos.length-1];
		ultimo.setVida(ultimo.getVida() * 2);
	}

}
