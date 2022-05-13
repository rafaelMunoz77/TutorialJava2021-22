package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio05_CentroEducativoTerceraParte.controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio05_CentroEducativoTerceraParte.ConnectionManager;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio05_CentroEducativoTerceraParte.entidades.TipologiaSexo;


public class ControladorTipologiaSexo extends SuperControlador {

	

	/**
	 * 
	 */
	public static List<TipologiaSexo> findAll () {
		List<TipologiaSexo> lista = new ArrayList<TipologiaSexo>();
		try {
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) ConnectionManager.getConexion().createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("Select * from tipologiasexo");
		   
			// Navegación del objeto ResultSet
			while (rs.next()) {
				TipologiaSexo t = new TipologiaSexo(rs.getInt("id"), rs.getString("descripcion"));
				lista.add(t);
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
