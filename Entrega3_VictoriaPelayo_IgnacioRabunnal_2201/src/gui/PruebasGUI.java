package gui;
import java.io.IOException;

import app.Sistema;
import excepciones.ArgumentoNoValido;

public class PruebasGUI {

	public static void main(String[] args) throws IOException, ArgumentoNoValido {
		Gui gui = new Gui("FreshApp");
		Sistema app = new Sistema();
		Controlador  controlador = new Controlador(gui, app);
		gui.setControlador( controlador );
	}

}
