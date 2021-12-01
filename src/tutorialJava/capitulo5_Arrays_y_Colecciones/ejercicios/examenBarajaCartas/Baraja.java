package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.examenBarajaCartas;

public class Baraja {
	private Carta cartas[] = new Carta[52];
	
	
	public Baraja () {
		
		int k = 0;
		
		// Carta del palo de corazones
		for (int i = 2; i < 15; i++) {
			Carta carta = new Carta(i, "Corazones", k);
			cartas[k] = carta;
			k++;
		}

		// Carta del palo de tréboles
		for (int i = 2; i < 15; i++) {
			Carta carta = new Carta(i, "Tréboles", k);
			cartas[k] = carta;
			k++;
		}

		// Carta del palo de Diamantes
		for (int i = 2; i < 15; i++) {
			Carta carta = new Carta(i, "Diamantes", k);
			cartas[k] = carta;
			k++;
		}
	
		// Carta del palo de Diamantes
		for (int i = 2; i < 15; i++) {
			Carta carta = new Carta(i, "Picas", k);
			cartas[k] = carta;
			k++;
		}
	
	}
	
	/**
	 * 
	 */
	public void mostar () {
		for (int i = 0; i < cartas.length; i++) {
			System.out.println(cartas[i].toString());
		}
	}
	
	/**
	 * 
	 */
	public void pasarCartaDeAbajoHaciaArriba () {
		Carta aux = cartas[0];
		for (int i = 0; i < cartas.length-1; i++) {
			cartas[i] = cartas[i+1];
		}
		cartas[cartas.length-1] = aux;
	}

	/**
	 * 
	 */
	public void pasarCartaDeArribaHaciaAbajo () {
		Carta aux = cartas[cartas.length-1];
		for (int i = cartas.length-1; i > 0; i--) {
			cartas[i] = cartas[i-1];
		}
		cartas[0] = aux;
	}
	
	/**
	 * 
	 */
	public void mezclar() {
		for (int i = 0; i < 200; i++) {
			int pos1 = (int) Math.round(Math.random() * (cartas.length-1));
			int pos2 = (int) Math.round(Math.random() * (cartas.length-1));
			Carta aux = cartas[pos1];
			cartas[pos1] = cartas[pos2];
			cartas[pos2] = aux;
		}
	}

	
	/**
	 * 
	 */
	public void ordenar() {
		boolean seHanHechoIntercambios;
		
		cartas[0].setId(5);
		
		do {
			seHanHechoIntercambios = false;

			for (int i = 0; i < cartas.length - 1; i++) {
				if (cartas[i].getId() > cartas[i+1].getId()) {
					Carta aux = cartas[i+1];
					cartas[i+1] = cartas[i];
					cartas[i] = aux;
					seHanHechoIntercambios = true;
				}
			}

		} while (seHanHechoIntercambios == true);

	}
	
	
	/**
	 * 
	 * @param j
	 */
	public void repartirMano (Jugador j) {
		
		for (int i = 0; i < 5; i++) {
			j.getMano()[i] = cartas[cartas.length-1-i];
		}
	}
}











