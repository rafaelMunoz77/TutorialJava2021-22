 package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque08_listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import tutorialJava.Utils;


public class EjercicioArrayListIntegerClase {

	public static void main(String[] args) {
		// Declaración de variables
		List<Integer> enteros = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int opcion=0;
		
		do{
			
			System.out.println("MENÚ DEL PROGRAMA");
			System.out.println("0.- Abandonar programa");
			System.out.println("1.- Crear aleatoriamente lista de valores");
			System.out.println("2.- Calcular suma, media, mínimo y máximo.");
			System.out.println("3.- Agregar cantidad nuevos valores");
			System.out.println("4.- Eliminar elementos en un intervalo");
			System.out.println("5.- Imprimir lista");
			
			System.out.println("Escribe la opción (0-5):");
			opcion = sc.nextInt();
			
			switch(opcion) {
			
			case 1: crearListaAleatoria(enteros);
				break;
			case 2: calcularSumaMediaMinimo(enteros);
				break;
			case 3: agregarCantidadValores(enteros);
				break;
			case 4: eliminarValores(enteros);
				break;
			case 5:imprimirLista(enteros);
				break;
			case 0:
				System.out.println("FIN DEL PROGRAMA. GRACIAS POR USAR NUESTRO SOFTWARE.");
				break;
			default:
				System.out.println("Dato no válido.");
			}
			
		}while(opcion != 0);

	}

	public static void eliminarValores(List<Integer> enteros) {
		// TODO Auto-generated method stub
		int min, max, contador=0;
		Scanner teclado = new Scanner(System.in);
	
		System.out.println("ELIMINANDO VALORES DE LA LISTA: ");
		System.out.println("Valor mínimo del intervalo a borrar: ");
		min = teclado.nextInt();
		
		System.out.println("Valor máximo del intervalo a borrar: ");
		max = teclado.nextInt();
		
		for (int i = 0; i < enteros.size(); i++) {
			//Compruebo el valor si se encuentra en este intervalo
			if (enteros.get(i) >= min && enteros.get(i) <= max) {
				enteros.remove(i);
				contador++;
			}
		}
		
		System.out.println("Elementos eliminados de la lista: "+contador);
		
		
	}

	public static void agregarCantidadValores(List<Integer> enteros) {
		// TODO Auto-generated method stub
		int cantidad, posicion, min, max;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Cantidad de nuevos valores: ");
		cantidad = teclado.nextInt(); 
		
		System.out.println("Posición a introducir estos valores: ");
		posicion = teclado.nextInt();
		
		//CONTROL DE ERRORES
		if (posicion > enteros.size()) {
			posicion = enteros.size();
		}
		
		System.out.println("Valor mínimo de los valores: ");
		min = teclado.nextInt();
		
		System.out.println("Valor máximo de los valores: ");
		max = teclado.nextInt();
		
		//Introducimos los nuevos valores en la posición
		
		for (int i = 0; i < cantidad; i++) {
			enteros.add((posicion + i), Utils.obtenerNumeroAzar(min, max));
		}
		
	}

	public static void calcularSumaMediaMinimo(List<Integer> enteros) {
		// TODO Auto-generated method stub
		int suma=0, minimo=0,maximo=0;
		float media;
		
		//Recorremos la lista para hacer los cálculos
		for (int i = 0; i < enteros.size(); i++) {
			//Suma
			suma += enteros.get(i);
			//Calculamos el mínimo y el máximo
			if (i==0) {
				minimo = enteros.get(i);
				maximo = enteros.get(i);
			}
			else {
				if(enteros.get(i) <= minimo) {
					minimo = enteros.get(i);
				}

				if(enteros.get(i) >= maximo) {
					maximo = enteros.get(i);
				}

			}	
		}
		
		//Calcular la media
		media = (float)suma / enteros.size();
		
		System.out.println("Suma: "+suma);
		System.out.println("Media: "+media);
		System.out.println("Mínimo: "+minimo);
		System.out.println("Máximo: "+maximo);
		
		
	}

	public static void imprimirLista(List<Integer> enteros) {
		// TODO Auto-generated method stub
		System.out.println("Lista de enteros: ");
	/*	for (Integer e : enteros) {
			System.out.print(e +" ");
		}*/
		
		for (int i = 0; i < enteros.size(); i++) {
			System.out.print(enteros.get(i)+" ");
		}
		System.out.println("");
		
	}

	public static void crearListaAleatoria(List<Integer> enteros) {
		// Declaración de variables
		int longitud, min, max;
		Scanner teclado = new Scanner(System.in);
		
		//Pedimos los datos al usuario
		System.out.println("Longitud de la lista: ");
		longitud = teclado.nextInt();
		
		System.out.println("Mínimo valor de la lista: ");
		min = teclado.nextInt();
		
		System.out.println("Máximo valor de la lista: ");
		max = teclado.nextInt();
		
		//Limpiamos la lista
		enteros.clear();
		
		for(int i=0;i<longitud;i++) {
			enteros.add(Utils.obtenerNumeroAzar(min, max));
		}
		
		
	}

}
