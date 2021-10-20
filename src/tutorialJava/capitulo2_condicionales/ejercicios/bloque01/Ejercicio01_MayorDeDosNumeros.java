package tutorialJava.capitulo2_condicionales.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio01_MayorDeDosNumeros {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca número: ");
		int num1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca otro número: ");
		int num2 = Integer.parseInt(str);
		
		if (num1 > num2) {
			System.out.println("El mayor es: " + num1);
		}
		else {
			if (num2 > num1) {
				System.out.println("El mayor es: " + num2);
			}
			else {
				System.out.println("Son iguales");
			}
		}
	}

}
