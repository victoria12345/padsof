import java.util.*;

/**
 * Descripcion de la clase ofertante
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Ofertante extends Rol {
	
	private long tarjeta;
	private boolean bloqueado;
	public List<Inmueble> inmuebles = new ArrayList<Inmueble>();

	/**
	 * @return los inmuebles
	 */
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	/**
	 * @param inmuebles nueva lista de inmuebles del ofertante
	 */
	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}
	
	/**
	 * Annade un inmueble al ofertante
	 * @param i nuevo inmueble del ofertante
	 */
	public void addInmueble(Inmueble i) {
		inmuebles.add(i);
	}

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
	
	/**
	 * Devuelve si es ofertante
	 * @return true
	 */
	public boolean isOfertante() {
		return true;
	}
		
}
