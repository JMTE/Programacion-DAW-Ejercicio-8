package itt.clases.banco;

/*Este es nuestro segundo paso en el proyecto. Implementar nuestra clase de una excepcion 
 * propia.
 * Nos dicen que tiene que ser una clase de excepcion controlada, por lo tanto tiene que
 * extender de Exception, sino heredaria de RunTimeException que son las no controladas
 */
/**
 * Se lanza para indicar que la aplicación ha intentado introducir un movimiento
 * de saldo negativo pero nuestra cuenta nunca puede quedar en numeros rojos
 * 
 * @author Jose Maria Tenreiro Eiranova
 * @since 26/02/2021
 **/
public class NumerosRojosException extends Exception {
	/*
	 * Con las clases de las excepciones vamos a construir siempre dos
	 * constructores, el constructor por defecto,sin pasarle ningun parametro. Y
	 * el constructor pasandole un mensaje por parametro y que va a heredar
	 * mediante el super.
	 */
	public NumerosRojosException() {

	}

	public NumerosRojosException(String mensaje_exception) {
		super(mensaje_exception);
	}
}
