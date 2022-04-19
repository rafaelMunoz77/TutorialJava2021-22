package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tutorialJava.capitulo7_Acceso_A_Datos.ejercicios.bloque01_CRUD_Fabricante.ConnectionManager;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Coche;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Concesionario;

public class ControladorCoche extends SuperControlador {

	
	/**
	 * 
	 */
	public static Coche findPrimero () {
		return find("select * from coche order by id limit 1");
	}

	/**
	 * 
	 */
	public static Coche findUltimo () {
		return find("select * from coche order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Coche findAnterior (int idActual) {
		return find("select * from coche where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Coche findSiguiente (int idActual) {
		return find("select * from coche where id > " + idActual + " order by id limit 1");
	}



	/**
	 * 
	 */
	public static Coche find (String sql) {
		Coche c = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery (sql);
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				c = new Coche(rs.getInt("id"), rs.getInt("idFabricante"), rs.getString("bastidor"), rs.getString("modelo"), rs.getString("color"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return c;
	}


	/**
	 * 
	 */
	public static List<Coche> findAll () {
		List<Coche> lista = new ArrayList<Coche>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("Select * from coche");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				Coche c = new Coche(rs.getInt("id"), rs.getInt("idFabricante"), rs.getString("bastidor"), rs.getString("modelo"), rs.getString("color"));
				lista.add(c);
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
	public static int guardar(Coche c) {
		if (c.getId() == 0) {
			return nuevo(c);
		}
		else {
			return modificar(c);
		}
	}
	
	
	/**
	 * 
	 */
	public static int modificar (Coche c) {		
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			
			registrosAfectados = s.executeUpdate(
					"update coche set idFabricante=" + c.getIdFabricante() + ", bastidor='" + c.getBastidor() + "', modelo='" + 
					c.getModelo() + "', color='" + c.getColor() + "' where id=" + c.getId());
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
					"delete from coche where id=" + idEliminacion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrosAfectados;		
	}

	/**
	 * 
	 */
	public static int nuevo (Coche c) {
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			c.setId(siguienteIdEnTabla("coche"));
			registrosAfectados = s.executeUpdate(
						"insert into coche values (" + c.getId() + ", " + c.getIdFabricante() + ",'" + c.getBastidor() +
						"', '" + c.getModelo() + "', '" + c.getColor() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrosAfectados;
	}


}
