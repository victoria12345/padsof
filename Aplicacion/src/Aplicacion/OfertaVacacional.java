import java.time.*;
public class OfertaVacacional extends Oferta {
	private LocalDate fin;
	private double fianza;

	public OfertaVacacional(double precio, LocalDate ini, LocalDate fin, double fianza) {
		super(precio, ini);
		this.fin = fin;
		this.fianza = fianza;
	}

	/**
	 * @return the fin
	 */
	public LocalDate getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	/**
	 * @return the fianza
	 */
	public double getFianza() {
		return fianza;
	}

	/**
	 * @param fianza the fianza to set
	 */
	public void setFianza(double fianza) {
		this.fianza = fianza;
	}

}
