package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio05_InicializaArrayYSumaParesEImpares {

	public static void main(String[] args) {
		int array[] = new int[15000];
		int sumaPares = 0, sumaImpares = 0;
		
		// Inicializo
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}

		// Visualizar el array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");

		// Ahora busco el valor buscado
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) sumaPares += array[i];
			else sumaImpares += array[i];
		}
		
		// Ponemos resultados
		System.out.println("Suma pares: " + sumaPares + " - Suma impares: " + sumaImpares);
	}

}
