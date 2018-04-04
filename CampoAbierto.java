package Inmuebles;
import java.io.*;

import Excepciones.ArgumentoNoValido;

/**
 * Descripcion de la clase campo abierto
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class CampoAbierto implements Serializable {
	public static final long serialVersionUID = 1L;
	private String clave;
	private String valor;
	
	/**
	 * Constructor de la clase campo abierto
	 * @param clave clave del nuevo campo
	 * @param valor el valor del campo
	 */
	public CampoAbierto(String clave, String valor) {
		
		if(clave == null) {
			this.clave = "NO CLAVE";
		}else {
			this.clave = clave;
		}
		
		if(valor == null) {
			this.valor = "NO VALOR";
		}else{
			this.valor = valor;
		}
	}
	
	
	/**
	 * @return la clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave nueva clave 
	 */
	public void setClave(String clave) throws ArgumentoNoValido {
		if(clave == null) {
			throw new ArgumentoNoValido();
		}
		this.clave = clave;
	}

	/**
	 * @return el valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor nuevo valor del campo
	 */
	public void setValor(String valor) throws ArgumentoNoValido{
		if(valor == null) {
			throw new ArgumentoNoValido();
		}
		this.valor = valor;
	}
}
