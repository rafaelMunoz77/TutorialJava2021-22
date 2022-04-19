package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tutorialJava.capitulo7_Acceso_A_Datos.ejercicios.bloque01_CRUD_Fabricante.ConnectionManager;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Cliente;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Coche;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Concesionario;

public class ControladorConcesionario extends SuperControlador {

	
	/**
	 * 
	 */
	public static Concesionario findPrimero () {
		return find("select * from concesionario order by id limit 1");
	}

	/**
	 * 
	 */
	public static Concesionario findUltimo () {
		return find("select * from concesionario order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Concesionario findAnterior (int idActual) {
		return find("select * from concesionario where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Concesionario findSiguiente (int idActual) {
		return find("select * from concesionario where id > " + idActual + " order by id limit 1");
	}



	/**
	 * 
	 */
	public static Concesionario find (String sql) {
		Concesionario c = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery (sql);
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				c = new Concesionario(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"), rs.getString("localidad"));
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
	public static List<Concesionario> findAll () {
		List<Concesionario> lista = new ArrayList<Concesionario>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("Select * from concesionario");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				Concesionario c = new Concesionario(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"), rs.getString("localidad"));
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
	public static int guardar(Concesionario c) {
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
	public static int modificar (Concesionario c) {		
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			
			registrosAfectados = s.executeUpdate(
					"update concesionario set cif='" + c.getCif() + "', nombre='" + 
					c.getNombre() + "', localidad='" + c.getLocalidad() + "' where id=" + c.getId());
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
					"delete from concesionario where id=" + idEliminacion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrosAfectados;		
	}

	/**
	 * 
	 */
	public static int nuevo (Concesionario c) {
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			c.setId(siguienteIdEnTabla("concesionario"));
			registrosAfectados = s.executeUpdate(
						"insert into concesionario values (" + c.getId() + ", '" + c.getCif() +
						"', '" + c.getNombre() + "', '" + c.getLocalidad() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrosAfectados;
	}


}
