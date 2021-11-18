package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio03_InicializaArrayMuestraOrdenInverso {

	public static void main(String[] args) {
		int array[] = new int[150];
		
		// Inicializo
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}

		// Visualizar el array
		for (int i = (array.length - 1); i > -1; i--) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
		
	}

}
