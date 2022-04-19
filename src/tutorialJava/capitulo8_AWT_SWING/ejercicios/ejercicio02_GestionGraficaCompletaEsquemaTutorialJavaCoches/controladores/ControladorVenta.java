package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tutorialJava.capitulo7_Acceso_A_Datos.ejercicios.bloque01_CRUD_Fabricante.ConnectionManager;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Venta;

public class ControladorVenta extends SuperControlador {

	
	/**
	 * 
	 */
	public static Venta findPrimero () {
		return find("select * from venta order by id limit 1");
	}

	/**
	 * 
	 */
	public static Venta findUltimo () {
		return find("select * from venta order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Venta findAnterior (int idActual) {
		return find("select * from venta where id < " + idActual + " order by id desc limit 1");
	}

	/**
	 * 
	 */
	public static Venta findSiguiente (int idActual) {
		return find("select * from venta where id > " + idActual + " order by id limit 1");
	}



	/**
	 * 
	 */
	public static Venta find (String sql) {
		Venta v = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery (sql);
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				v = new Venta(rs.getInt("id"), rs.getInt("idCliente"), rs.getInt("idConcesionario"), rs.getInt("idCoche"), 
						rs.getDate("fecha"), rs.getFloat("precioVenta"));
			}
			// Cierre de los elementos
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return v;
	}


	/**
	 * 
	 * @param f
	 * @return
	 */
	public static int guardar(Venta v) {
		if (v.getId() == 0) {
			return nuevo(v);
		}
		else {
			return modificar(v);
		}
	}
	
	
	/**
	 * 
	 */
	public static int modificar (Venta v) {		
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			
			registrosAfectados = s.executeUpdate(
					"update venta set idCliente=" + v.getIdCliente() + ", idConcesionario=" + v.getIdConcesionario() + ", idCoche=" + 
					v.getIdCoche() + ", fecha='" + sdfFormatoFechaMysql.format(v.getFecha()) + "', precioVenta=" + v.getPrecioVenta() + " where id=" + v.getId());
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
					"delete from venta where id=" + idEliminacion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrosAfectados;		
	}

	/**
	 * 
	 */
	public static int nuevo (Venta v) {
		int registrosAfectados = 0;
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			v.setId(siguienteIdEnTabla("venta"));
			registrosAfectados = s.executeUpdate(
						"insert into venta values (" + v.getId() + ", " + v.getIdCliente()+ "," + v.getIdConcesionario() +
						", " + v.getIdCoche() + ", '" + sdfFormatoFechaMysql.format(v.getFecha()) + "', " + v.getPrecioVenta() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrosAfectados;
	}


}
