package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.Font;
import javax.swing.JToggleButton;

import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores.ControladorCliente;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores.ControladorCoche;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores.ControladorConcesionario;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.controladores.ControladorVenta;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Cliente;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Coche;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Concesionario;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio02_GestionGraficaCompletaEsquemaTutorialJavaCoches.entidades.Venta;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class CRUD_Venta extends JPanel {

	private JFrame frame;
	private JTextField jtfId;
	private JLabel lblNewLabel_4;
	private JPanel panel;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JComboBox<Cliente> jcbCliente;
	private JLabel lblNewLabel_5;
	private JLabel lblColor;
	private JTextField jtfFecha;
	private JComboBox<Concesionario> jcbConcesionario;
	private JComboBox<Coche> jcbCoche;
	private JLabel lblNewLabel_6;
	private JTextField jtfPrecio;

	SimpleDateFormat sdfFormatoFechaUsuario = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the application.
	 */
	public CRUD_Venta() {
		initialize();
		inicializarComboBoxes();
		mostrarVenta(ControladorVenta.findPrimero());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Gestión de Ventas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(15, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbCliente = new JComboBox<Cliente>();
		GridBagConstraints gbc_jcbCliente = new GridBagConstraints();
		gbc_jcbCliente.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCliente.gridx = 1;
		gbc_jcbCliente.gridy = 2;
		add(jcbCliente, gbc_jcbCliente);
		
		lblNewLabel_4 = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 15);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 2;
		this.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Concesionario:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		this.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbConcesionario = new JComboBox<Concesionario>();
		GridBagConstraints gbc_jcbConcesionario = new GridBagConstraints();
		gbc_jcbConcesionario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbConcesionario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbConcesionario.gridx = 1;
		gbc_jcbConcesionario.gridy = 3;
		add(jcbConcesionario, gbc_jcbConcesionario);
		
		lblNewLabel_5 = new JLabel("Coche:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jcbCoche = new JComboBox<Coche>();
		GridBagConstraints gbc_jcbCoche = new GridBagConstraints();
		gbc_jcbCoche.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCoche.gridx = 1;
		gbc_jcbCoche.gridy = 4;
		add(jcbCoche, gbc_jcbCoche);
		
		lblColor = new JLabel("Fecha:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 5;
		add(lblColor, gbc_lblColor);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 5;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Precio:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfPrecio = new JTextField();
		GridBagConstraints gbc_jtfPrecio = new GridBagConstraints();
		gbc_jtfPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecio.gridx = 1;
		gbc_jtfPrecio.gridy = 6;
		add(jtfPrecio, gbc_jtfPrecio);
		jtfPrecio.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		this.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVenta(ControladorVenta.findPrimero());
			}
		});
		panel.add(btnPrimero);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVenta(ControladorVenta.findAnterior(
								Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVenta(ControladorVenta.findSiguiente(
								Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVenta(ControladorVenta.findUltimo());
			}
		});
		panel.add(btnUltimo);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		btnNuevo.setIcon(new ImageIcon(CRUD_Venta.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/nuevo.png")));
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(CRUD_Venta.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/guardar.png")));
		panel.add(btnGuardar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setIcon(new ImageIcon(CRUD_Venta.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/eliminar.png")));
		panel.add(btnEliminar);
	}
	
	/**
	 * 
	 */
	private void inicializarComboBoxes() {
		List<Cliente> clientes = ControladorCliente.findAll();
		for (Cliente c : clientes) {
			jcbCliente.addItem(c);
		}
		
		List<Concesionario> concesionarios = ControladorConcesionario.findAll();
		for (Concesionario c : concesionarios) {
			jcbConcesionario.addItem(c);
		}
		
		List<Coche> coches = ControladorCoche.findAll();
		for (Coche c : coches) {
			jcbCoche.addItem(c);
		}
		
		
	}
	
	/**
	 * Guardado, puede ser un alta nueva o una modificación
	 */
	private void guardar() {
		Venta v = new Venta();
		v.setId(Integer.parseInt(jtfId.getText()));
		v.setIdCliente( ((Cliente) this.jcbCliente.getSelectedItem()).getId() );
		v.setIdConcesionario( ((Concesionario) this.jcbConcesionario.getSelectedItem()).getId() );
		v.setIdCoche( ((Coche) this.jcbCoche.getSelectedItem()).getId() );
		try {
			v.setFecha(sdfFormatoFechaUsuario.parse(jtfFecha.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		v.setPrecioVenta(Float.parseFloat(jtfPrecio.getText()));
		
		if (ControladorVenta.guardar(v) == 1) {
			jtfId.setText("" + v.getId());
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
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon(CRUD_Venta.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/confirm.png")), 
		        posiblesRespuestas, posiblesRespuestas[1]);
	    
		// Si se confirma que se desea eliminar, se procede a ello
		if(opcionElegida == 0) {
			int idActual = Integer.parseInt(jtfId.getText());
			boolean existeAnterior = ControladorVenta.findAnterior(idActual) != null;
			boolean existeSiguiente = ControladorVenta.findSiguiente(idActual) != null;
			
			if (ControladorVenta.eliminar(idActual) == 1) {
				JOptionPane.showMessageDialog(null, "Eliminado correctamente");
				// Ahora debo navegar, una vez he borrado el registro, al registro anterior
				if (existeAnterior) {
					mostrarVenta(ControladorVenta.findAnterior(idActual));
				}
				else {
					if (existeSiguiente) {
						mostrarVenta(ControladorVenta.findSiguiente(idActual));
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
		jcbCliente.setSelectedIndex(0);
		jcbConcesionario.setSelectedIndex(0);
		jcbCoche.setSelectedIndex(0);
		jtfFecha.setText("");
		jtfPrecio.setText("");
	}
	
	
	/**
	 * 
	 * @param f
	 */
	private void mostrarVenta (Venta v) {
		if (v != null) {
			jtfId.setText("" + v.getId());
			// Selecciono el Cliente correcto del desplegable
			for (int i = 0; i < jcbCliente.getItemCount(); i++) {
				if (jcbCliente.getItemAt(i).getId() == v.getIdCliente()) {
					jcbCliente.setSelectedIndex(i);
				}
			}
			// Selecciono el Concesionario correcto del desplegable
			for (int i = 0; i < jcbConcesionario.getItemCount(); i++) {
				if (jcbConcesionario.getItemAt(i).getId() == v.getIdConcesionario()) {
					jcbConcesionario.setSelectedIndex(i);
				}
			}
			// Selecciono el Cliente correcto del desplegable
			for (int i = 0; i < jcbCoche.getItemCount(); i++) {
				if (jcbCoche.getItemAt(i).getId() == v.getIdCoche()) {
					jcbCoche.setSelectedIndex(i);
				}
			}
			
			jtfFecha.setText(sdfFormatoFechaUsuario.format(v.getFecha()));
			jtfPrecio.setText("" + v.getPrecioVenta());

			// Ahora habilitamos o deshabilitamos botones de navegación
			// Si no existe un anterior deshabilito los botones de primero y anterior
			if (ControladorVenta.findAnterior(v.getId()) == null) {
				btnPrimero.setEnabled(false);
				btnAnterior.setEnabled(false);
			}
			else {
				btnPrimero.setEnabled(true);
				btnAnterior.setEnabled(true);
			}
			// Si no existe un siguiente deshabilito los botones de último y siguiente
			boolean existeSiguiente = 
					(ControladorVenta.findSiguiente(v.getId()) == null)? false : true;
			btnUltimo.setEnabled(existeSiguiente);
			btnSiguiente.setEnabled(existeSiguiente);
		}
		
	}
	
	
	
}
