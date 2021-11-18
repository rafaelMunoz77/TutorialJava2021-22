package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio04_InicializaArrayYBuscaValor {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int valorBuscado;
		int array[] = new int[150];
		boolean estaValorEnArray = false;
		
		
		// Inicializo
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}

		// Pido el valor a buscar
		System.out.println("Introduce el valor a buscar: ");
		valorBuscado = sc.nextInt();
		
		// Visualizar el array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");

		// Ahora busco el valor buscado
		for (int i = 0; i < array.length; i++) {
			if (valorBuscado == array[i]) {
				estaValorEnArray = true;
				System.out.println("Encontrado " + valorBuscado + " en posición: " + i);
			}
		}
		
		// Puede ser que el valor no esté encontrado
		if (!estaValorEnArray) {
			System.out.println("El valor " + valorBuscado + " no está en el array");
		}
	}

}
