package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores.ControladorFabricante;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.controladores.ControladorCurso;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.entidades.Curso;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCRUD_Curso extends JPanel {
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	JButton btnPrimero;
	JButton btnAnterior;
	JButton btnSiguiente;
	JButton btnUltimo;
	JButton btnNuevo;
	JButton btnGuardar;
	JButton btnEliminar;

	/**
	 * Create the panel.
	 */
	public PanelCRUD_Curso() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCurso(ControladorCurso.findPrimero());
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelCRUD_Curso.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCurso(ControladorCurso.findAnterior(Integer.parseInt(jtfId.getText())));
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelCRUD_Curso.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/previous.png")));
		toolBar.add(btnAnterior);
		
		btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCurso(ControladorCurso.findSiguiente(Integer.parseInt(jtfId.getText())));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelCRUD_Curso.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/next.png")));
		toolBar.add(btnSiguiente);
		
		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCurso(ControladorCurso.findUltimo());
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelCRUD_Curso.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelCRUD_Curso.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelCRUD_Curso.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setIcon(new ImageIcon(PanelCRUD_Curso.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JPanel panelPrincipal = new JPanel();
		add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{0, 0, 0};
		gbl_panelPrincipal.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelPrincipal.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		JLabel lblNewLabel = new JLabel("Gestión de cursos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(15, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelPrincipal.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panelPrincipal.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 15);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panelPrincipal.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripción:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 15, 15, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panelPrincipal.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 15, 15);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 2;
		panelPrincipal.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);

		mostrarCurso(ControladorCurso.findPrimero());
	}

	
	/**
	 * Guardado, puede ser un alta nueva o una modificación
	 */
	private void guardar() {
		Curso c = new Curso();
		c.setId(Integer.parseInt(jtfId.getText()));
		c.setDescripcion(jtfDescripcion.getText());
		if (ControladorCurso.guardar(c) == 1) {
			jtfId.setText("" + c.getId());
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
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon(PanelCRUD_Curso.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/confirm.png")), 
		        posiblesRespuestas, posiblesRespuestas[1]);
	    
		// Si se confirma que se desea eliminar, se procede a ello
		if(opcionElegida == 0) {
			int idActual = Integer.parseInt(jtfId.getText());
			boolean existeAnterior = ControladorCurso.findAnterior(idActual) != null;
			boolean existeSiguiente = ControladorCurso.findSiguiente(idActual) != null;
			
			if (ControladorCurso.eliminar(idActual) == 1) {
				JOptionPane.showMessageDialog(null, "Eliminado correctamente");
				// Ahora debo navegar, una vez he borrado el registro, al registro anterior
				if (existeAnterior) {
					mostrarCurso(ControladorCurso.findAnterior(idActual));
				}
				else {
					if (existeSiguiente) {
						mostrarCurso(ControladorCurso.findSiguiente(idActual));
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
	
	/**
	 * 
	 */
	private void limpiarDatos() {
		jtfId.setText("0");
		jtfDescripcion.setText("");
	}
	
	
	/**
	 * 
	 * @param f
	 */
	private void mostrarCurso (Curso c) {
		if (c != null) {
			jtfId.setText("" + c.getId());
			jtfDescripcion.setText(c.getDescripcion());

			// Ahora habilitamos o deshabilitamos botones de navegación
			// Si no existe un anterior deshabilito los botones de primero y anterior
			if (ControladorCurso.findAnterior(c.getId()) == null) {
				btnPrimero.setEnabled(false);
				btnAnterior.setEnabled(false);
			}
			else {
				btnPrimero.setEnabled(true);
				btnAnterior.setEnabled(true);
			}
			// Si no existe un siguiente deshabilito los botones de último y siguiente
			boolean existeSiguiente = 
					(ControladorCurso.findSiguiente(c.getId()) == null)? false : true;
			btnUltimo.setEnabled(existeSiguiente);
			btnSiguiente.setEnabled(existeSiguiente);
		}
		
	}
	
	
	

}
