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
	
	public List<Usuario> getBloqueados() {
		return bloqueados;
	}

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
	
	public void addBloqueado(Usuario u) throws ArgumentoNoValido{
		if(bloqueados.contains(u) == true) {
			throw new ArgumentoNoValido();
		}
		bloqueados.add(u);
	}
	
	public void delBloqueado(Usuario u) throws ArgumentoNoValido{
		if(bloqueados.contains(u) == false) {
			throw new ArgumentoNoValido();
		}
		bloqueados.remove(u);
	}
	
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


	public boolean isDemandante() {
		return false;
	}


}
