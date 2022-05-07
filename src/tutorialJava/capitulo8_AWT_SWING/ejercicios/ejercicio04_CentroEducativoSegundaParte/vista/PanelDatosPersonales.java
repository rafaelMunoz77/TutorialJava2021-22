package tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio04_CentroEducativoSegundaParte.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio04_CentroEducativoSegundaParte.controladores.ControladorTipologiaSexo;
import tutorialJava.capitulo8_AWT_SWING.ejercicios.ejercicio04_CentroEducativoSegundaParte.entidades.TipologiaSexo;

import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

public class PanelDatosPersonales extends JPanel {
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JLabel lblNewLabel_2;
	private JComboBox<TipologiaSexo> jcbSexo;
	private JLabel lblNewLabel_3;
	private JTextField jtfId;
	private JScrollPane scrollPane;
	private JButton btnCargarImagen;
	private byte[] imagenEnBytes;
	private JLabel lblNewLabel_4;
	private JTextField jtfApellido2;
	private JTextField jtfTelefono;
	private JLabel lblNewLabel_5;
	private JTextField jtfDni;
	private JLabel lblNewLabel_6;
	private JTextField jtfDireccion;
	private JLabel lblNewLabel_7;
	private JTextField jtfEmail;
	private JLabel lblNewLabel_8;

	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout); 
		
		lblNewLabel_3 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		scrollPane = new JScrollPane();
		Dimension d = new Dimension(200, 200);
		scrollPane.setMaximumSize(d);
		scrollPane.setMinimumSize(d);
		scrollPane.setPreferredSize(d);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 8;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido 1:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1); 
		
		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 2;
		add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Apellido 2:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 3;
		add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbSexo = new JComboBox<TipologiaSexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 4;
		add(jcbSexo, gbc_jcbSexo);
		
		lblNewLabel_5 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 6;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 0, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		btnCargarImagen = new JButton("Cargar imagen");
		btnCargarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarFicheroImagen();
			}
		});
		GridBagConstraints gbc_btnCargarImagen = new GridBagConstraints();
		gbc_btnCargarImagen.gridx = 2;
		gbc_btnCargarImagen.gridy = 8;
		add(btnCargarImagen, gbc_btnCargarImagen);

		
		
		inicializarTipologiasSexo();
	}
	
	
	
	/**
	 * 
	 */
	private void seleccionarFicheroImagen() {
		JFileChooser jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().endsWith(".jpg") || 
								f.getAbsolutePath().endsWith(".jpeg")|| 
								f.getAbsolutePath().endsWith(".png")|| 
								f.getAbsolutePath().endsWith(".gif"))))
					return true;
				return false;
			}
		});
		
		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			
			if (fichero.isFile()) {
				try {
					this.imagenEnBytes = Files.readAllBytes(fichero.toPath());
					setImagen(imagenEnBytes);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 
	 */
	private void inicializarTipologiasSexo() {
		List<TipologiaSexo> tipos = ControladorTipologiaSexo.findAll();
		for (TipologiaSexo t : tipos) {
			jcbSexo.addItem(t);
		}
	}
	
	

	/**
	 * Setter y getters
	 * 
	 */
	public void setId (int id) {
		this.jtfId.setText("" + id);
	}

	public int getId () {
		return Integer.parseInt(jtfId.getText());
	}
	
	public void setNombre (String newNombre) {
		this.jtfNombre.setText(newNombre);
	}

	public String getNombre () {
		return this.jtfNombre.getText();
	}

	public void setApellido1 (String apellido1) {
		this.jtfApellido1.setText(apellido1);
	}

	public String getApellido1 () {
		return this.jtfApellido1.getText();
	}
	
	public void setApellido2 (String apellido2) {
		this.jtfApellido2.setText(apellido2);
	}

	public String getApellido2 () {
		return this.jtfApellido2.getText();
	}
	
	public void setDni (String dni) {
		this.jtfDni.setText(dni);
	}

	public String getDni () {
		return this.jtfDni.getText();
	}
	
	public void setDireccion (String direccion) {
		this.jtfDireccion.setText(direccion);
	}

	public String getDireccion () {
		return this.jtfDireccion.getText();
	}
	
	public void setEmail (String email) {
		this.jtfEmail.setText(email);
	}

	public String getEmail () {
		return this.jtfEmail.getText();
	}
	
	public void setTelefono (String telefono) {
		this.jtfTelefono.setText(telefono);
	}

	public String getTelefono () {
		return this.jtfTelefono.getText();
	}
	
	public void setIdTipologiaSexo(int newIdTipologiaSexo) {
		for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
			if (this.jcbSexo.getItemAt(i).getId() == newIdTipologiaSexo) {
				this.jcbSexo.setSelectedIndex(i);
			}
		}
	}
	
	public int getIdTipologiaSexo () {
		return ((TipologiaSexo) this.jcbSexo.getSelectedItem()).getId();
	}
	
	
	public void setImagen (byte[] newimagen) {
		this.imagenEnBytes = newimagen;
		if (newimagen != null && newimagen.length > 0) {
			ImageIcon icono = new ImageIcon(newimagen);
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);
		}
		else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}

	}
	
	public byte[] getImagen () {
		return this.imagenEnBytes;
	}
}
