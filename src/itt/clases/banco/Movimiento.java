package itt.clases.banco;

/*Lo primero en este proyecto es empezar implementado la clase Movimiento, es como la base
 * del proyecto, ya que otras clases necesitan de objetos Movimiento.
 */
import java.time.LocalDateTime;/*En vez de hacer un LocalTime como dice el enunciado prefiero
hacer un LocalDateTime ya que considero que en movimientos bancarios es importante tener 
la hora y los minutos del movimiento*/

public class Movimiento {
	/*
	 * Todos los datos estan dados en el enunciado, pero es como siempre,
	 * declaramos y encapsulamos los atributos de la clase Movimiento e
	 * implementamos un constructor que al llamarlo hay que pasarle 3
	 * parametros.
	 */
	private LocalDateTime fecha;
	private String concepto;
	private double cantidad;
	private double saldo;

	public Movimiento(String concepto, double cantidad, double saldo) {
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.saldo = saldo;
		this.fecha = LocalDateTime.now();/*
										 * Cada vez que llamemos al constructor
										 * se construye Localdatetime con la
										 * fecha y hora de ese momento
										 */

	}

	@Override
	// Sobreescribimos el metodo toString que nos devuelve el valor de los
	// atributos del objeto
	public String toString() {
		return fecha + " Concepto=" + concepto + ", Cantidad=" + cantidad
				+ ", Saldo=" + saldo;

	}
}
