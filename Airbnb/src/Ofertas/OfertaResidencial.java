package Ofertas;
import java.time.*;
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
		}
		System.out.println(this.nmeses);
		this.nmeses = nmeses;
		
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
	
	public boolean equals(Object o) {
		if(!(o instanceof OfertaResidencial)) {
			return false;
		}
		OfertaResidencial ofer = (OfertaResidencial) o;
		return this.getDesc().equals(ofer.getDesc()) && 
				this.getIni().equals(ofer.getIni()) &&
				this.getPrecio() == ofer.getPrecio() &&
				this.getNmeses() == ofer.getNmeses();
	}
}
