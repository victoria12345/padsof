package gui;
import java.io.IOException;

import app.Sistema;
import controladores.ControladorLogin;
import excepciones.ArgumentoNoValido;
import usuarios.Usuario;

public class PruebasGUI {

	public static void main(String[] args) throws IOException, ArgumentoNoValido {
		Sistema app = new Sistema();
		CustomFrame ventana = new CustomFrame(app, "FreshApp");
		
		
		
		Usuario user = app.buscarUsuario("51999111X", "pezEspada");
		System.out.println(user);
		
	}

}
