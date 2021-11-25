package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque07;

public class Ejercicio03_AddInteger {

	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 2, 5};
		int nuevoArray[];
		nuevoArray = addInteger(array, 10);

		// Muestro el nuevo array obtenido
		for (int i = 0; i < nuevoArray.length; i++) {
			System.out.print(nuevoArray[i] + " ");
		}
	}

	
	
	public static int[] addInteger (int array[], int numeroParaAgregar) {
		int nuevoArray[] = new int[array.length + 1];
		
		for (int i = 0; i < array.length; i++) {
			nuevoArray[i] = array[i];
		}
		nuevoArray[array.length] = numeroParaAgregar;
		
		return nuevoArray;
	}
}
