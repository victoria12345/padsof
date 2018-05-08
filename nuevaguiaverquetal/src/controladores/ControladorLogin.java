package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import excepciones.HayOtroUsuarioLogeado;
import excepciones.UsuarioNoEncontrado;
import gui.CustomFrame;
import paneles.LoginPanel;


public class ControladorLogin implements ActionListener{	
	private CustomFrame ventana;
	private Sistema app;
	
	public ControladorLogin(CustomFrame gui, Sistema app) {
		this.ventana = gui; 
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		LoginPanel pLogin = ventana.getPanelLogin();
		
		if(event.equals(pLogin.getBotonLogin())) {
				try {
					app.login(pLogin.getCampoUsuario().getText(), String.valueOf(pLogin.getCampoContrasena().getPassword()));
					pLogin.getCampoContrasena().setText("");
					pLogin.getCampoUsuario().setText("");
					ventana.mostrarPanelRol();
				} catch (ArgumentoNoValido e) {
					JOptionPane.showMessageDialog(pLogin, "Los datos introducidos no son validos");
				} catch (HayOtroUsuarioLogeado e) {
					JOptionPane.showMessageDialog(pLogin, "Hay otro usuario logeado");
				} catch (UsuarioNoEncontrado e) {
					JOptionPane.showMessageDialog(pLogin, "Usuario o contraseña equivocadas");
				}

		}else if(event.equals(pLogin.getBotonInvitado())) {
			ventana.mostrarPanelInvitado();
		}
		
	}

	public CustomFrame getVentana() {
		return ventana;
	}

	public void setVentana(CustomFrame ventana) {
		this.ventana = ventana;
	}

	public Sistema getApp() {
		return app;
	}

	public void setApp(Sistema app) {
		this.app = app;
	}

	

}