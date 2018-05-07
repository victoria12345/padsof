package excepciones;
/**
 * Definicion de la excepcion que se lanza si un usuario intenta hacer login y no se encuentra entre los registrados 
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
public class UsuarioNoEncontrado extends Exception{
	
	private static final long serialVersionUID = 1L;

	public UsuarioNoEncontrado() {
		
	}
	
	public String toString() {
		return "No se ha encontrado el usuario";
	}

}
