package examenes.examen20220509.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import examenes.examen20220509.ConnectionManager;
import examenes.examen20220509.modelo.Usuario;



public class UsuarioControlador {

	
	/**
	 * 
	 */
	public static Usuario findByNombreUsuario (String nombreUsuario) {
		Usuario a = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from usuario where usuario = '" + nombreUsuario + "'");
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				a = new Usuario(rs.getInt("id"), rs.getString("email"), rs.getString("usuario"), rs.getString("password"), rs.getInt("idIdioma"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return a;
	}

	
	
	/**
	 * 
	 * @param nombreTabla
	 * @return
	 */
	protected static int siguienteIdEnTabla() {
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			ResultSet rs = s.executeQuery("Select max(id) from usuario");
			
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1; 		
	}

	
	
	
	/**
	 * 
	 */
	public static int nuevo (Usuario u) {
		int registrosAfectados = 0;
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(
					"insert into usuario (id, email, usuario, password, idIdioma) "
							+ "values (?, ?, ?, ?, ?)");
			u.setId(siguienteIdEnTabla());

			ps.setInt(1, u.getId());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getUsuario());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getIdIdioma());
			registrosAfectados = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return registrosAfectados;
	}

}
