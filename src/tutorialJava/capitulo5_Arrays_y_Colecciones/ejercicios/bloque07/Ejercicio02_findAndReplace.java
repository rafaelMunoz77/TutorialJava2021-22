package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque07;

public class Ejercicio02_findAndReplace {

	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 2, 5};
		
		findAndReplace(array, 2, 7);
	}

	/**
	 * 
	 * @param array
	 * @param numeroBuscado
	 * @param numeroSustituto
	 */
	public static void findAndReplace (int array[], int numeroBuscado, int numeroSustituto) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numeroBuscado) {
				array[i] = numeroSustituto;
			}
		}
	}
}
