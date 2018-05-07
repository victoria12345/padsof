package controladores;

import app.Sistema;
import gui.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import paneles.AdminPanel;
import usuarios.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.SwingUtilities;



public class ControladorAdmin implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
		
	public ControladorAdmin(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;
	}

	public List<Usuario> obtenerUsuarios(){
		return app.getUsuarios();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		AdminPanel panel = ventana.getPanelAdmin();
		new JFXPanel();
		Platform.runLater(() ->{
			if(event.equals(panel.getBotonMostrarBloq())) {
				for(Usuario u: app.getUsuarios()) {
					if(u.isBloqueado() == false) {
						panel.getModelo().removeElement(u);
					}
				}
			
			}else if(event.equals(panel.getBotonMostrarTodos())) {
				panel.getModelo().clear();
				for(Usuario u: app.getUsuarios()) {
					panel.getModelo().addElement(u);
				}

				
			
				
				
			}else if(true) {
				
			}
		});
		
	}



	
}
