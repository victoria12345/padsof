package controladores;

import app.Sistema;
import gui.*;
import paneles.AdminPanel;
import usuarios.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JList;

/**
 * Descripcion de la clase Controlador Admin 
 * @implements Action Listener Controlador del Panel de Admin
 * 
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
public class ControladorAdmin implements ActionListener{
	/**
	 * Custom Frame de la aplicacion
	 */
	private CustomFrame ventana;
	/**
	 * Sistema de la aplicacion
	 */
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param ventana customFrame de la aplicacion
	 * @param app sistema de la aplicacion
	 * 
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public ControladorAdmin(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;
	}

	/**
	 * @return lista de Usuarios del Sistema
	 * 
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public List<Usuario> obtenerUsuarios(){
		return app.getUsuarios();
	}

	/**
	 * Implementa la accion que se realiza al escuchar un evento
	 * @param arg0 evento que se escucha
	 * 
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		}
	}



	
}
