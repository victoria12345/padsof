package excepciones;
/**
 * Definicion de la excepcion que se lanza si la oferta no esta disponible para la reserva 
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
public class OfertaNoDisponible extends Exception{
	private static final long serialVersionUID = 1L;
	
	public OfertaNoDisponible() {
		
	}
	
	public String toString() {
		return "Oferta no disponible";
	}
}
