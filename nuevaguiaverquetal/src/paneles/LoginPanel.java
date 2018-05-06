package paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel etiquetaUsuario = new JLabel("Usuario:       ");
	private JLabel etiquetaContrasena = new JLabel("Contraseña:");
	private JTextField campoUsuario = new JTextField(30);
	private JPasswordField campoContrasena = new JPasswordField(30);
	private JButton botonLogin = new JButton("Entrar");
	private JButton botonInvitado = new JButton("Entrar como invitado");
	// Propuesta: AÑADIR OTRO BOTON PARA CERRAR APLICACION
	// Proposed work: ADD A BUTTON THAT CLOSES THE APPLICATION
	

	
	public LoginPanel() {	
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		this.setLayout(layout);
	
		JPanel p1 = new JPanel();
		p1.add(etiquetaUsuario);
		p1.add(campoUsuario);
		constraints.gridx = 1;
		constraints.gridy = 0;
		layout.setConstraints(p1, constraints);
		
		JPanel p2 = new JPanel();
		p2.add(etiquetaContrasena);
		p2.add(campoContrasena);
		constraints.gridx = 1;
		constraints.gridy = 1;
		layout.setConstraints(p2, constraints);
		
		JPanel p3 = new JPanel();
		p3.add(botonLogin);
		p3.add(botonInvitado);
		constraints.gridx = 1;
		constraints.gridy = 2;
		layout.setConstraints(p3, constraints);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		
	}
	

	public JLabel getEtiquetaUsuario() {
		return etiquetaUsuario;
	}


	public void setEtiquetaUsuario(JLabel etiquetaUsuario) {
		this.etiquetaUsuario = etiquetaUsuario;
	}


	public JLabel getEtiquetaContrasena() {
		return etiquetaContrasena;
	}


	public void setEtiquetaContrasena(JLabel etiquetaContrasena) {
		this.etiquetaContrasena = etiquetaContrasena;
	}


	public JTextField getCampoUsuario() {
		return campoUsuario;
	}


	public void setCampoUsuario(JTextField campoUsuario) {
		this.campoUsuario = campoUsuario;
	}


	public JPasswordField getCampoContrasena() {
		return campoContrasena;
	}


	public void setCampoContrasena(JPasswordField campoContrasena) {
		this.campoContrasena = campoContrasena;
	}


	public JButton getBotonLogin() {
		return botonLogin;
	}


	public void setBotonLogin(JButton botonLogin) {
		this.botonLogin = botonLogin;
	}


	public JButton getBotonInvitado() {
		return botonInvitado;
	}


	public void setBotonInvitado(JButton botonInvitado) {
		this.botonInvitado = botonInvitado;
	}
	
	
	
	public void setControlador(ActionListener al) {
		this.botonLogin.addActionListener(al);
		this.botonInvitado.addActionListener(al);
	}
	
	
	


}