package tutorialJava.capitulo1.ejercicios.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio06_CuotaMensualDePrestamo {

	public static void main(String[] args) {
		String str;
		int n;
		float capital, euribor, diferencial, interesAnual, interesMensual, aux, 
		cuotaMensual;
		
		str = JOptionPane.showInputDialog("Introduzca el número de meses: ");
		n = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca capital: ");
		capital = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca diferencial: ");
		diferencial = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca euribor: ");
		euribor = Float.parseFloat(str);

		interesAnual = euribor + diferencial;
		interesMensual = interesAnual / 12 / 100;
		aux = (float) Math.pow(1 + interesMensual, n);
		
		cuotaMensual = capital * (interesMensual * aux) / (aux - 1);

		System.out.println("La cuota mensual es: " + cuotaMensual);
	}
	

}
