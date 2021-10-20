package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio05_IntercambioDosValores {

	public static void main(String[] args) {
		String str;
		int entero, entero2, aux;
		
		str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		entero = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		entero2 = Integer.parseInt(str);
		
		System.out.println("Antes - entero: " + entero + " - entero 2: " + entero2);
		
		aux = entero;
		entero = entero2;
		entero2 = aux;

		System.out.println("Antes - entero: " + entero + " - entero 2: " + entero2);
	}

}
