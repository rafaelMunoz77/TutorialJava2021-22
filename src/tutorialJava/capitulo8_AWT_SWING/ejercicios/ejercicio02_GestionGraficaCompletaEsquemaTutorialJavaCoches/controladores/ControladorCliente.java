package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import tutorialJava.capitulo7_Acceso_A_Datos.ejercicios.bloque01_CRUD_Fabricante.ConnectionManager;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Cliente;

public class ControladorCliente extends SuperControlador {

	
	/**
	 * 
	 */
	public static Cliente findPrimero () {
		return find("select * from cliente order by id limit 1");
	}

	/**
	 * 
	 */
	public static Cliente findUltimo () {
		return find("select * from cliente order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Cliente findAnterior (int idActual) {
		return find("select * from cliente where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Cliente findSiguiente (int idActual) {
		return find("select * from cliente where id > " + idActual + " order by id limit 1");
	}



	/**
	 * 
	 */
	public static Cliente find (String sql) {
		Cliente f = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery (sql);
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				f = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("localidad"), rs.getString("dniNie"),
						rs.getDate("fechaNac"), rs.getBoolean("activo"));
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
	public static List<Cliente> findAll () {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("Select * from cliente");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				Cliente c = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("localidad"), rs.getString("dniNie"),
						rs.getDate("fechaNac"), rs.getBoolean("activo"));
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
	public static int guardar(Cliente c) {
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
	public static int modificar (Cliente c) {		
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			
			int activo = (c.isActivo())? 1 : 0; 			
			registrosAfectados = s.executeUpdate(
					"update cliente set nombre='" + c.getNombre() + "', apellidos='" + c.getApellidos() 
					+ "', localidad='" + c.getLocalidad() + "', dniNie='" + c.getDniNie() + "', fechaNac='" + sdfFormatoFechaMysql.format(c.getFechaNacimiento()) + 
					"', activo=" + activo + " where id=" + c.getId());
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
					"delete from cliente where id=" + idEliminacion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrosAfectados;		
	}

	/**
	 * 
	 */
	public static int nuevo (Cliente c) {
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			c.setId(siguienteIdEnTabla("cliente"));
			registrosAfectados = s.executeUpdate(
						"insert into cliente values (" + c.getId() + ",'" + c.getNombre() +
						"', '" + c.getApellidos() + "', '" + c.getLocalidad() + "', '" + c.getDniNie() + "', '" + sdfFormatoFechaMysql.format(c.getFechaNacimiento()) + 
						"', " + c.isActivo() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrosAfectados;
	}


}
