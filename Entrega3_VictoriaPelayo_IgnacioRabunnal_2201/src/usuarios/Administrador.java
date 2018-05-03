package usuarios;
import java.util.ArrayList;
import java.util.List;

import excepciones.ArgumentoNoValido;

/**
 * Descripcion de la clase Administrador
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Administrador extends Rol{
	private static final long serialVersionUID = 1L;
	private List<Usuario> bloqueados = new ArrayList<>();
	/**
	 * Constructor de la clase Administrador
	 */
	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return la lista de usuarios bloqueados
	 */
	public List<Usuario> getBloqueados() {
		return bloqueados;
	}
	
	/**
	 * @param bloqueados lista de usuarios bloqueados
	 * @throws ArgumentoNoValido si la lista de bloqueados es null
	 */
	public void setBloqueados(List<Usuario> bloqueados) throws ArgumentoNoValido{
		if(bloqueados == null) {
			throw new ArgumentoNoValido();
		}
		this.bloqueados = bloqueados;
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
	 * Añade un usuario a la lista de bloqueados
	 * @param u usuario a añadir a la lista de bloqueados
	 * @throws ArgumentoNoValido si la lista de bloqueados ya contiene al usuario
	 */
	public void addBloqueado(Usuario u) throws ArgumentoNoValido{
		if(bloqueados.contains(u) == true) {
			throw new ArgumentoNoValido();
		}
		bloqueados.add(u);
	}
	
	/**
	 * Elimina un usuario de la lista de bloqueados
	 * @param u usuario a eliminar de la lista de bloqueados
	 * @throws ArgumentoNoValido si la lista de bloqueados no contiene al usuario
	 */
	public void delBloqueado(Usuario u) throws ArgumentoNoValido{
		if(bloqueados.contains(u) == false) {
			throw new ArgumentoNoValido();
		}
		bloqueados.remove(u);
	}
	
	/**
	 * Cambia la tarjeta de crédito de un usuario
	 * @param u usuario cuya tarjeta se puede cambiar
	 * @param tarjeta nueva tarjeta del usuario
	 * @throws ArgumentoNoValido si la lista de bloqueados no contiene al usuario
	 */
	public void cambiarTarjeta(Usuario u, String tarjeta) throws ArgumentoNoValido{
		Demandante d = null;
		if(bloqueados.contains(u) == false) {
			throw new ArgumentoNoValido();
		}
		for(Rol r: u.getRoles()) {
			if(r.isDemandante() == true) {
				d = (Demandante) r;
				d.setTarjeta(tarjeta);
			}
		}
	}

	/**
	 * Devuelve si es demandante
	 * @return false
	 */
	public boolean isDemandante() {
		return false;
	}
	
	/**
	 * Devuelve si es administrador
	 * @return true
	 */
	public boolean isAdmin() {
		return true;
	}


}
