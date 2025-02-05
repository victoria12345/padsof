package gui;
import java.io.IOException;

import app.Sistema;
import controladores.ControladorLogin;
import excepciones.ArgumentoNoValido;
import usuarios.Usuario;

public class PruebasGUI {

	public static void main(String[] args) throws IOException, ArgumentoNoValido {
		Gui gui = new Gui("FreshApp");
		Sistema app = new Sistema();
		
		
		Usuario user = app.buscarUsuario("51999111X", "pezEspada");
		System.out.println(user);
		
		ControladorLogin controler = new ControladorLogin(gui, app);
		gui.setControlador(controler);
	}

}
