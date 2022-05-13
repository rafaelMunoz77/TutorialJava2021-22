package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio05_CentroEducativoTerceraParte.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tutorialJava.capitulo8_AWT_SWING.utils.Apariencia;


public class VentanaPrincipal extends JFrame {

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Gestión de un centro educativo");
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menú de la aplicación
		this.setJMenuBar(new Menu());

		// Establezco el panel principal de la aplicación y la barra de herramientas
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(new ToolBar(), BorderLayout.NORTH);
	}


}
