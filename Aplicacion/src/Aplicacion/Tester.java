import java.io.*;

import java.util.*;

public class Tester {

	public static void main(String[] args) throws IOException {
		Sistema sist= new Sistema();

		Administracion ad= new Administracion(sist);

		System.out.println(args[0]);
		
		if(ad.cargarUsuarios("usuarios.txt") == true){
			//q va bn
			System.out.println("CACAAAAAAAAAAAAAAAAAAAAAAAAAAA");		
		}

		for(int i = 0; i < sist.getUsuarios().size(); i++){
			System.out.println("Usuario"+ sist.getUsuarios().get(i).getNombre());
		}
		String n = "5";
		Integer.parseInt(n);

	}
}
