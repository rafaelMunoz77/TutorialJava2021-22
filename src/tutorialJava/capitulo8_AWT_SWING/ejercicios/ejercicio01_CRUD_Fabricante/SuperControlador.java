package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio01_CRUD_Fabricante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tutorialJava.capitulo7_Acceso_A_Datos.ejercicios.bloque01_CRUD_Fabricante.ConnectionManager;

public class SuperControlador {

	/**
	 * 
	 * @param nombreTabla
	 * @return
	 */
	protected static int siguienteIdEnTabla(String nombreTabla) {
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			ResultSet rs = s.executeQuery("Select max(id) from " + nombreTabla);
			
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1; 		
	}

}
