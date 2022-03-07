package tutorialJava.capitulo6_Recursos.ejercicios.bloque01_WrappersDeTiposPrimitivos;

import java.util.Scanner;

public class Ejercicio02_PedirPasswordConRequisitos {

	public static void main(String[] args) {
		boolean mayuscula = false;
		boolean minuscula = false;
		boolean digito = false;
		boolean noAlfanumerico = false;
		Scanner sc = new Scanner(System.in);
		
		do {
			mayuscula = false;
			minuscula = false;
			digito = false;
			noAlfanumerico = false;

			System.out.println("Dame una contraseña con mayúsculas, minúsculas, dígitos y algún carácter no alfanumérico: ");
			String password = sc.next();
			
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i))) {
					mayuscula = true;
				}
				if (Character.isLowerCase(password.charAt(i))) {
					minuscula = true;
				}
				if (Character.isDigit(password.charAt(i))) {
					digito = true;
				}
				if (!Character.isLetterOrDigit(password.charAt(i))) {
					noAlfanumerico = true;
				}
			}
		} while (!(mayuscula && minuscula && digito && noAlfanumerico));
		
		// Contraseña establecida
		System.out.println("Contraseña establecida  :-)");
	}

}
