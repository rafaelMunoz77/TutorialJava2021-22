package tutorialJava.capitulo6_Recursos.ejercicios.bloque02_MathDateCalendar;

public class Ejercicio01_PuntoDeCorteDeDosGraficas {

	public static void main(String[] args) {
		
		double x = 0, y1 = 0, y2 = 0;
		
		for (x = 0; x < 1; x+=0.0001) {
			y1 = Math.sqrt(x);
			y2 = - Math.log(x);
			
			if (Math.abs(y1 - y2) < 0.001) {
				break;
			}
		}

		System.out.println("Cruce encontrado en x: " + x + " y: " + ((y1 + y2) / 2f));
	}

}
