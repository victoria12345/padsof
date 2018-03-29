/**
 * Descripcion de la clase Demandante
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Demandante extends Rol{
	private long tarjeta;
	private boolean bloqueado;
	
	/**
	 * Constructor de Demandante
	 * @param tarjeta tarjeta de credito del demandante
	 */
	public Demandante(long tarjeta) {
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
	 * @param tarjeta nueva tarjeta del demandante
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
	 * @param bloqueado nuevo estado de bloqueado
	 */
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}
