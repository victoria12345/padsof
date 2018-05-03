package ofertas;
import java.util.*;

import excepciones.*;

import java.time.*;

import usuarios.Demandante;
/**
 * Descripcion de la clase OfertaVacacional
 * @author Victoria Pelayo e Ignacio Rabunnal
 */

public class OfertaVacacional extends Oferta {

	private static final long serialVersionUID = 1L;
	private LocalDate fin;
	private double fianza;

	/**
	 * Constructor de Oferta Vacacional
	 * @param precio precio de la oferta
	 * @param ini fecha inicio de oferta
	 * @param fin fecha final de oferta
	 * @param fianza fianza a pagar por el demandante
	 */
	public OfertaVacacional(double precio, LocalDate ini, LocalDate fin, double fianza) {
		super(precio, ini);
		this.fin = fin;
		
		if(fianza <0) {
			this.fianza = 0;
		}else{
			this.fianza = fianza;
		}
	}

	/**
	 * @return la fecha final
	 */
	public LocalDate getFin() {
		return fin;
	}

	/**
	 * @param fin nueva fecha final
	 */
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	/**
	 * @return la fianza
	 */
	public double getFianza() {
		return fianza;
	}

	/**
	 * @param fianza nueva fianza de la oferta
	 * @throws ArgumentoNoValido si la fianza es menor que 0
	 */
	public void setFianza(double fianza) throws ArgumentoNoValido{
		if(fianza < 0) {
			throw new ArgumentoNoValido();
		}
		this.fianza = fianza;
	}
	
	/**
	 * Se reserva la oferta
	 * @param deman rol de demandante de un usuario
	 * @param date fecha en la que se realiza la reserva
	 * @throws UsuarioBloqueado si el usuario que intenta reservar la oferta esta bloqueado
	 * @throws OfertaNoDisponible si la oferta esta ya reservada o no esta aceptada por el admin
	 * @throws DemasiadasOfertasReservadas si el usuario que intenta reservar la oferta ya tiene otra reservada
	 */
	public void reservar(Demandante deman, LocalDate date) throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas {
		List<Demandante> bloqueados = this.getBloqueados();
		if(bloqueados.contains(deman) == true) {
			throw new UsuarioBloqueado();
		}
		if(this.getEstado() != Estado.ACEPTADA) {
			throw new OfertaNoDisponible();
		}
		if(this.getDisp() == Disponibilidad.RESERVADA) {
			throw new OfertaNoDisponible();
		}
		if(deman.getVacacional() != null) {
			throw new DemasiadasOfertasReservadas();
		}
		
		deman.setVacacional(this);
		this.setCancelacion(date.plusDays(5));  
	}
	
	/**
	 * Cancela la reserva de la oferta
	 * @param deman demandante que cancela la oferta
	 * @param valor true si hay que bloquear al usuario y false si no es asi
	 * @throws ArgumentoNoValido si el demandante no es el que ha reservado la oferta
	 */
	 public void cancelar(Demandante deman, boolean valor) throws ArgumentoNoValido {
		 if(this != deman.getVacacional()) {
			 throw new ArgumentoNoValido();
		 }
		 if(valor == true) {
			 this.addBloqueado(deman);
		 }
		 deman.setVacacional(null);
		 this.setDisp(Disponibilidad.DISPONIBLE);
		 this.setCancelacion(null);
	 }
	 
	 public double calcularPrecio() {
		 return this.getPrecio() + fianza;
	 }
}
