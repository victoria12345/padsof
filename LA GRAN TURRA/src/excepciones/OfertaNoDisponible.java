package excepciones;

public class OfertaNoDisponible extends Exception{
	private static final long serialVersionUID = 1L;
	
	public OfertaNoDisponible() {
		
	}
	
	public String toString() {
		return "Oferta no disponible";
	}
}
