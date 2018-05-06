package controladores;

import app.Sistema;
import gui.*;
import usuarios.Usuario;

import java.util.*;

public class ControladorAdmin {
	private CustomFrame gui;
	private Sistema app;
		
	public ControladorAdmin(CustomFrame gui, Sistema app) {
		this.gui = gui; 
		this.app = app;
	}

	public List<Usuario> obtenerUsuarios(){
		return app.getUsuarios();
	}

	
}
