package tutorialJava.capitulo6_Recursos.ejercicios.bloque03_Excepciones.ExcepcionPorFraseConPalabraBombilla;

public class MinimoNumeroDePalabrasNoAlcanzadoException extends Exception {

	private int minimoNumeroPalabras;
	
	public MinimoNumeroDePalabrasNoAlcanzadoException(int minimoNumeroPalabras) {
		this.minimoNumeroPalabras = minimoNumeroPalabras;
		// TODO Auto-generated constructor stub
	}

	public MinimoNumeroDePalabrasNoAlcanzadoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MinimoNumeroDePalabrasNoAlcanzadoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MinimoNumeroDePalabrasNoAlcanzadoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MinimoNumeroDePalabrasNoAlcanzadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
