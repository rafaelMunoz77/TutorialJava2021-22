package examenes.examen20220516.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examenes.examen20220516.ConnectionManager;
import examenes.examen20220516.modelo.Artista;

public class ArtistaControlador {
	
	/**
	 * 
	 */
	public static List<Artista> filterByNombre (String nombre) {
		List<Artista> lista = new ArrayList<Artista>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from artista where nombre like '%" + nombre + "%'");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				Artista p = new Artista(rs.getInt("id"), rs.getString("nombre"), rs.getInt("idDisciplina"), rs.getInt("idMunicipio"), rs.getBytes("imagen"));
				lista.add(p);
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
	public static int modificar (Artista a) {		
		int registrosAfectados = 0;
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(
					"update artista set nombre = ?, idDisciplina = ?, idMunicipio = ?, imagen = ? where id = ?");
			ps.setString(1, a.getNombre());
			ps.setInt(2, a.getIdDisciplina());
			ps.setInt(3, a.getIdMunicipio());
			ps.setBytes(4, a.getImagen());
			ps.setInt(5, a.getId());
			registrosAfectados = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return registrosAfectados;		
	}

}
