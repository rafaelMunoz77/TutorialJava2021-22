package tutorialJava.capitulo7_Acceso_A_Datos.ejercicios.bloque01_CRUD_Fabricante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int opcion = 0;
		
		do {
			opcion = menu();

			switch(opcion) {
			case 1: // Listado de fabricantes
				GestionFabricante.listarFabricantes();
				break;
			case 2: // Nuevo fabricante
				GestionFabricante.nuevoFabricante();
				break;
			case 3: // Modificar fabricante
				GestionFabricante.modificarFabricante();
				break;
			case 4: // Eliminar fabricante
				GestionFabricante.eliminarFabricante();
				break;
			}

		} while (opcion != 0);
		

	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static int menu () {
		Scanner sc = new Scanner(System.in);
		int opcionElegida = 0;
		
		System.out.println("\n\nMenú" + 
				"\n\t1.- Listar Fabricantes" +
				"\n\t2.- Nuevo Fabricante" +
				"\n\t3.- Modificar Fabricante" + 
				"\n\t4.- Eliminar Fabricante" +
				"\nIntroduzca su opción: ");
		
		opcionElegida = sc.nextInt();
		return opcionElegida;
	}
}
