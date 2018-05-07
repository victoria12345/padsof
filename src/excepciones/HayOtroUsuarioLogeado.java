package excepciones;
/**
 * Definicion de la excepcion que se lanza si un usuario intenta hacer login cuando ya hay otro usuario en el sistema 
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
public class HayOtroUsuarioLogeado extends Exception{
	private static final long serialVersionUID = 1L;
	
	public HayOtroUsuarioLogeado() {

	}

	public String toString() {
		return "Hay otro usuario en el sistema";
	}
}
