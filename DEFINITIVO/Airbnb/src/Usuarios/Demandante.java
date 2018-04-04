package Usuarios;
import java.util.*;

import Inmuebles.Inmueble;
import Ofertas.Disponibilidad;
import Ofertas.*;
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
	private OfertaResidencial reserva_residencial;
	private OfertaVacacional reserva_vacacional;
	private List<Oferta> ofertas = new ArrayList<Oferta>();
	
	/**
	 * @return la reserva residencial
	 */
	public OfertaResidencial getResidencial() {
		return reserva_residencial;
	}

	
	/**
	 * @return la reserva residencial
	 */
	public OfertaVacacional getVacacional() {
		return reserva_vacacional;
	}

	
	public void setResidencial(OfertaResidencial reserva_residencial) {
		this.reserva_residencial = reserva_residencial;
	}


	public void setVacacional(OfertaVacacional reserva_vacacional) {
		this.reserva_vacacional = reserva_vacacional;
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
	 * Se annade una reserva contratada.
	 * Solo se pueden contratar las que no lo esten por el usuario
	 * @param o
	 */
	public void addOferta(Oferta o) {
		if(o == null) {
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

