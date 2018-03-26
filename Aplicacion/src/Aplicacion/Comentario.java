import java.util.*;
public class Comentario {
	private String texto;
	private Usuario usuario;
	private List<Comentario> respuestas = new ArrayList<Comentario>();
	
	
	public Comentario(Usuario usuario, String texto) {
		this.usuario = usuario;
		this.texto = texto;
		
	}
	
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Comentario> getRespuestas(){
		return respuestas;
	}
	
	public void setRespuestas(List<Comentario> respuestas) {
		this.respuestas = respuestas;
	}
	
}
