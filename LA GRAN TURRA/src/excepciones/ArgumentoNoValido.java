package excepciones;

public class ArgumentoNoValido extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ArgumentoNoValido(){
		
	}
	
	public String toString() {
		return "Argumento no válido";
	}
}
