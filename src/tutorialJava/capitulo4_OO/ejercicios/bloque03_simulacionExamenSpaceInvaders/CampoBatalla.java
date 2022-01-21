package tutorialJava.capitulo4_OO.ejercicios.bloque03_simulacionExamenSpaceInvaders;

public class CampoBatalla {

	// Los dos arrays de personajes
	private Humano humanos[];
	private Malvado malvados[];
	
	// Singleton
	private static CampoBatalla instance = null;
	
	/**
	 * Método del Singleton
	 * @return
	 */
	public static CampoBatalla getInstance () {
		if (instance == null) {
			instance = new CampoBatalla();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public CampoBatalla() {
		// Bucles  que inicializan los personajes
		// for que hace el  = new Humano();
		// El último elemento con el doble de vida también se inicializará aquí
	}

	/**
	 * Responsable del bucle principal que lleva a cabo la acción
	 */
	public void comienzaBatalla() {
		// Bucle do ... while que permite que los dos primeros personajes de cada tipo con vida se 
		// disparen
	}
	
	/**
	 * Método que desordena un array, con un bucle que se ejecute X veces y que obtenga dos índices
	 * al azar e intercambie las posiciones de los dos elementos que corresponden con esos índices
	 * @param array
	 */
	public void mezclarArray (Personaje array[]) {
		
	}
	
	/**
	 * Método que se llamará desde el "comienzaBatalla" recibirá a los arrays, alternativamente, de
	 * humanos y malvados y buscará, con un bucle, desde la izquierda a la derecha el primer elemento
	 * que tenga vida.
	 * Si se recorre el array completo y no se encuentra un elemento con vida devolveremos "null", siendo
	 * esto una bandera que se reconocerá en el método "comienzaBatalla"
	 * @param array
	 * @return
	 */
	private Personaje getPrimerElementoVivoEnArray (Personaje array[]) {
		for (int i = 0; i < array.length; i++) {
			// if (array[i].isVivo() {
			// 		return array[i];
			// }
		}
		return null;
	}
	
	/**
	 * También se llamará desde "comienzaBatalla" y se utilizará alternando sus dos argumentos de entrada
	 * En unos casos el primer argumento será un humano y el segundo un malvado y otros casos será al
	 * contrario.
	 * @param queDispara
	 * @param queRecibeDisparo
	 */
	private void personajeDisparaAPersonaje (Personaje queDispara, Personaje queRecibeDisparo) {
		// Calculará los nuevos puntos de vida del personaje que recibe el disparo.
	}

	
	// Getters y Setters
	public Humano[] getHumanos() {
		return humanos;
	}

	public void setHumanos(Humano[] humanos) {
		this.humanos = humanos;
	}

	public Malvado[] getMalvados() {
		return malvados;
	}

	public void setMalvados(Malvado[] malvados) {
		this.malvados = malvados;
	}
	
	
	
	
}
