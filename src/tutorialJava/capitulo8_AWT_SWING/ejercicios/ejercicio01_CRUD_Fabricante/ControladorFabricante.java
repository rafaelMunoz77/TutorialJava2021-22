package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio01_CRUD_Fabricante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import tutorialJava.capitulo7_Acceso_A_Datos.ejercicios.bloque01_CRUD_Fabricante.ConnectionManager;

public class ControladorFabricante extends SuperControlador {

	
	/**
	 * 
	 */
	public static Fabricante findPrimerFabricante () {
		return findFabricante("select * from fabricante order by id limit 1");
	}

	/**
	 * 
	 */
	public static Fabricante findUltimoFabricante () {
		return findFabricante("select * from fabricante order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Fabricante findAnteriorFabricante (int idActual) {
		return findFabricante("select * from fabricante where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Fabricante findSiguienteFabricante (int idActual) {
		return findFabricante("select * from fabricante where id > " + idActual + " order by id limit 1");
	}



	/**
	 * 
	 */
	public static Fabricante findFabricante (String sql) {
		Fabricante f = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery (sql);
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				f = new Fabricante(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return f;
	}


	/**
	 * 
	 * @param f
	 * @return
	 */
	public static int guardarFabricante(Fabricante f) {
		if (f.getId() == 0) {
			return nuevoFabricante(f);
		}
		else {
			return modificarFabricante(f);
		}
	}
	
	
	/**
	 * 
	 */
	public static int modificarFabricante (Fabricante f) {		
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			
			registrosAfectados = s.executeUpdate(
					"update fabricante set cif='" + f.getCif() + "', nombre='" + f.getNombre() 
					+ "' " + " where id=" + f.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrosAfectados;		
	}
	

	/**
	 * 
	 */
	public static int nuevoFabricante (Fabricante f) {
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			f.setId(siguienteIdEnTabla("fabricante"));
			registrosAfectados = s.executeUpdate(
						"insert into fabricante values (" + f.getId() + ",'" + f.getCif() +
						"', '" + f.getNombre() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrosAfectados;
	}


}
