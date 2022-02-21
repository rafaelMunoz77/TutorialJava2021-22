package examenes.examen20220218;

import java.util.Scanner;

public class EjercicioC_letrasYDigitosEnPalabras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = "        Tenemos un PUEnte Guapo el día 25/02/2022";
		int contMinusculas = 0, contMayusculas = 0, contDigitos = 0;
		
//		System.out.println("Introduzca varias palabras: ");
//		frase = sc.nextLine();
		
		// Quitamos los primeros espacios en blanco de la cadena
		frase = frase.trim();
		
		String palabras[] = frase.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			String palabra = palabras[i];
			System.out.println(palabra);
			// Los contadores se inicializan
			contMinusculas = 0; contMayusculas = 0; contDigitos = 0;
			
			for (int j = 0; j < palabra.length(); j++) {
				if (Character.isLowerCase(palabra.charAt(j))) {
					contMinusculas++;
				}
				if (Character.isUpperCase(palabra.charAt(j))) {
					contMayusculas++;
				}
				if (Character.isDigit(palabra.charAt(j))) {
					contDigitos++;
				}
			}
			
			System.out.println("\tMinúsculas: " + contMinusculas);
			System.out.println("\tMayúsculas: " + contMayusculas);
			System.out.println("\tDígitos: " + contDigitos);
		}
	}

}
