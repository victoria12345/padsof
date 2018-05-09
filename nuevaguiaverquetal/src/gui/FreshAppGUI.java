package gui;
import java.io.IOException;
import java.time.LocalDate;

import app.Sistema;

import excepciones.ArgumentoNoValido;

public class FreshAppGUI {

	public static void main(String[] args) throws IOException, ArgumentoNoValido, ClassNotFoundException {
		Sistema app = new Sistema();
		app = app.deserializar(LocalDate.of(2000, 1, 1));
		@SuppressWarnings("unused")
		CustomFrame ventana = new CustomFrame(app, "FreshApp", LocalDate.of(2000, 1, 1));	
	}

}
