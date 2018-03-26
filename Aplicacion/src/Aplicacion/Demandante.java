
public class Demandante extends Rol{
	private int tarjeta;
	private boolean bloqueado;
	
	public Demandante(int tarjeta) {
		this.tarjeta = tarjeta;
		this.bloqueado = false;
	}

	/**
	 * @return the tarjeta
	 */
	public int getTarjeta() {
		return tarjeta;
	}

	/**
	 * @param tarjeta the tarjeta to set
	 */
	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}

	/**
	 * @return the bloqueado
	 */
	public boolean isBloqueado() {
		return bloqueado;
	}

	/**
	 * @param bloqueado the bloqueado to set
	 */
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}
