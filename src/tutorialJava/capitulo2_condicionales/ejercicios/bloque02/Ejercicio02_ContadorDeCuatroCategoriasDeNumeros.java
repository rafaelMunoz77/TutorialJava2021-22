package tutorialJava.capitulo2_condicionales.ejercicios.bloque02;

import java.util.Scanner;

public class Ejercicio02_ContadorDeCuatroCategoriasDeNumeros {

	public static void main(String[] args) {
		int num, contNegativos = 0, contBajos = 0, contMedios = 0, contGrandes = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca un número: ");
		num = sc.nextInt();
		if (num < 0 ) {
			System.exit(0);
		}
		else {
			if (num <= 25) {
				contBajos += 1;
			}
			else {
				if (num <= 250) {
					contMedios++;
				}
				else {
					contGrandes++;
				}
			}
		}
	}

}
