package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import tutorialJava.Utils;

public class Ejercicio01_InicializaArrayCalculaSumaMediaMayorMenor {

	public static void main(String[] args) {
		int array[] = new int[150];
		int suma, mayor, menor;

		// Inicialización del array
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}
		
		// Visualizar el array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
		
		// El mayor y el menor son el primer elemento del array
		mayor = array[0];
		menor = array[0];
		suma = array[0];
		
		for (int i = 1; i < array.length; i++) {
			suma += array[i];
			if (array[i] > mayor) mayor = array[i];
			if (array[i] < menor) menor = array[i];
		}
		
		// Imprimir los resultados
		System.out.println("Suma: " + suma + " - Mayor: " + mayor + " - Menor: " +
				menor + " - Media: " + (suma / (float) array.length));
		
	}

}
