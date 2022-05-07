package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio04_CentroEducativoSegundaParte.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.ConnectionManager;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.entidades.Materia;

public class ControladorMateria extends SuperControlador {

	
	/**
	 * 
	 */
	public static Materia findPrimero () {
		return find("select * from materia order by id limit 1");
	}

	/**
	 * 
	 */
	public static Materia findUltimo () {
		return find("select * from materia order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Materia findAnterior (int idActual) {
		return find("select * from materia where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Materia findSiguiente (int idActual) {
		return find("select * from materia where id > " + idActual + " order by id limit 1");
	}



	/**
	 * 
	 */
	public static Materia find (String sql) {
		Materia m = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery (sql);
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"), rs.getInt("curso_id"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return m;
	}


	
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public static int guardar(Materia m) {
		if (m.getId() == 0) {
			return nuevo(m);
		}
		else {
			return modificar(m);
		}
	}
	
	
	/**
	 * 
	 */
	public static int modificar (Materia m) {		
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			
			registrosAfectados = s.executeUpdate(
					"update maeria set nombre='" + m.getNombre() + "', acronimo='" + m.getAcronimo() + "', " +
					" curso_id=" + m.getCursoId() + " where id=" + m.getId());
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
					"delete from materia where id=" + idEliminacion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrosAfectados;		
	}

	/**
	 * 
	 */
	public static int nuevo (Materia m) {
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			m.setId(siguienteIdEnTabla("materia"));
			registrosAfectados = s.executeUpdate("insert into materia values (" + m.getId() + ",'" + 
						m.getNombre() + "', '" + m.getAcronimo() + "', " + m.getCursoId() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrosAfectados;
	}


}
