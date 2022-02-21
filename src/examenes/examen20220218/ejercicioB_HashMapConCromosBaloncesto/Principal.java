package examenes.examen20220218.ejercicioB_HashMapConCromosBaloncesto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		HashMap<Integer, Cromo> coleccion = new HashMap<Integer, Cromo>();
		
		Cromo c1 = new Cromo(1, "Stephen Curry", 30, 600);
		Cromo c2 = new Cromo(2, "Eustaquio Jiménez Jiménez", 300, 850);
		Cromo c3 = new Cromo(3, "Marita Cerdeña", 301, 743);
		Cromo c4 = new Cromo(4, "Peppa Pig", 14, 989);
		
		coleccion.put(c1.getCodigo(), c1);
		coleccion.put(c2.getCodigo(), c2);
		coleccion.put(c3.getCodigo(), c3);
		coleccion.put(c4.getCodigo(), c4);
		
		System.out.println("Con mas puntos: " + getCromoConMasPuntos(coleccion).toString());
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
