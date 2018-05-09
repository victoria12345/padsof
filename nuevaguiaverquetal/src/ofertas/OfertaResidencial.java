package ofertas;
import java.time.*;
import java.util.List;

import excepciones.*;
import usuarios.Demandante;
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
	 * @throws ArgumentoNoValido si el numero de meses es menor que uno
	 */
	public void setNmeses(int nmeses) throws ArgumentoNoValido{
		if(nmeses < 1) {
			throw new ArgumentoNoValido();
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
	 * @throws UsuarioBloqueado si el usuario que intenta reservar la oferta esta bloqueado
	 * @throws OfertaNoDisponible si la oferta esta ya reservada o no esta aceptada por el admin
	 * @throws DemasiadasOfertasReservadas si el usuario que intenta reservar la oferta ya tiene otra reservada
	 */
	public void reservar(Demandante deman, LocalDate date) throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas{
		List<Demandante> bloqueados = this.getBloqueados();
		if(bloqueados.contains(deman) == true) {
			throw new UsuarioBloqueado();
		}
		if(this.getDisp() == Disponibilidad.RESERVADA) {
			throw new OfertaNoDisponible();
		}
		if(deman.getResidencial() != null) {
			throw new DemasiadasOfertasReservadas();
		}
		if(this.getEstado() != Estado.ACEPTADA) {
			throw new OfertaNoDisponible();
		}
		
		deman.setResidencial(this);
		this.setDisp(Disponibilidad.RESERVADA);
		this.setCancelacion(date.plusDays(5));  
	}
	
	/**
	 * Cancela la reserva de una oferta
	 * @param deman demandante que cancela la oferta
	 * @param valor true si hay que bloquear al usuario y false si no es asi
	 * @throws ArgumentoNoValido si el demandante no es el que ha reservado la oferta
	 */
	 public void cancelar(Demandante deman, boolean valor) throws ArgumentoNoValido{
		 if(this != deman.getResidencial()) {
			 throw new ArgumentoNoValido();
		 }
		 if(valor == true) {
			 this.addBloqueado(deman);
		 }
		 deman.setResidencial(null);
		 this.setDisp(Disponibilidad.DISPONIBLE);
		 this.setCancelacion(null);
	 }
	 
	/**
	 * Calcula el precio total de una oferta
	 * @return el precio total de la oferta
	 */
	 public double calcularPrecio() {
		 return this.getPrecio()*nmeses;
	 }
	 
		/**
		 * Comprueba si la oferta es residencial
		 * @return true
		 */
	 public boolean isResidencial() {
		 return true;
	 }
	 
	 /**
		 * Comprueba si la oferta es vacacional
		 * @return false
		 */
	 public boolean isVacacional() {
		 return false;
	 }
}
