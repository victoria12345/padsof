package ofertas;
import java.util.*;

import excepciones.ArgumentoNoValido;
import usuarios.Usuario;

import java.io.*;

/**
 * Constructor de la clase Comentario
 * @author Victoria Pelayo e Ignacio Rabunnal
 */

public class Comentario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String texto;
	private Usuario usuario;
	private Comentario padre = null;
	private List<Comentario> respuestas = new ArrayList<Comentario>();
	
	/**
	 * Constructor de comentario
	 * @param usuario usuario que ha escrito el comentario
	 * @param texto texto del comentario
	 * @param id identificador del comentario
	 */
	public Comentario(Usuario usuario, String texto) {
		this.usuario = usuario;
		
		if(texto == null) {
			this.texto = "no texto";
		}else {
			this.texto = texto;
		}

		
	}
	/**
	 * @return texto del comentario
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * @param texto nuevo texto del comentario
	 * @throws ArgumentoNoValido si el texto es null
	 */
	public void setTexto(String texto) throws ArgumentoNoValido {
		if(texto == null) {
			throw new ArgumentoNoValido();
		}
		this.texto = texto;
	}
	
	/**
	 * @return usuario que ha escrito el comentario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * REVISAR
	 * @param usuario nuevo usuario que ha escrito el comentario
	 * @throws ArgumentoNoValido si el usuario es null
	 */
	public void setUsuario(Usuario usuario) throws ArgumentoNoValido{
		if(usuario == null) {
			throw new ArgumentoNoValido();
		}
		this.usuario = usuario;
	}
	
	/**
	 * @return respuestas a ese comentario
	 */
	public List<Comentario> getRespuestas(){
		return respuestas;
	}
	

	
	/**
	 * Annade una respuesta a un comentario
	 * @param c comentario que se annade
	 * @throws ArgumentoNoValido si el comentario es null
	 */
	public void addRespuesta(Comentario c) throws ArgumentoNoValido{
		if(c == null) {
			throw new ArgumentoNoValido();
		}
		respuestas.add(c);
		c.setPadre(this);
	}
	
	/**
	 * Elimina una respuesta a un comentario
	 * @param c comentario que se desea eliminar
	 * @throws ArgumentoNoValido si la respuesta es null o el comentario no contiene a la respuesta
	 */
	public void delRespuesta(Comentario c) throws ArgumentoNoValido{
		if(c == null || respuestas.contains(c) == false) {
			throw new ArgumentoNoValido();
		}
		respuestas.remove(c);
		c.setPadre(null);
	}
	
	/**
	 * Crea un string con la informacion del comentario
	 * @return comentario String con la informacion del comentario
	 */
	public String toString() {
		String comentario = "Comentario->" + " Usuario: " + this.getUsuario().toString() +
							" Texto: " + this.getTexto();
		return comentario;
	}

	/**
	 * @return the padre
	 */
	public Comentario getPadre() {
		return padre;
	}

	/**
	 * @param padre the padre to set
	 */
	public void setPadre(Comentario padre){
		this.padre = padre;
	}
}
