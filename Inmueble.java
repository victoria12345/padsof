package Inmuebles;
import java.util.*;

import Excepciones.ArgumentoNoValido;
import Ofertas.Oferta;

import java.io.*;

/**
 * Descripcion de la clase Inmueble
 * @author Victoria Pelayo e Ignacio Rabunnal
 */

public class Inmueble implements Serializable {
	private static final long serialVersionUID = 1L;
	private String localizacion;
	private int codigoPostal;
	private String descripcion;
	private List<CampoAbierto> campos = new ArrayList<CampoAbierto>();
	private List<Oferta> ofertas = new ArrayList<Oferta>();

	/**
	 * Constructor de la clase inmueble
	 * @param localizacion localizacion del inmueble
	 * @param codigoPostal codigo postal del inmueble
	 * @param descripcion descripcion del inmueble
	 */
	public Inmueble(String localizacion, int codigoPostal, String descripcion) {
		if(localizacion == null) {
			this.localizacion = "No especificado";
		}else{
			this.localizacion = localizacion;
		}
		this.codigoPostal = codigoPostal;
		if(descripcion == null) {
			this.descripcion = "No especificado";
		}else{
			this.descripcion = descripcion;
		}
	}
	/**
	 * @return la localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion localizacion que se deasea modificar
	 */
	public void setLocalizacion(String localizacion) throws ArgumentoNoValido{
		if(localizacion == null) {
			throw new ArgumentoNoValido();
		}
		this.localizacion = localizacion;
	}

	
	/**
	 * @return el codigoPostal
	 */
	public int getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal nuevo codigo postal del inmueble
	 */
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion nueva descripcion del inmueble
	 */
	public void setDescripcion(String descripcion) throws ArgumentoNoValido {
		if(descripcion == null) {
			throw new ArgumentoNoValido();
		}
		this.descripcion = descripcion;
	}

	/**
	 * @return campos abiertos del inmueble
	 */
	public List<CampoAbierto> getCampos() {
		return campos;
	}

	/**
	 * @param campos nueva lista de campos abiertos del inmueble
	 */
	public void setCampos(List<CampoAbierto> campos) throws ArgumentoNoValido{
		if(campos == null) {
			throw new ArgumentoNoValido();
		}
		this.campos = campos;
	}
	
	/**
	 * @return las ofertas asociadas al inmueble
	 */
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	/**
	 * @param ofertas nueva lista de ofertas asociadas
	 */
	public void setOfertas(List<Oferta> ofertas) throws ArgumentoNoValido{
		if(ofertas == null) {
			throw new ArgumentoNoValido();
		}
		this.ofertas = ofertas;
	}
	
	/**
	 * Se annade un campo variable al inmueble
	 * @param campo campo que se quiere aladir
	 * @param valor valor del nuevo campo
	 */
	public void addCampo(CampoAbierto c) throws ArgumentoNoValido{
		if(c == null) {
			throw new ArgumentoNoValido();
		}
		
		this.campos.add(c);
	}
	
	/**
	 * Se asocia una oferta al inmuele
	 * @param o oferta que se desea asociar
	 */
	public void asociarOferta(Oferta o) throws ArgumentoNoValido{
		if(o == null) {
			throw new ArgumentoNoValido();
		}
		this.ofertas.add(o);
	}
	
	public String toString() {
		String inmueble = "Inmueble:\n" + 
							"Localizacion:" + this.getLocalizacion() +"\n" +
							"Codigo postal:" + this.getCodigoPostal() + "\n" +
							"Descripcion:" + this.getDescripcion() + "\n";
		return inmueble;
	}
	

	
	
}
