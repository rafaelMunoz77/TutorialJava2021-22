package examenes.examen20211126.tipoB;

public class EjercicioB_ArrayAMatriz {

	public static void main(String[] args) {
		int array[] = inicializaArrayAzar(25);
		int matriz[][];
		
		muestraArray(array);
		
		matriz = convierteArrayEnMatriz(array);
		
		muestraMatriz(matriz);
	}

	
	public static int[][] convierteArrayEnMatriz(int array[]) {
		int lado = (int) Math.sqrt(array.length);
		int matriz[][] = new int[lado][lado];
//		int k = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = array[i * lado + j];
//				k++;
			}
		}
		
		return matriz;
	}
	
	/**
	 * 
	 * @param longitud
	 * @return
	 */
	public static int[] inicializaArrayAzar (int longitud) {
		int array[] = new int[longitud];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}
		
		return array;
	}
	

	/**
	 * 
	 * @param array
	 */
	public static void muestraArray(int array[]) {
		System.out.print("Array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	
	/**
	 * 
	 * @param matriz
	 */
	public static void muestraMatriz (int matriz[][]) {
		System.out.println("Matriz:");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
