package excepciones;

public class HayOtroUsuarioLogeado extends Exception{
	private static final long serialVersionUID = 1L;
	
	public HayOtroUsuarioLogeado() {

	}

	public String toString() {
		return "Hay otro usuario en el sistema";
	}
}
