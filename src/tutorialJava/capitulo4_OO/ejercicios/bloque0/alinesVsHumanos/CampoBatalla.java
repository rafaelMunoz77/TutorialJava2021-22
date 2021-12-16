package tutorialJava.capitulo4_OO.ejercicios.bloque0.alinesVsHumanos;

public class CampoBatalla {

	private Humano arrayHumanos[] = new Humano[5];
	private Alien arrayAliens[] = new Alien[5];

	
	/**
	 * 
	 */
	public CampoBatalla() {
		inicializaArrayPersonajes(arrayAliens);
		inicializaArrayPersonajes(arrayHumanos);
	}
	
	
	/**
	 * 
	 * @param array
	 */
	public static void inicializaArrayPersonajes (Personaje array[]) {
		// Inicializo el array con Aliens o Humanos
		for (int i = 0; i < array.length; i++) {
			if (array instanceof Alien[]) {
				array[i] = new Alien() {

					private String nombre = "";
					
					@Override
					public String serializar() {
						if (this.vida > 0) return "(V:" + this.vida + ")";
						else return "(V:X)";
					}
					
				};
			}
			if (array instanceof Humano[]) {
				array[i] = new Humano();
			}
		}
		
		// Ahora duplico la cantidad de vida del último elemento del array
		Personaje ultimoElemento = array[array.length - 1];
		ultimoElemento.setVida(ultimoElemento.getVida() * 2);
	}
	
	
	
	/**
	 * 
	 */
	public void iniciaBatalla() {
		Alien primerAlienVivo;
		Humano primerHumanoVivo;
		
		do {
			// Después de los dos disparos
			muestraCampoBatalla();

			// Disparamos Alien sobre Humano
			primerAlienVivo = (Alien) localizarPrimerPersonajeVivo(arrayAliens);
			primerHumanoVivo = (Humano) localizarPrimerPersonajeVivo(arrayHumanos);
			disparaSobrePersonaje(primerAlienVivo, primerHumanoVivo);
			
			// Disiparamos Humano sobre Alien
			primerHumanoVivo = (Humano) localizarPrimerPersonajeVivo(arrayHumanos);
			if (primerHumanoVivo == null) {
				System.out.println("Han ganado los Aliens");
			}
			else {
				disparaSobrePersonaje(primerHumanoVivo, primerAlienVivo);
			}
			
			// Compruebo los bandos
			primerAlienVivo = (Alien) localizarPrimerPersonajeVivo(arrayAliens);
			if (primerAlienVivo == null) {
				System.out.println("Han ganado los humanos");
			}


		} while (primerHumanoVivo != null && primerAlienVivo != null);
	}
	
	/**
	 * 
	 * @param queDispara
	 * @param queRecibe
	 */
	public void disparaSobrePersonaje (Personaje queDispara,  Personaje queRecibe) {
		int probabilidad = (int) Math.round(Math.random() * 100);
		if (probabilidad <= queDispara.getPrecision()) {
			queRecibe.setVida(queRecibe.getVida() - queDispara.getPotencia());

			// Si la vida se pone en negativa la ponemos a 0
			queRecibe.setVida((queRecibe.getVida() < 0)? 0 : queRecibe.getVida());			
		}
	}
	
	/**
	 * 
	 */
	public void muestraCampoBatalla() {
		System.out.print("Aliens: ");
		for (Alien a : this.arrayAliens) {
			muestraEnConsolaSerializable(a);
		}
		System.out.print("\nHumanos: ");
		for (Humano h : this.arrayHumanos) {
			muestraEnConsolaSerializable(h);
		}
		System.out.println("\n");
	}
	
	
	/**
	 * 
	 * @param s
	 */
	private void muestraEnConsolaSerializable (Serializable s) {
		System.out.print(s.serializar());
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static Personaje localizarPrimerPersonajeVivo (Personaje array[]) {
		for (Personaje p : array) {
			if (p.getVida() > 0) {
				return p;
			}
		}
		return null;
	}
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		CampoBatalla campo = new CampoBatalla();
		campo.iniciaBatalla();
	}
}
