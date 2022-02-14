package tutorialJava.capitulo4_OO.ejercicios.bloque02.cuestionario;

public abstract class Cuestion {

	private String enunciado;

	/**
	 * 
	 */
	public Cuestion() {
	}

	/**
	 * @param enunciado
	 */
	public Cuestion(String enunciado) {
		this.enunciado = enunciado;
	}

	public abstract boolean pedirRespuestaDelUsuario();
	
	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	@Override
	public String toString() {
		return "Cuestion [enunciado=" + enunciado + "]";
	}
	
	
}
