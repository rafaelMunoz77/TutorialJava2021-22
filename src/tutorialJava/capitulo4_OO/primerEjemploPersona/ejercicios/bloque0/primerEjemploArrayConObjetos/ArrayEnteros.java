package tutorialJava.capitulo4_OO.primerEjemploPersona.ejercicios.bloque0.primerEjemploArrayConObjetos;

import java.util.Arrays;

public class ArrayEnteros {

	private NumeroEntero array[];

	/**
	 * 
	 */
	public ArrayEnteros() {
		array = new NumeroEntero[100];
		
		for (int i = 0; i < array.length; i++) {
			int valor = (int) Math.round(Math.random()*100);
			array[i] = new NumeroEntero(valor);
		}
	}

	/**
	 * @param array
	 */
	public ArrayEnteros(NumeroEntero[] array) {
		this.array = array;
	}

	/**
	 * 
	 */
	public void mostrar() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].toString());
		}
	}
	
	
	@Override
	public String toString() {
		return "ArrayEnteros [array=" + Arrays.toString(array) + "]";
	}

	public NumeroEntero[] getArray() {
		return array;
	}

	public void setArray(NumeroEntero[] array) {
		this.array = array;
	}
	
	
}
