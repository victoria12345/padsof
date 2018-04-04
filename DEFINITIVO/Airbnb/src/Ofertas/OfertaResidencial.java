package Ofertas;
import java.time.*;
import java.util.List;

import Usuarios.Demandante;
/**
 * Descripcion clase OfertaResidencial
 * @author Victoria Pelayo e Ignacio Rabunnal
 */

public class OfertaResidencial extends Oferta {
	
	private static final long serialVersionUID = 1L;
	private int nmeses;

	/**
	 * Cosntructor OfertaResidencial
	 * @param precio precio de la oferta
	 * @param ini fecha inicio de la oferta
	 * @param nmeses numero de meses que dura la oferta
	 */
	public OfertaResidencial(double precio, LocalDate ini, int nmeses) {
		super(precio, ini);
		
		if(nmeses < 1) { //como minimo debe ser 1 mes de oferta
			this.nmeses = 1;
		}else {
			this.nmeses = nmeses;
		}
	}
	
	/**
	 * @return numero de meses que dura la oferta
	 */
	public int getNmeses() {
		return nmeses;
	}
	
	/**
	 * @param nmeses nuevo numero de meses que dura la oferta
	 */
	public void setNmeses(int nmeses) {
		if(nmeses < 1) {
			this.nmeses = 1;
			return;
		}
		this.nmeses = nmeses;
	}
	
	/**
	 * Devuelve la fecha final de la oferta
	 * @return fin fecha final de la oferta
	 */
	public LocalDate getFin() {
		return this.getIni().plusMonths(nmeses);
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
		if(deman.getResidencial() != null) {
			return false;
		}
		
		deman.setResidencial(this);
		this.setCancelacion(date.plusDays(5));  
		return true;
	}
	
	/**
	 * @param deman demandante que cancela la oferta
	 * @param valor true si hay que bloquear al usuario y false si no es asi
	 * @return true si se realiza y false si no es asi
	 */
	 public boolean cancelar(Demandante deman, boolean valor) {
		 if(this != deman.getResidencial()) {
			 return false;
		 }
		 if(valor == true) {
			 this.addBloqueado(deman);
		 }
		 deman.setResidencial(null);
		 this.setDisp(Disponibilidad.DISPONIBLE);
		 this.setCancelacion(null);
		 return true; 
	 }

}
