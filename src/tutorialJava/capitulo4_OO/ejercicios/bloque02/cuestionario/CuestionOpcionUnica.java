package tutorialJava.capitulo4_OO.ejercicios.bloque02.cuestionario;

import java.util.List;
import java.util.Scanner;

public class CuestionOpcionUnica extends Cuestion {

	List<String> posiblesRespuestas;
	int respuesta;
	
	public CuestionOpcionUnica() {
	}

	public CuestionOpcionUnica(String enunciado, List<String> posiblesRespuestas, int respuesta) {
		super(enunciado);
		this.posiblesRespuestas = posiblesRespuestas;
		this.respuesta = respuesta;
	}

	@Override
	public String getEnunciado() {
		String e = super.getEnunciado() + ": \n";
		for (int i = 0; i < this.posiblesRespuestas.size(); i++) {
			e += "\t" + (i + 1) + "- " + this.posiblesRespuestas.get(i) + "\n";
		}
		e += "Tu respuesta es: ";
		return e;
	}

	@Override
	public boolean pedirRespuestaDelUsuario() {
		Scanner sc = new Scanner(System.in);
		int respuestaUsuario = sc.nextInt();
		
		// Compruebo la respuesta
		if (respuestaUsuario == this.respuesta) {
			System.out.println("\t¡¡¡¡BIEN!!!!!");
			return true;
		}
		else {
			System.out.println("\t¡¡¡¡MAAAAAL!!!!!");
			return false;
		}

	}
}
