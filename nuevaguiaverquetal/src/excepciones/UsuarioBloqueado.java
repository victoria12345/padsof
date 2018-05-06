package excepciones;
/**
 * Definicion de la excepcion que se lanza si un usuario intenta reservar una oferta estando bloqueado
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
public class UsuarioBloqueado extends Exception{
	private static final long serialVersionUID = 1L;
	
	public UsuarioBloqueado() {
		
	}
	
	public String toString() {
		return "Usuario bloqueado";
	}
}
