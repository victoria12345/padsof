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
	public abstract boolean isBloqueado();
	
	/**
	 * @return true si puede false si no es asi
	 */
	public abstract boolean isOfertante();

	/**
	 * Annade un inmueble si el rol es ofertante
	 * @param i inmueble que se desea annadir
	 */
	public abstract void addInmueble(Inmueble i);
}
