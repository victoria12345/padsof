package Usuarios;
import java.time.LocalDate;
import java.util.*;

import Inmuebles.Inmueble;
import Ofertas.Disponibilidad;
import Ofertas.Oferta;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;

/**
 * Descripcion de la clase Demandante
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Demandante extends Rol{
	private static final long serialVersionUID = 1L;
	private String tarjeta;
	private boolean bloqueado;
	private List<Oferta> reservas = new ArrayList<Oferta>();
	private List<Oferta> ofertas = new ArrayList<Oferta>();
	
	/**
	 * @return las reservas
	 */
	public List<Oferta> getReservas() {
		return reservas;
	}

	/**
	 * @param reservas nueva lista de reservas
	 */
	public void setReservas(List<Oferta> reservas) {
		if(reservas == null) {
			return;
		}
		this.reservas = reservas;
	}

	/**
	 * @return las ofertas contratadas
	 */
	public List<Oferta> getOfertas() {
		return ofertas;
	}

	/**
	 * @param ofertas nuevo array de ofertas contratadas
	 */
	public void setOfertas(List<Oferta> ofertas) {
		if(ofertas == null ) {
			return;
		}
		this.ofertas = ofertas;
	}
	
	/**
	 * Se annade una reserva. Solo se puede reservar una oferta que no lo esta
	 * @param o oferta que se desea reservar
	 */
	public void addReserva(Oferta o, LocalDate fecha) {
		fecha.plusDays(5); //si en cinco dias no se paga se cancela
		
		if(o == null || o.getDisp() == Disponibilidad.RESERVADA) {
			return;
		}
		reservas.add(o);
		o.setDisp(Disponibilidad.RESERVADA);
		o.setCancelacion(fecha);
	}
	
	/**
	 * Se annade una reserva contratada.
	 * Solo se pueden contratar las que no lo esten por el usuario
	 * @param o
	 */
	public void addOferta(Oferta o) {
		if(o == null || (o.getDisp() == Disponibilidad.RESERVADA) && reservas.contains(o)==false){
			return;
		}
		o.setDisp(Disponibilidad.CONTRATADA);
		ofertas.add(o);
		o.setCancelacion(null);
	}

	/**
	 * Constructor de Demandante
	 * @param tarjeta tarjeta de credito del demandante
	 */
	public Demandante(String tarjeta) {
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
	 * @param tarjeta nueva tarjeta del demandante
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
	 * @param bloqueado nuevo estado de bloqueado
	 */
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	/**
	 * Devuelve si es ofertante
	 * @return false
	 */
	public boolean isOfertante() {
		return false;
	}
	
	/**
	 * No hace nada
	 */
	public void addInmueble(Inmueble i) {
		
	}
	
	public boolean isDemandante() {
		return true;
	}
	
	public void delReserva(Oferta o) {
		if(reservas.contains(o) == false) {
			return;
		}
		reservas.remove(o);
	}
	
	public void delOferta(Oferta o) {
		if(ofertas.contains(o) == false) {
			return;
		}
		ofertas.remove(o);
	}
	
	
	public void pagarOferta(Oferta o, String concepto) throws InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException {
		o.pagar(tarjeta, concepto);
	}
	
		
}

