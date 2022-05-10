package examenes.examen20220509.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import examenes.examen20220509.ConnectionManager;
import examenes.examen20220509.modelo.Acuerdo;



public class AcuerdoControlador {

	
	/**
	 * 
	 */
	public static Acuerdo findByIdIdioma (int idIdioma) {
		Acuerdo a = null;
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from acuerdo where idIdioma = " + idIdioma);
		   
			// Navegación del objeto ResultSet
			if (rs.next()) {
				a = new Acuerdo(rs.getInt("id"), rs.getString("descripcion"), rs.getInt("idIdioma"));
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

}
