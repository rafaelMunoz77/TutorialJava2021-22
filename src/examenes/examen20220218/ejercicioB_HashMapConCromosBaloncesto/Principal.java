package examenes.examen20220218.ejercicioB_HashMapConCromosBaloncesto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Principal {

	static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) {
		int opcionMenu = 1;
		
		HashMap<Integer, Cromo> coleccion = new HashMap<Integer, Cromo>();
		
		Cromo c1 = new Cromo(1, "Stephen Curry", 30, 600);
		Cromo c2 = new Cromo(2, "Eustaquio Jiménez Jiménez", 300, 850);
		Cromo c3 = new Cromo(3, "Marita Cerdeña", 301, 743);
		Cromo c4 = new Cromo(4, "Peppa Pig", 14, 989);
		
		coleccion.put(c1.getCodigo(), c1);
		coleccion.put(c2.getCodigo(), c2);
		coleccion.put(c3.getCodigo(), c3);
		coleccion.put(c4.getCodigo(), c4);

		do {
			opcionMenu = menu();
			
			switch (opcionMenu) {
			case 1: 
				visualizaCromos(coleccion);
				break;
			case 2:
			introduceNuevoCromo(coleccion);
				break;
			
			case 3:
				eliminaCromo(coleccion);
				break;
				
			case 4: 
				Cromo c = getCromoConMasPuntos(coleccion);
				System.out.println("Cromo con más puntos: " + getCromoConMasPuntos(coleccion));
				break;
			}
		} while (opcionMenu != 0);
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static int menu() {
		System.out.println("\n\nMENU\n\n"
				+ "0 - Salir\n"
				+ "1 - Visualizar valores de los cromos\n"
				+ "2 - Introducir un nuevo cromo\n"
				+ "3 - Elimionar un cromo por su id numérico\n"
				+ "4 - Imprimir en consola los datos del jugador o jugadora con más puntos\n"
				+ "Introduzca su opción: ");
		
		return sc.nextInt();
	}
	
	
	/**
	 * 
	 * @param cromos
	 */
	private static void visualizaCromos (HashMap<Integer, Cromo> cromos) {
		System.out.println("\n\nLISTADO DE CROMOS");
		
		Iterator<Cromo> it = cromos.values().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	/**
	 * 
	 * @param cromos
	 * @return
	 */
	private static int getSiguienteIdentificador (HashMap<Integer, Cromo> cromos) {
		Iterator<Cromo> it = cromos.values().iterator();
		int i = 0;
		int mayorIdentificadorUsado = 0;
		
		// Compruebo si existe al menos un primer valor
		while (it.hasNext()) {
			Cromo c = it.next();
			if (i == 0 && c != null) {
				mayorIdentificadorUsado = c.getCodigo();
			}
			else {
				if (c.getCodigo() > mayorIdentificadorUsado) {
					mayorIdentificadorUsado = c.getCodigo();
				}
			}	
		}
		return mayorIdentificadorUsado + 1;
	}
	
	/**
	 * 
	 * @param cromos
	 */
	private static void introduceNuevoCromo (HashMap<Integer, Cromo> cromos) {
		Cromo c = new Cromo();
		c.setCodigo(getSiguienteIdentificador(cromos));
		
		System.out.println("Introduce el nombre del jugador que aparece en el cromo: ");
		c.setNombre(sc.next());
		System.out.println("Introduce su cantidad de puntos: ");
		c.setPuntos(sc.nextInt());
		System.out.println("Introduce su cantidad de rebotes: ");
		c.setRebotes(sc.nextInt());
		
		cromos.put(c.getCodigo(), c);
	}
	
	/**
	 * 
	 * @param cromos
	 */
	private static void eliminaCromo (HashMap<Integer, Cromo> cromos) {
		System.out.println("Introduce el código del jugador que deseas eliminar: ");
		int codigo = sc.nextInt();
		
		cromos.remove(codigo);
	}
	
	/**
	 * 
	 * @param cromos
	 * @return
	 */
	private static Cromo getCromoConMasPuntos (HashMap<Integer, Cromo> cromos) {
		Cromo cromoConMasPuntos = null;
		Iterator<Cromo> it = cromos.values().iterator();
		
		// Compruebo si existe al menos un primer valor
		if (it.hasNext()) {
			cromoConMasPuntos = it.next();
		}
		
		// Recorro el resto de cromos buscando uno con más puntos
		while (it.hasNext()) {
			Cromo cromoQueCompruebo = it.next();
			if (cromoQueCompruebo.getPuntos() > cromoConMasPuntos.getPuntos()) {
				cromoConMasPuntos = cromoQueCompruebo;
			}
		}
		
		return cromoConMasPuntos;
	}

}
