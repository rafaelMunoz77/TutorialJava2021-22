package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio05_CentroEducativoTerceraParte.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio05_CentroEducativoTerceraParte.ConnectionManager;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio05_CentroEducativoTerceraParte.entidades.Profesor;



public class ControladorProfesor extends SuperControlador {

	
	/**
	 * 
	 */
	public static Profesor findPrimero () {
		return find("select * from profesor order by id limit 1");
	}

	/**
	 * 
	 */
	public static Profesor findUltimo () {
		return find("select * from profesor order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Profesor findAnterior (int idActual) {
		return find("select * from profesor where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Profesor findSiguiente (int idActual) {
		return find("select * from profesor where id > " + idActual + " order by id limit 1");
	}



	/**
	 * 
	 */
	public static Profesor find (String sql) {
		Profesor e = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery (sql);
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				e = new Profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"),
						rs.getString("dni"), rs.getString("direccion"), rs.getString("email"), rs.getString("telefono"),
						rs.getInt("idTipologiaSexo"), rs.getBytes("imagen"), rs.getString("colorPreferido"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return e;
	}


	
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public static int guardar(Profesor e) {
		if (e.getId() == 0) {
			return nuevo(e);
		}
		else {
			return modificar(e);
		}
	}
	
	
	/**
	 * 
	 */
	public static int modificar (Profesor e) {		
		int registrosAfectados = 0;
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(
					"update profesor set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, direccion = ?, email = ?, "
					+ " telefono = ?, idTipologiaSexo = ?, imagen=?, colorPreferido = ? where id = ?");
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getApellido1());
			ps.setString(3, e.getApellido2());
			ps.setString(4, e.getDni());
			ps.setString(5, e.getDireccion());
			ps.setString(6, e.getEmail());
			ps.setString(7, e.getTelefono());
			ps.setInt(8, e.getIdTipologiaSexo());
			ps.setBytes(9, e.getImagen());
			ps.setString(10, e.getColorPreferido());
			ps.setInt(11, e.getId());
			registrosAfectados = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
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
					"delete from profesor where id=" + idEliminacion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrosAfectados;		
	}

	/**
	 * 
	 */
	public static int nuevo (Profesor e) {
		int registrosAfectados = 0;
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(
					"insert into profesor (id, nombre, apellido1, apellido2, dni, direccion, email, telefono, idTipologiaSexo, imagen) "
							+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			e.setId(siguienteIdEnTabla("profesor"));

			ps.setInt(1, e.getId());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getApellido1());
			ps.setString(4, e.getApellido2());
			ps.setString(5, e.getDni());
			ps.setString(6, e.getDireccion());
			ps.setString(7, e.getEmail());
			ps.setString(8, e.getTelefono());
			ps.setInt(9, e.getIdTipologiaSexo());
			ps.setBytes(10, e.getImagen());
			ps.setString(11, e.getColorPreferido());
			registrosAfectados = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return registrosAfectados;
	}


}
