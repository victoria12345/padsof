package paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Descripcion de la clase LoginPanel
 *
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
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
	
	/**
	 * Constructor de la clase LoginPanel
	 */
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
	
	/**
	 * @return etiqueta usuario
	 */
	public JLabel getEtiquetaUsuario() {
		return etiquetaUsuario;
	}

	/**
	 * cambia etiqueta usuario
	 * @param etiquetaUsuario nueva etqueta
	 */
	public void setEtiquetaUsuario(JLabel etiquetaUsuario) {
		this.etiquetaUsuario = etiquetaUsuario;
	}

	/**
	 * @return contrasenna
	 */
	public JLabel getEtiquetaContrasena() {
		return etiquetaContrasena;
	}

	/**
	 * Cambia la contrasenna
	 * @param etiquetaContrasena nueva contrasenna
	 */
	public void setEtiquetaContrasena(JLabel etiquetaContrasena) {
		this.etiquetaContrasena = etiquetaContrasena;
	}

	/**
	 * @return campo usuario
	 */
	public JTextField getCampoUsuario() {
		return campoUsuario;
	}

	/**
	 * cambia campo usuario
	 * @param campoUsuario nuevo campo
	 */
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