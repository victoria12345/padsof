package usuarios;
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
	 * @return true si el rol es ofertante y false en caso contrario
	 */
	public abstract boolean isOfertante();

	/**
	 * @return true si el rol es demandante y false en caso contrario
	 */
	public abstract boolean isDemandante();
	
	/**
	 * @return true si el rol es administrador y false en caso contrario
	 */
	public abstract boolean isAdmin();
	
}
