package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio04_CentroEducativoSegundaParte.vista;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;


public class Menu extends JMenuBar {

	/**
	 * 
	 */
	public Menu () {
		// Menú Archivo de la aplicación
        JMenu menuGestion = new JMenu("Gestión");
        
        // MenuItem para la gestión de cursos
        JMenuItem itemGestionCursos = new JMenuItem("Cursos");
        		itemGestionCursos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
	        	VistaUtils.mostrarPanelEnDialogo(new PanelCRUD_Curso(), "Cursos");
            }
        });
        menuGestion.add(itemGestionCursos);
        
        // MenuItem para la gestión de materias
        JMenuItem itemGestionMaterias = new JMenuItem("Materias");
        itemGestionMaterias.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
	        	VistaUtils.mostrarPanelEnDialogo(new PanelCRUD_Materia(), "Materias");
            } 
        });
        menuGestion.add(itemGestionMaterias);
        
        // Agrego el menú al JMenuBar
        this.add(menuGestion);
        
        // MenuItem para la gestión de estudiantes
        JMenuItem itemGestionEstudiantes = new JMenuItem("Estudiantes");
        itemGestionEstudiantes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
	        	VistaUtils.mostrarPanelEnDialogo(new PanelCRUD_Estudiante(), "Estudiante");
            }
        });
        menuGestion.add(itemGestionEstudiantes);
        
        // Agrego el menú al JMenuBar
        this.add(menuGestion);
        
        // MenuItem para la gestión de estudiantes
        JMenuItem itemGestionProfesores = new JMenuItem("Profesores");
        itemGestionProfesores.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
	        	VistaUtils.mostrarPanelEnDialogo(new PanelCRUD_Profesor(), "Profesor");
            }
        });
        menuGestion.add(itemGestionProfesores);
        
        // Agrego el menú al JMenuBar
        this.add(menuGestion);
        
	}
	
}
