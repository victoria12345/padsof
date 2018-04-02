/**
 * Descripcion de la clase Administrador
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Administrador extends Rol{

	/**
	 * Constructor de la clase Administrador
	 */
	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Informa sobre si el usuario tipo administrador esta bloqueado
	 * Nunca lo esta luego siempre devolvera false
	 * @return false
	 */
	public boolean isBloqueado() {
		return false;
	}
	
	/**
	 * Devuelve si es ofertante
	 * @return false
	 */
	public boolean isOfertante() {
		return false;
	}
	
	/**
	 * No hace nada
	 */
	public void addInmueble(Inmueble i) {
		
	}

}
