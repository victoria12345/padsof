import java.util.*;

/**
 * Constructor de la clase Comentario
 * @author Victoria Pelayo e Ignacio Rabunnal
 * CREO QUE TENIAN QUE SER APROBADOS 
 */

public class Comentario{
	private int id;
	private String texto;
	private Usuario usuario;
	private List<Comentario> respuestas = new ArrayList<Comentario>();
	
	/**
	 * Constructor de comentario
	 * @param usuario usuario que ha escrito el comentario
	 * @param texto texto del comentario
	 * @param id identificador del comentario
	 */
	public Comentario(Usuario usuario, String texto, int id) {
		this.usuario = usuario;
		
		if(texto == null) {
			this.texto = "no texto";
		}else {
			this.texto = texto;
		}
		
		this.id = id;
		
	}
	
	/**
	 * @return el Identificador
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return texto del comentario
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * @param texto nuevo texto del comentario
	 */
	public void setTexto(String texto) {
		if(texto == null) {
			return;
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
	 */
	public void setUsuario(Usuario usuario) {
		if(usuario == null) {
			return;
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
	 * Cambia todo la lista de respuestas de un comentario
	 * @param respuestas respuestas de un comentario
	 */
	public void setRespuestas(List<Comentario> respuestas) {
		if(respuestas == null) {
			return;
		}
		this.respuestas = respuestas;
	}
	
	/**
	 * Annade una respuesta a un comentario
	 * @param c comentario que se annade
	 */
	public void addRespuesta(Comentario c) {
		if(c == null) {
			return;
		}
		respuestas.add(c);
	}
	
	/**
	 * Elimina una respuesta a un comentario
	 * @param c comentario que se desea eliminar
	 */
	public void delRespuesta(Comentario c){
		if(c == null) {
			return;
		}
		
		if(respuestas.contains(c) == false) {
			return;
		}
		
		respuestas.remove(c);
	}
}
