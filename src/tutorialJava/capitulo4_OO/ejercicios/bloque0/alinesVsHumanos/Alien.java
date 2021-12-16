package tutorialJava.capitulo4_OO.ejercicios.bloque0.alinesVsHumanos;

public class Alien extends Personaje implements Serializable {

	public int numeroBrazos = 5;
	
	public Alien () {
		super();
	}

	@Override
	public String toString() {
		if (this.vida > 0) return "[A:" + this.vida + "]";
		else return "[A:X]";
	}

	@Override
	public String serializar() {
		if (this.vida > 0) return "(A:" + this.vida + ")";
		else return "(A:X)";
	}


	

}
