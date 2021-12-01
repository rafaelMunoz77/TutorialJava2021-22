package examenes.examen20211126.tipoB;

import java.util.Scanner;

public class EjercicioD_ArrayEliminarUnaPosicionYDesplaza {

	public static void main(String[] args) {
		int posicion;
		Scanner sc = new Scanner(System.in);
		int array[] = inicializaArrayAzar(10);
		muestraArray(array);
		
		// Pedimos una posición
		System.out.println("Introduzca posición a eliminar");
		posicion = sc.nextInt();
		
		// 
		for (int i = posicion; i < (array.length - 1); i++) {
			array[i] = array[i + 1];
		}
		
		array[array.length - 1] = (int) Math.round(Math.random() * 100);
		
		muestraArray(array);
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

}
