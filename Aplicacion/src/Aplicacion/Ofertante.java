/**
 * Descripcion de la clase ofertante
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Ofertante extends Rol {
	
	private long tarjeta;
	private boolean bloqueado;

	/**
	 * Constructor de Ofertante
	 * @param tarjeta tarjeta de credito del ofertante
	 */
	public Ofertante(long tarjeta) {
		this.tarjeta = tarjeta;
		this.bloqueado = false;
	}

	/**
	 * @return la tarjeta
	 */
	public long getTarjeta() {
		return tarjeta;
	}

	/**
	 * @param tarjeta nueva tarjeta de credito del ofertante
	 */
	public void setTarjeta(long tarjeta) {
		this.tarjeta = tarjeta;
	}

	/**
	 * @return el estado de bloqueado
	 */
	public boolean isBloqueado() {
		return bloqueado;
	}

	/**
	 * @param bloqueado cambia el estado de bloqueado
	 */
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}
