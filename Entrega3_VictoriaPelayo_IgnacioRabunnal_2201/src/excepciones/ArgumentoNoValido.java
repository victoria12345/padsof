package excepciones;
/**
 * Definicion de la excepcion que maneja los argumentos no validos
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
public class ArgumentoNoValido extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ArgumentoNoValido(){
		
	}
	
	public String toString() {
		return "Argumento no válido";
	}
}
