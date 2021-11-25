package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque07;

public class Ejercico04_CountOccurrences {

	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 2, 5, 5};
		int contadorOcurrencias;
		contadorOcurrencias = countOccurrences(array, 5);

		System.out.println("El valor buscado aparece: " + contadorOcurrencias + " veces");
	}

	
	
	public static int countOccurrences (int array[], int numeroBuscado) {
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numeroBuscado) {
				count++;
			}
		}
		
		return count;
	}

}
