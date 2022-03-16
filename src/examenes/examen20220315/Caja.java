package examenes.examen20220315;

import java.util.HashMap;

public class Caja {
	
	private HashMap<Integer, Articulo> hm = new HashMap<Integer, Articulo>();

	/**
	 * 
	 */
	public Caja() {
	}

	public HashMap<Integer, Articulo> getHm() {
		return hm;
	}

	public void setHm(HashMap<Integer, Articulo> hm) {
		this.hm = hm;
	}
	
	
	
}
