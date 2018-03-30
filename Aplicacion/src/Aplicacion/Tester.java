import java.io.*;

public class Tester {

	public static void main(String[] args) throws IOException {
		Sistema sist= new Sistema();

		Administracion ad= new Administracion(sist);

		System.out.println("inmuebles.txt");
		
		ad.cargarInmuebles("inmuebles.txt");

		for(int i = 0; i < sist.getUsuarios().size(); i++){
			System.out.println("Inmueble : "+  sist.getInmuebles().get(i).getLocalizacion());
		}
		String n = "5";
		Integer.parseInt(n);

	}
}
