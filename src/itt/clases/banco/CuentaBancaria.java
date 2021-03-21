package itt.clases.banco;

/*Despues de haber implementado la clase Movimiento,y de crear la clase de nuestra
 * excepcion NumeroRojos seguimos con la clase CuentaBancaria.
 * Aqui, será donde implementaremos el metodo que agrega movimientos a nuestra cuenta
 * bancaria y el metodo que lista todos nuestros movimientos. El codigo está basicamente
 * definido en el enunciado,salvo por los cambios que hay que introducir al implementar
 * la excepcion controlada.
 */
import java.util.ArrayList;

public class CuentaBancaria {
	/* Definimos y encapsulamos los atributos de la clase */
	private int numeroCuenta;
	private String cliente;
	private double saldo;
	/*
	 * Creamos un Array List del tipo Movimiento que sera donde almacenaremos
	 * nuestros objetos de los movimientos.
	 */
	private ArrayList<Movimiento> movimientos;

	// Construimos nuestro constructor que recibira dos parametros
	public CuentaBancaria(int numeroCuenta, String cliente) {
		this.numeroCuenta = numeroCuenta;
		this.cliente = cliente;
		// Al construirlo definimos que empezamos con cero euros en la cuenta
		this.saldo = 0;
		// Para esta nueva cuenta empezamos un nuevo ArrayList de movimientos
		this.movimientos = new ArrayList();

	}

	/**
	 * Este será el metodo en donde se llevará a cabo la introduccion de nuevos
	 * movimientos y las operaciones basicas de como quedará el saldo de la
	 * cuenta. Este metodo es de tipo void por lo que no devuelve nada y recibe
	 * dos parametros de entrada(concepto y cantidad). A partir de ahi
	 * calcularemos el valor actual del saldo y construiremos un nuevo objeto
	 * Movimiento el cual añadiremos directamente al ArrayList creado para la
	 * cuenta en la que nos encontramos
	 * 
	 * @param concepto
	 * @param cantidad
	 * @throws NumerosRojosException
	 *             La excepcion se producirá cuando al introducir un parametro
	 *             cantidad haga que nuestro saldo sea menor de cero. Llamaremos
	 *             a nuestro constructor de la clase NumerosRojos el cual le
	 *             pasamos un mensaje con el error que queremos sacar por
	 *             consola
	 */
	public void agregarMovimientos(String concepto, double cantidad)
			throws NumerosRojosException {

		this.saldo = this.saldo + cantidad;// calculamos el saldo actual despues
											// del parametro cantidad
		if (this.saldo < 0) {// Si el saldo resultante es menor de cero:
			this.saldo = this.saldo - cantidad;// Devolvemos el saldo a como
												// estaba
			// Hacemos saltar la excepcion.
			throw new NumerosRojosException(
					"####### La operación no puede realizarse. Saldo insuficiente. #######"
							+ "");
		}
		// Añadimos a nuestro ArrayList de movimientos el nuevo objeto
		// Movimiento creado a partir de los parametros
		this.movimientos.add(new Movimiento(concepto, cantidad, saldo));

	}

	@Override
	// Sobreescribimos el metodo ToString que nos dara la informacion de los
	// atributos del objeto Cuenta Bancaria
	public String toString() {
		return "Número=" + numeroCuenta + ",Cliente=" + cliente + "Saldo="
				+ saldo;

	}

	/**
	 * En el siguiente metodo se recorre el ArrayList y se devuelve un String
	 * con todos los movimientos bancarios realizados.
	 * 
	 * @return Movimientos realizados en lineas independientes
	 */
	public String listarMovimientos() {
		/*
		 * En el enunciado se hace con un bucle for each, que aunque entiendo su
		 * funcionamiento yo prefiero cambiarlo por un for normal porque lo veo
		 * mas claro.
		 */
		String listado = "";
		for (int i = 0; i < movimientos.size(); i++) {
			listado = listado + movimientos.get(i).toString() + "\n";

		}
		return listado;
	}
}
