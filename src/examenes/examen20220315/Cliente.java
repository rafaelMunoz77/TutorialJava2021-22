package examenes.examen20220315;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	List<Articulo> articulos = new ArrayList<Articulo>();

	/**
	 * 
	 */
	public Cliente() {
		this.articulos.add(new Tomate(1, "Tomate", 0.8, 2, "Rojo"));
		this.articulos.add(new Gelatina(2, "Gelatina", 0.9, 3, "Moco"));
		this.articulos.add(new Magdalena(3, "Magdalena", 1.05, 1, "Fresa"));
		this.articulos.add(new Patata(4, "Patata", 0.6, 3, true));
		
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	
	
}
