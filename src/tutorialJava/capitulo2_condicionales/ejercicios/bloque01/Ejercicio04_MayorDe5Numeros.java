package tutorialJava.capitulo2_condicionales.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio04_MayorDe5Numeros {

	public static void main(String[] args) {
		int menor = 0, num;
		
		System.out.println("Vamos a obtener el menor de 5 números");
		
		System.out.println("Introduzca otro número: ");
		Scanner sc = new Scanner(System.in);
		menor = sc.nextInt();
		
		System.out.println("Introduzca otro número: ");
		sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num < menor) {
			menor = num;
		}
		
		System.out.println("Introduzca otro número: ");
		sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num < menor) {
			menor = num;
		}
		
		System.out.println("Introduzca otro número: ");
		sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num < menor) {
			menor = num;
		}
		
		System.out.println("Introduzca otro número: ");
		sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num < menor) {
			menor = num;
		}
		
		System.out.println("El menor es: " + menor);
		
	}

}
