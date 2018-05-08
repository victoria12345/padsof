package controladores;

import app.Sistema;
import gui.*;
import paneles.AdminPanel;

import usuarios.Usuario;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;


import javax.swing.JList;




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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		AdminPanel panel = ventana.getPanelAdmin();
		JList list = panel.getUsers();

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

		}else if(event.equals(panel.getBotVerUser())) {
			if(list.isSelectionEmpty() == false) {
				int index =  list.getSelectedIndex();
				Usuario u;
				if((u = (Usuario)list.getModel().getElementAt(index)) == null) {
					return;
				}
				ventana.getPanelUsuario().iniciar(u);
				ventana.mostrarPanelUsuario();
			}
			
		}else if(event.equals(panel.getBotOfertas())) {
			ventana.mostrarPanelPendientes();
		}else if(event.equals(panel.getBotVolver())) {
			ventana.mostrarPanelRol();
		}
	}



	
}
