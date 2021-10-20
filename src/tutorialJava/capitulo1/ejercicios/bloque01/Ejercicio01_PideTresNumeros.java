package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio01_PideTresNumeros {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int entero = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca un número flotante: ");
		float flotante = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca un número double: ");
		double doble = Double.parseDouble(str);
		
		System.out.println("El entero es: " + entero + "\nEl float es: " +
				flotante + ", el double es: " + doble);
	}

}
