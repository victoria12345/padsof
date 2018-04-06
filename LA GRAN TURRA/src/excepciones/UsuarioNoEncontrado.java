package excepciones;

public class UsuarioNoEncontrado extends Exception{
	
	private static final long serialVersionUID = 1L;

	public UsuarioNoEncontrado() {
		
	}
	
	public String toString() {
		return "No se ha encontrado el usuario";
	}

}
