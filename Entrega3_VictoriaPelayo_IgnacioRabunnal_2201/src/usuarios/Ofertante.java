package usuarios;
import java.util.*;

import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import es.uam.eps.padsof.telecard.TeleChargeAndPaySystem;
import excepciones.ArgumentoNoValido;
import inmuebles.Inmueble;
import ofertas.Oferta;

/**
 * Descripcion de la clase ofertante
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Ofertante extends Rol {
	private static final long serialVersionUID = 1L;
	private String tarjeta;
	private double saldoPendiente;
	private boolean bloqueado;
	public List<Inmueble> inmuebles = new ArrayList<Inmueble>();

	/**
	 * @return los inmuebles
	 */
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	
	/**
	 * Annade un inmueble al ofertante
	 * @param i nuevo inmueble del ofertante
	 * @throws ArgumentoNoValido si la lista de inmuebles ya contiene al inmueble
	 */
	public void addInmueble(Inmueble i) throws ArgumentoNoValido{
		if(inmuebles.contains(i) == true) {
			throw new ArgumentoNoValido();
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
		this.saldoPendiente = 0;
	}
	
	public double getSaldoPendiente() {
		return saldoPendiente;
	}
	
	public void recibirPago(Oferta o, String concepto) {
		try {
			TeleChargeAndPaySystem.charge(tarjeta, concepto, o.getPrecio());
		} catch (InvalidCardNumberException e) {
			saldoPendiente += o.getPrecio();
		} catch (FailedInternetConnectionException e) {
			saldoPendiente += o.getPrecio();
		} catch (OrderRejectedException e) {
			saldoPendiente += o.getPrecio();
		}
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
	
	/**
	 * Devuelve si es demandante
	 * @return false
	 */
	public boolean isDemandante() {
		return false;
	}
	
	/**
	 * Devuelve si es administrador
	 * @return false
	 */
	public boolean isAdmin() {
		return false;
	}
	
	
		
}
