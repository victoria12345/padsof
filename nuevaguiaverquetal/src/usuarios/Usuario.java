package usuarios;
import java.util.*;

import excepciones.ArgumentoNoValido;

import java.io.*;
/**
 * Descripcion de la clase Usuario
 * @author Victoria Pelayo e Ignacio Rabunnal
 */

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nick;
	private String nombre;
	private String apellido;
	private String contrasenia;
	private List<Rol> roles = new ArrayList<Rol>();
	
	/**
	 * Cosntructor de usuario
	 * @param nick nick del usuario
	 * @param nombre numbre del usuario
	 * @param apellido apellido del usuario
	 * @param contrasenia constrasenia del usuario
	 */
	public Usuario(String nick, String nombre, String apellido, String contrasenia) {
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
	}

	/**
	 * @return el nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick nuevo nick del usuario
	 * @throws ArgumentoNoValido si el nick es null
	 */
	public void setNick(String nick) throws ArgumentoNoValido{
		if(nick == null) {
			throw new ArgumentoNoValido();
		}
		this.nick = nick;
	}

	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre nuevo nombre del usuario
	 * @throws ArgumentoNoValido si el nombre es null
	 */
	public void setNombre(String nombre) throws ArgumentoNoValido{
		if(nombre == null) {
			throw new ArgumentoNoValido();
		}
		this.nombre = nombre;
	}

	/**
	 * @return el apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido nuevo apellido del usuario
	 * @throws ArgumentoNoValido si el apellido es null
	 */
	public void setApellido(String apellido) throws ArgumentoNoValido{
		if(apellido == null) {
			throw new ArgumentoNoValido();
		}
		this.apellido = apellido;
	}

	/**
	 * @return la contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia nueva constrasenia 
	 * @throws ArgumentoNoValido si la contraseña es null
	 */
	public void setContrasenia(String contrasenia) throws ArgumentoNoValido{
		if(contrasenia == null) {
			throw new ArgumentoNoValido();
		}
		this.contrasenia = contrasenia;
	}


	/**
	 * @return los roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}

	/**
	 * @param roles nueva lista de roles
	 * @throws ArgumentoNoValido si la lista de roles es null
	 */
	public void setRoles(List<Rol> roles) throws ArgumentoNoValido{
		if(roles == null) {
			throw new ArgumentoNoValido();
		}
		this.roles = roles;
	}
	
	/**
	 * Sirve para saber si un usuario esta bloqueado
	 * Solo puede estar bloqueado el rol de demandante
	 * @return true si el usuario esta bloqueado y false si no es asi
	 */
	public boolean isBloqueado() {
		for(int i = 0; i < roles.size(); i++) {
			if(roles.get(i).isBloqueado() == true) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Crea un string con la informacion del usuario
	 * @return usuario String con la informacion del usuario
	 */
	public String toString() {
		String usuario = "Nombre: " + this.getNombre() +
						 "\nApellido: " + this.getApellido() +
						 "\nNick: " + this.getNick()+
						 "\nBloqueado:" + this.isBloqueado();
		return usuario;
						
	}
	
	

}
