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
	 * @param nombre nuevo nombre del usuairo
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
	 * 
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
	
	public String toString() {
		String usuario = "Usuario:\n" +
						 "Nombre:" + this.getNombre() + "\n" +
						 "Apellido:" + this.getApellido() + "\n" +
						 "Nick" + this.getNick();
		return usuario;
						
	}
	
	

}
