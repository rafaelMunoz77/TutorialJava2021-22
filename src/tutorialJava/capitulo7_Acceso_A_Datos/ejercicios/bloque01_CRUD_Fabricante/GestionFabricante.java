package tutorialJava.capitulo7_Acceso_A_Datos.ejercicios.bloque01_CRUD_Fabricante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GestionFabricante extends SupertipoGestion {

	/**
	 * 
	 */
	public static void eliminarFabricante() {
		Scanner sc = new Scanner(System.in);
		int id = 0;
		
		System.out.println("Introduce id del fabricante para su eliminación: ");
		id = sc.nextInt();

		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			int registrosAfectados = s.executeUpdate(
					"delete from fabricante where id=" + id);
			System.out.println(registrosAfectados + " registros eliminados");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 */
	public static void modificarFabricante () {
		Scanner sc = new Scanner(System.in);
		int id = 0;
		String cif = "", nombre = "";
		String nuevoCif = "", nuevoNombre = "";
		
		System.out.println("Introduce id del fabricante: ");
		id = Integer.parseInt(sc.nextLine());
		
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			ResultSet rs = s.executeQuery("Select * from fabricante where id=" + id);
			if (rs.next()) {
				cif = rs.getString("cif");
				nombre = rs.getString("nombre");
			}

			System.out.println("Cif (" + cif + ") (Intro para mantener): ");
			nuevoCif = sc.nextLine();
			if (!nuevoCif.trim().equals("")) {
				cif = nuevoCif;
			}
	
			System.out.println("Nombre (" + nombre + ") (Intro para mantener): ");
			nuevoNombre = sc.nextLine();
			if (!nuevoNombre.trim().equals("")) {
				nombre = nuevoNombre;
			}
			
			int registrosAfectados = s.executeUpdate(
					"update fabricante set cif='" + cif + "', nombre='" + nombre + "' " +
					"where id=" + id);
			System.out.println(registrosAfectados + " registros afectados");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

	/**
	 * 
	 */
	public static void nuevoFabricante () {
		Scanner sc = new Scanner(System.in);
		String cif, nombre;
		int nuevoIdDisponible;
		
		System.out.println("Creación de un nuevo fabricante:");
		System.out.println("Dame el cif:");
		cif = sc.next();
		System.out.println("Dame el nombre:");
		nombre = sc.next();
		
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			nuevoIdDisponible = maxIdEnTabla("fabricante");
			if (nuevoIdDisponible != -1) {
				int registrosAfectados = s.executeUpdate(
						"insert into fabricante values (" + nuevoIdDisponible + ",'" + cif + "', '" + nombre + "')");
				System.out.println(registrosAfectados + " registros insertados ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 */
	public static void listarFabricantes() {
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from fabricante");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) { 
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	

}
