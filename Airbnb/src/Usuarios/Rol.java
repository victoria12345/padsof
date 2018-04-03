package Usuarios;
import java.io.*;

/**
 * Definicion de la clase abstracta Rol
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public abstract class Rol implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de Rol
	 */
	public Rol() {
		
	}
	
	/**
	 * @return estado bloqueado, en este caso siempre false
	 */
	public abstract boolean isBloqueado();
	
	/**
	 * @return true si puede false si no es asi
	 */
	public abstract boolean isOfertante();

	
	public abstract boolean isDemandante();
	
}
