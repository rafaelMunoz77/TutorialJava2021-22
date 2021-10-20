package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio02_PideTresNumerosEImprime {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int entero = Integer.parseInt(str);
		System.out.println("El entero es: " + entero);
		
		str = JOptionPane.showInputDialog("Introduzca un número flotante: ");
		float flotante = Float.parseFloat(str);
		System.out.println("El float es: " + flotante);
		
		str = JOptionPane.showInputDialog("Introduzca un número double: ");
		double doble = Double.parseDouble(str);
		System.out.println("El double es: " + doble);
	}

}
