package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio03_SumaDeTresNumeros {

	public static void main(String[] args) {
		String str;
		int entero, entero2, entero3, suma;
		
		str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		entero = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		entero2 = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		entero3 = Integer.parseInt(str);
		
		suma = entero + entero2 + entero3;
		
		System.out.println("La suma es " + suma);
	}

}
