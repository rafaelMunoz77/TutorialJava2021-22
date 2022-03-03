package tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.pojos;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import tutorialJava.modelosBasesDeDatosComunesJPA.evaluacionCentroEducativo.Profesor;

public class ProfesorPOJO {
	@JsonUnwrapped
	private Profesor profesor;
	private int idTipologiaSexo = 0;
	/**
	 * @param profesor
	 * @param idTipologiaSexo
	 */
	public ProfesorPOJO(Profesor profesor) {
		super();
		this.profesor = profesor;

		if (profesor.getTipologiaSexo() != null) {
			this.idTipologiaSexo = profesor.getTipologiaSexo().getId();
		}
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public int getIdTipologiaSexo() {
		return idTipologiaSexo;
	}
	
	

}
