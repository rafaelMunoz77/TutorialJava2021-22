package tutorialJava.capitulo2_condicionales.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio03_MayorDe5Numeros {

	public static void main(String[] args) {
		int mayor = 0, num;
		
		System.out.println("Vamos a obtener el mayor de 5 números");
		
		System.out.println("Introduzca otro número: ");
		Scanner sc = new Scanner(System.in);
		mayor = sc.nextInt();
		
		System.out.println("Introduzca otro número: ");
		sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num > mayor) {
			mayor = num;
		}
		
		System.out.println("Introduzca otro número: ");
		sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num > mayor) {
			mayor = num;
		}
		
		System.out.println("Introduzca otro número: ");
		sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num > mayor) {
			mayor = num;
		}
		
		System.out.println("Introduzca otro número: ");
		sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num > mayor) {
			mayor = num;
		}
		
		System.out.println("El mayor es: " + mayor);
		
	}

}
