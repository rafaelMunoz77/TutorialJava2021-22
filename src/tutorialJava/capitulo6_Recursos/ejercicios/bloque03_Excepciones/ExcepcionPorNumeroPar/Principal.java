package tutorialJava.capitulo6_Recursos.ejercicios.bloque03_Excepciones.ExcepcionPorNumeroPar;

import java.util.Scanner;

public class Principal {

	private static int getNumeroPar () throws NumeroImparException {
		System.out.println("Introduzca número par: ");
		Scanner sc = new Scanner (System.in);
		int numero = sc.nextInt();
		
		if (numero % 2 == 0) {
			return numero;
		}
		else {
			throw new NumeroImparException("El número: " + numero + " no es par");
		}
	}
	
	
	
	public static void main(String[] args) {
		
		try {
			getNumeroPar();
		} catch (NumeroImparException e) {
			e.printStackTrace();
		}
		
	}

}
