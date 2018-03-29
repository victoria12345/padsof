import java.util.*;
import java.io.*;

/**
 * Descripcion de la clase Inmueble
 * @author Victoria Pelayo e Ignacio Rabuñal
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
	public void setLocalizacion(String localizacion) {
		if(localizacion == null) {
			return;
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
	public void setDescripcion(String descripcion) {
		if(descripcion == null) {
			return;
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
	public void setCampos(List<CampoAbierto> campos) {
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
	public void setOfertas(List<Oferta> ofertas) {
		if(ofertas == null) {
			return;
		}
		this.ofertas = ofertas;
	}
	
	/**
	 * Se añade un campo variable al inmueble
	 * @param campo campo que se quiere aladir
	 * @param valor valor del nuevo campo
	 */
	public void addCampo(String campo, String valor) {
		CampoAbierto nuevo_campo = new CampoAbierto(campo, valor);
		
		this.campos.add(nuevo_campo);
	}
	
	/**
	 * Se asocia una oferta al inmuele
	 * @param o oferta que se desea asociar
	 */
	public void asociarOferta(Oferta o) {
		if(o == null) {
			return;
		}
		this.ofertas.add(o);
	}
	

	
	
}
