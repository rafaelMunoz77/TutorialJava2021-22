package tutorialJava.capitulo8_AWT_SWING.v01_PrimeraVentanaMouseListeners;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tutorialJava.capitulo8_AWT_SWING.utils.Apariencia;
import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;

public class VentanaPrincipal extends JFrame {

	public static int ANCHO = 800;
	public static int ALTO = 600;
	public static String TITULO_APLICACION = "T�tulo de la aplicaci�n";
	
	private CacheImagenes cacheImagenes;
	public static BufferedImage iconoApp;

	
	// Establecer la apariencia t�pica de Windows
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	
	
	public VentanaPrincipal () {
		super (TITULO_APLICACION);
		
		cacheImagenes = new CacheImagenes();
		iconoApp = cacheImagenes.getImagen("nave.gif");
		this.setIconImage(iconoApp);
		
		// Tama�o por defecto, basado en los valores est�ticos de esta misma clase
		setDimensionesBasicas();
		
		// Una posibilidad es iniciar el JFrame en un estado determinado, las opciones son:
		// JFrame.NORMAL: Inicializa el JFrame en estado Normal
		// JFrame.ICONIFIED: Inicializa el JFrame en estado Minimizado.
		// JFrame.MAXIMIZED_HORIZ: Inicializa el JFrame en estado Maximizado Horizontalmente
		// JFrame.MAXIMIZED_VERT: Inicializa el JFrame en estado Maximizado Verticalmente
		// JFrame.MAXIMIZED_BOTH: Inicializa el JFrame en estado Maximizado en ambos sentidos		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// Configuraci�n del evento de cerrado
		// Para m�s informaci�n debes estudiar Javadoc WindowListener y WindowAdapter
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				String posiblesRespuestas[] = {"S�","No"};
				// En esta opci�n se utiliza un showOptionDialog en el que personalizo el icono mostrado
				int opcionElegida = JOptionPane.showOptionDialog(null, "�Realmente desea cerrar la aplicaci�n?", TITULO_APLICACION, 
				        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, cacheImagenes.getIcono("confirm.png"), posiblesRespuestas, posiblesRespuestas[1]);
			    if(opcionElegida == 0) {
			      System.exit(0);          
			    }
			}
		});
		
		
		
		

		// Inclusi�n de los eventos de teclado
		// Para m�s informaci�n debes estudiar Javadoc KeyListener y KeyAdapter
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				// En esta ocasi�n he decidido no personalizar el icono mostrado, para obtener el icono por defecto
				JOptionPane.showMessageDialog(null, "Deja de pulsar teclas ya", TITULO_APLICACION, JOptionPane.INFORMATION_MESSAGE, null);
			}
		});

		// incluimos y estudiamos los eventos del rat�n
		inclusionEventosRaton();
		
		// Construcci�n elementos b�sicos sobre el ContentPanel
		this.setContentPane(getElementosBasicosPanel());
	}

	
	
	/**
	 * 
	 */
	private void setDimensionesBasicas () {
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, ANCHO, ALTO);
		this.setMinimumSize(new Dimension(ANCHO, ALTO));
	}
	
	
	
	
	/**
	 * 
	 */
	private void inclusionEventosRaton () {
		// MouseListener permite controlar eventos de rat�n simples
		this.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Bot�n de rat�n pulsado: " + e.getButton() + " - " + e.getClickCount() + " veces");
				System.out.println("\tX: " + e.getX() + " Y: " + e.getY() + " X en pantalla: " + e.getXOnScreen() + " Y en pantalla: " + e.getYOnScreen());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Bot�n de rat�n presionado: " + e.getButton());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Bot�n de rat�n liberado: " + e.getButton());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Rat�n entra en la ventana");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Rat�n sale de la ventana");
			}
			
		});
	
		
		// Los eventos del MouseMotionListener nos permiten detectar movimiento del rat�n y arrastre, a bajo nivel 
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("Rat�n se ha desplazado a las coordenadas x: " + e.getX() + " y: " + e.getY());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("Rat�n arrastrando a las coordenadas x: " + e.getX() + " y: " + e.getY());
			}
		});
	
		
		// Por �ltimo, algo muy habitual
		this.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getWheelRotation() > 0) {
					System.out.println("Movimiento de reducci�n - Rueda hac�a atr�s - Pasos: " + e.getWheelRotation());
				}
				else {
					System.out.println("Movimiento de amplitud - Rueda hac�a adelante - Pasos: " + e.getWheelRotation());
				}
			}
		});
	}
	
	
	
	/**
	 * 
	 */
	// Una web muy interesante para obtener un showcase de los componentes SWING es http://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
	private JPanel getElementosBasicosPanel () {
		JPanel muestrario = new JPanel();
		
		// JLabel
		JLabel lb = new JLabel ("Ejemplo de JTextField: ");
		muestrario.add(lb);
		
		// JTextField
		JTextField tf = new JTextField("asdf");
		tf.setText("Texto en el interior");
		tf.setColumns(40);
		tf.setToolTipText("ToolTip para el componente JTextField");
		muestrario.add(tf);
		
		// JButton
		JButton bt = new JButton("Acci�n!!!");
		bt.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				System.out.println("Entrado en el bot�n");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				System.out.println("Saliendo en el bot�n");
			}
			
		});
		bt.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Personalizaci�n del icono, otra vez
				JOptionPane.showMessageDialog(null, "Acci�n!!!!!!!", TITULO_APLICACION, JOptionPane.INFORMATION_MESSAGE, cacheImagenes.getIcono("goku.png"));
			}
		});
		muestrario.add(bt);
		
		return muestrario;
	}
	
	
	

}
