import java.time.*;
public class OfertaResidencial extends Oferta {
	private int nmeses;

	public OfertaResidencial(double precio, LocalDate ini, int nmeses) {
		super(precio, ini);
		this.nmeses = nmeses;
	}
	
	public int getNmeses() {
		return nmeses;
	}
	
	public void setNmeses(int nmeses) {
		this.nmeses = nmeses;
	}
}
