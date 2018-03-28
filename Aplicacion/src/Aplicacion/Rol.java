/**
 * Definicion de la clase abstracta Rol
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public abstract class Rol {

	/**
	 * Constructor de Rol
	 */
	public Rol() {
		
	}
	
	/**
	 * @return estado bloqueado, en este caso siempre false
	 */
	public boolean isBloqueado() {
		return false;
	}

}
