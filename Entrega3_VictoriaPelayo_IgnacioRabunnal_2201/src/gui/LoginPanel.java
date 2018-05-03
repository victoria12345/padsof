package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LoginPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel etiquetaUsuario = new JLabel("Usuario:");
	private JLabel etiquetaContrasena = new JLabel("Clave secreta");
	private JTextField campoUsuario = new JTextField(30);
	private JTextField campoContrasena = new JTextField(30);
	private JButton botonLogin = new JButton("Entrar");
	// Propuesta: AÑADIR OTRO BOTON PARA CERRAR APLICACION
	// Proposed work: ADD A BUTTON THAT CLOSES THE APPLICATION
	
	private Gui gui;
	
	public LoginPanel(Gui gui) {	
		this.gui = gui;
		
		this.setLayout(new BorderLayout());
		JPanel pn = new JPanel(new GridLayout(2,2));
		pn.add(etiquetaUsuario); 
		pn.add(campoUsuario);
		pn.add(etiquetaContrasena);
		pn.add(campoContrasena);
		this.add(pn, BorderLayout.CENTER);
		
		JPanel pb = new JPanel();
		pb.add(botonLogin);
		this.add(pb, BorderLayout.SOUTH);
		
		botonLogin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evento) {
		// this.setVisible(false); // no hasta saber si login OK  
		gui.getControlador().login( campoUsuario.getText(), 
				                    campoContrasena.getText() );  
		// System.out.println("Traza: pulsado en login");
    }

	// Propuesta: CAMBIA LA FORMA/LUGAR/MECANISMO PARA MOSTRAR ERROR
	// Proposed work: CHANGE THE WAY/PLACE/MECHANISM TO DISPLAY ERROR
	public void setError(String error) {	
		campoContrasena.setText(error);
		campoContrasena.setForeground(java.awt.Color.red);
	}
}