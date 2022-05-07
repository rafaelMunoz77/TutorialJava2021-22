package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio04_CentroEducativoSegundaParte.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio04_CentroEducativoSegundaParte.controladores.ControladorEstudiante;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio04_CentroEducativoSegundaParte.entidades.Estudiante;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCRUD_Estudiante extends JPanel {
	
	JButton btnPrimero;
	JButton btnUltimo;
	PanelDatosPersonales panelDatosPersonales = new PanelDatosPersonales();
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnNuevo;
	private JButton btnEliminar;
	/**
	 * Create the panel.
	 */
	public PanelCRUD_Estudiante() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEstudiante(ControladorEstudiante.findPrimero());
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		
		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEstudiante(ControladorEstudiante.findUltimo());
			}
		});
		
		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEstudiante(ControladorEstudiante.findAnterior(panelDatosPersonales.getId()));
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/previous.png")));
		toolBar.add(btnAnterior);
		
		btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEstudiante(ControladorEstudiante.findSiguiente(panelDatosPersonales.getId()));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/next.png")));
		toolBar.add(btnSiguiente);
		btnUltimo.setIcon(new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/nuevo.png")));
		toolBar.add(btnNuevo);
		btnGuardar.setIcon(new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setIcon(new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		
		add(panelDatosPersonales, BorderLayout.CENTER);
		
		
		mostrarEstudiante(ControladorEstudiante.findPrimero());

	}

	
	
	
	/**
	 * 
	 * @param f
	 */
	private void mostrarEstudiante (Estudiante e) {
		if (e != null) {
			this.panelDatosPersonales.setId(e.getId());;
			this.panelDatosPersonales.setNombre(e.getNombre());
			this.panelDatosPersonales.setApellido1(e.getApellido1());
			this.panelDatosPersonales.setApellido2(e.getApellido2());
			this.panelDatosPersonales.setDni(e.getDni());
			this.panelDatosPersonales.setDireccion(e.getDireccion());
			this.panelDatosPersonales.setEmail(e.getEmail());
			this.panelDatosPersonales.setTelefono(e.getTelefono());
			this.panelDatosPersonales.setIdTipologiaSexo(e.getIdTipologiaSexo());
			this.panelDatosPersonales.setImagen(e.getImagen());

			// Ahora habilitamos o deshabilitamos botones de navegación
			// Si no existe un anterior deshabilito los botones de primero y anterior
			if (ControladorEstudiante.findAnterior(e.getId()) == null) {
				btnPrimero.setEnabled(false);
				btnAnterior.setEnabled(false);
			}
			else {
				btnPrimero.setEnabled(true);
				btnAnterior.setEnabled(true);
			}
			// Si no existe un siguiente deshabilito los botones de último y siguiente
			boolean existeSiguiente = 
					(ControladorEstudiante.findSiguiente(e.getId()) == null)? false : true;
			btnUltimo.setEnabled(existeSiguiente);
			btnSiguiente.setEnabled(existeSiguiente);
		}
		
	}

	/**
	 * 
	 */
	private void limpiarDatos() {
		this.panelDatosPersonales.setId(0);
		this.panelDatosPersonales.setNombre("");
		this.panelDatosPersonales.setApellido1("");
		this.panelDatosPersonales.setApellido2("");
		this.panelDatosPersonales.setDni("");
		this.panelDatosPersonales.setDireccion("");
		this.panelDatosPersonales.setEmail("");
		this.panelDatosPersonales.setTelefono("");
		this.panelDatosPersonales.setIdTipologiaSexo(0);
		this.panelDatosPersonales.setImagen(new byte[0]);
	}
	
	
	/**
	 * Guardado, puede ser un alta nueva o una modificación
	 */
	private void guardar() {
		Estudiante e = new Estudiante();
		e.setId(this.panelDatosPersonales.getId());
		e.setNombre(this.panelDatosPersonales.getNombre());
		e.setApellido1(this.panelDatosPersonales.getApellido1());
		e.setApellido2(this.panelDatosPersonales.getApellido2());
		e.setDni(this.panelDatosPersonales.getDni());
		e.setDireccion(this.panelDatosPersonales.getDireccion());
		e.setEmail(this.panelDatosPersonales.getEmail());
		e.setTelefono(this.panelDatosPersonales.getTelefono());
		e.setIdTipologiaSexo(this.panelDatosPersonales.getIdTipologiaSexo());
		e.setImagen(this.panelDatosPersonales.getImagen());

		if (ControladorEstudiante.guardar(e) == 1) {
			this.panelDatosPersonales.setId(e.getId());
			JOptionPane.showMessageDialog(null, "Guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error, no se ha podido guardar");
		}
	}

	
	
	/**
	 * Eliminación 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// Utilizo un JOptionPane para preguntar si realmente se desea eliminar un registro
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", "Confirmar eliminación", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/confirm.png")), 
		        posiblesRespuestas, posiblesRespuestas[1]);
	    
		// Si se confirma que se desea eliminar, se procede a ello
		if(opcionElegida == 0) {
			int idActual = this.panelDatosPersonales.getId();
			boolean existeAnterior = ControladorEstudiante.findAnterior(idActual) != null;
			boolean existeSiguiente = ControladorEstudiante.findSiguiente(idActual) != null;
			
			if (ControladorEstudiante.eliminar(idActual) == 1) {
				JOptionPane.showMessageDialog(null, "Eliminado correctamente");
				// Ahora debo navegar, una vez he borrado el registro, al registro anterior
				if (existeAnterior) {
					mostrarEstudiante(ControladorEstudiante.findAnterior(idActual));
				}
				else {
					if (existeSiguiente) {
						mostrarEstudiante(ControladorEstudiante.findSiguiente(idActual));
					}
					else {
						limpiarDatos();
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Error, no se ha podido eliminar");
			}
	    }
	}
	
	
}
