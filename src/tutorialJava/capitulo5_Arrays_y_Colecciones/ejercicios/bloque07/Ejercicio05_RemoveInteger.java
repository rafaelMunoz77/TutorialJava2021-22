package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque07;

import java.util.Iterator;

public class Ejercicio05_RemoveInteger {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 2, 5, 5};

		int nuevoArray[] = removeInteger(array, 2);
		
		// Muestro el nuevo array creado
		for (int i = 0; i < nuevoArray.length; i++) {
			System.out.print(nuevoArray[i] + " ");
		}
	}

	
	/**
	 * 
	 * @param array
	 * @param numeroAEliminar
	 * @return
	 */
	public static int[] removeInteger (int array[], int numeroAEliminar) {
		int nuevoArray[];
		int ocurrenciasDelNumeroEnArray;
		int k = 0;
		
		// Encuentro cuántas veces aparece el valor a eliminar del array
		ocurrenciasDelNumeroEnArray = countOccurrences(array, numeroAEliminar);
		
		// Inicializo un nuevo array con el número de elementos necesario, quitanto las ocurrencias del número buscado en el array
		nuevoArray = new int[array.length - ocurrenciasDelNumeroEnArray];
		
		// Copio los elementos, obviando los elementos que quiero eliminar
		for (int i = 0; i < array.length; i++) {
			if (array[i] != numeroAEliminar) {
				nuevoArray[k] = array[i];
				k++;
			}
		}
		
		// Devuelvo el nuevo array creado
		return nuevoArray;
	}
	
	/**
	 * 
	 * @param array
	 * @param numeroBuscado
	 * @return
	 */
	public static int countOccurrences (int array[], int numeroBuscado) {
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numeroBuscado) {
				count++;
			}
		}
		
		return count;
	}

}
