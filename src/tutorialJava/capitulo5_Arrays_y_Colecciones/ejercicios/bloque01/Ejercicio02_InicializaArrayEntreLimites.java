package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio02_InicializaArrayEntreLimites {

	public static void main(String[] args) {
		int limiteInf, limiteSup, array[] = new int[150];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Límite inferior: ");
		limiteInf = sc.nextInt();
		System.out.println("Límite superior: ");
		limiteSup = sc.nextInt();
		
		// Inicializo
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * (limiteSup - limiteInf) + limiteInf);
		}

		// Visualizar el array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
		
	}

}
