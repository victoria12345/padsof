import java.util.*;

public class Sistema {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the inmuebles
	 */
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	/**
	 * @param inmuebles the inmuebles to set
	 */
	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public Sistema() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario buscarUsuario(String nick, String cont){
		for(Usuario u : this.usuarios) {
			if(u.getNick() == nick && u.getContrasenia() == cont) {
				return u;
			}
		}
		return null;
	}
	
	public Oferta buscarOferta(String desc) {
		for(Inmueble i : this.inmuebles) {
			for(Oferta o : i.getOfertas()) {
				if(o.getDesc() == desc) {
					return o;
				}
			}
		}
		return null;
	}
	



}
