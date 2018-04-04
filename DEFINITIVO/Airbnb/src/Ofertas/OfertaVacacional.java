package Ofertas;
import java.util.*;
import java.time.*;

import Usuarios.Demandante;
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
	 */
	public void setFianza(double fianza) {
		if(fianza < 0) {
			return;
		}
		this.fianza = fianza;
	}
	
	/**
	 * Se reserva la oferta
	 * @param deman rol de demandante de un usuario
	 * @param date fecha en la que se realiza la reserva
	 * @return true si se puede reservar
	 */
	public boolean reservar(Demandante deman, LocalDate date) {
		List<Demandante> bloqueados = this.getBloqueados();
		if(bloqueados.contains(deman) == true) {
			return false;
		}
		if(this.getDisp() == Disponibilidad.RESERVADA) {
			return false;
		}
		if(deman.getVacacional() != null) {
			return false;
		}
		
		deman.setVacacional(this);
		this.setCancelacion(date.plusDays(5));  
		return true;
	}
	
	/**
	 * @param deman demandante que cancela la oferta
	 * @param valor true si hay que bloquear al usuario y false si no es asi
	 * @return true si se realiza y false si no es asi
	 */
	 public boolean cancelar(Demandante deman, boolean valor) {
		 if(this != deman.getVacacional()) {
			 return false;
		 }
		 if(valor == true) {
			 this.addBloqueado(deman);
		 }
		 deman.setVacacional(null);
		 this.setDisp(Disponibilidad.DISPONIBLE);
		 this.setCancelacion(null);
		 return true; 
	 }
}
