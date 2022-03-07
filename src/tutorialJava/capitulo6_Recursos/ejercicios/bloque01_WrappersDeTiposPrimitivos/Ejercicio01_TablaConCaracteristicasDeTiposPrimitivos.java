package tutorialJava.capitulo6_Recursos.ejercicios.bloque01_WrappersDeTiposPrimitivos;

public class Ejercicio01_TablaConCaracteristicasDeTiposPrimitivos {

	public static void main(String[] args) {
		
		// Características de un Integer
		System.out.println("Valor máximo para un Integer: " + Integer.MAX_VALUE);
		System.out.println("Valor mínimo para un Integer: " + Integer.MIN_VALUE);
		System.out.println("Tamaño en bits complemento a 2 para Integer: " + Integer.SIZE);

		// Características de un Long
		System.out.println("\nValor máximo para un Long: " + Long.MAX_VALUE);
		System.out.println("Valor mínimo para un Long: " + Long.MIN_VALUE);
		System.out.println("Tamaño en bits complemento a 2 para Long: " + Long.SIZE);

		// Características de un Short
		System.out.println("\nValor máximo para un Short: " + Short.MAX_VALUE);
		System.out.println("Valor mínimo para un Short: " + Short.MIN_VALUE);
		System.out.println("Tamaño en bits complemento a 2 para Short: " + Short.SIZE);
				
		// Características de un Float
		System.out.println("\nValor máximo para un Float: " + Float.MAX_VALUE);
		System.out.println("Valor mínimo para un Float: " + Float.MIN_VALUE);
		System.out.println("Tamaño en bits complemento a 2 para Float: " + Float.SIZE);
		
		// Características de un Double
		System.out.println("\nValor máximo para un Double: " + Double.MAX_VALUE);
		System.out.println("Valor mínimo para un Double: " + Double.MIN_VALUE);
		System.out.println("Tamaño en bits complemento a 2 para Double: " + Double.SIZE);
		
		// Wrapper para el tipo de datos "Character"
		System.out.println("Tamaño en bits complemento a 2 para Character: " + Character.SIZE);

	}

}
