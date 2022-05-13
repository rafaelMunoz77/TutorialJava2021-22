package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio05_CentroEducativoTerceraParte.entidades;

public class Profesor {

	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private String direccion;
	private String email;
	private String telefono;
	private int idTipologiaSexo;
	private byte[] imagen;
	private String colorPreferido;

	
	/**
	 * 
	 */
	public Profesor() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param direccion
	 * @param email
	 * @param telefono
	 * @param idTipologiaSexo
	 * @param imagen
	 */
	public Profesor(int id, String nombre, String apellido1, String apellido2, String dni, String direccion,
			String email, String telefono, int idTipologiaSexo, byte[] imagen, String colorPreferido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.idTipologiaSexo = idTipologiaSexo;
		this.imagen = imagen;
		this.colorPreferido = colorPreferido;
	}


	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", idTipologiaSexo="
				+ idTipologiaSexo + "]";
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


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getIdTipologiaSexo() {
		return idTipologiaSexo;
	}


	public void setIdTipologiaSexo(int idTipologiaSexo) {
		this.idTipologiaSexo = idTipologiaSexo;
	}


	public byte[] getImagen() {
		return imagen;
	}


	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getColorPreferido() {
		return colorPreferido;
	}

	public void setColorPreferido(String colorPreferido) {
		this.colorPreferido = colorPreferido;
	}
	
	
}
