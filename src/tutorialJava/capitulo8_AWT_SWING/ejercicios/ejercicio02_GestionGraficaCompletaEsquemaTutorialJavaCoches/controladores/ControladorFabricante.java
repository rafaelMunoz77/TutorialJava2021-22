package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import tutorialJava.capitulo7_Acceso_A_Datos.ejercicios.bloque01_CRUD_Fabricante.ConnectionManager;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Fabricante;

public class ControladorFabricante extends SuperControlador {

	
	/**
	 * 
	 */
	public static Fabricante findPrimero () {
		return find("select * from fabricante order by id limit 1");
	}

	/**
	 * 
	 */
	public static Fabricante findUltimo () {
		return find("select * from fabricante order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Fabricante findAnterior (int idActual) {
		return find("select * from fabricante where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Fabricante findSiguiente (int idActual) {
		return find("select * from fabricante where id > " + idActual + " order by id limit 1");
	}



	/**
	 * 
	 */
	public static Fabricante find (String sql) {
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
	 */
	public static List<Fabricante> findAll () {
		List<Fabricante> lista = new ArrayList<Fabricante>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("Select * from fabricante");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				Fabricante f = new Fabricante(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"));
				lista.add(f);
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return lista;
	}


	
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public static int guardar(Fabricante f) {
		if (f.getId() == 0) {
			return nuevo(f);
		}
		else {
			return modificar(f);
		}
	}
	
	
	/**
	 * 
	 */
	public static int modificar (Fabricante f) {		
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
	public static int eliminar (int idEliminacion) {		
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			
			registrosAfectados = s.executeUpdate(
					"delete from fabricante where id=" + idEliminacion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrosAfectados;		
	}

	/**
	 * 
	 */
	public static int nuevo (Fabricante f) {
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
