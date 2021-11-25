package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque07;

public class Ejercicio01_MetodoStringFromArray {

	public static void main(String[] args) {
		int array[] = new int[] {65, 66, 67};
		String str = stringFromArray(array);
		System.out.println("str: " + str);
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static String stringFromArray (int array[]) {
		String str = "";
		
		for (int i = 0; i < array.length; i++) {
			str += (char) array[i];
		}
		return str;
	}

}
