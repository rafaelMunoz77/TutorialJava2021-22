package tutorialJava.capitulo5_Arrays_y_Colecciones;

import tutorialJava.Utils;

public class MetodosSobreArrays {

	public static void main(String[] args) {
		int array[] = new int[10];

		inicializaArrayAlAzar(array);
		muestraArray(array);
	}
	
	
	public static void inicializaArrayAlAzar (int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.obtenerNumeroAzar();
		}
	}
	
	
	
	public static void muestraArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
