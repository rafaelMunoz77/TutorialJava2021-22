package tutorialJava.capitulo4_OO.ejercicios.bloque0.alinesVsHumanos;

public class Humano extends Personaje implements Serializable {

	
	public Humano () {
		super();
	}

	@Override
	public String toString() {
		if (this.vida > 0) return "[H:" + this.vida + "]";
		else return "[H:X]";
	}

	@Override
	public String serializar() {
		if (this.vida > 0) return "(H:" + this.vida + ")";
		else return "(H:X)";
	}

	

}
