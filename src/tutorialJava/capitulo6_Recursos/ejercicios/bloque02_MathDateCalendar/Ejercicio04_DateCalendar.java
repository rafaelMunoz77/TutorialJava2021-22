package tutorialJava.capitulo6_Recursos.ejercicios.bloque02_MathDateCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio04_DateCalendar {

	public static void main(String[] args) {
	
		Date date = pideFechaConFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		
		System.out.println("Año del date: " + new SimpleDateFormat("yyyy").format(date));
		System.out.println("Mes del date: " + new SimpleDateFormat("MM").format(date));
		System.out.println("Día del date: " + new SimpleDateFormat("dd").format(date));
		System.out.println("Hora del date: " + new SimpleDateFormat("HH").format(date));
		System.out.println("Minuto del date: " + new SimpleDateFormat("mm").format(date));
		System.out.println("Segundo del date: " + new SimpleDateFormat("ss").format(date));

		System.out.println("\nAño del calendar: " + calendar.get(Calendar.YEAR));
		System.out.println("Mes del calendar: " + calendar.get(Calendar.MONTH));
		System.out.println("Día del calendar: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("Hora del calendar: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minuto del calendar: " + calendar.get(Calendar.MINUTE));
		System.out.println("Segundo del calendar: " + calendar.get(Calendar.SECOND));
		
		calendar.add(Calendar.DAY_OF_YEAR, 3); System.out.println("\nCalendar más 3 días: " + calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, -14); System.out.println("Calendar menos 2 semanas: " + calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, 300); System.out.println("Calendar más 300 días: " + calendar.getTime());
		calendar.add(Calendar.YEAR, 4); System.out.println("Calendar más 4 años: " + calendar.getTime());
	}

	
	
	/**
	 * 
	 * @param formato
	 * @return
	 */       
	private static Date pideFechaConFormat (String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		
		do {
			try {
				return sdf.parse(JOptionPane.showInputDialog("Introduzca una fecha con formato dd/mm/yyyy: "));
			} catch (ParseException e) {
				System.out.println("Fecha con formato incorrecto. Vuelva a intentarlo");
			}
		} while (true);
	}
}
