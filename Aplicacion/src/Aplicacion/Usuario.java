package Aplicacion;

import java.util.*;

/**
 * Definicion de la clase Usuario
 * 
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Usuario {
	private String dni;
	private String contrasenna;
	private List<Rol> rol = new ArrayList<Rol>();
	
	/**
	 * @return the rol
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public List<Rol> getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}

	public Usuario(String dni, String contrasenna){
		this.dni = dni;
		this.contrasenna = contrasenna;
	}

	/**
	 * @return the dni
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the contrasenna
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public String getContrasenna() {
		return contrasenna;
	}

	/**
	 * @param contrasenna the contrasenna to set
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	
}
