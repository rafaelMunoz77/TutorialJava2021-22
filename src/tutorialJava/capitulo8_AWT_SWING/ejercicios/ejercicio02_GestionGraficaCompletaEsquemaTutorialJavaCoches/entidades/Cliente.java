package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades;

import java.util.Date;

public class Cliente {
	private int id;
	private String nombre;
	private String apellidos;
	private String localidad;
	private String dniNie;
	private Date fechaNacimiento;
	private boolean activo;
	
	/**
	 * 
	 */
	public Cliente() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param localidad
	 * @param dniNie
	 * @param fechaNacimiento
	 * @param activo
	 */
	public Cliente(int id, String nombre, String apellidos, String localidad, String dniNie, Date fechaNacimiento,
			boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.localidad = localidad;
		this.dniNie = dniNie;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos + " - " + dniNie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDniNie() {
		return dniNie;
	}

	public void setDniNie(String dniNie) {
		this.dniNie = dniNie;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
