package Usuarios;
import java.util.*;

import Inmuebles.Inmueble;

/**
 * Descripcion de la clase ofertante
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Ofertante extends Rol {
	private static final long serialVersionUID = 1L;
	private String tarjeta;
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
		if(inmuebles.contains(i) == true) {
			return;
		}
		inmuebles.add(i);
	}

	/**
	 * Constructor de Ofertante
	 * @param tarjeta tarjeta de credito del ofertante
	 */
	public Ofertante(String tarjeta) {
		this.tarjeta = tarjeta;
		this.bloqueado = false;
	}

	/**
	 * @return la tarjeta
	 */
	public String getTarjeta() {
		return tarjeta;
	}

	/**
	 * @param tarjeta nueva tarjeta de credito del ofertante
	 */
	public void setTarjeta(String tarjeta) {
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
	
	public boolean isDemandante() {
		return false;
	}
	
		
}
