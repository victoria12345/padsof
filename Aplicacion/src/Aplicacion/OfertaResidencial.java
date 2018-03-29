import java.time.*;
import java.util.Calendar;
import java.util.Date;
/**
 * Descripcion clase OfertaResidencial
 * @author Victoria Pelayo e Ignacio Rabunnal
 */

public class OfertaResidencial extends Oferta {
	
	private static final long serialVersionUID = 1L;
	private int nmeses;

	/**
	 * Cosntructor OfertaResidencial
	 * @param id identificador de la oferta
	 * @param precio precio de la oferta
	 * @param ini fecha inicio de la oferta
	 * @param nmeses numero de meses que dura la oferta
	 */
	public OfertaResidencial(int id, double precio, LocalDate ini, int nmeses) {
		super(id,precio, ini);
		if(nmeses < 1) { //como minimo debe ser 1 mes de oferta
			this.nmeses = 1;
		}
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
			return;
		}
		this.nmeses = nmeses;
	}
	
	/**
	 * Devuelve la fecha final de la oferta
	 * @return fin fecha final de la oferta
	 */
	public LocalDate getFin() {
		Calendar calendario = Calendar.getInstance();
		Date date = Date.from(getIni().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		LocalDate fin;
		
		calendario.setTime(date);
		calendario.add(Calendar.MONTH,  nmeses);
		fin = Instant.ofEpochMilli(calendario.getTime().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		
		return fin;
		
	}
}
