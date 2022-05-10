package examenes.examen20220509.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examenes.examen20220509.ConnectionManager;
import examenes.examen20220509.modelo.Idioma;


public class IdiomaControlador {

	
	/**
	 * 
	 */
	public static List<Idioma> findAll () {
		List<Idioma> lista = new ArrayList<Idioma>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from idioma");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				Idioma i = new Idioma(rs.getInt("id"), rs.getString("descripcion"), rs.getInt("idPais"));
				lista.add(i);
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
	 */
	public static List<Idioma> findByIdPais (int idPais) {
		List<Idioma> lista = new ArrayList<Idioma>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from idioma where idPais = " + idPais);
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				Idioma i = new Idioma(rs.getInt("id"), rs.getString("descripcion"), rs.getInt("idPais"));
				lista.add(i);
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


}
