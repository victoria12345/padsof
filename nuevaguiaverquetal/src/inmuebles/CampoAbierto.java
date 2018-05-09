package inmuebles;
import java.io.*;

import excepciones.ArgumentoNoValido;

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
	 * Obtiene la clave del campo
	 * @return la clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * Establece una nueva clave
	 * @param clave nueva clave 
	 * @throws ArgumentoNoValido si la clave es null
	 */
	public void setClave(String clave) throws ArgumentoNoValido {
		if(clave == null) {
			throw new ArgumentoNoValido();
		}
		this.clave = clave;
	}

	/**
	 * Obtiene el valor del campo
	 * @return el valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Establece un nuevo valor para el campo
	 * @param valor nuevo valor del campo
	 * @throws ArgumentoNoValido si el valor es null
	 */
	public void setValor(String valor) throws ArgumentoNoValido{
		if(valor == null) {
			throw new ArgumentoNoValido();
		}
		this.valor = valor;
	}
	
	public String toString() {
		return this.getClave() + this.getValor();
	}
}
