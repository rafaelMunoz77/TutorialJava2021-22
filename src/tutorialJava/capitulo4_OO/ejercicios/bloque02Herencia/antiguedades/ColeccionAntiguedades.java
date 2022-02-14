package tutorialJava.capitulo4_OO.ejercicios.bloque02Herencia.antiguedades;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class ColeccionAntiguedades {

	private List<Antiguedad> lista = new ArrayList<Antiguedad>();
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static int menu () {
		String str = "\n\nMENÚ DE ANTIGÜEDADES" +
				"\n1.- Crear Joya" +
				"\n2.- Crear Mueble" + 
				"\n3.- Mostrar lista";
		System.out.println(str);
		return sc.nextInt();
	}

}
