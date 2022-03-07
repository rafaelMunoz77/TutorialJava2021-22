package tutorialJava.capitulo6_Recursos.ejercicios.bloque01_WrappersDeTiposPrimitivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import tutorialJava.capitulo6_Recursos.EjemploFicheroPropiedades;

public class Ejercicio04_LecturaFicheroPropiedades {
	private static Properties propiedades = null;

	
	/**
	 * 
	 * @return
	 */
	private static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
		    
			try {
				// Otra forma de leer el fichero de propiedades
				File file = new File("./src/tutorialJava/capitulo6_Recursos/ejercicios/bloque01_WrappersDeTiposPrimitivos/Ejercicio04.properties");
				System.out.println("Fichero encontrado: " + file.exists());
				propiedades.load(new FileReader(file));
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		return propiedades;
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}

	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static int getIntProperty (String nombrePropiedad) {
		return Integer.parseInt(getPropiedades().getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static Float getFloatProperty (String nombrePropiedad) {
		return Float.parseFloat(getPropiedades().getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static Boolean getBooleanProperty (String nombrePropiedad) {
		return Boolean.parseBoolean(getPropiedades().getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		String usuario = Ejercicio04_LecturaFicheroPropiedades.getProperty("USUARIO");
		String password = Ejercicio04_LecturaFicheroPropiedades.getProperty("PASSWORD");
		int id = Ejercicio04_LecturaFicheroPropiedades.getIntProperty("ID_USUARIO");
		boolean todoCorrecto = Ejercicio04_LecturaFicheroPropiedades.getBooleanProperty("TODO_CORRECTO");
		
		System.out.println("Usuario leído del fichero de propiedades: " + usuario);
		System.out.println("Password leído del fichero de propiedades: " + password);
		System.out.println("Id de usuario leído del fichero de propiedades: " + id);
		System.out.println("Todo correcto: " + todoCorrecto);
	}
}
