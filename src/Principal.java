import itt.clases.banco.CuentaBancaria;
import itt.clases.banco.NumerosRojosException;
//Importamos las carpetas donde se encuentran nuestras clases necesarias
import java.util.Scanner;

/*Cuando ya tenemos nuestras clases implementadas correctamente, es el momento de introducir 
 * las funciones operativas en la clase principal o main.
 */
public class Principal {

	public static void main(String[] args) {
		/*
		 * Construimos una referencia al objeto de la clase Scanner porque
		 * tendremos que pasarle por teclado el importe de la retirada de dinero
		 */
		Scanner lector = new Scanner(System.in);

		System.out
				.println("Vamos a crear una cuenta y realizar el primer ingreso de 100 euros");
		/*
		 * Creamos una referencia al objeto de nuestra clase CuentaBancaria
		 * llamando al constructor en el cual tenemos que pasarle los dos
		 * parametros solicitados
		 */
		CuentaBancaria miCuenta = new CuentaBancaria(38143, "Amelia González");

		try {
			/*
			 * Aqui es donde tenemos que capturar nuestra primera excepcion,
			 * sabemos que no se va a producir porque en este caso es un
			 * ingreso, numero positivo, pero debemos de capturarla porque
			 * llamamos al metodo agregarMovimientos
			 */
			miCuenta.agregarMovimientos("Ingreso Inicial", 100);
		} catch (NumerosRojosException e) {

		}
		/*
		 * Aqui introduzco un bucle while porque el cajero es solo para
		 * retirada, no para hacer ingresos, se podria modificar para que fuera
		 * para las dos cosas, pero el enunciado ya está escrito. Si lo
		 * implementara yo de cero lo hubiera hecho. La cuestion, es que queria
		 * solucionar un poco si el usuario introduce un numero negativo que no
		 * aumente la cuenta bancaria poniendo Retirada de dinero, por lo tanto
		 * con este bucle while, mientras el usuario meta un numero
		 * negativo,vuelve a pedir el importe.
		 */
		boolean salir = false;
		while (salir == false) {
			System.out.println("Cuanto dinero deseas retirar: ");
			int dinero;// Aqui definimos la variable en donde guardaremos el
						// importe sacado
			try {
				/*
				 * Y aqui es donde empieza nuestro bloque try-catch para
				 * capturar la excepcion de introducir letras en vez de
				 * numeros(NumberFormatException). Desde el momento que vamos a
				 * introducir el numero por teclado, para ver si le pasamos
				 * numero o cadena.
				 */
				dinero = Integer.parseInt(lector.nextLine());
				if (dinero > 0) {/*
								 * Aqui le digo que si el numero introducido es
								 * positivo puede llamar al metodo
								 * agregarmovimientos
								 */
					try {
						/*
						 * Y por lo tanto aqui volvemos a implementar nuestro
						 * bloque try-catch en donde captura la excepcion al ir
						 * al metodo y ver si la cuenta se queda en numeros
						 * rojos con la retirada.
						 */
						miCuenta.agregarMovimientos("Retirada de fondos",
								-dinero);
					} catch (NumerosRojosException e) {

						System.out.println(e.getMessage());// Sacamos el mensaje
															// del constructor
															// de la excepcion
						System.out.println(e.getClass());// Mostramos a que
															// clase de
															// excepcion se
															// refiere
					}
					
				} else {// Si se ha introducido un numero negativo, seguimos en
						// el bucle
					System.out
							.println("Esta operacion es para retirada de fondos no para ingresos");
					salir = false;
				}
			} catch (NumberFormatException e) {/*
												 * Se lanza para indicar que la
												 * aplicación ha intentado
												 * convertir una cadena a uno de
												 * los tipos numéricos, pero que
												 * la cadena no tiene el formato
												 * adecuado.
												 */

				System.out.println("Has introducido un valor incorrecto");
				System.out.println("Tipo de excepcion " + e.getClass());
			}
			System.out.println(miCuenta);// Imprimimos el objeto miCuenta que me
			// muestra el valor de los atributos
// llamamos al metodo listar movimientos y vemos todos los movimientos
// validos de la cuenta
			System.out.println(miCuenta.listarMovimientos());

			System.out.println("¿Quieres salir del cajero?");
			String palabra=lector.nextLine();
			if (palabra.equalsIgnoreCase("Si")) {
				salir=true;
			}else salir =false;
		}

		lector.close();// Cerramos el Scanner
		
	}

}
