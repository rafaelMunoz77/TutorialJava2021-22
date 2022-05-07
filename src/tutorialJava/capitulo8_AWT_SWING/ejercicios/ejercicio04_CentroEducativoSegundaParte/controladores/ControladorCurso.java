package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio04_CentroEducativoSegundaParte.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Cliente;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.ConnectionManager;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.entidades.Curso;

public class ControladorCurso extends SuperControlador {

	
	/**
	 * 
	 */
	public static Curso findPrimero () {
		return find("select * from curso order by id limit 1");
	}

	/**
	 * 
	 */
	public static Curso findUltimo () {
		return find("select * from curso order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Curso findAnterior (int idActual) {
		return find("select * from curso where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Curso findSiguiente (int idActual) {
		return find("select * from curso where id > " + idActual + " order by id limit 1");
	}



	/**
	 * 
	 */
	public static Curso find (String sql) {
		Curso c = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery (sql);
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				c = new Curso(rs.getInt("id"), rs.getString("descripcion"));
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
	public static List<Curso> findAll () {
		List<Curso> lista = new ArrayList<Curso>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("Select * from curso");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				Curso c = new Curso(rs.getInt("id"), rs.getString("descripcion"));
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
	public static int guardar(Curso c) {
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
	public static int modificar (Curso c) {		
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			
			registrosAfectados = s.executeUpdate(
					"update curso set descripcion='" + c.getDescripcion() + "' where id=" + c.getId());
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
					"delete from curso where id=" + idEliminacion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrosAfectados;		
	}

	/**
	 * 
	 */
	public static int nuevo (Curso c) {
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			c.setId(siguienteIdEnTabla("curso"));
			registrosAfectados = s.executeUpdate("insert into curso values (" + c.getId() + ",'" + c.getDescripcion() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrosAfectados;
	}


}
