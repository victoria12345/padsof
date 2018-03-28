/**
 * Definicion de la clase Sistema
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
import java.util.*;
import java.time.*;

public class Sistema {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	private List<Oferta> ofertas = new ArrayList<Oferta>();

	/**
	 * Constructor de Sistema
	 */
	public Sistema() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return los usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios nueva lista de usuarios
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		if(usuarios == null) {
			return;
		}
		this.usuarios = usuarios;
	}

	/**
	 * @return los inmuebles
	 */
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	/**
	 * @param inmuebles nueva lista de inmuebles
	 */
	public void setInmuebles(List<Inmueble> inmuebles) {
		if(inmuebles == null) {
			return;
		}
		this.inmuebles = inmuebles;
	}
	
	/**
	 * @return las ofertas
	 */
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	
	/**
	 * @param ofertas nueva lista de ofertas
	 */
	public void setOfertas(List<Oferta> ofertas) {
		if(ofertas == null) {
			return;
		}
		this.ofertas = ofertas;
	}
	/**
	 * Se busca un usuario en el sistema
	 * @param nick nick del usuario que se busca
	 * @param cont constraseņa del usuario
	 * @return null si no se encuentra y el usuario si lo hace
	 */
	public Usuario buscarUsuario(String nick, String cont){
		if(nick == null|| cont == null) {
			return null;
		}
		for(Usuario u : this.usuarios) {
			if(u.getNick() == nick && u.getContrasenia() == cont) {
				return u;
			}
		}
		return null;
	}
	
	/**
	 * REVISAAAAAAAAAAAAAAAR
	 * Se busca una oferta a traves de su descripcion
	 * @param desc descripcion de la oferta que se busca
	 * @return lista de las ofertas con esa descripcion
	 */
	public List<Oferta> buscarOferta(String desc) {
		if(desc == null) {
			return null;
		}
		
		List<Oferta> ofs = new ArrayList<Oferta>();
		
		for(Inmueble i : this.inmuebles) {
			for(Oferta o : i.getOfertas()) {
				if(o.getDesc() == desc) {
					ofs.add(o);
				}
			}
		}
		return ofs;
	}
	
	/**
	 * 
	 * @param cp codigo postal que busca el usuario
	 * @return lista de ofertas asociadas a un inmueble con ese cp
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public List<Oferta> filtrar_codigo(int cp) {
		List<Oferta> ofs = new ArrayList<Oferta>();
		
		for(Inmueble i: this.inmuebles) {
			if(i.getCodigoPostal() == cp) {
				ofs.addAll(i.getOfertas());
			}
		}
			
		return ofs;		
	}
	
	/**
	 * 
	 * @param precio precio maximo de las ofertas que se buscan
	 * @return lista de ofertas cuyo precio es menor o igual al indicado
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public List<Oferta> filtrar_precio(int precio) {
		if(precio < 0) {
			return null;
		}
		List<Oferta> ofs = new ArrayList<Oferta>();
		
		for(Oferta o: this.ofertas) {
			if(o.getPrecio() <=  precio) {
				ofs.add(o);
			}
		}
			
		return ofs;		
	}
	
	/**
	 * 
	 * @param valoracion valoracion minima de las ofertas que se buscan
	 * @return lista de ofertas cuya valoracion es mayor o igual 
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public List<Oferta> filtrar_valoracion(int valoracion) {
		if(valoracion <0) {
			return null;
		}
		List<Oferta> ofs = new ArrayList<Oferta>();
		
		for(Oferta o: this.ofertas) {
			if(o.getValoracion() <=  valoracion) {
				ofs.add(o);
			}
		}
			
		return ofs;		
	}
	
	/**
	 * 
	 * @param estado estado sobre la disponibilidad de la oferta
	 * @return lista de ofertas cuyo estado es el indicado
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public List<Oferta> filtrar_estado(Disponibilidad estado) {
		List<Oferta> ofs = new ArrayList<Oferta>();
		
		for(Oferta o: this.ofertas) {
			if(o.getDisp() ==  estado) {
				ofs.add(o);
			}
		}
			
		return ofs;		
	}
	
	/**
	 * Busca ofertas que esten entre dos fechas
	 * @param ini fecha inicial minima
	 * @param fin fecha final maxima
	 * @return lista de ofertas que cumplan esa caracteristica
	 */
	public List<Oferta> filtrar_fecha(LocalDate ini, LocalDate fin){
		List<Oferta> ofs = new ArrayList<Oferta>();
				
		for(Oferta o: this.ofertas) {
			if(o.getIni().isAfter(ini) == true && o.getFin().isBefore(fin) == true) {
				ofs.add(o);
			}
		}
			
		return ofs;	
	}
	
	/**
	 * Ordena las ofertas segun su precio
	 * @param ofertas liasta de ofertas a ordenar
	 * en caso de que sea null se ordenaran todas las ofertas del sistema
	 * @param orden 1 si quieres de menor a mayor y 0 si quieres de mayor a menor
	 * @return lista de las ofertas ordenadas
	 */
	public List<Oferta> ordenar_precio(List<Oferta> ofertas, int orden){
		List<Oferta> ofs = new ArrayList<Oferta>();
		if(orden != 0 && orden != 1) {
			return null;
		}
		
		if (orden == 0) { //precio de mayor a menor
			if(ofertas == null) {
				ofertas = this.ofertas;
			}
			
			for(int i = 0; i < ofertas.size(); i++){
				Oferta max = ofertas.get(i);
				for(int j = i+1; j < ofertas.size(); j++) {
					if(max.getPrecio() < ofertas.get(j).getPrecio()) {
						max = ofertas.get(j);
					}
				}
				ofs.add(max);
			}
		}else {
			if(ofertas == null) {
				ofertas = this.ofertas;
			}
			
			for(int i = 0; i < ofertas.size(); i++){
				Oferta min = ofertas.get(i);//de menor a mayor
				for(int j = i+1; j < ofertas.size(); j++) {
					if(min.getPrecio() < ofertas.get(j).getPrecio()) {
						min = ofertas.get(j);
					}
				}
				ofs.add(min);
			}
		}
		
		return ofs;
	}
	
	/**
	 * Devuelve una lista de usuarios. Los buscara bloqueados  
	 * o no segun el parametro introducido
	 * Se debe tener en cuenta que si se buscan usuarios no bloqueados
	 * siempre se devolvera el administrador
	 * 
	 * @param bloq el estado de bloqueo que interesa
	 * @return lista de usuarios con ese estado
	 */
	public List<Usuario> buscarUsuariosBloqueado(boolean bloq){
		List<Usuario> uss = new ArrayList<Usuario>();
		for(Usuario u: usuarios) {
			if(u.isBloqueado() == bloq) {
				uss.add(u);
			}
		}
		return uss;
	}

}
