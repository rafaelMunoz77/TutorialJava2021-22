package examenes.examen20211126.tipoA;

public class EjercicioB_DamasEnTablero10x10 {

	public static void main(String[] args) {
		int tablero[][] = inicializaTablero (10, 10);

		muestraMatriz(tablero);
	}

	
	/**
	 * 
	 * @param filas
	 * @param columnas
	 * @return
	 */
	public static int[][] inicializaTablero (int filas, int columnas) {
		int matriz[][] = new int[filas][columnas];
		int valorAlterno = 0;
		
		// Comienzo recorriendo las filas
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i < 4 || i > 5) {
					matriz[i][j] = valorAlterno;
					if (j != (matriz[i].length-1)) {
						valorAlterno = (valorAlterno == 0)? 1 : 0;
					}
				}
				else {
					matriz[i][j] = 0;
				}
			}
		}
		
		return matriz;
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
