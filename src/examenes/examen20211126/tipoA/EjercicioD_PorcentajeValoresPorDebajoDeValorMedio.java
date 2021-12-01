package examenes.examen20211126.tipoA;

public class EjercicioD_PorcentajeValoresPorDebajoDeValorMedio {

	public static void main(String[] args) {
		int array[] = inicializaArrayAzar(100);
		float media;
		
		muestraArray(array);
		
		media = valorMedio(array); 
		
		System.out.println("Porcentaje de valores por debajo de la media: " + 
				porcentajeNumerosBajoValorMedio(array, media));
	}
	
	
	/**
	 * 
	 * @param array
	 * @param media
	 * @return
	 */
	public static float porcentajeNumerosBajoValorMedio (int array[], float media) {
		int contador = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < media) {
				contador++;
			}
		}
		
		return contador * 100 / (float) array.length;
	}
	
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static float valorMedio (int array[]) {
		int suma = 0;
		
		for (int i = 0; i < array.length; i++) {
			suma += array[i];
		}
		
		return suma / (float) array.length;
	}
	
	
	
	/**
	 * 
	 * @param longitud
	 * @return
	 */
	public static int[] inicializaArrayAzar (int longitud) {
		int array[] = new int[longitud];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 200 - 100);
		}
		
		return array;
	}
	

	/**
	 * 
	 * @param array
	 */
	public static void muestraArray(int array[]) {
		System.out.print("Array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
