package tutorialJava.capitulo2_condicionales.ejercicios.bloque02;

import java.util.Scanner;

public class Ejercicio01_SumaDeCuatroCategoriasDeNumeros {

	public static void main(String[] args) {
		int num, sumaNegativos = 0, sumaBajos = 0, sumaMedios = 0, sumaGrandes = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca un número: ");
		num = sc.nextInt();
		if (num < 0 ) {
			sumaNegativos = sumaNegativos + num;
		}
		else {
			if (num <= 25) {
				sumaBajos += num;
			}
			else {
				if (num <= 250) {
					sumaMedios += num;
				}
				else {
					sumaGrandes += num;
				}
			}
		}
	}

}
