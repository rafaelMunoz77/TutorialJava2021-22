package tutorialJava.capitulo4_OO.ejercicios.bloque02Herencia.articulosComestibles;

import java.util.Scanner;


public class Tienda {

	public Tienda() {
	}

	public static void main(String[] args) {
		
		Perecedero magdalenaChocolate = new Perecedero();
		inicializaArticulo(magdalenaChocolate, "magdalena de chocolate");
		System.out.println(magdalenaChocolate.toString());

		Perecedero palmeraChocolate = new Perecedero();
		inicializaArticulo(palmeraChocolate, "palmera de chocolate");
		System.out.println(palmeraChocolate.toString());
		
		NoPerecedero miel = new NoPerecedero();
		inicializaArticulo(miel, "miel");
		System.out.println(miel.toString());
		
		NoPerecedero sal = new NoPerecedero();
		inicializaArticulo(sal, "sal");
		System.out.println(sal.toString());
	}
	
	/**
	 * 
	 */
	public static void inicializaArticulo (Articulo a, String str) {
		a.setCodigo(pedirDatoString("Introduzca el código de " + str));
		a.setNombre(pedirDatoString("Introduzca el nombre de " + str));
		a.setPrecio(pedirDatoFloat("Introduzca el precio de " + str));
		
		if (a instanceof Perecedero) {
			Perecedero p = (Perecedero) a;
			p.setFecha(pedirDatoString("Introduzca la fecha de caducidad de " + str));
		}
	}
	
	/**
	 * 
	 * @param textoUsuario
	 * @return
	 */
	public static String pedirDatoString (String textoUsuario) {
		Scanner sc = new Scanner (System.in);
		System.out.println(textoUsuario);
		return sc.nextLine();
	}

	/**
	 * 
	 * @param textoUsuario
	 * @return
	 */
	public static float pedirDatoFloat (String textoUsuario) {
		return Float.parseFloat(pedirDatoString(textoUsuario));
	}
}
