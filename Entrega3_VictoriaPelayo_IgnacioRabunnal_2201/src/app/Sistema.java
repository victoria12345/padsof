package app;
import java.util.*;

import excepciones.*;
import inmuebles.Inmueble;
import ofertas.*;
import usuarios.*;

import java.io.*;
import java.time.*;

/**
 * Definicion de la clase Sistema
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
public class Sistema implements Serializable{
	private static final long serialVersionUID = 1L;
	private Usuario admin = new Usuario("admin", "Roberto", "Latorre", "admin");
	private Usuario uActual = null;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	private List<Oferta> ofertas = new ArrayList<Oferta>();
	private List<Oferta> pendientes = new ArrayList<Oferta>();
	private List<Oferta> filtradas = new ArrayList<Oferta>();

	/**
	 * Constructor de Sistema
	 * @throws ArgumentoNoValido si hay algun fallo en los argumentos
	 * @throws IOException si no encuentra el fichero usuarios.txt
	 */
	public Sistema() throws IOException, ArgumentoNoValido{
		List<Rol> rol = new ArrayList<Rol>();
		File usuarios = new File("usuarios.txt");
		this.cargarUsuarios(usuarios.getAbsolutePath());
		rol.add(new Administrador());
		admin.setRoles(rol);
	}
	
	/**
	 * @return pendientes lista de ofertas pendientes
	 */
	public List<Oferta> getPendientes() {
		return pendientes;
	}
	
	/**
	 * @param pendientes lista de ofertas pendientes de aceptacion
	 */
	public void setPendientes(List<Oferta> pendientes) {
		this.pendientes = pendientes;
	}
	
	/**
	 * Añade una oferta a la lista de pendientes de aceptar
	 * @param o oferta a añadir a la lista de pendientes
	 */
	public void addPendiente(Oferta o) {
		if(o == null ||pendientes.contains(o) == true) {
			return;
		}
		pendientes.add(o);
		o.setEstado(Estado.PENDIENTE);
		o.setCancelacion(null);
	}
	
	/**
	 * Añade una oferta a la lista total de ofertas
	 * @param o oferta a añadir a la lista total de ofertas
	 */
	public void addOferta(Oferta o) {
		if(o == null ||ofertas.contains(o) == true) {
			return;
		}
		ofertas.add(o);
	}
	
	/**
	 * Añade una rectificacion a realizar por la oferta
	 * @param o oferta a la que queremos añadir una rectificacion
	 * @param s rectificacion a añadir
	 * @param date fecha maxima para realizar la rectificacion
	 */
	public void rectificar(Oferta o, String s, LocalDate date) {
		if(o == null || pendientes.contains(o) == false || o.getEstado() == Estado.ACEPTADA) {
			return;
		}
		o.setRectificacion(s);
		o.setCancelacion(date);
		pendientes.remove(o);
	}
	
	/**
	 * Acepta una oferta de la lista de pendientes
	 * @param o oferta que queremos aceptar
	 */
	public void aceptarOferta(Oferta o) {
		if(o == null ||pendientes.contains(o) == false) {
			return;
		}
		pendientes.remove(o);
		o.setEstado(Estado.ACEPTADA);
		o.setCancelacion(null);
	}
	
	/**
	 * Rechaza una oferta de la lista de pendientes
	 * @param o oferta que queremos rechazar
	 */
	public void cancelarOferta(Oferta o) {
		if(o == null || pendientes.contains(o) == false) {
			return;
		}
		pendientes.remove(o);
		o.setEstado(Estado.RECHAZADA);
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
	 * @return uActual el usuario logeado en el sistema
	 */
	public Usuario getUsuarioActual() {
		return uActual;
	}
	
	/**
	 * Se busca un usuario en el sistema
	 * @param nick nick del usuario que se busca
	 * @param cont constrasenna del usuario
	 * @return null si no se encuentra y el usuario si lo hace
	 */
	public Usuario buscarUsuario(String nick, String cont){
		if(nick == null|| cont == null) {
			return null;
		}
		for(Usuario u : this.getUsuarios()) {
			System.out.println(u);
			if(nick == u.getNick() && cont == u.getContrasenia()) {
				System.out.println("Holaxd");
				return u;
			}
		}
		return null;
	}
	
	/**
	 * login de un usuario en el sistema
	 * @param nick nick del usuario que hace login
	 * @param cont contraseña del usuario que hace login
	 * @throws ArgumentoNoValido si el nick o la contraseña son null
	 * @throws HayOtroUsuarioLogeado si ya hay un usuario logeado en el sistema
	 * @throws UsuarioNoEncontrado si no existe un usuario registrado con el nick y la contraseña dados
	 */
	public void login(String nick, String cont) throws ArgumentoNoValido, HayOtroUsuarioLogeado, UsuarioNoEncontrado {
		if(nick == null || cont == null) {
			throw new ArgumentoNoValido();
		}
		
		if(uActual != null) {
			throw new HayOtroUsuarioLogeado();
		}
		
		if(nick == "admin" && cont == "admin") {
			uActual = admin;
			return;
		}
		
		uActual = this.buscarUsuario(nick, cont);
		if(uActual == null) {
			throw new UsuarioNoEncontrado();
		}
		return;
	}
	
	
	/**
	 * logout del usuario actual en el sistema
	 */
	public void logout() {
		this.uActual = null;
	}
	
	/**
	 * se busca una oferta
	 * @param of oferta que se quiere buscar
	 * @return o la oferte si esta es encontrada y null en caso contrario
	 */
	public Oferta buscarOferta(Oferta of) {
				
		for(Oferta o : this.ofertas) {
			
			if(o.equals(of) == true) {
				return o;
			}
			
		}
		return null;
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
		this.setFiltradas(ofs);	
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
		this.setFiltradas(ofs);	
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
			if(o.getValoracion() >=  valoracion) {
				ofs.add(o);
			}
		}
		this.setFiltradas(ofs);	
		return ofs;		
	}
	
	/**
	 * 
	 * @param estado estado sobre la disponibilidad de la oferta
	 * @return lista de ofertas cuyo estado es el indicado
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public List<Oferta> filtrar_disp(Disponibilidad estado) {
		List<Oferta> ofs = new ArrayList<Oferta>();
		
		for(Oferta o: this.ofertas) {
			if(o.getDisp() ==  estado) {
				ofs.add(o);
			}
		}
		this.setFiltradas(ofs);	
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
		
		this.setFiltradas(ofs);
			
		return ofs;	
	}
	
	/**
	 * Ordena las ofertas segun su precio
	 * @param ofertas lista de ofertas a ordenar en caso de que sea null se ordenaran todas las ofertas del sistema
	 * @param orden 0 si quieres de menor a mayor y 1 si quieres de mayor a menor
	 */
	public void ordenar_precio(List<Oferta> ofertas, int orden){
		if(orden != 0 && orden != 1) {
			return;
		}
		
		if (orden == 0) { //precio de menor a mayor
			if(ofertas == null) {
				ofertas = this.ofertas;
			}
			
			for(int i = 0; i < ofertas.size(); i++){
				for(int j = 1; j < (ofertas.size()-i); j++) {
					if(ofertas.get(j-1).getPrecio() > ofertas.get(j).getPrecio()) {
						Collections.swap(ofertas, j-1, j);
					}
				}
			}
		}else {//precio de mayor a menor
			if(ofertas == null) {
				ofertas = this.ofertas;
			}
			
			for(int i = 0; i < ofertas.size(); i++){
				for(int j = 1; j < (ofertas.size()-i); j++) {
					if(ofertas.get(j-1).getPrecio() < ofertas.get(j).getPrecio()) {
						Collections.swap(ofertas, j-1, j);
					}
				}
			}
		}
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
	
	/**
	 * Carga los usuarios en el sistema leidos desde un fichero
	 * @param fichero nombre del fichero donde estan los usuarios
	 * @throws IOException si no encuentra el fichero de carga de usuarios
	 * @throws ArgumentoNoValido si hay algun fallo de argumentos en el metodo
	 */
	public void cargarUsuarios(String fichero) throws IOException, ArgumentoNoValido {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));
		String linea;
		String nick, rol, nombre, apellidos, tarjeta, contrasenia;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		int i = 0;

		while((linea = buffer.readLine()) != null){
			if(i == 0){ //nos saltamos la cabecera
				i = 1;
			}else{
				List<Rol> roles = new ArrayList<Rol>();
				Usuario u;
				String trozos[] = linea.split(";");
				String fullname[] = trozos[2].split(", "); //Dividimos fullname en dos trozos(nombre y apellido)
				
				rol = trozos[0];
				nick = trozos[1];
				nombre = fullname[1];
				apellidos = fullname[0];
				contrasenia = trozos[3];
				tarjeta = trozos[4];

				u = new Usuario(nick, nombre, apellidos, contrasenia);

				switch(rol) {
				case "D":
					roles.add(new Demandante(tarjeta));
				case "O":
					roles.add(new Ofertante(tarjeta));
				case "OD":
					roles.add(new Demandante(tarjeta));
					roles.add(new Ofertante(tarjeta));
				}
				
				u.setRoles(roles);
				usuarios.add(u);
			}

			
		}

		buffer.close();
		this.setUsuarios(usuarios);
	}
	
	/**
	 * Comprueba las ofertas reservadas y pendientes de rectificacion que tienen que ser canceladas
	 * @param date fecha en la que se comprueban las ofertas
	 */
	private void comprobarOfertas(LocalDate date) throws ArgumentoNoValido {
		//Primero comprobamos las ofertas en estado de rectificacion
		
		for(Usuario u: usuarios) {
			List<Rol> roles = u.getRoles();
			for(Rol r: roles) {
				if (r.isDemandante() == true) {
					Demandante rol = (Demandante) r;
					OfertaResidencial res = rol.getResidencial();
					OfertaVacacional vac = rol.getVacacional();
					
					if(res != null) {
						if(res.getCancelacion().isBefore(date) == true) {
							//Si se bloquea la oferta se cancela el usuario
							res.addBloqueado(rol);
							//la oferta pasa de nuevo a disponible
							res.setDisp(Disponibilidad.DISPONIBLE);
							//el usuario ya no tiene esa reserva
							rol.setResidencial(null);
						}
					}
					
					if(vac != null) {
						if(vac.getCancelacion().isBefore(date) == true) {
							//Si se bloquea la oferta se cancela el usuario
							vac.addBloqueado(rol);
							//la oferta pasa de nuevo a disponible
							vac.setDisp(Disponibilidad.DISPONIBLE);
							//el usuario ya no tiene esa reserva
							rol.setResidencial(null);
						}
					}
				}
				if(r.isOfertante() == true) {
					Ofertante rol = (Ofertante)r;
					for(Inmueble in: rol.getInmuebles()) {
						for(Oferta o: in.getOfertas()) {
							LocalDate cancelacion = o.getCancelacion();
							if(o.getEstado() == Estado.RECTIFICADA && cancelacion.isBefore(date)) {
								if(pendientes.contains(o) == true) {
									pendientes.remove(o);
								}
								o.setEstado(Estado.RECHAZADA);
							}	
						
						}
					}
				}
			}
		}
	}
	
	/**
	 * Serializa el sistema
	 * @throws IOException si no encuentra el archivo sistema.ser
	 */
	public void serializar() throws IOException{
		FileOutputStream fsalida = new FileOutputStream("sistema.ser");
		ObjectOutputStream objsal = new ObjectOutputStream(fsalida);
		objsal.writeObject(this);
		objsal.close();
		fsalida.close();
	}
	
	/**
	 * Deserializa el sistema y comprueba las ofertas y reservas que tienen que ser canceladas
	 * @param date fecha en la que se deserializa el sistema
	 * @return sist el sistema recien deserializado
	 * @throws ArgumentoNoValido si hay algun fallo con los argumentos
	 * @throws IOException si no encuentra el archivo sistema.ser
	 * @throws ClassNotFoundException xd
	 */
	public Sistema deserializar(LocalDate date) throws IOException, ClassNotFoundException, ArgumentoNoValido{
			Sistema sist = new Sistema();
			FileInputStream fentrada = new FileInputStream("sistema.ser");
			ObjectInputStream objent = new ObjectInputStream(fentrada);
			sist = (Sistema) objent.readObject();
			sist.comprobarOfertas(date);
			objent.close();
			fentrada.close();
			return sist;
		
	}

	/**
	 * @return the filtradas
	 */
	public List<Oferta> getFiltradas() {
		return filtradas;
	}

	/**
	 * @param filtradas the filtradas to set
	 */
	public void setFiltradas(List<Oferta> filtradas) {
		if(filtradas == null) {
			return;
		}
		this.filtradas = filtradas;
	}

	/**
	 * @return el adiministrador del sistema
	 */
	public Usuario getAdmin() {
		return admin;
	}
}
