package tutorialJava.capitulo2_condicionales.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio06_NumeroParOImpar {

	public static void main(String[] args) {
		int num;
		
		System.out.println("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();

		if (num % 2 == 0) {
			System.out.println("El número es par");
		}
		else {
			System.out.println("El número es impar");
		}
	}

}
