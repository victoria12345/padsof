import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws IOException {
		Sistema sist= new Sistema();
		Administracion ad= new Administracion(sist);
		
		ad.cargarUsuarios("usuarios.txt");

	}
}
