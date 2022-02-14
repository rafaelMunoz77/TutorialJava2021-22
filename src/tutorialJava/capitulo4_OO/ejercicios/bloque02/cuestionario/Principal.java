package tutorialJava.capitulo4_OO.ejercicios.bloque02.cuestionario;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// Declaración del cuestionario
		Cuestion cuestionario[] = new Cuestion[2];
		int contadorRespuestasCorrectas = 0;
		
		// Crear las cuestiones del cuestionario
		cuestionario[0] = new CuestionVoF("España está dentro de Europa", "V");
		
		List<String> respuestas = new ArrayList<String>();
		respuestas.add("Unidos Mejoramos España");
		respuestas.add("Unidad Militar de Emergencias");
		respuestas.add("United Musicians Entity");
		respuestas.add("Únicamente Molestamos Eternamente");
		cuestionario[1] = new CuestionOpcionUnica("Las siglas U.M.E. significan", respuestas, 2);
		
		// Presentación al usuario
		for (int i = 0; i < cuestionario.length; i++) {
			System.out.println("\n" + cuestionario[i].getEnunciado());
			if (cuestionario[i].pedirRespuestaDelUsuario() == true) {
				contadorRespuestasCorrectas++;
			}
		}

		// Muestro resultado del cuestionario al usuario
		System.out.println("\nHas acertado " + contadorRespuestasCorrectas + " cuestiones");
	}

}
