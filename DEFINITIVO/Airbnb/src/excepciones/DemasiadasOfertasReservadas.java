package excepciones;

public class DemasiadasOfertasReservadas extends Exception{
	private static final long serialVersionUID = 1L;
	
	public DemasiadasOfertasReservadas() {
		
	}
	
	public String toString() {
		return "Demasiadas ofertas reservadas";
	}
}
