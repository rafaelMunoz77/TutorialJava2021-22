package tutorialJava.capitulo2_condicionales.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio07_NumeroParOImparPorOperadorDeBits {

	public static void main(String[] args) {
		int num;
		
		System.out.println("Introduzca un número: ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();

		if ((num & 1) == 1) {
			System.out.println("El número es impar");
		}
		else {
			System.out.println("El número es par");
		}
	}

}
