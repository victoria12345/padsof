package gui;
import java.io.IOException;
import java.time.LocalDate;

import app.Sistema;
import controladores.ControladorLogin;
import excepciones.ArgumentoNoValido;
import usuarios.Usuario;

public class PruebasGUI {

	public static void main(String[] args) throws IOException, ArgumentoNoValido, ClassNotFoundException {
		Sistema app = new Sistema();
		
		app = app.deserializar(LocalDate.of(2000, 1, 1));
		CustomFrame ventana = new CustomFrame(app, "FreshApp");
		
		
		
		Usuario user = app.buscarUsuario("51999111X", "pezEspada");
		System.out.println(user);
		
	}

}
