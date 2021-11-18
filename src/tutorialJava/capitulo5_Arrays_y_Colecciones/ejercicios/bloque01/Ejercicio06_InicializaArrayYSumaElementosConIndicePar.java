package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio06_InicializaArrayYSumaElementosConIndicePar {

	public static void main(String[] args) {
		int array[] = new int[15000];
		int sumaElementosIndicePar = 0;
		
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
			if (i % 2 == 0) sumaElementosIndicePar += array[i];
		}
		
		// Ponemos resultados
		System.out.println("Suma elementos con índice par: " + sumaElementosIndicePar);
	}

}
