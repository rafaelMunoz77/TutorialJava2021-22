package examenes.examen20211126.tipoA;

import java.util.Iterator;
import java.util.Scanner;

public class EjercicioA_LeeArrayTecladoMuestraYOrdena {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Inicializo el array a través del teclado
		int array[] = inicializaArrayPorTeclado(10);

		// Muestro
		muestraArray(array);
		
		// Ordeno
		ordenaArrayPorBurbuja(array);
		
		// Muestro el array
		muestraArray(array);
	}

	
	/**
	 * 
	 * @param longitud
	 * @return
	 */
	public static int[] inicializaArrayPorTeclado (int longitud) {
		int array[] = new int[longitud];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("Introduzca el siguiente número del array: ");
			array[i] = sc.nextInt();
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
	
	/**
	 * 
	 * @param array
	 */
	public static void ordenaArrayPorBurbuja (int array[]) {
		boolean seHanHechoIntercambios;
		// Ordeno por la burbuja
		do {
			seHanHechoIntercambios = false;

			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] < array[i+1]) {
					int aux = array[i+1];
					array[i+1] = array[i];
					array[i] = aux;
					seHanHechoIntercambios = true;
				}
			}

		} while (seHanHechoIntercambios == true);
	}
}
