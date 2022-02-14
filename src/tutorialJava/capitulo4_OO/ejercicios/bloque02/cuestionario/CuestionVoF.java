package tutorialJava.capitulo4_OO.ejercicios.bloque02.cuestionario;

import java.util.Scanner;

public class CuestionVoF extends Cuestion {

	String respuesta;
	
	public CuestionVoF() {
	}

	public CuestionVoF(String enunciado, String respuesta) {
		super(enunciado);
		this.respuesta = respuesta.toUpperCase();
	}

	@Override
	public String getEnunciado() {
		return super.getEnunciado() + " (\"V\" ó \"F\"): ";
	}

	@Override
	public boolean pedirRespuestaDelUsuario() {
		Scanner sc = new Scanner(System.in);
		String respuestaUsuario = sc.next();
		
		// Compruebo la respuesta
		if (respuestaUsuario.toUpperCase().equals(this.respuesta)) {
			System.out.println("\t¡¡¡¡BIEN!!!!!");
			return true;
		}
		else {
			System.out.println("\t¡¡¡¡MAAAAAL!!!!!");
			return false;
		}
	}

	
}
