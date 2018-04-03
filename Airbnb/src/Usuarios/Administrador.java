package Usuarios;
import java.util.ArrayList;
import java.util.List;

import Inmuebles.Inmueble;
import Ofertas.Oferta;
/**
 * Descripcion de la clase Administrador
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Administrador extends Rol{
	private static final long serialVersionUID = 1L;
	public List<Oferta> pendientes = new ArrayList<Oferta>();
	public List<Usuario> bloqueados = new ArrayList<Usuario>();
	/**
	 * Constructor de la clase Administrador
	 */
	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Oferta> getPendientes() {
		return pendientes;
	}

	public void setPendientes(List<Oferta> pendientes) {
		this.pendientes = pendientes;
	}

	public List<Usuario> getBloqueados() {
		return bloqueados;
	}

	public void setBloqueados(List<Usuario> bloqueados) {
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
	 * No hace nada
	 */
	public void addInmueble(Inmueble i) {
		
	}
	
	public boolean isDemandante() {
		return false;
	}
	
	public void addPendiente(Oferta o) {
		if(pendientes.contains(o) == true) {
			return;
		}
		pendientes.add(o);
	}
	
	public void delPendiente(Oferta o) {
		if(pendientes.contains(o) == false) {
			return;
		}
		pendientes.remove(o);
	}
	
	public void addBloqueado(Usuario u) {
		if(bloqueados.contains(u) == true) {
			return;
		}
		bloqueados.add(u);
	}
	
	public void delBloqueado(Usuario u) {
		if(bloqueados.contains(u) == false) {
			return;
		}
		bloqueados.remove(u);
	}
	
	public void cambiarTarjeta(Usuario u, String tarjeta) {
		Demandante d = null;
		if(bloqueados.contains(u) == false) {
			return;
		}
		for(Rol r: u.getRoles()) {
			if(r.isDemandante() == true) {
				d = (Demandante) r;
				d.setTarjeta(tarjeta);
			}
		}
	}


	

}
