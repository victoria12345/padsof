package Ofertas;
import java.time.*;
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
	
	public boolean equals(Object o) {
		if(!(o instanceof OfertaVacacional)) {
			return false;
		}
		OfertaVacacional ofer = (OfertaVacacional) o;
		return this.getDesc().equals(ofer.getDesc()) && 
				this.getIni().equals(ofer.getIni()) &&
				this.getFin().equals(ofer.getFin()) &&
				this.getPrecio() == ofer.getPrecio();
	}

}
