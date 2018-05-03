package gui;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import excepciones.HayOtroUsuarioLogeado;
import excepciones.UsuarioNoEncontrado;

public class Controlador {	
	private Gui gui;
	private Sistema app;
	
	public Controlador(Gui gui, Sistema app) {
		this.gui = gui; 
		this.app = app;
	}

	public void login(String name, String passwd) {
		try {
			app.login(name, passwd);
			gui.loginResultOK();
		}catch(HayOtroUsuarioLogeado e){
			gui.loginResultOUL();
		}catch (UsuarioNoEncontrado e2){
			gui.loginResultUNE();
		}catch (ArgumentoNoValido e3){
			gui.loginResultANV();
		}
		
	}

}