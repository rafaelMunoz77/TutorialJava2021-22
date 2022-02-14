package tutorialJava.capitulo5_Arrays_y_Colecciones.ejercicios.bloque08_listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 2.- Escribe un programa editor de textos. Debes utilizar la consola de Java.
 *  El objetivo es que se pueda editar el contenido de un archivo ficticio.
 *   Para hacer esto utilizarás una lista de elementos de tipo String.
 *    Cada línea del texto será representada como un String. Debes mostrar
 *     un menú en pantalla, que contenga todas las opciones siguientes,
 *      y que funcionen adecuadamente:
 *      
a) "Abandonar el programa".
b) "Agregar una línea al texto". Pediras al usuario un String
 y lo agregarás al final de la lista que representa tu fichero ficticio.
 
b) "Insertar una línea en cualquier posición del texto". Pedirás al usuario
 un String y un número. Insertarás el String en la línea pedida.
 
c) "Editar una línea (reescribir su contenido)". Pedirás al usuario un número 
de línea para sobrescribir, mostrarás al usuario la línea actual que desea
 sobrescribir. Pedirás un nuevo String. Eliminarás el String actual y cambiarás con el nuevo
d) "Borrar una línea". Pedirás un número de línea y la eliminarás de la lista.

e) "Cortar un conjunto de líneas", (marcadas por su posición inicial y final).
 Pedirás un número de línea inicial y uno final. "Transportarás todas las líneas
  del intervalo a una nueva lista y las borrarás de la lista original.
  
f) "Pegar un conjunto de líneas cortadas en una determinada posición".
 Pedirás un número de línea en la que insertar lo que tienes cortado 
 con la opción anterior.
g) "Imprimir el fichero". Mostrarás cada línea del fichero ficticio, aparecerá numerada en la consola.
 * 
 * @author AlbertoLamarca
 *
 */

public class EjercicioArrayListStringClase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> editor = new ArrayList<String>();
		List<String> portapapeles = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		int opcion=0;
		
		do{
			System.out.println("MENÚ DEL PROGRAMA");
			System.out.println("0.- Abandonar programa");
			System.out.println("1.- Agregar una línea al texto");
			System.out.println("2.- Insertar una línea en cualquier posición del texto.");
			System.out.println("3.- Editar una línea (reescribir su contenido)");
			System.out.println("4.- Borrar una línea");
			System.out.println("5.- Cortar un conjunto de líneas, (marcadas por su posición inicial y final).");
			System.out.println("6.- Pegar un conjunto de líneas, (marcadas por su posición).");
			System.out.println("7.- Imprimir el fichero");
			
			System.out.println("Escribe la opción (0-7):");
			opcion = sc.nextInt();
			
			switch(opcion) {
			
			case 1: agregarLinea(editor);
				break;
			case 2: insertarLineaPosicion(editor);
				break;
			case 3: editarLinea(editor);
				break;
			case 4: borrarLinea(editor);
				break;
			case 5:cortarLineas(editor,portapapeles);
				break;
			case 6: pegarLineas(editor,portapapeles);
				break;
			case 7: imprimirFichero(editor);
				break;
			case 0:
				System.out.println("FIN DEL PROGRAMA. GRACIAS POR USAR NUESTRO SOFTWARE.");
				break;
			default:
				System.out.println("Dato no válido.");
			}
			
		}while(opcion != 0);

	}

	private static void pegarLineas(List<String> editor, List<String> portapapeles) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				int posicion,j=0;
				
				System.out.println("Editor de Texto");
				//mostramos el fichero
				imprimirFichero(editor);
				
				
				System.out.println("Posicion donde pegar las líneas: ");
				posicion = sc.nextInt();
				
				editor.addAll(posicion-1, portapapeles);
				
				//Otra alternativa
		/*		for (int i = 0; i < portapapeles.size(); i++) {
					editor.add((posicion-1)+i, portapapeles.get(i));
				}
		*/
				
				//Limpiamos el portapapeles
				portapapeles.clear();
		
	}

	private static void cortarLineas(List<String> editor, List<String> portapapeles) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int posInicial, posFinal;
		
		System.out.println("Editor de Texto");
		//mostramos el fichero
		imprimirFichero(editor);
		
		//Limpiamos el portapapeles
		portapapeles.clear();
		
		System.out.println("Posicion Inicial para cortar: ");
		posInicial = sc.nextInt();
		
		System.out.println("Posicion Final para cortar: ");
		posFinal = sc.nextInt();
		
		for (int i = (posInicial-1); i < posFinal; i++) {
			portapapeles.add(editor.get(i));
		}
		
		//Eliminamos los elementos del fichero
		editor.removeAll(portapapeles);
		
		//Otra alternativa para borrar el fichero
	/*
	  	for (int i = (posInicial-1); i < posFinal; i++) {
	 
			editor.remove(posInicial-1);
		}
	*/
		
	}

	private static void borrarLinea(List<String> editor) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int posicion;
		
		System.out.println("Editor de Texto");
		//mostramos el fichero
		imprimirFichero(editor);
		
		System.out.println("Posicion de la línea a eliminar: ");
		posicion = sc.nextInt();
		
		// CONTROL DE ERRORES
		if (posicion > editor.size()) {
			posicion = editor.size();
		}
		
		editor.remove(posicion-1);
		
		System.out.println("Línea eliminada correctamente");
		
		
	}

	private static void editarLinea(List<String> editor) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int posicion;
		String linea;
		
		System.out.println("Editor de Texto");
		//mostramos el fichero
		imprimirFichero(editor);
		
		System.out.println("Posicion de la línea a modificar: ");
		posicion = sc.nextInt();
		
		linea = JOptionPane.showInputDialog("Modificar la línea", editor.get(posicion-1));
		
		editor.set(posicion-1, linea);

		//Otra alternativa para modificar la línea del fichero
		//editor.add(posicion-1, linea);
		//editor.remove(posicion);
	}

	private static void insertarLineaPosicion(List<String> editor) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int posicion;
		String linea;
		
		System.out.println("Editor de Texto");
		//mostramos el fichero
		imprimirFichero(editor);
		
		System.out.println("Posicion de la nueva línea");
		posicion = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Nueva línea a introducir: ");
		linea = sc.nextLine();
		
		//Introducimos la linea en la posición dada por el usuario
		editor.add((posicion-1),linea);
	}

	private static void imprimirFichero(List<String> editor) {
		// TODO Auto-generated method stub
		int numLinea = 1;
		
		//Recorremos la lista de String y la mostramos por consola
		System.out.println("*****************");
		for (String linea : editor) {
			System.out.println(numLinea+".-"+linea);
			numLinea++;
		}
		System.out.println("*****************");
		
	}

	private static void agregarLinea(List<String> editor) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		//Pedimos las línea al usuario
		System.out.println("Nueva línea: ");
		editor.add(teclado.nextLine());
		
	}

}
