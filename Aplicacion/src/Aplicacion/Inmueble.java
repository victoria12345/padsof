

/**
 * @author Victoria Pelayo e Ignacio Rabuñal
 *
 */

import java.util.*;

public class Inmueble {
	private String localizacion;
	private int codigoPostal;
	private String descripcion;
	private List<CampoAbierto> campos = new ArrayList<CampoAbierto>();
	private List<Oferta> ofertas = new ArrayList<Oferta>();

	/**
	 * 
	 */
	public Inmueble(String localizacion, int codigoPostal, String descripcion) {
		this.localizacion = localizacion;
		this.codigoPostal = codigoPostal;
		this.descripcion = descripcion;
	}
	/**
	 * @return the localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	
	/**
	 * @return the codigoPostal
	 */
	public int getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the campos
	 */
	public List<CampoAbierto> getCampos() {
		return campos;
	}

	/**
	 * @param campos the campos to set
	 */
	public void setCampos(List<CampoAbierto> campos) {
		this.campos = campos;
	}
	
	/**
	 * @return the ofertas
	 */
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	/**
	 * @param ofertas the ofertas to set
	 */
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	
	
}
