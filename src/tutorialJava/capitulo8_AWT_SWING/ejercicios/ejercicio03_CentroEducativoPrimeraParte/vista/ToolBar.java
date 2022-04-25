package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio03_CentroEducativoPrimeraParte.vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;
import tutorialJava.capitulo8_AWT_SWING.v03_JComponentsAvanzados.JPanelIntoJDialog.PanelAInsertarEnJDialog;



public class ToolBar extends JToolBar {

	
	public ToolBar () {
		// Botón para la gestión de cursos
	    JButton jbtCursos = new JButton();
	    jbtCursos.setToolTipText("Cursos");
	    jbtCursos.setIcon(new ImageIcon(ToolBar.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/ruedadentada.png")));
	    jbtCursos.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	VistaUtils.mostrarPanelEnDialogo(new PanelCRUD_Curso(), "Cursos");
	        }
	    });
	    
	    // Agrego el botón a la JToolBar
	    this.add(jbtCursos);

		// Botón para la gestión de cursos
	    JButton jbtMaterias = new JButton();
	    jbtMaterias.setToolTipText("Materias");
	    jbtMaterias.setIcon(new ImageIcon(ToolBar.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/ruedadentada.png")));
	    jbtMaterias.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	VistaUtils.mostrarPanelEnDialogo(new PanelCRUD_Materia(), "Materias");
	        }
	    });
	    
	    // Agrego el botón a la JToolBar
	    this.add(jbtMaterias);
	
	}

	
}
