package examenes.examen20220516;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import examenes.examen20220516.controladores.ArtistaControlador;
import examenes.examen20220516.controladores.MunicipioControlador;
import examenes.examen20220516.controladores.ProvinciaControlador;
import examenes.examen20220516.modelo.Artista;
import examenes.examen20220516.modelo.Municipio;
import examenes.examen20220516.modelo.Provincia;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private JTextField jtfBuscar;
	private JTextField jtfNombre;
	JComboBox<Artista> jcbArtistaEncontrado;
	JComboBox<Provincia> jcbProvincia;
	JComboBox<Municipio> jcbMunicipio;
	JRadioButton radioCantante;
	JRadioButton radioMagia;
	JRadioButton radioDanza;
	ButtonGroup grupoDisciplina = new ButtonGroup();
	private byte[] imagenEnBytes = null;
	JScrollPane scrollPaneImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel_6 = new JLabel("Gestión de artistas");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridwidth = 3;
		gbc_lblNewLabel_6.insets = new Insets(10, 0, 10, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		frame.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Búsqueda de artista:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		jtfBuscar = new JTextField();
		GridBagConstraints gbc_jtfBuscar = new GridBagConstraints();
		gbc_jtfBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_jtfBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBuscar.gridx = 1;
		gbc_jtfBuscar.gridy = 1;
		frame.getContentPane().add(jtfBuscar, gbc_jtfBuscar);
		jtfBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarArtistas();
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 1;
		frame.getContentPane().add(btnBuscar, gbc_btnBuscar);
		
		JLabel lblArtistasEncontrados = new JLabel("Artistas encontrados:");
		GridBagConstraints gbc_lblArtistasEncontrados = new GridBagConstraints();
		gbc_lblArtistasEncontrados.anchor = GridBagConstraints.EAST;
		gbc_lblArtistasEncontrados.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistasEncontrados.gridx = 0;
		gbc_lblArtistasEncontrados.gridy = 2;
		frame.getContentPane().add(lblArtistasEncontrados, gbc_lblArtistasEncontrados);
		
		jcbArtistaEncontrado = new JComboBox<Artista>();
		GridBagConstraints gbc_jcbArtistaEncontrado = new GridBagConstraints();
		gbc_jcbArtistaEncontrado.insets = new Insets(0, 0, 5, 5);
		gbc_jcbArtistaEncontrado.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbArtistaEncontrado.gridx = 1;
		gbc_jcbArtistaEncontrado.gridy = 2;
		frame.getContentPane().add(jcbArtistaEncontrado, gbc_jcbArtistaEncontrado);
		
		JButton btnNewButton = new JButton("Cargar datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatosArtistaSeleccionado();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Artista encontrado");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(10, 0, 10, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		scrollPaneImagen = new JScrollPane();
		GridBagConstraints gbc_scrollPaneImagen = new GridBagConstraints();
		gbc_scrollPaneImagen.gridheight = 5;
		gbc_scrollPaneImagen.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneImagen.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneImagen.gridx = 0;
		gbc_scrollPaneImagen.gridy = 1;
		panel.add(scrollPaneImagen, gbc_scrollPaneImagen);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre artístico:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 2;
		gbc_jtfNombre.gridy = 1;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Disciplina:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridheight = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		radioCantante = new JRadioButton("Cantante");
		GridBagConstraints gbc_radioCantante = new GridBagConstraints();
		gbc_radioCantante.insets = new Insets(0, 0, 5, 0);
		gbc_radioCantante.anchor = GridBagConstraints.WEST;
		gbc_radioCantante.gridx = 2;
		gbc_radioCantante.gridy = 2;
		panel.add(radioCantante, gbc_radioCantante);
		grupoDisciplina.add(radioCantante);
		
		radioMagia = new JRadioButton("Magia");
		GridBagConstraints gbc_radioMagia = new GridBagConstraints();
		gbc_radioMagia.insets = new Insets(0, 0, 5, 0);
		gbc_radioMagia.anchor = GridBagConstraints.WEST;
		gbc_radioMagia.gridx = 2;
		gbc_radioMagia.gridy = 3;
		panel.add(radioMagia, gbc_radioMagia);
		grupoDisciplina.add(radioMagia);
		
		radioDanza = new JRadioButton("Danza");
		GridBagConstraints gbc_radioDanza = new GridBagConstraints();
		gbc_radioDanza.insets = new Insets(0, 0, 5, 0);
		gbc_radioDanza.anchor = GridBagConstraints.WEST;
		gbc_radioDanza.gridx = 2;
		gbc_radioDanza.gridy = 4;
		panel.add(radioDanza, gbc_radioDanza);
		grupoDisciplina.add(radioDanza);
		
		JLabel lblNewLabel_4 = new JLabel("Provincia:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbProvincia = new JComboBox<Provincia>();
		jcbProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMunicipiosDeProvincia();
			}
		});
		GridBagConstraints gbc_jcbProvincia = new GridBagConstraints();
		gbc_jcbProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvincia.gridx = 2;
		gbc_jcbProvincia.gridy = 5;
		panel.add(jcbProvincia, gbc_jcbProvincia);
		
		JButton btnCargarImagen = new JButton("Cargar imagen");
		btnCargarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarFicheroImagen();
			}
		});
		GridBagConstraints gbc_btnCargarImagen = new GridBagConstraints();
		gbc_btnCargarImagen.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarImagen.gridx = 0;
		gbc_btnCargarImagen.gridy = 6;
		panel.add(btnCargarImagen, gbc_btnCargarImagen);
		
		JLabel lblNewLabel_5 = new JLabel("Municipio:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jcbMunicipio = new JComboBox<Municipio>();
		GridBagConstraints gbc_jcbMunicipio = new GridBagConstraints();
		gbc_jcbMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMunicipio.gridx = 2;
		gbc_jcbMunicipio.gridy = 6;
		panel.add(jcbMunicipio, gbc_jcbMunicipio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 255, 204));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 7;
		panel.add(panel_1, gbc_panel_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel_1.add(btnGuardar);
		
		cargarTodasProvincias();
		this.jcbProvincia.setSelectedIndex(0);
		cargarMunicipiosDeProvincia();
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
					setImagen(Files.readAllBytes(fichero.toPath()));
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	
	
	/**
	 * 
	 * @param newimagen
	 */
	public void setImagen (byte[] newimagen) {
		this.imagenEnBytes = newimagen;
		if (newimagen != null && newimagen.length > 0) {
			ImageIcon icono = new ImageIcon(newimagen);
			JLabel lblIcono = new JLabel(icono);
			this.scrollPaneImagen.setViewportView(lblIcono);
		}
		else {
			JLabel lblIcono = new JLabel("Sin imagen");
			this.scrollPaneImagen.setViewportView(lblIcono);
		}

	}
	
	
	/**
	 * 
	 */
	private void guardar() {
		Artista a = (Artista) this.jcbArtistaEncontrado.getSelectedItem();
		
		a.setNombre(this.jtfNombre.getText());
		a.setIdMunicipio( ((Municipio) this.jcbMunicipio.getSelectedItem()).getId() );
		
		if (this.radioCantante.isSelected()) a.setIdDisciplina(1);
		else if (this.radioMagia.isSelected()) a.setIdDisciplina(2);
		else a.setIdDisciplina(3);
		
		a.setImagen(this.imagenEnBytes);
		
		if (ArtistaControlador.modificar(a) > 0) {
			JOptionPane.showMessageDialog(null, "Guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Imposible guardar");
		}
	}
	
	/**
	 * 
	 */
	private void cargarDatosArtistaSeleccionado() {
		Artista a = (Artista) this.jcbArtistaEncontrado.getSelectedItem();
		
		this.jtfNombre.setText(a.getNombre());
		
		if (a.getIdDisciplina() == 1) this.radioCantante.setSelected(true);
		else if (a.getIdDisciplina() == 2) this.radioMagia.setSelected(true);
		else this.radioDanza.setSelected(true);
		
		Provincia p = ProvinciaControlador.findByIdMunicipio(a.getIdMunicipio());
		for (int i = 0; i < this.jcbProvincia.getItemCount(); i++) {
			if (this.jcbProvincia.getItemAt(i).getId() == p.getId()) {
				this.jcbProvincia.setSelectedIndex(i);
			}
		}
		cargarMunicipiosDeProvincia();
		for (int i = 0; i < this.jcbMunicipio.getItemCount(); i++) {
			if (this.jcbMunicipio.getItemAt(i).getId() == a.getIdMunicipio()) {
				this.jcbMunicipio.setSelectedIndex(i);
			}
		}
		
		setImagen(a.getImagen());
	}
	
	/**
	 * 
	 */
	private void cargarMunicipiosDeProvincia() {
		this.jcbMunicipio.removeAllItems();
		Provincia provinciaSeleccionada = (Provincia) this.jcbProvincia.getSelectedItem();
		List<Municipio> municipios = MunicipioControlador.findAllByIdProvincia(provinciaSeleccionada.getId());
		
		for (Municipio m : municipios) {
			this.jcbMunicipio.addItem(m);
		}
	}
	
	/**
	 * 
	 */
	private void cargarTodasProvincias() {
		this.jcbProvincia.removeAllItems();
		
		List<Provincia> provincias = ProvinciaControlador.findAll();
		for (Provincia p : provincias) {
			this.jcbProvincia.addItem(p);
		}
	}	
	
	
	/**
	 * 
	 */
	private void filtrarArtistas() {
		String filtro = this.jtfBuscar.getText();
		this.jcbArtistaEncontrado.removeAllItems();
		
		List<Artista> artistasFiltrados = ArtistaControlador.filterByNombre(filtro);
		for (Artista a : artistasFiltrados) {
			this.jcbArtistaEncontrado.addItem(a);
		}
	}
}
