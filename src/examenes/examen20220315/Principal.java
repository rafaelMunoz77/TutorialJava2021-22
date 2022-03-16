package examenes.examen20220315;

import java.util.Iterator;
import java.util.Scanner;

public class Principal {

	
	public static Cliente cliente;
	public static Caja caja;
	
	public static void main(String[] args) {
		
		cliente = new Cliente();
		caja = new Caja();
		
		pasaArticulosDeClienteACaja();
		
		System.out.println("BIENVENIDO AL SUPERMERCADO " + FicheroPropiedades.getProperty("NOMBRE"));

		eliminarUnArticuloDeLaCaja();
		
		System.out.println("El total del carro asciende a " + calculaTotalDeArticulosEnCaja());
	
		try {
			pagarEnCaja();
		} catch (NoSuficienteDineroException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private static void pasaArticulosDeClienteACaja () {
//		for (int i = 0; i < array.length; i++) {
//			caja.getHm().put(cliente.getArticulos().get(i).getId(), 
//					cliente.getArticulos().get(i));
//		}
		for (Articulo a : cliente.getArticulos()) {
			caja.getHm().put(a.getId(), a);
		}
		cliente.getArticulos().clear();
	}
	
	/**
	 * 
	 * @return
	 */
	private static double calculaTotalDeArticulosEnCaja () {
		double total = 0;
		
		Iterator<Articulo> it = caja.getHm().values().iterator();
		while (it.hasNext()) {
			Articulo a = it.next();
			total += a.getPrecioUnitario() * a.getUnidades();
		}
		
		return total;
	}

	/**
	 * 
	 */
	private static void muestraArticulosEnCaja() {
		System.out.println("\n\nLista de articulos en Caja:");

		Iterator<Articulo> it = caja.getHm().values().iterator();
		while (it.hasNext()) {
			Articulo a = it.next();
			System.out.println("\t" + a.getDescripcion());
		}
	}
	
	/**
	 * 
	 */
	private static void eliminarUnArticuloDeLaCaja () {
		Scanner sc = new Scanner(System.in);
		int idArticuloAEliminar;
		
		muestraArticulosEnCaja();
		
		System.out.println("Introduzca el identificador del artículo que desea eliminar: ");
		idArticuloAEliminar = sc.nextInt();
		
		caja.getHm().remove(idArticuloAEliminar);
		
		muestraArticulosEnCaja();
	}
	
	/**
	 * 
	 * @throws NoSuficienteDineroException
	 */
	private static void pagarEnCaja() throws NoSuficienteDineroException {
		Scanner sc = new Scanner(System.in);
		double cantidadPagaCliente, totalDelCarro;
		
		System.out.println("\nCon cuanto dinero desea pagar?: ");
		cantidadPagaCliente = sc.nextDouble();
		
		totalDelCarro = calculaTotalDeArticulosEnCaja();
		
		if (cantidadPagaCliente < totalDelCarro) {
			throw new NoSuficienteDineroException("El carro cuesta " + totalDelCarro +
					" € y usted paga sólo " + cantidadPagaCliente + " €");
		}
		else {
			System.out.println("Compra realizada correctamente");
		}
	}
}
