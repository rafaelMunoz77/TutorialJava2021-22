package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque08_listas;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio01_ListaIntegers {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>();
		int suma = 0;
		
		for (int i = 0; i < 100; i++) {
			lista.add(new Integer((int) Math.round(Math.random() * 100)));
		}

		imprimeLista(lista);
		
		
	}
	
	/**
	 * 
	 * @param l
	 */
	private static void imprimeLista (List<Integer> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i).intValue() + " ");
		}
	}

}
