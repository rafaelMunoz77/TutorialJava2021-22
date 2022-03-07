package tutorialJava.capitulo6_Recursos.ejercicios.bloque02_MathDateCalendar;

import java.util.Calendar;
import java.util.TimeZone;

public class Ejercicio05_DiferenciaHorariaEntreCiudades {

	public static void main(String[] args) {

		Calendar ahoraEnRoma = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
		Calendar ahoraEnWashington = Calendar.getInstance(TimeZone.getTimeZone("EST"));
		
		int horaEnRoma = ahoraEnRoma.get(Calendar.HOUR_OF_DAY);
		int horaEnWashington = ahoraEnWashington.get(Calendar.HOUR_OF_DAY);
		
		System.out.println("Diferencia horaria entre Roma y Wasington: " + Math.abs(horaEnRoma - horaEnWashington));


	}

}
