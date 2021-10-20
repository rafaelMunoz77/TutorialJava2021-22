package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio04_MediaDeTresNumeros {

	public static void main(String[] args) {
		String str;
		int entero, entero2, entero3;
		float media;
		
		str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		entero = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		entero2 = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		entero3 = Integer.parseInt(str);
		
		media = (entero + entero2 + entero3) / 3.0f;
		
		System.out.println("La media es " + media);
	}

}
