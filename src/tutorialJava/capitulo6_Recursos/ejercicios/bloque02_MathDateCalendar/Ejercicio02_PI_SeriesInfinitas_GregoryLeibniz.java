package tutorialJava.capitulo6_Recursos.ejercicios.bloque02_MathDateCalendar;

public class Ejercicio02_PI_SeriesInfinitas_GregoryLeibniz {

	public static void main(String[] args) {
		
		double PI = 0;
		int signo = 1;
		int denominador = 1;
		
		while (Math.abs(Math.PI - PI) > 0.00001) {
			PI += signo * (4f / denominador);
			signo = -signo;
			denominador += 2;
		}
		
		System.out.println("PI: " + PI);
	}

}
