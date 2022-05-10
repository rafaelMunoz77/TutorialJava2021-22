package examenes.examen20220509;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import examenes.examen20220509.controladores.AcuerdoControlador;
import examenes.examen20220509.controladores.IdiomaControlador;
import examenes.examen20220509.controladores.PaisControlador;
import examenes.examen20220509.controladores.UsuarioControlador;
import examenes.examen20220509.modelo.Acuerdo;
import examenes.examen20220509.modelo.Idioma;
import examenes.examen20220509.modelo.Pais;
import examenes.examen20220509.modelo.Usuario;

import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frmAltaDeUsuario;
	private JTextField jtfEmail;
	private JTextField jtfUsuario;
	private JTextField jtfPassword;
	private JTextField jtfRepePassword;
	private JComboBox<Pais> jcbPais;
	private JComboBox<Idioma> jcbIdioma;
	private JCheckBox jcheckAcuerdo;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmAltaDeUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaDeUsuario = new JFrame();
		frmAltaDeUsuario.setTitle("Alta de usuario");
		frmAltaDeUsuario.setBounds(100, 100, 450, 300);
		frmAltaDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmAltaDeUsuario.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frmAltaDeUsuario.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 0;
		frmAltaDeUsuario.getContentPane().add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frmAltaDeUsuario.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.anchor = GridBagConstraints.NORTH;
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 1;
		frmAltaDeUsuario.getContentPane().add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		frmAltaDeUsuario.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfPassword = new JTextField();
		GridBagConstraints gbc_jtfPassword = new GridBagConstraints();
		gbc_jtfPassword.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPassword.gridx = 1;
		gbc_jtfPassword.gridy = 2;
		frmAltaDeUsuario.getContentPane().add(jtfPassword, gbc_jtfPassword);
		jtfPassword.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Repetición password:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		frmAltaDeUsuario.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfRepePassword = new JTextField();
		GridBagConstraints gbc_jtfRepePassword = new GridBagConstraints();
		gbc_jtfRepePassword.insets = new Insets(0, 0, 5, 0);
		gbc_jtfRepePassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfRepePassword.gridx = 1;
		gbc_jtfRepePassword.gridy = 3;
		frmAltaDeUsuario.getContentPane().add(jtfRepePassword, gbc_jtfRepePassword);
		jtfRepePassword.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("País:");
		lblNewLabel_4.setToolTipText("País:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		frmAltaDeUsuario.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbPais = new JComboBox<Pais>();
		jcbPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarIdiomasPorPaisSeleccionado();
			}
		});
		GridBagConstraints gbc_jcbPais = new GridBagConstraints();
		gbc_jcbPais.insets = new Insets(0, 0, 5, 0);
		gbc_jcbPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbPais.gridx = 1;
		gbc_jcbPais.gridy = 4;
		frmAltaDeUsuario.getContentPane().add(jcbPais, gbc_jcbPais);
		
		JLabel lblNewLabel_5 = new JLabel("Idioma:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		frmAltaDeUsuario.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jcbIdioma = new JComboBox<Idioma>();
		jcbIdioma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizaIdiomaDelAcuerdo();
			}
		});
		GridBagConstraints gbc_jcbIdioma = new GridBagConstraints();
		gbc_jcbIdioma.insets = new Insets(0, 0, 5, 0);
		gbc_jcbIdioma.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbIdioma.gridx = 1;
		gbc_jcbIdioma.gridy = 5;
		frmAltaDeUsuario.getContentPane().add(jcbIdioma, gbc_jcbIdioma);
		
		jcheckAcuerdo = new JCheckBox("Acepta los términos del alta del usuario");
		jcheckAcuerdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardar.setEnabled(jcheckAcuerdo.isSelected());
			}
		});
		GridBagConstraints gbc_jcheckAcuerdo = new GridBagConstraints();
		gbc_jcheckAcuerdo.insets = new Insets(0, 0, 5, 0);
		gbc_jcheckAcuerdo.anchor = GridBagConstraints.WEST;
		gbc_jcheckAcuerdo.gridwidth = 2;
		gbc_jcheckAcuerdo.gridx = 0;
		gbc_jcheckAcuerdo.gridy = 6;
		frmAltaDeUsuario.getContentPane().add(jcheckAcuerdo, gbc_jcheckAcuerdo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarUsuario();
			}
		});
		btnGuardar.setEnabled(false);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 7;
		frmAltaDeUsuario.getContentPane().add(btnGuardar, gbc_btnGuardar);
		
		
		cargarPaisesEnComboBox();
		cargarIdiomasEnComboBox();
	}

	
	/**
	 * 
	 */
	private void cargarPaisesEnComboBox() {
		List<Pais> paises = PaisControlador.findAll();
		for (Pais p : paises) {
			this.jcbPais.addItem(p);
		}
	}

	/**
	 * 
	 */
	private void cargarIdiomasEnComboBox() {
		List<Idioma> idiomas = IdiomaControlador.findAll();
		for (Idioma i : idiomas) {
			this.jcbIdioma.addItem(i);
		}
	}

	/**
	 * 
	 */
	private void filtrarIdiomasPorPaisSeleccionado() {
		int idPaisSeleccionado = ((Pais) this.jcbPais.getSelectedItem()).getId();
		
		this.jcbIdioma.removeAllItems();
		
		List<Idioma> idiomas = IdiomaControlador.findByIdPais(idPaisSeleccionado);		
		for (Idioma i : idiomas) {
			this.jcbIdioma.addItem(i);
		}
	}
	
	/**
	 * 
	 */
	private void actualizaIdiomaDelAcuerdo() {
		if (this.jcbIdioma.getSelectedItem() != null) {
			int idIdiomaSeleccionado = ((Idioma) this.jcbIdioma.getSelectedItem()).getId();
			
			Acuerdo a = AcuerdoControlador.findByIdIdioma(idIdiomaSeleccionado);
			
			if (a != null) {
				this.jcheckAcuerdo.setText(a.getDescripcion());
			}
		}
	}
	
	/**
	 * 
	 */
	private void guardarUsuario() {
		// Comprobación del email
		String email = this.jtfEmail.getText();
		if (! (email.lastIndexOf('.') != -1 && email.lastIndexOf('@') != -1 && email.lastIndexOf('.') > email.lastIndexOf('@') )) {
			JOptionPane.showMessageDialog(null, "El email no es válido");
			return;
		}
		
		// Longitud del usuario
		if (this.jtfUsuario.getText().length() < 8) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario debe tener al menos 8 caracteres");
			return;
		}
		
		// Compruebo que exista una minúscula, una mayúscula y un dígito
		boolean mayuscula = false, minuscula = false, digito = false;
		String password = this.jtfPassword.getText();
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) minuscula = true;
			else if (Character.isUpperCase(password.charAt(i))) mayuscula = true;
			else if (Character.isDigit(password.charAt(i))) digito = true;
		}
		
		if (!mayuscula || !minuscula || !digito) {
			JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos una mayúscula, una minúscula y un dígito");
			return;
		}
		
		// Repetición de la contraseña
		if (!password.equals(this.jtfRepePassword.getText())) {
			JOptionPane.showMessageDialog(null, "La contraseña y su repetición no coinciden");
			return;

		}
		
		// Compruebo que el usuario no exista antes de guardar
		if (UsuarioControlador.findByNombreUsuario(this.jtfUsuario.getText()) != null) {
			JOptionPane.showMessageDialog(null, "El usuario ya existe");
			return;
		}
		
		// Finalmente guardo el usuario
		Usuario u = new Usuario();
		u.setEmail(this.jtfEmail.getText());
		u.setUsuario(this.jtfUsuario.getText());
		u.setPassword(this.jtfPassword.getText());
		u.setIdIdioma(((Idioma) this.jcbIdioma.getSelectedItem()).getId());
		
		if (UsuarioControlador.nuevo(u) > 0) {
			JOptionPane.showMessageDialog(null, "Usuario almacenado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "El usuario no puede guardarse");
		}
	}
}
