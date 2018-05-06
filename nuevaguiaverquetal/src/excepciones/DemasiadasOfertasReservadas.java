package excepciones;
/**
 * Definicion de la excepcion que se lanza si el demandante intenta reservar mas ofertas de las que puede
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
public class DemasiadasOfertasReservadas extends Exception{
	private static final long serialVersionUID = 1L;
	
	public DemasiadasOfertasReservadas() {
		
	}
	
	public String toString() {
		return "Demasiadas ofertas reservadas";
	}
}
