package examenes.examen20211126.tipoB;

import java.util.Scanner;

public class EjercicioA_DosArraysAzarYUnoValoresMedios {

	public static void main(String[] args) {
		int[] array1, array2;
		float array3[];
		
		// Inicializo los arrays 1 y 2
		array1 = inicializaArrayAzar(5);
		array2 = inicializaArrayAzar(5);

		// Calculo los valores del array 3
		array3 = new float[5];
		for (int i = 0; i < array3.length; i++) {
			array3[i] = (array1[i] + array2[i]) / 2f;
		}
		
		// Muestro
		muestraArray(array1);
		muestraArray(array2);
		muestraArray(array3);
	}

	
	
	/**
	 * 
	 * @param longitud
	 * @return
	 */
	public static int[] inicializaArrayAzar (int longitud) {
		int array[] = new int[longitud];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
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
	public static void muestraArray(float array[]) {
		System.out.print("Array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	

}
