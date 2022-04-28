package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCRUD_Estudiante extends JPanel {
	
	PanelDatosPersonales panelDatosPersonales = new PanelDatosPersonales();
	/**
	 * Create the panel.
	 */
	public PanelCRUD_Estudiante() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDatosPersonales.setNombre("Rafa");
			}
		});
		btnNewButton.setIcon(new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/gotostart.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(panelDatosPersonales.getNombre());
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(PanelCRUD_Estudiante.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/guardar.png")));
		toolBar.add(btnNewButton_2);
		
		
		add(panelDatosPersonales, BorderLayout.CENTER);

	}

	
	
	
}
