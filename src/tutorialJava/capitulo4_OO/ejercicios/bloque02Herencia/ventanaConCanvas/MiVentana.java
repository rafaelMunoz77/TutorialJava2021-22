package tutorialJava.capitulo4_OO.ejercicios.bloque02Herencia.ventanaConCanvas;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MiVentana {

	public static void main (String args[]) {
		JFrame ventana = new JFrame("Mi ventana");
		ventana.setBounds(0, 0, 800, 600);
		
		ventana.getContentPane().setLayout(new BorderLayout());
		
		Canvas miCanvas = new Canvas() {
			
		};
		
		ventana.add(new Canvas() {

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(Color.RED);
				g.fillRect(10, 10, 200, 100);
				
				g.setColor(Color.GREEN);  
				g.fillOval(300, 400, 100, 100);
				
				g.setColor(Color.BLUE);
				int x[] = new int[] {50, 90, 220};
				int y[] = new int[] {100, 25, 400};
				g.fillPolygon(x, y, 3);

			}
			
		}, BorderLayout.CENTER);
		
		ventana.setVisible(true);
	}
}
