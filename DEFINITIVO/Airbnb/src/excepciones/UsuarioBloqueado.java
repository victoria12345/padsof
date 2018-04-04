package excepciones;

public class UsuarioBloqueado extends Exception{
	private static final long serialVersionUID = 1L;
	
	public UsuarioBloqueado() {
		
	}
	
	public String toString() {
		return "Usuario bloqueado";
	}
}
