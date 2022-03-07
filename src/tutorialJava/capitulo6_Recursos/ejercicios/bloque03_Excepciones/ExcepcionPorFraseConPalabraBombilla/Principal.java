package tutorialJava.capitulo6_Recursos.ejercicios.bloque03_Excepciones.ExcepcionPorFraseConPalabraBombilla;

import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {

	
	private static String getFraseConPalabraBombilla () throws SoloEspaciosEnBlancoException, 
																MinimoNumeroDePalabrasNoAlcanzadoException, 
																PalabraBombillaNoEncontradaException, 
																PalabraOfensivaException {
		String frase = JOptionPane.showInputDialog("Introduzca una frase con la palabra \"bombilla\"");
		
		// No frase formada por espacios en blanco
		if (frase.trim().equals("")) {
			throw new SoloEspaciosEnBlancoException("No hay palabras en la frase introducida");
		}
		// Mínimo número de palabras en 3.
		String palabras[] = frase.split("[ ]{1,}");
		if (palabras.length < 3) {
			throw new MinimoNumeroDePalabrasNoAlcanzadoException(3);
		}
		
		// No aparece la palabra bombilla
		if (frase.toUpperCase().indexOf("BOMBILLA") == -1) {
			throw new PalabraBombillaNoEncontradaException();
		}
		
		// Comprobar palabras ofensivas
		String palabrasOfensivas[] = new String[] {"tonto", "tonta", "idiota"};
		for (String palabraOfensiva : palabrasOfensivas) {
			if (frase.toUpperCase().indexOf(palabraOfensiva) != -1) {
				throw new PalabraOfensivaException("Palabra " + palabraOfensiva + " encontrada");
			}
		}
		
		return frase;
	}
	
	
	public static void main(String[] args) {
		
		try {
			System.out.println(getFraseConPalabraBombilla());
		} catch (SoloEspaciosEnBlancoException e) {
			e.printStackTrace();
		} catch (MinimoNumeroDePalabrasNoAlcanzadoException e) {
			e.printStackTrace();
		} catch (PalabraBombillaNoEncontradaException e) {
			e.printStackTrace();
		} catch (PalabraOfensivaException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
